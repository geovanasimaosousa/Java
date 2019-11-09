<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Esta página é escrita em </h1>

<%
out.println("HTML com JAVA");
%>
<br>
<% 
out.println(new Date());
%>
</body>
</html>