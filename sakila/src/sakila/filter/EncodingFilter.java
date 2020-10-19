/*
 	프로젝트 구조 셋팅
	필터 생성 : request인코딩 필터, 인증페이지 세션 검사 필터
*/
package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFilter 실행 : request utf-8 인코딩");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}
	public EncodingFilter() {}
	public void destroy() {}
	public void init(FilterConfig fConfig) throws ServletException {}
}
