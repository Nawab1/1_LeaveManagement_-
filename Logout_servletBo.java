package BO.Layer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Layer.DBConnectionDAO;

/**
 * Servlet implementation class Logout_servletBo
 */

public class Logout_servletBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
        Cookie []ck = request.getCookies();
        if(ck != null) {
        
        		if(ck[0].getValue().equals(Check_forinsert.xy)) {
        			//Check_forinsert.xy = null;
        			Cookie ck1 = new Cookie("username","");
        			ck1.setMaxAge(0);
        			
        		}
        
        }
        response.sendRedirect("HomePage.html");
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
