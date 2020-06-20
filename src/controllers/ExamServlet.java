package controllers;

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

@WebServlet(name = "controllers/ExamServlet", urlPatterns = "/exam")
public class ExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Tools.printClassMessage(this,"Enter.");

            Answer anwser = new Answer();
            Tools.fill(anwser,request);

            MainServiceInterface mainService = ServiceContainer.get().mainService();
            int score = mainService.judge(anwser);

            MessageDao message = new MessageDao();
            message.setMsg("您这次赚取了 "+score+" SOULS");
            System.out.println(message.getMsg());
            request.setAttribute("message",message);
            request.getRequestDispatcher("/exam.jsp").forward(request, response);



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
            MessageDao message = new MessageDao();
            request.setAttribute("message", message);
            Tools.printClassMessage(this,"Redirect to exam");
            request.getRequestDispatcher("/exam.jsp").forward(request, response);
        }
    }
}
