package gtu.g12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

public class UniversidadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		List<Solicitud> lista = dao.getSolPorEstado("SOLICITADA");
		List<Solicitud> lista2 = dao.getSolPorEstado("REMITIDA_UNIV");
		List<Solicitud> lista3 = dao.getSolPorEstado("RECHAZADA_BANCO");
		List<Solicitud> lista4 = dao.getSolPorEstadoYNoBanco("RECHAZADA_ESTAMP");
		
		RequestDispatcher view = req.getRequestDispatcher("universidad.jsp");
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista));
		req.getSession().setAttribute("solicitudes2", new ArrayList<Solicitud>(lista2));
		req.getSession().setAttribute("solicitudes3", new ArrayList<Solicitud>(lista3));
		req.getSession().setAttribute("solicitudes4", new ArrayList<Solicitud>(lista4));
        view.forward(req, resp);
		
	}
}