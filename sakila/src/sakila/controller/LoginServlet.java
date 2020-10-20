package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StateService;
import sakila.vo.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private StateService stateService;
	
	//로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginservlet) doget 시작");
		HttpSession session = request.getSession(); //세션이 없을 때 새로 생성, 있으면 세션 리턴
		if(session.getAttribute("loginStaff") != null) {//로그인 상태일 떄
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");  // auth폴더는 로그인 되어있는 회원만 접근 가능
			return;
		}
		System.out.println("loginservlet) doget stateListener and 로그인 확인 이후");
		
		stateService = new StateService();
		State state = stateService.getState();
		System.out.println("loginservlet) doget new stateservice생성 및 getState()");
		
		request.setAttribute("state", state);
		System.out.println("loginservlet) doget session 저장");
		
		int totalCount = stateService.getTotalCount();
		System.out.println("loginservlet) doget total");
		
		request.setAttribute("totalCount",totalCount);
		System.out.println("loginservlet) doget total session");
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	//로그린 액션으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
