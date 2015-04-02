package gtu.g12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class volverServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		if (req.getSession().getAttribute("usuario") != null) { 
	        	resp.sendRedirect("/usuario1");
		}


		
		if (req.getSession().getAttribute("universidad") != null) {
			resp.sendRedirect("/universidad");	
		}

		
		
		
		if (req.getSession().getAttribute("banco") != null) {
			resp.sendRedirect("/banco");
		}
		
		
		
		
		if (req.getSession().getAttribute("estampadora") != null) {
			resp.sendRedirect("/estampadora");
		}
		
		
		
		
		
		if (req.getSession().getAttribute("gestor") != null) {
			resp.sendRedirect("/gestor");
		}
	}
}

