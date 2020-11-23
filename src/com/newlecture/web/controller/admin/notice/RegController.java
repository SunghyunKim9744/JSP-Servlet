package com.newlecture.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		읽어들일 때 UTF-8로 읽기 
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		
//		reg?cnt=3 
//		reg?cnt=  -- > "" 빈 문자열
//		reg?      -- > null
//		reg       -- > null
		if(title !=null || !title.equals(""))
			System.out.printf("title is %s\n",title);
//		String[] titles = request.getParameterValues("title");
		String[] food = request.getParameterValues("food");
		String file = request.getParameter("file");
		
//		for(int i=0; i<titles.length; i++)
//			System.out.printf("title is %s\n",titles[i]);
//		for(int i=0; i<food.length; i++)
//			System.out.printf("food is %s\n",food[i]);
//		System.out.printf("title is %s\n, file is %s\n",title,file);
	}
}
