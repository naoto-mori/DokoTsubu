<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Mutter" %>
<%@ page import="java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
List<Mutter> mutterList = (List<Mutter>)request.getAttribute("mutterList");
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DokoTsubu</title>
</head>
<body>
<h1>DokoTsubu Main</h1>
<p>[<%= loginUser.getName() %>]</p>
<form action="/DokoTsubu/Main" method="post">
	<input type="text" name="text"><br>
	<input type="submit" value="Tsubu!">
</form>
<% if(errorMsg != null){ %>
	<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList){ %>
	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %>
<a href="/DokoTsubu/Main">reload!</a><br>
<a href="/DokoTsubu/Logout">Logout!</a>
</body>
</html>