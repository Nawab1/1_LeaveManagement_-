package BO.Layer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Layer.DBConnectionDAO;

/**
 * Servlet implementation class Admin_login_servletBo
 */
public class Admin_login_servletBo extends HttpServlet {
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
		String name = request.getParameter("username_admin");
		String password = request.getParameter("password_admin");
		try {

			boolean c = DBConnectionDAO.admin_checkDAO(name, password);
			if (c) {
				RequestDispatcher rd = request.getRequestDispatcher("/view_admin.jsp");
				rd.forward(request, response);

			} else {
                String s = "<html><body><b><h1 style ='margin-left:450px;'>not valid</h1></b></body></html>";
				pw.println(s);
				RequestDispatcher rd = request.getRequestDispatcher("/admin_login.html");
				rd.include(request, response);

			}
		} catch (Exception e) {
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
