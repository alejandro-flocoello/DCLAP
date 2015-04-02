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
			
			 resp.setContentType("text/html;charset=UTF-8");
			 
		        
			//dao.getSol(correoS).setImage(foto)
			
			if ((dao.getSol(correoS).getEstado()).equals("")) {
				dao.getSol(correoS).setEstado("SOLICITADA");
			}
			req.getSession().setAttribute("solicitud", dao.getSol(correoS));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("usuario"));
			resp.sendRedirect("/viewState");
		}

		
		
		
		
		if (req.getSession().getAttribute("universidad") != null) {

			String email = req.getParameter("correoUniv");
			System.out.println(email);
			 

			if ((dao.getSol(email).getEstado()).equals("SOLICITADA") || (dao.getSol(email).getEstado()).equals("REMITIDA_UNIV")){
				dao.getSol(email).setEstado("ACEPTADA_UNIV");
				
				req.getSession().setAttribute("solicitud", dao.getSol(email));
				req.getSession().setAttribute("rol", req.getSession().getAttribute("universidad"));
				resp.sendRedirect("/viewState");
			}
		}

		
		
		
		if (req.getSession().getAttribute("banco") != null) {

			String email = req.getParameter("correoUniv");
			
			String cv2 = req.getParameter("CV2");
			dao.getSol(email).setCv2(Integer.parseInt(cv2));
			
			
			String cuenta = req.getParameter("Cuenta");
			dao.getSol(email).setCuentaBan(Integer.parseInt(cuenta));
			
			
			
			String pin = req.getParameter("Pin");
			dao.getSol(email).setCuentaBan(Integer.parseInt(pin));
			
	
			if ((dao.getSol(email).getEstado()).equals("ACEPTADA_UNIV") || (dao.getSol(email).getEstado()).equals("REMITIDA_BANCO")) {
				dao.getSol(email).setEstado("ASOCIADA_BANCO");
			}
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("banco"));
			resp.sendRedirect("/viewState");
		}
		
		
		
		
		if (req.getSession().getAttribute("estampadora") != null) {
			
			String email = req.getParameter("correoUniv");

			String numTarjeta = req.getParameter("numTarjeta");
			dao.getSol(email).setNumTarjeta(Integer.parseInt(numTarjeta));
			System.out.println(dao.getSol(email).getNumTarjeta());
			
			
			if ((dao.getSol(email).getEstado()).equals("ASOCIADA_BANCO")) {
				dao.getSol(email).setEstado("IMPRESA_ESTAMP");
			}
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("estampadora"));
			resp.sendRedirect("/viewState");
		}
		
		
		
		
		
		if (req.getSession().getAttribute("gestor") != null) {
			
			String email = req.getParameter("correoUniv");
			
			if ((dao.getSol(email).getEstado()).equals("ELIMINADA")){
				dao.getSol(email).setEstado("");
			}
			
			else {
				dao.getSol(email).setEstado("ELIMINADA");
			}
			
			req.getSession().setAttribute("solicitud", dao.getSol(email));
			req.getSession().setAttribute("rol", req.getSession().getAttribute("gestor"));
			resp.sendRedirect("/gestor");
			
		}
	}
}
