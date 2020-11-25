package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

// 	 모든 url 
//   init의 filterConfig에 전달할 값 encoding이란 이름으로 UTF-8 전달
@WebFilter(
		urlPatterns = {"/*"},
		initParams = {@WebInitParam(name="encoding", value="UTF-8")}
)
public class CharactrerEncodingFilter implements Filter {

	private String encoding = "UTF-8"; // 기본 인코딩 방식 - > UTF-8로 설정
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		읽어들일 때 사용자가 설정한 encoding방식으로 읽기
		request.setCharacterEncoding(encoding);
//		System.out.println("필터 전");
//		필터 전
		chain.doFilter(request, response);
//		필터 후
		
//		System.out.println("after 필터 실행");

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		filterConfig - > web.xml의 param-value 값이 전달됨.
		encoding = filterConfig.getInitParameter("encoding");
	}

}
