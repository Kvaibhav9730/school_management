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

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String stream = req.getParameter("stream");
	double fees = Double.parseDouble(req.getParameter("fees"));
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    Student s = new Student();
    s.setId(id);
    s.setName(name);
    s.setStream(stream);
    s.setFees(fees);
    
    et.begin();
    em.merge(s);
    et.commit();
    
    PrintWriter pw = resp.getWriter();
    pw.write("Data Added Successfully");
    
    RequestDispatcher rd = req.getRequestDispatcher("StudentrMenu.html");
    rd.include(req, resp);
    resp.setContentType("text/html");
}
}
