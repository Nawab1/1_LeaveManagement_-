package DAO.Layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import BO.Layer.Check_forinsert;
import DTO.Layer.EmployeeBeanDTO;

public class DBConnectionDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signi", "root", "nawab");
		} catch (Exception e) {
			System.out.println("EEEE" + e);
		}
		return con;

	}

	public static boolean check_existDAO(String username, String password) throws SQLException {
		Connection con = getConnection();
		String sql = "select * from emp_data_userpass where username = ? and password = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}

	public static void leave_apply_insert(EmployeeBeanDTO e) throws SQLException {

		Connection con = getConnection();
		String sql = "insert into emp_leave_apply(username,applyfrom,applyto,reason,work)values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, e.getUsername());
		ps.setDate(2, new java.sql.Date(e.getDateFrom().getTime()));
		ps.setDate(3, new java.sql.Date(e.getDateTo().getTime()));
		ps.setString(4, e.getReason());
		ps.setString(5, e.getWork());
		ps.executeUpdate();
		ps.close();
	}

	public static boolean check_existDAO_reg(String username) throws SQLException {
		Connection con = getConnection();
		String sql = "select count(*) from emp_data_userpass where username = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int row = rs.getInt(1);
			if (row == 0) {

				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean Insert_emp(EmployeeBeanDTO e) throws SQLException {
		// TODO Auto-generated method stub
		boolean c = check_existDAO_reg(e.getUsername());
		Connection con = getConnection();
		if (c) {

			String sql = "insert into emp_data_userpass(username,password)values(?,?)";
			String sql1 = "insert into emp_data(name,last,dpment,dob,username,password)values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getUsername());
			ps.setString(2, e.getPassword());
			ps.executeUpdate();
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, e.getName());
			ps1.setString(2, e.getLast());
			ps1.setString(3, e.getDepartment());
			ps1.setDate(4, new java.sql.Date(e.getDOB().getTime()));
			ps1.setString(5, e.getUsername());
			ps1.setString(6, e.getPassword());
			ps1.executeUpdate();
			ps.close();
			ps1.close();
			return c;
		} else {
			return c;
		}

	}

	public static boolean admin_checkDAO(String username_admin, String password) throws SQLException {
		Connection con = getConnection();
		String sql = "select * from admin_data where username = ? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username_admin);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			return true;
		} else {
			return false;
		}

	}

	public static List<EmployeeBeanDTO> getlist() {
		List<EmployeeBeanDTO> l = new ArrayList<EmployeeBeanDTO>();
		try {

			Connection con = getConnection();

			String sql = "select * from emp_leave_apply where work = 'underprocess...'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EmployeeBeanDTO empdto = new EmployeeBeanDTO();
				empdto.setUsername(rs.getString("username"));
				Date dtf = rs.getDate("applyfrom");
				// DateFormat dateform = new SimpleDateFormat("YYYY-MM-DD");

				Date dtt = rs.getDate("applyto");
				// DateFormat dateto = new SimpleDateFormat("YYYY-MM-DD");

				// empdto.setDateFrom(dateform.format(dtf));
				empdto.setDtdataf(dtf);
				empdto.setDtdatat(dtt);
				empdto.setWork(rs.getString("work"));
				empdto.setReason(rs.getString("reason"));
				empdto.setId(rs.getInt("id"));
				
				l.add(empdto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return l;
	}

	public static void Update_action(String action, String un, int id) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = null;
		if (action.equals("approve")) {
			String sql = "update emp_leave_apply set work ='approved'  where username =? and id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, un);
			ps.setInt(2, id);
		} else {
			String sql = "update emp_leave_apply set work ='reject'  where username =? and id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, un);
			ps.setInt(2, id);
		}
		ps.executeUpdate();
		ps.close();
	}

	public static List<EmployeeBeanDTO> getsinglelist() {
		List<EmployeeBeanDTO> l = new ArrayList<EmployeeBeanDTO>();
		try {

			Connection con = getConnection();

			String sql = "select * from emp_leave_apply where username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Check_forinsert.xy);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EmployeeBeanDTO empdto = new EmployeeBeanDTO();
				empdto.setUsername(rs.getString("username"));
				Date dtf = rs.getDate("applyfrom");
				// DateFormat dateform = new SimpleDateFormat("YYYY-MM-DD");

				Date dtt = rs.getDate("applyto");
				// DateFormat dateto = new SimpleDateFormat("YYYY-MM-DD");

				// empdto.setDateFrom(dateform.format(dtf));
				empdto.setDtdataf(dtf);
				empdto.setDtdatat(dtt);
				empdto.setWork(rs.getString("work"));
				empdto.setReason(rs.getString("reason"));

				l.add(empdto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return l;
	}

	public static List<EmployeeBeanDTO> getview_history(String action) {
		List<EmployeeBeanDTO> l = new ArrayList<EmployeeBeanDTO>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			String sql = "select * from emp_leave_apply where work = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, action);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeBeanDTO empdto = new EmployeeBeanDTO();
				empdto.setUsername(rs.getString("username"));
				empdto.setDtdataf(rs.getDate("applyfrom"));
				empdto.setDtdatat(rs.getDate("applyto"));
				empdto.setReason(rs.getString("reason"));
				empdto.setWork(rs.getString("work"));
				l.add(empdto);
			}

		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				ps.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return l;
	}
}
