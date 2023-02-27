package com.mhj.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BbsService;
import com.mhj.s1.board.BoardDTO;
import com.mhj.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "notice";
	}
	
	/** Select **/
	//Select (List)
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> ar = noticeService.getBoardList(pager);
		
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("board/list");
		
		return modelAndView;
	}
	
	//Select (Detail)
	@GetMapping("detail")
	public ModelAndView getBoardDetail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		BoardDTO boardDTO = noticeService.getBoardDetail(noticeDTO);
		
		modelAndView.addObject("DTO", boardDTO);
		modelAndView.setViewName("board/detail");
		
		return modelAndView;
	}
	
	/** Insert **/
	//Insert (Add, 입력 폼으로 이동)
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/add");
		return modelAndView;
	}
	
	//Insert (Add, DB에 Insert)
	@PostMapping("add")
	public ModelAndView setBoardAdd(NoticeDTO noticeDTO, MultipartFile [] files, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = noticeService.setBoardAdd(noticeDTO, files, session);
		
		String message = "게시글 등록 실패!!!!";
		
		if(result > 0) {
			message = "게시글 등록 성공!!!!!!!~~~>.<";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("URL", "./list");
		modelAndView.setViewName("common/result");
		return modelAndView;
	}
	
	/** Update **/
	
	/** Delete **/
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = noticeService.setBoardDelete(bbsDTO, session);
		
		String message = "삭제할 수 없습니다!";
		
		if(result > 0) {
			message = "삭제되었습니다 >.<";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("URL", "./list");
		modelAndView.setViewName("common/result");
		
		return modelAndView;
	}

}
