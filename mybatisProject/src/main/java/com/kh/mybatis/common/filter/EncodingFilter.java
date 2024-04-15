package com.kh.mybatis.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*") // * 찍어주면 모든 곳에 필터 적용
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터가 종료할 때 해주는 작업
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	// 우리가 지금까지 하던 servlet은 httprequest, 여기서는 servletrequest.
	// servlet이 부모 http가 자식
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청을 가로채거나
		
		// 특정 조건에 따라서 다른 필터나 서블릿으로 요청을 전달
		request.setCharacterEncoding("UTF-8");
		System.out.println("인코딩 필터 통과");
		chain.doFilter(request, response);
		// 가던길 그대로 가라(필터 내용없으면 근야 가라~)
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 초기화 작업
		// TODO Auto-generated method stub
	}

}
