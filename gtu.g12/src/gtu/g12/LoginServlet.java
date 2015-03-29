package gtu.g12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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
				        session.setAttribute("usuario",user);
						response.sendRedirect("/universidad");
					
					} else if (usIden.getRol().equals("banco")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("usuario",user);
						response.sendRedirect("/banco");
					} else if (usIden.getRol().equals("estampadora")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("usuario",user);
						response.sendRedirect("/estampadora");
					} else if (usIden.getRol().equals("gestor")) {
						HttpSession session=request.getSession();  
				        session.setAttribute("usuario",user);
						response.sendRedirect("/gestor");
					}

				} else { response.sendRedirect("/error"); }
			
			} else{ response.sendRedirect("/error"); }

		} else { response.sendRedirect("/error"); }
	}
}