package com.faiez.web;

import com.faiez.ejb.UserBeanLocal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import javax.naming.InitialContext;


@WebServlet(name="myServlet", urlPatterns = { "/fzservlet/*" })
public class MyServlet extends HttpServlet {

    @EJB
    private UserBeanLocal hello;

    private InitialContext initialContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        /*Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.core.LocalInitialContextFactory");
        HelloBeanLocal helloBeanLocal=null;
        try {
            initialContext = new InitialContext(properties);

             helloBeanLocal = (HelloBeanLocal) initialContext.lookup("HelloBeanLocal");

        } catch (NamingException e) {
            e.printStackTrace();
        }*/


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Test </h2>");
        out.println("Result : "+hello.sayHello());

        out.flush();
        out.close();

    }


}
