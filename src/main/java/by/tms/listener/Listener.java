package by.tms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("users", new ArrayList<>());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println(sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
