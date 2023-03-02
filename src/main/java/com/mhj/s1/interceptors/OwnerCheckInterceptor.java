package com.mhj.s1.interceptors;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mhj.s1.board.BoardDTO;
import com.mhj.s1.board.notice.NoticeDAO;
import com.mhj.s1.board.qna.QnaDAO;
import com.mhj.s1.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Long num = Long.parseLong(request.getParameter("num"));
		
		System.out.println("URI : " + request.getRequestURI());
		System.out.println("PathInfo : " + request.getPathInfo());
		System.out.println("ServletPath : " + request.getServletPath());
		
		String uri = request.getRequestURI();
		uri = uri.substring(1, uri.lastIndexOf("/"));
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		
		if(uri.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		} else {
			boardDTO = qnaDAO.getBoardDetail(boardDTO);
		}
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			request.setAttribute("result", "작성자만 가능합니다.");
			request.setAttribute("URL", "./list");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			return false;
		}
		
		return true;
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		System.out.println("Owner Check Interceptor");
//		
//		//1. 로그인
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		//2. BoardDTO
//		Map<String, Object> map = modelAndView.getModel();
//		BoardDTO boardDTO = (BoardDTO)map.get("DTO");
////		map.keySet().iterator()
//		
//		//3. Check
//		if(memberDTO == null || !boardDTO.getWriter().equals(memberDTO.getId())) {
//			modelAndView.setViewName("common/result");
//			modelAndView.addObject("result", "작성자만 가능합니다.");
//			modelAndView.addObject("URL", "./list");
//		}
//		
//		super.postHandle(request, response, handler, modelAndView);
//	}
	
}
