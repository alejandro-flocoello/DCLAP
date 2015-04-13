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
import javax.servlet.http.HttpSession;



public class Usuario2Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
				
		SolicitudDAO dao = SolicitudDAOImpl.getInstance();
		
		String email = (String) req.getSession().getAttribute("usuario");
				
	    String[] solDual = req.getParameterValues("checkbox"); 
	    
	    HttpSession session= req.getSession();
	    
	    if(solDual != null){
	    	dao.changeMonederoSol(email, true);	
	    }else{
	    	dao.changeMonederoSol(email, false);		
	    }
	    

	    String[] bancos= req.getParameterValues("bancos");
	    
	    

	    	for(String banco: bancos){
	    		if (banco.equals("--- Elija banco ---")){
	    			session.setAttribute("error","Seleccione un banco");
					resp.sendRedirect("/error");
					return;
	    		}
	    		dao.changeBancoSol(email, banco);
	    	}
	    	

	    	
	    Solicitud solicitud = dao.getSol(email);
		req.getSession().setAttribute("solicitud", solicitud); 
	    RequestDispatcher view = req.getRequestDispatcher("usuario2.jsp");
        view.forward(req, resp);
		
	}
}