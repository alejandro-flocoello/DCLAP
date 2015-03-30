package gtu.g12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

public class BancoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		List<Solicitud> lista = dao.getSolPorEstadoYBanco("ACEPTADA_UNIV");
		List<Solicitud> lista2 = dao.getSolPorEstadoYBanco("REMITIDA_BANCO");

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
		RequestDispatcher view = req.getRequestDispatcher("banco.jsp");
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista));
		req.getSession().setAttribute("solicitudes2", new ArrayList<Solicitud>(lista2));
        view.forward(req, resp);

	}
}
