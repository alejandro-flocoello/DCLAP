package gtu.g12;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Estampadora3Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		String email = req.getParameter("correoUniv");
		
		Solicitud solicitud = dao.getSol(email);	
				
		req.getSession().setAttribute("solicitud", solicitud);
		RequestDispatcher view = req.getRequestDispatcher("estampadora3.jsp");
	    view.forward(req, resp);
	}
}	