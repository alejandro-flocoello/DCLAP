package gtu.g12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.dao.UsuarioDAO;
import gtu.g12.dao.UsuarioDAOImpl;


public class InitBdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		
		
		UsuarioDAO daous = UsuarioDAOImpl.getInstance();
		//elimina todos los datos de la bd
		daous.removeUsuarios();
	
		daous.addUsuario("l.gomezr@alumnos.upm.es", "laura", "solicitante");
		daous.addUsuario("alejandro.flocoello@alumnos.upm.es", "alejandro", "solicitante");
		daous.addUsuario("d.g.tevar@alumnos.upm.es", "daniel", "solicitante");
		daous.addUsuario("paula.fernandez.perez@alumnos.upm.es", "paula", "solicitante");
		daous.addUsuario("clara.madrigal.gonzalez@alumnos.upm.es", "clara", "solicitante");
		
		daous.addUsuario("jcduenas@dit.upm.com", "dueñas", "solicitante");
		daous.addUsuario("yelmogar@dit.upm.es", "yelmo", "solicitante");
		
		daous.addUsuario("universidad@universidad.com", "uni", "universidad");
		
		daous.addUsuario("bbva@banco.com", "bbva", "banco");
		daous.addUsuario("caixa@banco.com", "caixa", "banco");
		daous.addUsuario("santander@banco.com", "santander", "banco");
		
		daous.addUsuario("estampadora@estampadora.com", "estampadora", "estampadora");
		
		daous.addUsuario("gestor@gestor.com", "gestor", "gestor");
		
		
     
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		dao.removeSolicitudes();
		
		dao.addSol("Laura", "Gomez", "Rodriguez", "DNI", "52901938", "España", "Calle A", "UPM", "ETSIT", "l.gomezr@alumnos.upm.es", "", "alumno", 123412342, false,"",0,0,"","");
		dao.addSol("Alejandro", "Flores", "Coello", "DNI", "58967412", "España", "Calle B", "UPM", "ETSIT", "alejandro.flocoello@alumnos.upm.es", "", "alumno", 456789123, false,"",0,0,"","");
		dao.addSol("Daniel", "Gordo", "Tevar", "DNI", "12345678", "España", "Calle C", "UPM", "ETSIT", "d.g.tevar@alumnos.upm.es", "", "alumno", 789456123, false,"",0,0,"","");
		dao.addSol("Paula", "Fernández", "Pérez", "DNI", "98765432", "España", "Calle D", "UPM", "ETSIT", "paula.fernandez.perez@alumnos.upm.es", "", "alumno", 654987321, false,"",0,0,"","");
		dao.addSol("Clara", "Madrigal", "González", "DNI", "56897412", "España", "Calle E", "UPM", "ETSIT", "clara.madrigal.gonzalez@alumnos.upm.es", "", "alumno", 897564231, false,"",0,0,"","");
		dao.addSol("Juan Carlos", "Dueñas", "López", "DNI", "235689", "España", "Calle F", "UPM", "ETSIT", "jcduenas@dit.upm.com", "", "empleado", 897896789, false,"",0,0,"","");
		dao.addSol("Juan Carlos", "Yelmo", "García", "DNI", "89562374", "España", "Calle G", "UPM", "ETSIT", "yelmogar@dit.upm.es", "", "empleado", 125689741, false,"",0,0,"","");
	
		
		resp.sendRedirect("/showBd");
	}

}