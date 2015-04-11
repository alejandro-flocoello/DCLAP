package gtu.g12;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class GestorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		List<Solicitud> lista1 = dao.listSol();
		List<Solicitud> lista2 = dao.getSolPorEstado("ELIMINADA");
		
		RequestDispatcher view = req.getRequestDispatcher("gestor.jsp");
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista1));
		req.getSession().setAttribute("solicitudes2", new ArrayList<Solicitud>(lista2));
        view.forward(req, resp);
		
	}
}