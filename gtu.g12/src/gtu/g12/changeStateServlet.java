package gtu.g12;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class changeStateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		SolicitudDAO daoS = SolicitudDAOImpl.getInstance();

		if (req.getSession().getAttribute("usuario") != null) {

			String correoS = (String) req.getSession().getAttribute("usuario");

			if ((daoS.getSol(correoS).getEstado()).equals("")) {
				daoS.getSol(correoS).setEstado("SOLICITADA");
			}
			req.getSession().setAttribute("solicitud", daoS.getSol(correoS));
			resp.sendRedirect("/viewState");
		}

		
		if (req.getSession().getAttribute("universidad") != null) {
			
			String email = req.getParameter("correoUniv");
		
			if ((daoS.getSol(email).getEstado()).equals("SOLICITADA")) {
				daoS.getSol(email).setEstado("ACEPTADA_UNIV");
				System.out.println(daoS.getSol(email).getEstado());
			}
		}
	}
}
