<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="api.*, classes.*, java.sql.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <%
       		UserDAO dao = UserDAO.getInstance();
        	User user = new User();
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("User")) {
                        userName = cookie.getValue();
                    	user = dao.findUser(userName);
                    	break;
                    }
                }
            }
            if (userName == null)
                response.sendRedirect("login.html");
        %>
<title><%= user.getFirstname()%> <%= user.getLastname() %>'s Homepage</title>
</head>
 
<body>
    <div class="container">
        <div class="avatar">
	        <img src=<%= user.getAvatar()%>>
	        <p> </p> <%= user.getFirstname()%> <%= user.getLastname() %>
	        <p> </p> <%= user.getBio() %>
	        <form action="LogOutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
        </div>
        
        
        <div class="queries">
        <form action="./searchUser.jsp" method="post">
            <br> <br> Search Username: <input type="text" name="targetUser">
            <br> <br> <input type="submit" value="Seach Usernames">
        </form>
        
    		<form action="./QueryResults.jsp" method="post" target="_blank">
            <br> <br> Search Products: <input type="text" name="keyword">
            <br> <br> <input type="Submit" name ="btn" value="Search Products">
        </form>
    </div>
         
    </div>
      <%LikeDAO l = LikeDAO.getInstance();
    List<Like> recentLikes = l.recentLikes(user.getUsername());
    %>
    
    <%
			for (Like like: recentLikes) {
		%>
		
		<tr>
		<td><%=like.getUser().getFirstname() %> likes item<%=like.getId().getSku()%></td>
		</tr>
		<%} %>
</body>
</html>