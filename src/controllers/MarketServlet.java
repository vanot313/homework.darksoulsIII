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

@WebServlet(name = "controllers/MarketServlet", urlPatterns = "/browsecard")
public class MarketServlet extends HttpServlet {

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

            if(cards!=null)
                for(HashMap.Entry<String, String[]>  entry : cards.entrySet()){
                    Tools.printClassMessage(this,"get from session id:" + entry.getKey());
                }
            else{
                cards = new HashMap<String, String[]>();
        }


            request.setAttribute("cards", cards);
            Tools.printClassMessage(this,"Redirect to market");
            request.getRequestDispatcher("/browsecard.jsp").forward(request, response);
        }
    }


}
