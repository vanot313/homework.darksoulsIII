package controllers;

import dao.MessageDao;
import dao.UserDao;
import request.Answer;
import services.MainServiceInterface;
import services.ServiceContainer;
import sql.fakeSql;
import util.Tools;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmailServlet extends HttpServlet {
    private ServletConfig config = null;
    private String email = null;
    private String username = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tools.printClassMessage(this, "Enter");
        UserDao user = new UserDao();
        user.setId(username);
        user.setEmail(email);
        Tools.printClassMessage(this, "Set UserDao");
        user.setCard(fakeSql.query());

        request.setAttribute("user",user);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        this.config=config;
        email=config.getInitParameter("email");
        username=config.getInitParameter("username");
        Tools.printClassMessage(this, username);
        Tools.printClassMessage(this, email);

    }
}
