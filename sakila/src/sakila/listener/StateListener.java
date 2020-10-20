package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import sakila.service.StateService;

@WebListener
public class StateListener implements ServletContextListener { // ServletContextListener ������ �����Ǵ� ���� ����
	private StateService stateService;
    public StateListener() {
    }
    public void sessionCreated(HttpSessionEvent se) { //������ ������ ������ ����
		if(se.getSession().isNew()) { // isNew()������ ���� ������ �ƿ� ���� ���� �������� �Ǻ� =>�ƿ� ���� ���� ������ �� ����
			stateService = new StateService();
			
		}
	}
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
