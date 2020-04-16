<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DokoTsubu</title>
</head>
<body>
<h1>DokoTsubu-LoginResult</h1>
<% if(loginUser != null){ %>
	<p>Login OK!</p>
	<p>Welcome! <%= loginUser.getName() %></p>
	<a href="/DokoTsubu/Main">Go to TsubuTsubu!</a><br>
<% }else { %>
	<p>Login false!</p>
	<a href="/DokoTsubu/Login">return!</a>
<% } %>
</body>
</html>