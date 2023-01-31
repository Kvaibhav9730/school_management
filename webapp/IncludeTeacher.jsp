<%@page import="Entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id = Integer.parseInt(request.getParameter("id")); 

EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
EntityManager em = emf.createEntityManager();

Teacher t = em.find(Teacher.class, id);
%>
<center>
<form action="updateteacher" method="post">
Id: <input type="number" value="<%=t.getId() %>" name="id"><br><br>
Name: <input type="text" value="<%=t.getName() %>" name="name"><br><br>
Subject: <input type="text" value="<%=t.getSubject() %>" name="subject"><br><br>
Salary: <input type="number" value="<%=t.getSal() %>" name="salary"><br><br>
<button type="submit">Submit</button>
</form>
</center>
</body>
</html>