<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>

<script type="text/javascript">
function alertName() {
	alert("Username/Password combination is incorrect!")
}

</script>

<div class="container">

<%
   String sAction = (String) request.getAttribute("blowup");
   if ( sAction != null && (sAction).equals("y")) { %>
   <script> alert("kaboom");</script>
<% } %>

	<h1>Login</h1>
	<form action="/Project-CS5200/loginAction" method="post">
		Username:
		<input name="username" class="form-control"/>
		
		Password:
		<input name="password" type="password"  class="form-control"/>
		
		<button class="btn btn-primary btn-block">Login</button>
	</form>	
</div>
</body>
</html>