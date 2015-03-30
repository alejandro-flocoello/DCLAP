package gtu.g12;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gtu.g12.dao.UsuarioDAO;
import gtu.g12.dao.UsuarioDAOImpl;
import gtu.g12.model.Usuario;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		// Comprobar en la base de datos que ese email y password corresponde con un usuario y ver que rol tiene.
		// en funcion de ese rol, lo mandare a un servlet o a otro

		UsuarioDAO daous = UsuarioDAOImpl.getInstance();

		if (!(user.isEmpty()) || !(password.isEmpty())) {

			Usuario nombreUser = daous.getUserName(user);

			if (nombreUser != null) {

				Usuario usIden = daous.getUserPassword(user, password);

				if (usIden != null) {
					if (usIden.getRol().equals("solicitante")) {
						HttpSession session= request.getSession();  
				        session.setAttribute("usuario",user);  
						response.sendRedirect("/usuario1");
					
					} else if (usIden.getRol().equals("universidad")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("universidad",user);
						response.sendRedirect("/universidad");
					
					} else if (usIden.getRol().equals("banco")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("banco",user);
						response.sendRedirect("/banco");
					} else if (usIden.getRol().equals("estampadora")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("estampadora",user);
						response.sendRedirect("/estampadora");
					} else if (usIden.getRol().equals("gestor")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("gestor",user);
						response.sendRedirect("/gestor");
					}

				} else { response.sendRedirect("/error"); }
			
			} else{ response.sendRedirect("/error"); }

		} else { response.sendRedirect("/error"); }
	}
}