package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener { //ServletContextListener : 톰캣이 켜질때 실행
    public DBListener() {
    }
    public void contextDestroyed(ServletContextEvent arg0)  {      
    }
    
    public void contextInitialized(ServletContextEvent arg0)  { //DB드라이브 연결
        System.out.println("DBListener.contextInitialized() 실행");
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	System.out.println("mariadb 드라이브로딩 성공");
        }catch(ClassNotFoundException e) {
        	System.out.println("Class.forName()실행 실패!");
        	e.printStackTrace();
        }
    }	
}
