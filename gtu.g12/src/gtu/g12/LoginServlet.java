package gtu.g12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.dao.UsuarioDAO;
import gtu.g12.dao.UsuarioDAOImpl;
import gtu.g12.model.Solicitud;
import gtu.g12.model.Usuario;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		// Comprobar en la base de datos que ese email y password corresponde con un usuario y ver que rol tiene.
		// en funcion de ese rol, lo mandare a un servlet o a otro

		UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		SolicitudDAO daoS = SolicitudDAOImpl.getInstance();
		

		if (!(user.isEmpty()) || !(password.isEmpty())) {

			Usuario nombreUser = daous.getUserName(user);

			if (nombreUser != null) {

				Usuario usIden = daous.getUserPassword(user, password);

				if (usIden != null) {
					HttpSession session= request.getSession();
					if (usIden.getRol().equals("solicitante") && (session.getAttribute("usuario") == null)) {
				        session.setAttribute("usuario",user);  
				        
				        String correo = nombreUser.getUsuario();
			        
				        if(daoS.getSol(correo).getEstado().equals("")){
				        	response.sendRedirect("/usuario1");
				        }else{
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

				} else { response.sendRedirect("/error"); }
			
			} else{ response.sendRedirect("/error"); }

		} else { response.sendRedirect("/error"); }
	}
}