<%@ page import="java.util.Date" %>
<%@ page import="com.liuxiaonian.demo.data.User" %>
<h1><%= new Date()%></h1>
<%
    String result = request.getParameter("userName");
    System.err.println(result);
%>
<h2><%= request.getParameter("userName")%></h2>