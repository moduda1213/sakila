  
package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.*;
@WebListener
public class StateListener implements HttpSessionListener {
    private StateService stateService;
	public StateListener() {}
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("StateListener ¡¯¿‘");
        if(se.getSession().isNew()) {
        	stateService = new StateService();
        	stateService.countState();
        }
    }
    public void sessionDestroyed(HttpSessionEvent se)  {}
}
