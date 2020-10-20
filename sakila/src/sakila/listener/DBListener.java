package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener { //ServletContextListener : ��Ĺ�� ������ ����

    public DBListener() {
    	
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }
    
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("DBListener.contextInitialized() ����");
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	System.out.println("mariadb ����̺�ε� ����");
        }catch(ClassNotFoundException e) {
        	System.out.println("Class.forName()���� ����!");
        	e.printStackTrace();
        }
    }
	
}
