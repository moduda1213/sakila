package sakila.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StateService;
import sakila.vo.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StateService stateService;
	private StaffService staffService;
	
	//�α��� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("loginservlet) doget ����");
		HttpSession session = request.getSession(); //������ ���� �� ���� ����, ������ ���� ����
		if(session.getAttribute("loginStaff") != null) {//�α��� ������ ��
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");  // auth������ �α��� �Ǿ��ִ� ȸ���� ���� ����
			return;
		}
		//System.out.println("loginservlet) doget stateListener and �α��� Ȯ�� ����");
		
		stateService = new StateService();
		State state = stateService.getState();
		//System.out.println("loginservlet) doget new stateservice���� �� getState()");
		
		request.setAttribute("state", state);
		//System.out.println("loginservlet) doget session ����");
		
		int totalCount = stateService.getTotalCount();
		//System.out.println("loginservlet) doget total");
		
		request.setAttribute("totalCount",totalCount);
		//System.out.println("loginservlet) doget total session");
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	//�α׸� �׼����� �̵�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost) loginAction ����");
		
		staffService = new StaffService();
		
		//requset �߹޾Ҵ��� �����
		System.out.println("doPost) request.getParameter('id')=> "+ request.getParameter("id"));
		System.out.println("doPost) request.getParameter('pw')=> " + request.getParameter("pw"));
		Staff staff = new Staff(); // request ...
		staff.setStaffId(Integer.parseInt(request.getParameter("id")));
		staff.setPassword(request.getParameter("pw"));
		
		Staff returnStaff = null;
		returnStaff = staffService.getStaffIDPW(staff);
		
		if(returnStaff != null) {
			System.out.println("�α��� ����");
			//session ���
			HttpSession session = request.getSession();
			request.setAttribute("staff", returnStaff);
			// indexServlet ������
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			
		}else {
			System.out.println("�α��� ����");
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
		}
		
	}
}
