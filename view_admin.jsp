<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,DAO.Layer.*"%>
<%@page import="DTO.Layer.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style/decorate.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script type="text/javascript">
        function preventBack() {
            window.history.forward(); 
        }
          
        setTimeout("preventBack()", 0);
          
        window.onunload = function () { null };
    </script> 
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
#x {
height:30px;
width:80px;
font-weight: bold;
background:#232e;
color:white;
border-radius: 7px;
border: 2px solid #232e;
}
#v {
background: #234e;
color: white;
}
#shift,#shift1 {
background: #234e;
color: white;
}
a {
text-decoration: none;
color: white;
}
body {
	background: orange;
}
</style>
</head>

<body  oncontextmenu="return false;">


	<%
	List<EmployeeBeanDTO> list = DBConnectionDAO.getlist();
	request.setAttribute("list", list);
	%>
	<table id="t_id" style="width: 100$, align:center">
		<caption>Leave of Emp</caption>
		<tr>
			<th>username</th>
			<th>datefrom</th>
			<th>dateto</th>
			<th>reason</th>
			<th>work</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getUsername()}</td>
				<td>${u.getDtdataf()}</td>
				<td>${u.getDtdatat()}</td>
				<td>${u.getReason()}</td>
				<td>${u.getWork()}</td>
				<td><button  id="btn" type="submit">
						<a
							href="Admin_actionBo?action=approve&un=${u.getUsername()}&id=${u.getId()}">approve</a>
					</button></td>
				<td><button  id="btn" type="submit">
						<a
						href="Admin_actionBo?action=reject&un=${u.getUsername()}&id=${u.getId()}">reject</a>
					</button></td>
			</tr>
		</c:forEach>

	</table>
	<br><br>
	<button id="shift" ><a href="View_history.jsp?action=approved">approved list</a></button>
	<button id="shift1"><a href="View_history.jsp?action=reject">rejected list</a></button>
	<a href="HomePage.html"><button id="x">logOut</button></a>
</body>
</html>