<%@include file = "welcome.jsp" %>
<%@page import="Model.Alumni, servlets.AlumniServlet,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Alumni</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
    ArrayList<Alumni> alumniList = Alumni.getAllAlumnies();
%>
<body >
<hr>
<table class="form-table" align="center" border="2" bordercolor="white" cellpadding="10px" bgcolor="#4db8ff" >
	<tr>
		<th>Alumni ID</th>
		<th>Alumni Name</th>
		<th>Founded In</th>
		<th>Link</th>
	</tr>
		<% for(int j=0; j<2; j++)
				{
					System.out.println("Value of a_id in jsp :"+alumniList.get(j).getA_id());
			%>
			<tr>
					<td>	<%	out.println((alumniList.get(j).getA_id())); 	%> 	</td>
					<td>	<%	out.println((alumniList.get(j).getA_name())); 	%> 	</td>
					<td>	<% 	out.println((alumniList.get(j).getFounded())); 	%>	</td>
					<td>	<% 	out.println((alumniList.get(j).getLink()));	%>	</td>
			</tr>
				<% } %>
	</table>
	<hr>
</body>
</html>