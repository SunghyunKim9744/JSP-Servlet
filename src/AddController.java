import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 
		 *  이클립스에서 arguments 주는 방법  
		 *  
		 *  Run AddController -> Run Configurations - > Arguments
		*/		
			
			
			int x=0;
			int y=0;
		
		/*    
		 * 	web에서의 arguments 전달 방식
		 *  브라우저 - > /add?x=10&y=20
		 * 
		*/		
			x = Integer.parseInt(request.getParameter("x"));
			y = Integer.parseInt(request.getParameter("y"));
			
			int result = x+y;
			
			response.getWriter().println(result);
			
	}

}
