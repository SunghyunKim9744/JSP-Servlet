package com.newlecture.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//		get요청
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		
		//		post 요청
		else if(request.getMethod().equals("POST")) {
	//		1. 사용자가 입력한 값 받기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Notice notice = new Notice(title,content);
	//		2. 데이터 베이스에 입력
			NoticeService service = new NoticeService();
			service.insert(notice);
	//		3. 목록페이지로 이동
	//      Servlet - > Servlet 이동 하는 방법
	//      1. forward - > 현재 진행형, 남아 있는 작업이 있을 때
	//      2. redirect - > 모든 작업이 끝나고 페이지 전환, 모든 post처리 부분
			response.sendRedirect("list");
			
		}
		

	}
}
