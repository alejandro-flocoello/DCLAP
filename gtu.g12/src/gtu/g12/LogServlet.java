package gtu.g12;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.dao.UsuarioDAO;
import gtu.g12.dao.UsuarioDAOImpl;
import gtu.g12.model.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("Cache-Control", "no-cache, no-store");
		resp.setHeader("Pragma", "no-cache");

		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/main");
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		// Comprobar en la base de datos que ese email y password corresponde con un usuario y ver que rol tiene.
		// en funcion de ese rol, lo mandare a un servlet o a otro

		UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		SolicitudDAO daoS = SolicitudDAOImpl.getInstance();
		HttpSession session= request.getSession();

		if (!(user.isEmpty()) || !(password.isEmpty())) {

			Usuario nombreUser = daous.getUserName(user);
			

			if (nombreUser != null) {

				Usuario usIden = daous.getUserPassword(user, password);

				if (usIden != null) {
					
					if (usIden.getRol().equals("solicitante") && (session.getAttribute("usuario") == null)) {
				        
						session.setAttribute("usuario",user);  
				        
				        String correo = nombreUser.getUsuario();
			        
				        if(daoS.getSol(correo).getEstado().equals("")){
				        	response.sendRedirect("/usuario");
				        
				        }else{
				        	String correoS = (String) request.getSession().getAttribute("usuario");
				    		request.getSession().setAttribute("solicitud", daoS.getSol(correoS));
							request.getSession().setAttribute("rol", request.getSession().getAttribute("usuario"));
				        	response.sendRedirect("/viewState");
				        
				        }
						
					} else if (usIden.getRol().equals("universidad")  && (session.getAttribute("universidad") == null)) { 
				        session.setAttribute("universidad",user);
						response.sendRedirect("/universidad");
					
					
					} else if (usIden.getRol().equals("banco") && (session.getAttribute("banco") == null)) {  
				        session.setAttribute("banco",user);
						response.sendRedirect("/banco");
					
					
					} else if (usIden.getRol().equals("estampadora") && (session.getAttribute("estampadora") == null)) {
				        session.setAttribute("estampadora",user);
						response.sendRedirect("/estampadora");
					
					
					} else if (usIden.getRol().equals("gestor") && (session.getAttribute("gestor") == null)) { 
				        session.setAttribute("gestor",user);
						response.sendRedirect("/gestor");
					}

				} else { 
					session.setAttribute("error","Contraseņa incorrecta");
					response.sendRedirect("/error"); }
			
			} else{ 
				session.setAttribute("error","El usuario introducido no existe");
				response.sendRedirect("/error"); }

		} else { 
			session.setAttribute("error","Rellene todos los campos");
			response.sendRedirect("/error"); }
	}
}