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

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		
		 UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		 List<Usuario> lista = daous.listaUsuarios();
		//elimina todos los datos de la bd
		daous.removeUsuarios();
	
		daous.addUsuario("paula@alumnos.com", "paulaisst", "estampadora");
		daous.addUsuario("laura@alumnos.com", "lauraisst", "solicitante"); //ALUMNA
		daous.addUsuario("paula2@profesores.com", "paula2isst", "solicitante"); //PROFESOR 
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
		dao.addSol("Paula", "Fernandez", "Perez", "DNI", "53654635", "Esp", "Gomar", "UPM", "ETSIT", "paula2@profesores.com", "profesor", 12341234, true, 0,0,0,0,"");
		dao.addSol("Laura", "Gomez", "Rodriguez", "DNI", "536546352", "Española", "Casa", "UPM", "ETSIT", "laura@alumnos.com", "alumno", 123412342, false,0,0,0,0,"");
		
		
		req.getSession().setAttribute("solicitudes", new ArrayList<Solicitud>(lista));
		RequestDispatcher view = req.getRequestDispatcher("initBd.jsp");
        view.forward(req, resp);
        */
        
	}

}
