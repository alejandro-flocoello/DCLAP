package gtu.g12;

import gtu.g12.dao.SolicitudDAO;
import gtu.g12.dao.SolicitudDAOImpl;
import gtu.g12.model.Solicitud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class changeStateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		String email = (String) req.getSession().getAttribute("usuario");
		System.out.println(email); //-------->laura@alumnos.com
		
		
		Solicitud solicitud = dao.getSol(email);	
		String estadoDual = solicitud.getEstado();
		System.out.println(estadoDual); //----------->""
		
		if(estadoDual.equals("")){
			solicitud.setEstado("SOLICITADA");
			Solicitud solicitud2 = dao.getSol(email);	
			String estadoDual2 = solicitud2.getEstado();
			System.out.println(estadoDual2);//---------->SOLICITUD
		}
		
		Solicitud solicitud2 = dao.getSol(email);
		req.getSession().setAttribute("solicitud", solicitud2); 
		RequestDispatcher view = req.getRequestDispatcher("usuario3.jsp");
	    view.forward(req, resp);
	}	
}
