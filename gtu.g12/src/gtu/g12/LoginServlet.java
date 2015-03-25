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

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();

		/*UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		List<Todo> todos = new ArrayList<Todo>();
		            
		if (user != null){
		    url = userService.createLogoutURL(req.getRequestURI());
		    urlLinktext = "Logout";
		    todos = dao.getTodos(user.getNickname());
		}
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("todos", new ArrayList<Todo>(todos));
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		*/
		RequestDispatcher view = req.getRequestDispatcher("universidadInicio.jsp");
        view.forward(req, resp);
		
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
				String user = request.getParameter("usuario");
				String password = request.getParameter("password");
				
				
				//String test = userName + password; //comprobar que se guardan los datos
				
				//Comprobar en la base de datos que ese email y password corresponde con un usuario y ver que rol tiene.
				//en funcion de ese rol, lo mandare a un servlet o a otro
				//String rol;
				
				/*
				if (user.getPassword!=password){
					request.setAttribute("tipoError", "passwordNoMatch");
					request.getRequestDispatcher("ErrorServlet").forward(request, response);			
				}
				
				if (user.getPassword==null){
					request.setAttribute("tipoError", "passswordVacio");
					request.getRequestDispatcher("ErrorServlet").forward(request, response);			
				}
				if (user no esta en la tabla){
					request.setAttribute("tipoError", "noExisteUsuario");
					request.getRequestDispatcher("ErrorServlet").forward(request, response);			
				}
				if (user.getrol()==solicitante){
				request.getRequestDispatcher("UsuarioServlet").forward(request, response);
				}
				
				else if (user.getrol()==universidad){
					request.getRequestDispatcher("UniversidadServlet").forward(request, response);
				}
				else if (user.getrol()==banco){
					request.getRequestDispatcher("BancoServlet").forward(request, response);
				}
				else if (user.getrol()==estampadora){
					request.getRequestDispatcher("EstampadoraServlet").forward(request, response);
				}
				
				*/
	}
}
