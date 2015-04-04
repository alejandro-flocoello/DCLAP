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
import gtu.g12.dao.UsuarioDAO;
import gtu.g12.dao.UsuarioDAOImpl;
import gtu.g12.model.Solicitud;
import gtu.g12.model.Usuario;

public class ShowBdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		List<Usuario> listaUS = daous.listaUsuarios();
		List<Solicitud> listaSol = dao.listSol();
		
		RequestDispatcher view = req.getRequestDispatcher("showBd.jsp");
		req.getSession().setAttribute("usuarios", new ArrayList<Usuario>(listaUS));
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(listaSol));
        view.forward(req, resp);
        
   
		
		
		
 
        
	}

}
