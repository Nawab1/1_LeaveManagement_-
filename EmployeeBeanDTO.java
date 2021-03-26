package DTO.Layer;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBeanDTO {
	private String Name, Last, Department, username, password, dt;
	private Date DOB;
	private Date dtfrom;
	private Date dtto;
	private String comment;
	private String work;

	public EmployeeBeanDTO() {

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLast() {
		return Last;
	}

	public void setLast(String last) {
		Last = last;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDOB() {
		return this.DOB;
	}

	public void setDOB(String dt) {

		try {

			java.util.Date udt = new SimpleDateFormat("yyyy-MM-dd").parse(dt);
			this.DOB = udt;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setDateFrom(String from) {
		// TODO Auto-generated method stub

		try {

			java.util.Date dfrom = new SimpleDateFormat("yyyy-MM-dd").parse(from);
			this.dtfrom = dfrom;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Date getDateFrom() {
		return this.dtfrom;
	}

	public void setDateTo(String to) {
		// TODO Auto-generated method stub

		try {

			java.util.Date dto = new SimpleDateFormat("yyyy-MM-dd").parse(to);
			this.dtto = dto;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Date getDateTo() {
		return this.dtto;
	}

	public void setReason(String comment) {
		this.comment = comment;
	}

	public String getReason() {
		return comment;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getWork() {
		return work;
	}

	Date sqld = null;

	public void setDtdataf(Date sqld) {
		this.sqld = sqld;
	}

	public Date getDtdataf() {
		return this.sqld;
	}

	Date sqldto = null;

	public void setDtdatat(Date sqldto) {
		this.sqldto = sqldto;
	}

	public Date getDtdatat() {
		return this.sqldto;
	}

	int int1 = 0;

	public void setId(int int1) {
		// TODO Auto-generated method stub
		this.int1 = int1;

	}

	public int getId() {
		return this.int1;
	}
}