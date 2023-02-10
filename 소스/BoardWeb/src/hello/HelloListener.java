package hello;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

    public HelloListener() {
    	System.out.println("===> HelloListener ����");
    }
    
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("---> contextInitialized() ȣ��");
    }
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("---> contextDestroyed() ȣ��");
    }	
}
