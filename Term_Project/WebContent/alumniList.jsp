<%@include file = "welcome.jsp" %>
<%@page import="Model.Alumni, servlets.AlumniServlet,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Course</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
    ArrayList<Alumni> alumniList = Alumni.getAllAlumnies();
%>
<body >
<div>
<table class="form-table" align="center" cellpadding="30px"  >
	<tr>
		<th>Alumni ID</th>
		<th>Alumni Name</th>
	</tr>
	<tr><hr></tr>
		<% for(int j=0; j<alumniList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((alumniList.get(j).getA_id())); 	%> 	</td>
					<td>	<% 	out.println((alumniList.get(j).getA_name())); 	%>	</td>
					<td>	<a href="AlumniServlet?a_id=<%=	alumniList.get(j).getA_id()%>"> <input type="button" style="width: 100px" value="Choose" /></a>	</td>
			</tr>
				<% } %>
	</table>
<hr>
</div>
</body>
</html>