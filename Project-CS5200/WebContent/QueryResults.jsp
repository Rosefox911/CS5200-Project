<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="api.*, classes.*, java.sql.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<input type=text name="keyword">
<input type="Submit" name="btn" value="submit">
</form>

<%
String keyword = request.getParameter("keyword");
EbayJsonWebServiceClient test3 = new EbayJsonWebServiceClient();

if(keyword != null && keyword.length() > 1) {
	List<Product> products = new ArrayList<Product>();

	products = test3.getProductsforKeyword(keyword);
	%>
	<table class="table">
	<td>Picture</td>
			<td>Title</td>
			<td>Category</td>
			<td>Price</td>
			<td>Time Left</td>
	<%
	for(Product p: products) {
		%>
		
		<tr>
			<td><img src=<%= p.getGalleryURL() %>></td>
			<td><%= p.getTitle() %></td>
			<td><%= p.getPrimaryCategoryName() %></td>
			<td><%= p.getConvertedCurrentPrice() %></td>
			<td><%= p.getTimeLeft() %></td>
		</tr>
		
		<%
	}
}
%>
</table>
</table>
</body>
</html>