package com.mhj.s1.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/** SELECT **/
	@PostMapping(value="memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		boolean check = memberService.getMemberIdCheck(memberDTO);
		
		ModelAndView modelAndView = new ModelAndView();		
		
		modelAndView.addObject("result", check);
		modelAndView.setViewName("common/ajaxResult");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberAgree", method = RequestMethod.GET)
	public void setMemberAgree() throws Exception {
		
	}
	
	//getMemberList
	@RequestMapping(value="list")
	public ModelAndView getMemberList(ModelAndView modelAndView) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		modelAndView.setViewName("member/memberList");
		modelAndView.addObject("list", ar);
		return modelAndView;
	}
		
	//getMemberLogin (입력 폼으로 이동)
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView getMemberLogin(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberLogin");
		
//		Cookie [] cookies = request.getCookies();
//		
//		for(Cookie cookie:cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("-----------------");
//			if(cookie.getName().equals("rememberId")) {
//				modelAndView.addObject("rememberId", cookie.getValue());
//				break;
//			}
//		}
		
		return modelAndView;
	}
	
	//getMemberLogin (DB에 INSERT)
	@PostMapping("login")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response, String remember) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("Remember : " + remember);
		
		if(remember != null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7);	//초 단위, -1 영구히 저장
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
//		memberDTO = memberService.getMemberLogin(memberDTO);
//		if(memberDTO != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);	
//		}
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	//getMemberLogout
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	//getMemberPage
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getMemberPage(memberDTO);
		modelAndView.addObject("DTO", memberDTO);
		modelAndView.setViewName("member/memberPage");
		return modelAndView;
	}
	
	/** INSERT **/
	//setMemberAdd (입력 폼으로 이동)
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView setMemberAdd(ModelAndView modelAndView) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		modelAndView.setViewName("member/memberAdd");
		return modelAndView;
	}
	
	//setMemberAdd (DB에 INSERT)
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView setMemberAdd(MemberDTO memberDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = memberService.setMemberAdd(memberDTO);
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	/** UPDATE **/
	//setMemberUpdate (입력 폼으로 이동)
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getMemberPage(memberDTO);
		modelAndView.addObject("DTO", memberDTO);
		modelAndView.setViewName("member/memberUpdate");
		return modelAndView;
	}
	
	//setMemberUpdate (DB에 INSERT)
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView setMemberUpdate (HttpSession session, ModelAndView modelAndView, MemberDTO memberDTO) throws Exception {
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result = memberService.setMemberUpdate(memberDTO);
//		if(result>0) {	
//			session.setAttribute("member", memberDTO);
//		}
		modelAndView.setViewName("redirect:./myPage");
		return modelAndView;
	}
		
	/** DELETE **/

}
