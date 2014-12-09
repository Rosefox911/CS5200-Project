package api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

/**
 * Servlet implementation class LoginServlet
 */
 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "User";
    private final String password = "Password";
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String User = request.getParameter("User");
        String pwd = request.getParameter("Password");
 
        if (userID.equals(User) && password.equals(pwd)) {
            Cookie LoginCookie = new Cookie("User", User);
            // setting cookie to expiry in 60 mins
            LoginCookie.setMaxAge(60 * 60);
            response.addCookie(LoginCookie);
            response.sendRedirect("success.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Please make sure you enter UserID/Pass as \"User : Password\".</font>\n");
            rd.include(request, response);
        }
 
    }
}