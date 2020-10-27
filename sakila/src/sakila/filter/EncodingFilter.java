  
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
public class EncodingFilter implements Filter { // 체인을 따라 다음에 존재하는 필터로 이동 / 체인의 가장 마지막에는 클라이언트가 요청한 최종 자원이 위치
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFilter 실행 : request utf-8 인코딩");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response); //등록된 다음 필터로 이동
	}
	public EncodingFilter() {}
	public void destroy() {} // 필터가 웹 컨테이너에서 삭제할 때 호출
	public void init(FilterConfig fConfig) throws ServletException {} // 필터를 초기화할 때 호출
}
