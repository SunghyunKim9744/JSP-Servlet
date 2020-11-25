package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		입력받은 것은 필터에서하기.
//		읽어들일 때 UTF-8로 읽기 
//		request.setCharacterEncoding("UTF-8");

//		출력시 UTF-8로 보내기.		
		response.setCharacterEncoding("UTF-8");

//		브라우저에게 UTF-8로 읽으라고 보내기.
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		
//		reg?cnt=3 
//		reg?cnt=  -- > "" 빈 문자열
//		reg?      -- > null
//		reg       -- > null
		
		if(title != null && !title.equals(""))
			out.printf("title is %s\n",title);
		
			
//		String[] titles = request.getParameterValues("title");
		String[] food = request.getParameterValues("food");
		String file = request.getParameter("file");
		
//		for(int i=0; i<titles.length; i++)
//			System.out.printf("title is %s\n",titles[i]);
		for(int i=0; i<food.length; i++)
			out.printf("음식 is %s\n",food[i]);
//		System.out.printf("title is %s\n, file is %s\n",title,file);
	}
}
