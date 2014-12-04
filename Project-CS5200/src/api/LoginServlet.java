package api;

import java.io.IOException;

import sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Hello from Login Servlet " + username + " "  + password);
		
		UserDAO dao = UserDAO.getInstance();
		
		Boolean result = dao.findUserByUsernamePassword(username, password);
		
		if(result == false)
		{
			response.sendRedirect("/Project-CS5200/login.jsp");
		}
		else {
		//	request.setAttribute("user", user);
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/listMyWeatherLocations.jsp");
		//	dispatcher.forward(request, response);
			response.sendRedirect("/Project-CS5200/success.jsp");
//			response.sendRedirect("/WeatherApp/listMyWeatherLocations.jsp");
		}
	}

}