package gtu.g12;

import java.io.IOException;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotificationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		if (req.getSession().getAttribute("universidad") != null) {
			
			String email = req.getParameter("correoUniv");
			
			dao.changeEstadoSol(email, "REMITIDA_USR");
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("universidad"));
			resp.sendRedirect("/viewState");
		}
		
		if (req.getSession().getAttribute("banco") != null) {
			
			String email = req.getParameter("correoUniv");
			
			dao.changeEstadoSol(email, "REMITIDA_UNIV");
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("universidad"));
			resp.sendRedirect("/viewState");
		}
		
		if (req.getSession().getAttribute("estampadora") != null) {
			
			String email = req.getParameter("correoUniv");
			
			if(dao.getSol(email).isMonedero()){
				dao.changeEstadoSol(email, "REMITIDA_BANCO");
			}else{
				dao.changeEstadoSol(email, "REMITIDA_UNIV");
			}
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("universidad"));
			resp.sendRedirect("/viewState");
		}
	}
}