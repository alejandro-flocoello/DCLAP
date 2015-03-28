package gtu.g12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
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
import gtu.g12.model.Solicitud;

public class userSolServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
				
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
				
		String id1 = req.getParameter("id");
		Long id = Long.parseLong(id1);
		
	    String[] solDual = req.getParameterValues("tipoSolicitud");
	    
	    /*
	    if( !(solDual.equals(""))){
	    	
	    	dao.changeMonerderoSol(id, true);	    	
	    }else{
	    	dao.changeMonerderoSol(id, false);		
	    }
	    */
				
	    RequestDispatcher view = req.getRequestDispatcher("usuario2.jsp");
        view.forward(req, resp);
		
	}
}
