package by.tms.servlets;

import by.tms.entity.Result;
import by.tms.operation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {

    List<Result> results=new ArrayList<>();

    @Override
    public void init() throws ServletException {
        System.out.println("Init first");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session=req.getSession();
        String a = req.getParameter("num1");
        String b = req.getParameter("num2");
        String type = req.getParameter("type");
        double result=getResponse(a, b, type, resp);
        Result result1=new Result(a,b,type,result);
        results.add(result1);
        session.setAttribute("result", results);
        resp.getWriter().println(result);
    }

    private double getResponse(String a, String b, String type, HttpServletResponse resp) {
        Map<Type, Operation> hashMap = new HashMap<>();
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        hashMap.put(Type.SUM, new Sum());
        hashMap.put(Type.SUBTR, new Subtr());
        hashMap.put(Type.DIV, new Div());
        hashMap.put(Type.MULT, new Mult());
        return hashMap.get(Type.valueOf(type)).calc(num1, num2);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
