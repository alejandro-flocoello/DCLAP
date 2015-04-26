package gtu.g12;

import java.io.IOException;
import java.util.regex.Pattern;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changeStateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		HttpSession session= req.getSession();

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
			
			String cuenta = req.getParameter("Cuenta");
			
			String Pin = req.getParameter("Pin");
			
			
			if (cuenta.equals("")){
				
				session.setAttribute("error","Introduzca el número de cuenta");
				resp.sendRedirect("/error");
				return;
			}
			else if (cuenta.length()!=20 || Pattern.matches("\\d+", (CharSequence) cuenta)==false){
				
				session.setAttribute("error","Introduzca un número de cuenta de 20 dígitos");
				resp.sendRedirect("/error");
				return;
			
			
			}
			else if (Pin.equals("")){
				
				session.setAttribute("error","Introduzca el Pin");
				resp.sendRedirect("/error");
				return;
			}
			else if (Pin.length()!=4){
				
				session.setAttribute("error","Introduzca un pin de 4 dígitos");
				resp.sendRedirect("/error");
				return;
			}
			else if (Pattern.matches("\\d+", (CharSequence) Pin)==false){
				
				session.setAttribute("error","Introduzca un pin de 4 dígitos");
				resp.sendRedirect("/error");
				return;
			}
			
			else if (cv2.equals("")){
				
				session.setAttribute("error","Introduzca el CV2");
				resp.sendRedirect("/error");
				return;
			}
			else if (cv2.length()!=3 || Pattern.matches("\\d+", (CharSequence) cv2)==false){
				
				session.setAttribute("error","Introduzca un CV2 de 3 dígitos");
				resp.sendRedirect("/error");
				return;
			}
			else {
				int cv = Integer.parseInt(cv2);
				//float cuentaB = Float.parseFloat(cuenta);
				//System.out.println(cuentaB);
				//String s = String.valueOf(cuentaB);
				//System.out.println(s);
				int pin =Integer.parseInt(Pin);
				dao.addBan(email, cuenta, pin, cv);
			}
	
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
			
			if (numTarjeta.equals("")){
				
				session.setAttribute("error","Introduzca el número de tarjeta");
				resp.sendRedirect("/error");
				return;
			}
			else if (numTarjeta.length()!=16 || Pattern.matches("\\d+", (CharSequence) numTarjeta)==false){
				
				session.setAttribute("error","Introduzca un número de cuenta de 16 dígitos");
				resp.sendRedirect("/error");
				return;
			
			}else {
				//int numero = Integer.parseInt(numTarjeta);
				dao.addEstamp(email, numTarjeta);		
			}
					
			
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