package BO.Layer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Layer.DBConnectionDAO;
import DTO.Layer.EmployeeBeanDTO;

/**
 * Servlet implementation class Check_forinsert
 */

public class Check_forinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static String xy = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext ctx = getServletContext();

		try {
			boolean c = DBConnectionDAO.check_existDAO(username, password);
			 if(username.equals("") || password.equals("")) {
				 String s = "<html><body><b><h1 style ='margin-left:450px;'>not valid user</h1></b></body></html>";
				 pw.println(s);
					RequestDispatcher rd = request.getRequestDispatcher("/leave_apply.html");
					rd.include(request, response);
			 }
			if (c) {
				xy = username;
                Cookie ck = new Cookie("username",xy);
                response.addCookie(ck);
                
				RequestDispatcher rd = request.getRequestDispatcher("/leave_apply_form.html");
				rd.forward(request, response);

			} else {
				String s = "<html><body><b><h1 style ='margin-left:450px;'>not valid user</h1></b></body></html>";
				pw.println(s);
				RequestDispatcher rd = request.getRequestDispatcher("/leave_apply.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
