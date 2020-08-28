package by.tms.servlets;

import by.tms.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet (urlPatterns = "/auto")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List<User> users=(List<User>) getServletContext().getAttribute("users");

        for(User user:users){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);
            }
        }
    }
}
