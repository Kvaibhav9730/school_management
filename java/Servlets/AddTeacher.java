package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Teacher;
@WebServlet("/add_teacher")
public class AddTeacher extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String subject = req.getParameter("subject");
	double salary = Double.parseDouble(req.getParameter("salary"));
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Teacher t = new Teacher();
	t.setName(name);
	t.setSubject(subject);
	t.setSal(salary);
	
	et.begin();
	em.persist(t);
	et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Data Added Successfully");
	
	RequestDispatcher rd = req.getRequestDispatcher("Menu.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
}
}
