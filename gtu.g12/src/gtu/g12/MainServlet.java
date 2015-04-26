package gtu.g12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		if(req.getSession() != null){
			
			resp.setHeader("Cache-Control", "no-cache, no-store");
			resp.setHeader("Pragma", "no-cache");

			req.getSession().invalidate();
		}
		
		RequestDispatcher view = req.getRequestDispatcher("interfazInicio.jsp");
        view.forward(req, resp);
		
	}
}