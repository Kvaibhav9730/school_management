package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Principle;
@WebServlet("/goto_validatep")
public class ValidatePrinciple extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	EntityManager em = emf.createEntityManager();
	
	Query q = em.createQuery("select p from Principle p where p.email = ?1 and p.password = ?2");
	q.setParameter(1, email);
	q.setParameter(2, pass);
	
	List<Principle> lp = q.getResultList();
	for(Principle p : lp) {
		if(email.equals(p.getEmail()) && pass.equals(p.getPassword())) {
			RequestDispatcher rd = req.getRequestDispatcher("Menu.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter pw = resp.getWriter();
			pw.write("Invalid Email OR Password");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		}
	}
}
}
