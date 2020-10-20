/*
 	������Ʈ ���� ����
	���� ���� : request���ڵ� ����, ���������� ���� �˻� ����
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
public class EncodingFilter implements Filter { // ü���� ���� ������ �����ϴ� ���ͷ� �̵� / ü���� ���� ���������� Ŭ���̾�Ʈ�� ��û�� ���� �ڿ��� ��ġ
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFilter ���� : request utf-8 ���ڵ�");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response); //��ϵ� ���� ���ͷ� �̵�
	}
	public EncodingFilter() {}
	public void destroy() {} // ���Ͱ� �� �����̳ʿ��� ������ �� ȣ��
	public void init(FilterConfig fConfig) throws ServletException {} // ���͸� �ʱ�ȭ�� �� ȣ��
}
