package BO.Layer;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Layer.DBConnectionDAO;
import DTO.Layer.EmployeeBeanDTO;

public class Emp_signupServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		EmployeeBeanDTO e =  new EmployeeBeanDTO();
		
		PrintWriter pw = resp.getWriter();
		e.setName(req.getParameter("name"));
		e.setLast(req.getParameter("last"));
		e.setDepartment(req.getParameter("dpment"));
		if(req.getParameter("dob").equals("") || req.getParameter("dob") == null) {
			pw.println("data should be field");
			RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
			rd.include(req, resp);
		}
		e.setDOB(req.getParameter("dob"));
	
		 e.setPassword(req.getParameter("password"));
		 e.setUsername(req.getParameter("username"));
		 
		boolean res;
		try {
			res = DBConnectionDAO.Insert_emp(e);
			if(res)
			{   pw.println("<h1 style='color:green'>submitted</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
		        rd.include(req,resp);
			}
			else
			{
				  pw.println("data exist");
					RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
			        rd.include(req,resp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
