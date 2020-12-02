package com.newlecture.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		저장소
//		1. pageContext - > 현재 페이지 - > 페이지 바꾸면 없어짐
//		2. session - > 현재 사용자
//		3. application - > 전체 - > 톰캣이 실행되는 순간
//		4. request - > 서블릿 간의 호출시(forward 관계) 공유 공간. - > page와 session 사이, 서블릿이 서블릿을 호출 할 때, 두 서블릿이 공유할 수 있는 저장소
		
		int id = Integer.parseInt(request.getParameter("id"));
		NoticeService service = new NoticeService();
		Notice n = service.get(id);
		
		
//		모델을 전달
		request.setAttribute("n", n);
		
//		다른 서블릿을 호출하면서 공유하는 것 - > forward - > request,response 같은 것을 씀.
		request.getRequestDispatcher("/admin/board/notice/detail.jsp").forward(request, response);
	
	
	}

}
