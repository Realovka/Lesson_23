package by.tms.servlets;

import by.tms.operation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("Init first");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String a = req.getParameter("num1");
        String b = req.getParameter("num2");
        String type = req.getParameter("type");
        getResponse(a, b, type, resp);
    }

    private void getResponse(String a, String b, String type, HttpServletResponse resp){
        Map<Type, Operation> hashMap = new HashMap<>();
        double num1=Double.parseDouble(a);
        double num2=Double.parseDouble(b);
        hashMap.put(Type.SUM, new Sum());
        hashMap.put(Type.SUBTR, new Subtr());
        hashMap.put(Type.DIV, new Div());
        hashMap.put(Type.MULT, new Mult());
        try {
            resp.getWriter().print(hashMap.get(Type.valueOf(type)).calc(num1,num2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
