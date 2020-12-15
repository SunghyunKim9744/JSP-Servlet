package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	private NoticeService service;

	public RegController() {
		service = new NoticeService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get요청
		if (request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);

		// post 요청
		else if (request.getMethod().equals("POST")) {

			// 1. 사용자가 입력한 값 받기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
//			Notice notice = new Notice(title,content);
			// 2. 데이터 베이스에 입력
//			NoticeService service = new NoticeService();
//			service.insert(notice);
			// 3. 목록페이지로 이동
			// Servlet - > Servlet 이동 하는 방법
			// 1. forward - > 현재 진행형, 남아 있는 작업이 있을 때
			// 2. redirect - > 모든 작업이 끝나고 페이지 전환, 모든 post처리 부분
			response.sendRedirect("list");

//			파일 받기 - >  1개
//			Part filePart = request.getPart("file");
//			파일 받기 - > 여러개
			Collection<Part> fileParts = request.getParts();
			String fileNames = "";
			for (Part p : fileParts) {
				if (p.getName().equals("file") && p.getSize() >0) {
					Part filePart = p;

					String fileName = filePart.getSubmittedFileName();
					fileNames += fileName;
					fileNames += ",";

					int newId = service.getLastId() + 1;

					String pathTemp = request.getServletContext().getRealPath("/static/notice/2020/" + newId + "/");

					File path = new File(pathTemp);
					if (!path.exists())
						path.mkdirs();

					String filePath = pathTemp + File.separator + fileName;
					System.out.println(filePath);

					InputStream fis = filePart.getInputStream();
					FileOutputStream fos = new FileOutputStream(filePath);

					byte[] buf = new byte[1024];
					int size = 0;
					while ((size = fis.read(buf)) != -1)
						fos.write(buf, 0, size);

					fos.close();
					fis.close();

				}

			}
			 //1. 데이터베이스에 입력
	         NoticeService service = new NoticeService();
	         Notice notice = new Notice(title, content);
	         // 꼬랑지 떼기~
	         notice.setFiles(fileNames); // "img1.jpg,img2.png,"
	         notice.setWriterId("newlec");
	         service.insert(notice);



//			Notice notice = new Notice(title, content);
//
//			if (filePart != null) {
//				String fileName = filePart.getSubmittedFileName();
//				notice.setFiles(fileName);
//				int newId = service.getLastId() + 1;
////				서블릿들이 필요로하는 것을 공유하는 장소 servletContext - > 절대경로를 사용해야함 - > realPath
//				String pathTemp = request.getServletContext().getRealPath("/static/notice/2020/26/");
//
//				File path = new File(pathTemp);
//				if (!path.exists())
//					path.mkdirs();
//
////				호환을 위해 \\ X
////				String filePath = pathTemp+"\\"+partFile.getSubmittedFileName();
//				String filePath = pathTemp + File.separator + fileName;
//
////				File submittedFile = new File(filePath);
//
//				InputStream fis = filePart.getInputStream();
//
//				FileOutputStream fos = new FileOutputStream(filePath);
//
//				byte[] buf = new byte[1024];
//				int size = 0;
//				while ((size = fis.read(buf)) != -1)
//					fos.write(buf, 0, size);
//				fos.close();
//				fis.close();
//
//			}
//			service.insert(notice);
//
//		}
		}
	}
}
