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
 * Servlet implementation class Admin_actionBo
 */

public class Admin_actionBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();

		String un = request.getParameter("un");
		int id = Integer.parseInt(request.getParameter("id"));

		//pw.println();
		String action = request.getParameter("action");

		try {
			DBConnectionDAO.Update_action(action, un, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//RequestDispatcher rd = request.getRequestDispatcher("/view_admin.jsp");
		//rd.forward(request, response);
		response.sendRedirect("view_admin.jsp");

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
