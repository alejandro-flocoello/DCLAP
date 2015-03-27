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

public class InitBdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		
		 UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		 List<Usuario> lista = daous.listaUsuarios();
		//elimina todos los datos de la bd
		daous.removeUsuarios();
	
		daous.addUsuario("paula@alumnos.com", "paulaisst", "estampadora");
		daous.addUsuario("laura@alumnos.com", "lauraisst", "solicitante");
		daous.addUsuario("alejandro@alumnos.com", "alejandroisst", "universidad");
		daous.addUsuario("clara@alumnos.com", "claraisst", "banco");
		daous.addUsuario("daniel@alumnos.com", "danielisst", "gestor");
		
		RequestDispatcher view = req.getRequestDispatcher("initBd.jsp");
		req.getSession().setAttribute("usuarios", new ArrayList<Usuario>(lista));
        view.forward(req, resp);
   
		
		/*
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		List<Solicitud> lista = dao.listSol();
		dao.removeSolicitudes();
		dao.addSol("Paula", "Fernandez", "Perez", "DNI", "53654635", "Esp", "Gomar", "UPM", "ETSIT", "paula@alumnos.com", "estampadora", 12341234, true, 0,0,0,0,"solicitada");
		dao.addSol("Paula2", "Fernandez2", "Perez2", "DNI2", "536546352", "Esp2", "Gomar2", "UPM2", "ETSIT2", "paula2@alumnos.com", "alumna2", 123412342, false,0,0,0,0,"aceptada por uni");
		
		RequestDispatcher view = req.getRequestDispatcher("initBd.jsp");
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista));
        view.forward(req, resp);
		*/
	}

}
