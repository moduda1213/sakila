package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import sakila.service.StateService;

@WebListener
public class StateListener implements ServletContextListener { // ServletContextListener 세션이 생성되는 것을 감시
	private StateService stateService;
    public StateListener() {
    }
    public void sessionCreated(HttpSessionEvent se) { //세션이 생성된 시점에 실행
		if(se.getSession().isNew()) { // isNew()새션이 죽은 것인지 아예 새로 받은 세션인지 판별 =>아예 새로 받은 세션일 때 실행
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
