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
    ArrayList<Exam> examList = (ArrayList<Exam>) request.getAttribute("e_id");
%>
<body >
<br><br><br>
<form action="ExamServlet?action=editExam" method="post">
<table class="form-table" align="center"  cellpadding="10px" >
				<% for(int j=0; j<1; j++)
					{	
				%>	
					<tr>
	                    <td><input style="display: none;" type="text" name="e_id" value="<%	out.println((examList.get(j).getE_id())); 	%>" /> </td>
	             	</tr>
	             	<tr>
	                	<td>Exam NAME: </td>
	                    <td><input type="text" name="e_name" value="<% 	out.println((examList.get(j).getE_name())); 	%>" /> </td>
	             	</tr>
	                <tr>
	                	 <td>Student ID : </td>
	                     <td><input type="text" name="s_id" value="<% 	out.println((examList.get(j).getS_id()));	%>" /></td>
	             	</tr>
	                <tr>
	              	     <td>Result</td>
	                   	 <td><input type="text" name="result" value="<% 	out.println((examList.get(j).getResult()));		%>" /></td>
	                </tr>
					<tr>
						<td>Net Id : </td>
						<td><%out.println(session.getAttribute("name"));%></td>
					</tr>
					
					<tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
	                <% } %>
	</table>
	</form>
	</body>
</html>