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

@WebServlet({"/","/LoginServlet"}) //�α��� �������� �̵��϶� �Ǵ� �ƹ��͵� ���ص� �� �������� ����
public class LoginServlet extends HttpServlet {
	private StateService stateService;
	private StaffService staffService;
	
	//�α��� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("loginservlet) doget ����");
		HttpSession session = request.getSession(); //������ ���� �� ���� ����, ������ ���� ����
		
		if(session.getAttribute("loginStaff") != null) {//�α��� ������ ��
			System.out.println("loginservlet) �α��� �����ΰ�?");

			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");  // auth������ �α��� �Ǿ��ִ� ȸ���� ���� ����  | �ʱ� �ڵ� auth/IndexServlet
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
		int id = 0;
		String pw = "";
		staffService = new StaffService();
		
		//request �߹޾Ҵ��� �����
		System.out.println("doPost) request.getParameter('id')=> "+ request.getParameter("id"));
		System.out.println("doPost) request.getParameter('pw')=> " + request.getParameter("pw"));
		Staff staff = new Staff(); // request ...
		
		//�ƹ��͵� �Է¾��ϰ� �α��� ���� �� ���� ����
		if(request.getParameter("id")== "" || request.getParameter("pw")== "" ) {
			staff.setStaffId(id);
			staff.setPassword(pw);
		}else {//id/pw�Է����� ��
			System.out.println("doPost) request else{}");
			id = Integer.parseInt(request.getParameter("id"));
			pw = request.getParameter("pw");
			staff.setStaffId(id);
			staff.setPassword(request.getParameter("pw"));
		}
		
		
		Staff returnStaff = null;
		returnStaff = staffService.getStaffIDPW(staff); // ��ġ�ϴ��� �Ǵ�
		
		if(returnStaff != null) {
			System.out.println("�α��� ����");
			//session ���
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff); //doGet���� �α��� �������� �ƴ��� �Ǵ��ϱ� ����
			
			// indexServlet ������
			//request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			
		}else {
			System.out.println("�α��� ����");
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	}
}
