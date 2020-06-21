package controllers;

import dao.MessageDao;
import dao.UserDao;
import enums.GenerationType;
import enums.Properties;
import enums.PropertyType;
import enums.StandardType;
import util.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "controllers/AddCardServlet", urlPatterns = "/addCard")
public class AddCardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tools.printClassMessage(this, "POST");
        HashMap<String, String[]> cards;
        String id;
        String[] value = new String[12];

        cards = (HashMap<String, String[]>)request.getSession(true).getAttribute("cards");
        if(cards == null){
            cards = new HashMap<String, String[]>();
        }

        id = request.getParameter("id");
        value[0] = request.getParameter("name");
        value[1] = request.getParameter("standard");
        value[2] = request.getParameter("generation");
        value[3] = request.getParameter("1");
        value[4] = request.getParameter("2");
        value[5] = request.getParameter("3");
        value[6] = request.getParameter("4");
        value[7] = request.getParameter("5");
        value[8] = request.getParameter("6");
        value[9] = request.getParameter("7");
        value[10] = request.getParameter("8");
        value[11] = request.getParameter("url");


//        Tools.printClassMessage(this, "id:" + id);
//        Tools.printClassMessage(this, "name: " + value[0]);
//        Tools.printClassMessage(this, "standard: " + StandardType.getType(Integer.parseInt(value[1])));
//        Tools.printClassMessage(this, "generation: " + GenerationType.getType(Integer.parseInt(value[2])));
//        Tools.printClassMessage(this, Properties.getType(1) + ": " + PropertyType.getType(Integer.parseInt(value[3])));
//        Tools.printClassMessage(this, Properties.getType(2) + ": " + PropertyType.getType(Integer.parseInt(value[4])));
//        Tools.printClassMessage(this, Properties.getType(3) + ": " + PropertyType.getType(Integer.parseInt(value[5])));
//        Tools.printClassMessage(this, Properties.getType(4) + ": " + PropertyType.getType(Integer.parseInt(value[6])));
//        Tools.printClassMessage(this, Properties.getType(5) + ": " + PropertyType.getType(Integer.parseInt(value[7])));
//        Tools.printClassMessage(this, Properties.getType(6) + ": " + PropertyType.getType(Integer.parseInt(value[8])));
//        Tools.printClassMessage(this, Properties.getType(7) + ": " + PropertyType.getType(Integer.parseInt(value[9])));
//        Tools.printClassMessage(this, Properties.getType(8) + ": " + PropertyType.getType(Integer.parseInt(value[10])));
//        Tools.printClassMessage(this, "url: " + value[11]);


        cards.put(id, value);
        HttpSession session = request.getSession(true);
        session.setAttribute("cards", cards);

        MessageDao message = new MessageDao();
        message.setMsg("添加成功");
        request.setAttribute("message",message);
        request.getRequestDispatcher("/addcard.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tools.printClassMessage(this,"GET");
        UserDao user = (UserDao)request.getAttribute("user");
        if(user == null) //当前用户还没有登录
        {
            response.sendRedirect("/login");
        } else {
            MessageDao message = new MessageDao();
            request.setAttribute("message", message);
            Tools.printClassMessage(this,"Redirect to addCard");
            request.getRequestDispatcher("/addcard.jsp").forward(request, response);
        }
    }
}
