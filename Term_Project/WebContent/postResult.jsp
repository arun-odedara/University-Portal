<%@include file = "welcome.jsp" %>
<%@page import="Model.Exam,servlets.ExamServlet,java.util.ArrayList" %>
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
<div>
<table class="form-table" align="center" cellpadding="30px"  >
	<tr>
		<th>Exam ID</th>
		<th>Exam Name</th>
	</tr>
	<tr><hr></tr>
		<% for(int j=0; j<examList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((examList.get(j).getE_id())); 	%> 	</td>
					<td>	<% 	out.println((examList.get(j).getE_name())); 	%>	</td>
					<td>	<a href="ExamServlet?action=postResult&e_id=<%=	examList.get(j).getE_id()%>&e_name=<%=examList.get(j).getE_name()%>"> <input type="button" style="width: 100px" value="Choose" /></a>	</td>
			</tr>
				<% } %>
	</table>
<hr>
</div>
</body>
</html>