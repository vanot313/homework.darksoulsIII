package controllers;

import dao.MessageDao;
import dao.UserDao;
import util.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "controllers/DetailServlet", urlPatterns = "/details")
public class DetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tools.printClassMessage(this,"GET");
        UserDao user = (UserDao)request.getAttribute("user");
        if(user == null) //当前用户还没有登录
        {
            response.sendRedirect("/login");
        } else {


            HashMap<String, String[]> cards;
            cards = (HashMap<String, String[]>)request.getSession(true).getAttribute("cards");

            String id = request.getParameter("id");

            request.setAttribute("id",id);
            request.setAttribute("cards", cards);
            Tools.printClassMessage(this,"Redirect to details");
            request.getRequestDispatcher("/details.jsp").forward(request, response);
        }
    }


}