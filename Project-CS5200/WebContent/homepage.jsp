<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="api.*, classes.*, java.sql.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Successful</title>
<style type="text/css">
body {
    background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
 
<body>
    <div class="container">
        <%
       		UserDAO dao = UserDAO.getInstance();
        	User user = new User();
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("User"))
                        userName = cookie.getValue();
                    	user = dao.findUser(userName);
                }
            }
            if (userName == null)
                response.sendRedirect("login.html");
        %>
        <div class="avatar">
	        <img src=<%= user.getAvatar()%>>
	        <p> Name</p> <%= user.getFirstname()%> <%= user.getLastname() %>
	        <p>Biography: </p> <%= user.getBio() %>
	        <p></p>
        </div>
        
        

   <!-- <h3> Hi <%=userName%>, Login successful. </h3> <br> -->     
 
        <form action="LogOutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>
</body>
</html>