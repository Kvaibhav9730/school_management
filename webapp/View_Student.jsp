<%@page import="Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  a{
       color: white;
       text-decoration: underline;
       padding: 25px;
       background-color: navy;
       margin-top: 100px;
       border: 8px groove gray;
       border-radius: 30px;
       font-family: serif;
       position: relative;
       top: 50px;
       display: inline-block;
  }
</style>
</head>
<body>
<h1 color="navy" align="center">Student List</h1>
<hr width="1300">
<%Student s = (Student) session.getAttribute("1"); %>
<table cellpadding="3px" align="center" border="8">

<th>Id</th>
<th>Name</th>
<th>Stream</th>
<th>Fees</th>
<tr>
<td><%=s.getId() %></td>
<td><%=s.getName() %></td>
<td><%=s.getStream() %></td>
<td><%=s.getFees() %></td>
</tr>
</table><br><br>
<center>
<a href="StudentMenu.html">Student Menu</a>
</center>
</body>
</html>