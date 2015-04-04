package gtu.g12;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RechazosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		
		if (req.getSession().getAttribute("universidad") != null) {
			
			String email = req.getParameter("correoUniv");
					
			if ((dao.getSol(email).getEstado()).equals("SOLICITADA")) {
				dao.getSol(email).setEstado("RECHAZADA_UNIV");
			}
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("universidad"));
			resp.sendRedirect("/viewState");
		}
		
		
		
		
		if (req.getSession().getAttribute("banco") != null) {
			
			String email = req.getParameter("correoUniv");
					
			if ((dao.getSol(email).getEstado()).equals("ACEPTADA_UNIV")) {
				dao.getSol(email).setEstado("RECHAZADA_BANCO");
			}
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("banco"));
			resp.sendRedirect("/viewState");
		}

	
		if (req.getSession().getAttribute("estampadora") != null) {
			
			String email = req.getParameter("correoUniv");
					
			if ((dao.getSol(email).getEstado()).equals("ASOCIADA_BANCO") || (dao.getSol(email).getEstado()).equals("ACEPTADA_UNIV")) {
				dao.getSol(email).setEstado("RECHAZADA_ESTAMP");
			}
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("estampadora"));
			resp.sendRedirect("/viewState");
		}
	}
}

