package gtu.g12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

public class EstampadoraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		//List<Solicitud> lista" = dao.getSolPorEstadoYBanco("ACEPTADA_UNIV");
		List<Solicitud> lista = dao.getSolPorEstado("ASOCIADA_BANCO");

		RequestDispatcher view = req.getRequestDispatcher("estampadora.jsp");
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista));
		//req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista2));
        view.forward(req, resp);
		
	}
}
