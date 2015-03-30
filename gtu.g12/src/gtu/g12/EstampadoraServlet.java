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

public class EstampadoraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		List<Solicitud> lista = dao.getSolPorEstadoYNOBanco("ACEPTADA_UNIV");
		List<Solicitud> lista2 = dao.getSolPorEstado("ASOCIADA_BANCO");
		List<Solicitud> lista3 = dao.getSolPorEstado("IMPRESA_ESTAMP");

		RequestDispatcher view = req.getRequestDispatcher("estampadora.jsp");
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista));
		req.getSession().setAttribute("solicitudes2", new ArrayList<Solicitud>(lista2));
		req.getSession().setAttribute("solicitudes3", new ArrayList<Solicitud>(lista3));
        view.forward(req, resp);
		
	}
}
