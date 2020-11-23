import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

import java.io.*;
import java.util.List;

@WebServlet("/na")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//		OutputStream oos = response.getOutputStream();
//		PrintStream out = new PrintStream(oos);

//      writer는 다중 국가 언어 지원
//		PrintWriter out = new PrintStream(oos);

		// 1. 컴파일 cmd - > javac -cp "톰캣\lib\servelt-api.jar" ?.java
		// 2. .class 배포 - > 톰캣\webapps\ROOT\WEB-INF\classes 폴더 안에 넣는다.
		// --> 이클립스에선 Server path에 배포. -> 톰캣 실행시 배포됨.
		// --> 이클립스 Project Explorer은 단순 작업공간.
		// 3. 톰캣\webapps\ROOT\WEB-INF 안의 web.xml 맵핑
		// 4. 톰캣 실행.

		/* 컴파일의 문제 - > Project - > Clean */

		PrintWriter out = response.getWriter();

//		System.out.println("hohoho");
//		out.println("hahahaha");
		
// jdbc driver도 같이 배포해야함 - > lib 안에 넣어둬야함


		MemberService service = new MemberService();

		List<Member> list = service.getList();

		for (Member m : list)
			out.printf("nicname : %s, name : %s\n", m.getNicname(), m.getName());

	}
}
