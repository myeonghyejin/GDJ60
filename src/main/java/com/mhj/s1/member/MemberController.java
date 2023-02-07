package com.mhj.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//getMemberList
	@RequestMapping(value="list")
	public ModelAndView getMemberList(ModelAndView modelAndView) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		modelAndView.setViewName("member/MemberList");
		modelAndView.addObject("list", ar);
		return modelAndView;
	}

	//memberJoin
	@RequestMapping(value="memberJoin")
	public ModelAndView memberJoin(ModelAndView modelAndView) throws Exception {
		MemberDTO memberDTO = new MemberDTO();	
		modelAndView.setViewName("member/memberJoin");
		modelAndView.addObject("memberJoin", memberDTO);
		return modelAndView;
	}
	
}
