package controllers;

import dao.CardPropertiesDao;
import dao.MessageDao;
import dao.UserDao;
import request.*;
import services.MainService;
import services.MainServiceInterface;
import services.ServiceContainer;
import util.Tools;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Number;

@WebServlet(name = "controllers/RandomServlet", urlPatterns = "/random")
public class RandomServlet extends HttpServlet {
    private int number;
    private CardPropertiesDao cardDao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Tools.printClassMessage(this,"Enter.");

            int getNumber = Integer.parseInt(request.getParameter("number"));

            MainServiceInterface mainService = ServiceContainer.get().mainService();
            int result = mainService.judgeRandom(getNumber,number);

            Tools.printClassMessage(this,"Correct number : " + number);

            if(result == 2){
                MessageDao message = new MessageDao();
                message.setMsg("大了");
                request.setAttribute("message",message);

            }else if(result == 1){
                MessageDao message = new MessageDao();
                message.setMsg("小了");
                request.setAttribute("message",message);

            }else{
                MessageDao message = new MessageDao();
                message.setMsg("生成卡片成功");
                request.setAttribute("message",message);
            }

            CardPropertiesDao card = mainService.randomCard(cardDao);
            request.setAttribute("card", card);

            request.getRequestDispatcher("/random.jsp").forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tools.printClassMessage(this,"GET");
        UserDao user = (UserDao)request.getAttribute("user");
        if(user == null) //当前用户还没有登录
        {
            response.sendRedirect("/login");
        } else {
            Tools.printClassMessage(this,"Redirect to random");
            MessageDao message = new MessageDao();
            message.setMsg("");
            request.setAttribute("message", message);

            number = (int)(Math.random()*100) + 1;

            CardPropertiesDao card = new CardPropertiesDao();
            card.setProperty1(0);
            card.setProperty2(0);
            card.setProperty3(1);
            card.setProperty4(0);
            card.setProperty5(1);
            card.setProperty6(0);
            card.setProperty7(1);
            card.setProperty8(0);
            request.setAttribute("card", card);
            cardDao = card;

            request.getRequestDispatcher("/random.jsp").forward(request, response);
        }
    }
}
