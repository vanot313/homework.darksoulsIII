package controllers;

import modles.UserAccess;
import request.UserLogin;
import services.MainServiceInterface;
import services.ServiceContainer;
import util.Tools;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controllers/loginServlet", urlPatterns = "/login")
public class loginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Tools.printClassMessage(this,"Enter.");

			UserLogin login = new UserLogin();
			Tools.fill(login,request);

			MainServiceInterface mainService = ServiceContainer.get().mainService();
			UserAccess access = mainService.login(login,response);



			if(access != null){
				Tools.printClassMessage(this,"Redirect to index.");
				Tools.sendRedirect(response,this.getServletContext(),"");
			}else{
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			Tools.printClassMessage(this,"POST");

		}catch (Exception e){
			e.printStackTrace();
		}



//				String message="";
//				request.setCharacterEncoding("UTF-8");
//				String username=request.getParameter("username");
//				String password=request.getParameter("password");
//				if(username.equals("zjh")&&password.equals("123456"))
//				{
//					HttpSession session=request.getSession();
//					session.setAttribute("username", "zjh");
//					//RequestDispatcher rd=request.getRequestDispatcher("/getship.jsp");
//					RequestDispatcher rd=request.getRequestDispatcher("/information.do");
//					rd.forward(request,response);
//				}
//				else
//				{
//					/*message="username or password wrong,please enter again";
//					request.setAttribute("message", message);
//					RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
//					rd.forward(request,response);*/
//					response.sendRedirect("error.html");
//				}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tools.printClassMessage(this,"GET");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
}
