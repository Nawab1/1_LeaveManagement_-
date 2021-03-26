package BO.Layer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Layer.DBConnectionDAO;
import DTO.Layer.EmployeeBeanDTO;

/**
 * Servlet implementation class Leave_apply_servletBo
 */

public class Leave_apply_servletBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
          response.setContentType("text/html");
          PrintWriter pw = response.getWriter();
          String from = request.getParameter("fdate");
          String to = request.getParameter("tdate");
          String comment = request.getParameter("comment");
          ServletContext ctx = getServletContext();
          //pw.println(Check_forinsert.xy);
          EmployeeBeanDTO obj = new EmployeeBeanDTO();
          obj.setUsername(Check_forinsert.xy);
          obj.setDateFrom(from);
          obj.setDateTo(to);
          obj.setWork("underprocess...");
          obj.setReason(comment);
          try {
        	  DBConnectionDAO.leave_apply_insert(obj);
          }catch(Exception e) {
        	  e.printStackTrace();
          }
          RequestDispatcher rd = request.getRequestDispatcher("/emp_view.jsp");
          rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
