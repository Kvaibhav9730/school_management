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

import Entity.Student;

@WebServlet("/delete_student")
public class DeleteStudent extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Student s = em.find(Student.class, id);
	
	et.begin();
	em.remove(s);
	et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Data Deleted Successfully");
	
	RequestDispatcher rd = req.getRequestDispatcher("StudentMenu.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
}
}
