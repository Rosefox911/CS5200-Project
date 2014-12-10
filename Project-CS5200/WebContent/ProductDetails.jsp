<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="api.*, classes.*, java.sql.*, java.util.*, java.io.*, java.net.*, org.json.simple.parser.*, org.json.simple.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");

String finderAPI = "http://open.api.ebay.com/shopping?callname=GetSingleItem&responseencoding=JSON&appid=JorgeDel-89b1-4723-8ee2-8812f73e42fe&siteid=0&version=515&ItemID=" + id;

URL url = new URL(finderAPI);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
InputStream stream = connection.getInputStream();
InputStreamReader reader = new InputStreamReader(stream);
BufferedReader buffer = new BufferedReader(reader);
String line;
String json = "";
while((line = buffer.readLine()) != null) {
	json += line;
}
JSONParser parser = new JSONParser();
JSONObject root = (JSONObject) parser.parse(json);
JSONObject FirstItem = (JSONObject) root.get("Item");
String ItemID = FirstItem.get("ItemID").toString();
String EndTime = FirstItem.get("EndTime").toString();
String ItemURL = FirstItem.get("ViewItemURLForNaturalSearch").toString();
String ListingType = FirstItem.get("ListingType").toString();
String GalleryURL = FirstItem.get("GalleryURL").toString();
String PrimaryCategoryID = FirstItem.get("PrimaryCategoryID").toString();
String PrimaryCategoryName = FirstItem.get("PrimaryCategoryName").toString();
String ListingStatus = FirstItem.get("ListingStatus").toString();
String TimeLeft = FirstItem.get("TimeLeft").toString();
String Title = FirstItem.get("Title").toString();
String pictureurl = FirstItem.get("PictureURL").toString();
JSONObject ConvertedCurrentPriceList = (JSONObject) FirstItem.get("ConvertedCurrentPrice");
Double ConvertedCurrentPrice = (Double) ConvertedCurrentPriceList.get("Value");
%>
<h2>Item ID: <%=ItemID %></h2>
<h2>Item URL: <%=ItemURL %></h2>
<h2>Listing Type: <%=ListingType %></h2>
<h2>Picture: <img src = "<%=GalleryURL %>"></h2>
<h2>Price: <%= ConvertedCurrentPrice %></h2>

</body>
</html>