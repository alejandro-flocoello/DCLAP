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
	
		daous.addUsuario("paula@alumnos.com", "paulaisst", "estampadora");
		daous.addUsuario("laura@alumnos.com", "lauraisst", "solicitante");
		daous.addUsuario("alejandro@alumnos.com", "alejandroisst", "universidad");
		daous.addUsuario("clara@alumnos.com", "claraisst", "banco");
		daous.addUsuario("daniel@alumnos.com", "danielisst", "gestor");
		
		  
     
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		dao.removeSolicitudes();
		
		dao.addSol("Paula", "Fernandez", "Perez", "DNI", "53654635", "Esp", "Gomar", "UPM", "ETSIT", "paula@alumnos.com", "estampadora", 12341234, true, 0,0,0,0,"SOLICITADA");
		dao.addSol("Paula2", "Fernandez2", "Perez2", "DNI2", "536546352", "Esp2", "Gomar2", "UPM2", "ETSIT2", "paula2@alumnos.com", "alumna2", 123412342, true,0,0,0,0,"ACEPTADA_UNIV");
		dao.addSol("Laura", "Gomez", "Rodriguez", "DNI", "47234046", "Esp", "Gomar", "UPM", "ETSIT", "laura@alumnos.com", "alumna", 123412342, false,0,0,0,0,"");
		dao.addSol("Laura2", "Gomez2", "Rodriguez2", "DNI2", "472340462", "Esp2", "Gomar2", "UPM2", "ETSIT2", "laura2@alumnos.com", "alumna2", 123412342, false,0,0,0,0,"ACEPTADA_UNIV");
		dao.addSol("Laura3", "Gomez3", "Rodriguez3", "DNI3", "472340463", "Esp3", "Gomar3", "UPM3", "ETSIT3", "laura3@alumnos.com", "alumna3", 123412342, false,0,0,0,0,"ASOCIADA_BANCO");
		dao.addSol("Laura4", "Gomez4", "Rodriguez4", "DNI4", "472340464", "Esp4", "Gomar4", "UPM4", "ETSIT4", "laura4@alumnos.com", "alumna4", 123412342, false,0,0,0,0,"REMITIDA_UNIV");
		dao.addSol("Laura5", "Gomez5", "Rodriguez5", "DNI5", "472340465", "Esp5", "Gomar5", "UPM5", "ETSIT5", "laura5@alumnos.com", "alumna5", 123412342, false,0,0,0,0,"REMITIDA_BANCO");
		dao.addSol("Laura6", "Gomez6", "Rodriguez6", "DNI6", "472340466", "Esp6", "Gomar6", "UPM6", "ETSIT6", "laura6@alumnos.com", "alumna6", 123412346, false,0,0,0,0,"IMPRESA_ESTAMP");
		
		
		resp.sendRedirect("/showBd");
	}

}
