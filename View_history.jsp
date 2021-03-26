<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,DAO.Layer.*"%>
<%@page import="DTO.Layer.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style/decorate.css">
<style>
table, ht, td {
	border: 1px solid black;
	border-collpase: collapse;
	align: center;
}

th, td {
	padding: 5px;
	text-align: left;
}
button {
height:30px;
width:80px;
font-weight: bold;
background:#232e;
color:white;
border-radius: 7px;
border: 2px solid #232e;
}
h2 {
color:#234e;
}
</style>
</head>
<body bgcolor="orange">
	<%
	String action = request.getParameter("action");
	List<EmployeeBeanDTO> list = DBConnectionDAO.getview_history(action);
	request.setAttribute("list", list);
	%>

	<table id="t_id" style="width: 100$, align:center">
		<caption><h2>Leave of Emp</h2></caption>
		<tr>
			<th>username</th>
			<th>datefrom</th>
			<th>dateto</th>
			<th>reason</th>
			<th>progress</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getUsername()}</td>
				<td>${u.getDtdataf()}</td>
				<td>${u.getDtdatat()}</td>
				<td>${u.getReason()}</td>
				<td>${u.getWork()}</td>
			</tr>
		</c:forEach>
		<a href="view_admin.jsp"><button>Back</button></a>
	</table>
</body>
</html>
