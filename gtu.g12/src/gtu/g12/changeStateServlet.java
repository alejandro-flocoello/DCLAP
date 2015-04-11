package gtu.g12;

import java.io.IOException;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class changeStateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		SolicitudDAO dao = SolicitudDAOImpl.getInstance();

		if (req.getSession().getAttribute("usuario") != null) {

			String correoS = (String) req.getSession().getAttribute("usuario");
						 
			if ((dao.getSol(correoS).getEstado()).equals("")) {
				dao.changeEstadoSol(correoS, "SOLICITADA");
			}
			req.getSession().setAttribute("solicitud", dao.getSol(correoS));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("usuario"));
			resp.sendRedirect("/viewState");
		}

		
		
		
		
		if (req.getSession().getAttribute("universidad") != null) {

			String email = req.getParameter("correoUniv");			 

			if ((dao.getSol(email).getEstado()).equals("SOLICITADA")){
				dao.changeEstadoSol(email, "ACEPTADA_UNIV");
			}else if ((dao.getSol(email).getEstado()).equals("REMITIDA_UNIV")){
				dao.changeEstadoSol(email, "REMITIDA_USR");
			}
				req.getSession().setAttribute("solicitud", dao.getSol(email));
				req.getSession().setAttribute("rol", req.getSession().getAttribute("universidad"));
				resp.sendRedirect("/viewState");
		}

		
		
		
		if (req.getSession().getAttribute("banco") != null) {

			String email = req.getParameter("correoUniv");
			
			String cv2 = req.getParameter("CV2");
			int cv = Integer.parseInt(cv2);
			
			String cuenta = req.getParameter("Cuenta");
			int cuentaB = Integer.parseInt(cuenta);
			
			String Pin = req.getParameter("Pin");
			int pin =Integer.parseInt(Pin);
			
			dao.addBan(email, cuentaB, pin, cv);
			
	
			if ((dao.getSol(email).getEstado()).equals("ACEPTADA_UNIV")) {
				dao.changeEstadoSol(email, "ASOCIADA_BANCO");
			}else if ((dao.getSol(email).getEstado()).equals("REMITIDA_BANCO")){
				dao.changeEstadoSol(email, "REMITIDA_UNIV");
			}
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("banco"));
			resp.sendRedirect("/viewState");
		}
		
		
		
		
		if (req.getSession().getAttribute("estampadora") != null) {
			
			String email = req.getParameter("correoUniv");

			String numTarjeta = req.getParameter("numTarjeta");
			int numero = Integer.parseInt(numTarjeta);
			dao.addEstamp(email, numero);			
			
			if ((dao.getSol(email).getEstado()).equals("ASOCIADA_BANCO")) {
				dao.changeEstadoSol(email, "IMPRESA_ESTAMP");
			}else if ((dao.getSol(email).getEstado()).equals("ACEPTADA_UNIV")){
				dao.changeEstadoSol(email, "IMPRESA_ESTAMP");
			}else if ((dao.getSol(email).getEstado()).equals("IMPRESA_ESTAMP")){
				if ((dao.getSol(email).isMonedero())){
					dao.changeEstadoSol(email, "REMITIDA_BANCO");
				}else{
					dao.changeEstadoSol(email, "REMITIDA_UNIV");
				}
			}
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("estampadora"));
			resp.sendRedirect("/viewState");
		}
			
		
		if (req.getSession().getAttribute("gestor") != null) {
			
			String email = req.getParameter("correoUniv");
			
			if ((dao.getSol(email).getEstado()).equals("ELIMINADA")){
				dao.changeEstadoSol(email, "");
				//dao.removeSol(email);
			}
			
			else {
				dao.changeEstadoSol(email, "ELIMINADA");
			}
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("gestor"));
			resp.sendRedirect("/gestor");
			
		}
	}
}