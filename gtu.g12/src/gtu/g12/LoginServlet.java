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
import gtu.g12.dao.UsuarioDAO;
import gtu.g12.dao.UsuarioDAOImpl;
import gtu.g12.model.Solicitud;
import gtu.g12.model.Usuario;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();

		RequestDispatcher view = req
				.getRequestDispatcher("universidadInicio.jsp");
		view.forward(req, resp);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		

		// Comprobar en la base de datos que ese email y password corresponde con un usuario y ver que rol tiene.
		// en funcion de ese rol, lo mandare a un servlet o a otro
		
		UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		
		if(!(user.isEmpty()) || !(password.isEmpty())){
			
			Usuario usIden = daous.getUserPassword(user, password);
			
			if (usIden != null) {
				String rolUsIdentif = usIden.getRol();
				if (usIden.getRol().equals("solicitante")) {
					response.sendRedirect("/usuario1");
				} else if (usIden.getRol().equals("universidad")) {
					response.sendRedirect("/universidad");
				} else if (usIden.getRol().equals("banco")) {
					response.sendRedirect("/banco");
				} else if (usIden.getRol().equals("estampadora")) {
					response.sendRedirect("/estampadora");
				} else if (usIden.getRol().equals("gestor")) {
					response.sendRedirect("/gestor");
				}

			} else {
				response.sendRedirect("/error");
			}
		
		}else{
			response.sendRedirect("/error");
		}	
	}
}			



