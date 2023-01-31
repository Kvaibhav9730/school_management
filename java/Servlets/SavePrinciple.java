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

import Entity.Principle;
@WebServlet("/goto_principle")

public class SavePrinciple extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	int age = Integer.parseInt(req.getParameter("age"));
	long mobno = Long.parseLong(req.getParameter("mobno"));
	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Principle p = new Principle();
	p.setName(name);
	p.setAge(age);
	p.setMobno(mobno);
	p.setEmail(email);
	p.setPassword(pass);
	
	et.begin();
	em.persist(p);
	et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Account Created Successfully");
	pw.write("You Can Login Now");
	
	RequestDispatcher rd = req.getRequestDispatcher("Sign-Up.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
}
}
