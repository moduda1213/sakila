package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	//�α��� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) {//�α��� ������ ��
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");  // auth������ �α��� �Ǿ��ִ� ȸ���� ���� ����
			return;
		}
		request.getRequestDispatcher("/WEB-INF/loing.jsp").forward(request, response);
	}
	//�α׸� �׼����� �̵�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
