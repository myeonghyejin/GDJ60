package com.mhj.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BbsService;
import com.mhj.s1.util.Pager;

@Controller
@RequestMapping("/bankbookComment/*")
public class BankbookCommentController {
	
	@Autowired
	private BbsService bankbookCommentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> ar = bankbookCommentService.getBoardList(pager);
		
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("board/list");
		
		return modelAndView;
	}

}
