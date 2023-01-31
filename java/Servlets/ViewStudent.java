package Servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Student;

@WebServlet("/view_student")
public class ViewStudent extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	EntityManager em = emf.createEntityManager();
	
	Student s = em.find(Student.class, id);
	HttpSession hs = req.getSession();
	hs.setAttribute("1", s);
	
	RequestDispatcher rd = req.getRequestDispatcher("View_Student.jsp");
    rd.forward(req, resp);
}
}
