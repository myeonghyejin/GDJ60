package com.mhj.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BbsService;
import com.mhj.s1.member.MemberDTO;
import com.mhj.s1.util.Pager;

@Controller
@RequestMapping("/bankbookComment/*")
public class BankbookCommentController {
	
	@Autowired
	private BbsService bankbookCommentService;
	
	/** Select **/
	@GetMapping("list")
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> ar = bankbookCommentService.getBoardList(pager);
		
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("common/commentList");
		
		return modelAndView;
	}
	
	/** Insert **/
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankbookCommentDTO bankbookCommentDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		bankbookCommentDTO.setWriter(memberDTO.getId());
		
		bankbookCommentDTO.setWriter("mhj");
		
		int result = bankbookCommentService.setBoardAdd(bankbookCommentDTO, null, null);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");
		
		return modelAndView;
	}
	
	/** Delete **/
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BankbookCommentDTO bankbookCommentDTO) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = bankbookCommentService.setBoardDelete(bankbookCommentDTO, null);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");
	      
		return modelAndView;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BankbookCommentDTO bankbookCommentDTO) throws Exception{
	   ModelAndView modelAndView = new ModelAndView();
	   int result = bankbookCommentService.setBoardUpdate(bankbookCommentDTO);
	   modelAndView.addObject("result", result);
	   modelAndView.setViewName("common/ajaxResult");
	   return modelAndView;
	}

}
