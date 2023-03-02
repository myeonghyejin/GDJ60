package com.mhj.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// Controller 진입 전
		//  return이 true라면 다음 Controller로 진행
		//  return이 false라면 진행 X
		System.out.println("Member Check Interceptor");
		
		Object object = request.getSession().getAttribute("member");
		
		if(object != null) {
			return true;
		}
		
		System.out.println("Login 안 한 경우");
		
		//1. forward로 JSP를 찾아가기
//		request.setAttribute("result", "권한이 없습니다.");
//		request.setAttribute("URL", "../member/login");
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
//		view.forward(request, response);
		
		//2. Redirect
		response.sendRedirect("../../../../../member/login");
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// Controller에서 리턴 후 DS로 가기 전
		System.out.println("Controller에서 리턴 후 DS 진입 전");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		// JSP 렌더링 후
		System.out.println("JSP 렌더링이 종료된 후");
	}
	
}
