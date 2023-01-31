<%@page import="Entity.Teacher"%>
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
<h1 color="navy" align="center">Teacher List</h1>
<hr width="1300">
<%Teacher t = (Teacher) session.getAttribute("1"); %>

<table cellpadding="3px" align="center" border="8">
<th>Id</th>
<th>Name</th>
<th>Subject</th>
<th>Salary</th>
<tr>
<td><%=t.getId() %></td>
<td><%=t.getName() %></td>
<td><%=t.getSubject() %></td>
<td><%=t.getSal() %></td>
</tr>
</table>
<center>
<a href="TeacherMenu.html">Teacher Menu</a>
</center>
</body>
</html>