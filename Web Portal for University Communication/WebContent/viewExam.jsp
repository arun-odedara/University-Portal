<%@include file = "welcome.jsp" %>
<%@page import="Model.Exam, servlets.ExamServlet,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Exam</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
    ArrayList<Exam> examList = Exam.getAllExames();
%>
<body >
<hr>
<table class="form-table" align="center" border="2" bordercolor="white" cellpadding="10px" bgcolor="#4db8ff" >
	<tr>
		<th>Exam ID</th>
		<th>Exam Name</th>
		<th>Exam Date</th>
		<th>Info</th>
	</tr>
		<% for(int j=0; j<examList.size(); j++)
				{
					System.out.println("Value of a_id in jsp :"+examList.get(j).getE_id());
			%>
			<tr>
					<td>	<%	out.println((examList.get(j).getE_id())); 	%> 	</td>
					<td>	<%	out.println((examList.get(j).getE_name())); 	%> 	</td>
					<td>	<% 	out.println((examList.get(j).getE_date())); 	%>	</td>
					<td>	<% 	out.println((examList.get(j).getInfo()));	%>	</td>
			</tr>
				<% } %>
	</table>
	<hr>
</body>
</html>