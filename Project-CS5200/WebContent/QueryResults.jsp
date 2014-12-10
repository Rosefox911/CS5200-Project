<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="api.*, classes.*, java.sql.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ebay Product Search</title>
<script>
function captureLike(itemid)
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","processLike.jsp?id=" + itemid,true);
xmlhttp.send();
}
</script>
</head>
<body>

	<form method="post">
		<input type=text name="keyword"> <input type="Submit"
			name="btn" value="submit">
	</form>

	<%
		String keyword = request.getParameter("keyword");
		EbayJsonWebServiceClient test3 = new EbayJsonWebServiceClient();

		if (keyword != null && keyword.length() > 1) {
			List<Product> products = new ArrayList<Product>();

			products = test3.getProductsforKeyword(keyword);
	%>
	<table class="table">
		<tr>
			<td>Picture</td>
			<td>Title</td>
			<td>Category</td>
			<td>Price</td>
			<td>Time Left</td>
			<td>Like Product</td>
		</tr>
		<%
			for (Product p : products) {
		%>
		<tr>
			<td><a href="ProductDetails.jsp?id=<%= p.getItemID()%>"><img src=<%=p.getGalleryURL()%>></a></td>
			<td><%=p.getTitle()%></td>
			<td><%=p.getPrimaryCategoryName()%></td>
			<td>$<%=p.getConvertedCurrentPrice()%></td>
			<td><%=p.getTimeLeft()%></td>
			<td><input type="button" name = "like" value = "like" onclick="captureLike(<%= p.getItemID() %>)"></td>
		</tr>
		<%
			}
			}
			
		%>
	</table>
</body>
</html>