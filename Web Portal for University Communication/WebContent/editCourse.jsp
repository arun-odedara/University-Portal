<%@include file = "welcome.jsp" %>
<%@page import="Model.Course,servlets.CourseServlet,java.util.ArrayList" %>
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
    ArrayList<Course> courseList = (ArrayList<Course>) request.getAttribute("c_id");
%>
<body >
<br><br><br>
<form action="CourseServlet?action=editcourse" method="post">
<table class="form-table" align="center"  cellpadding="10px" >
				<% for(int j=0; j<1; j++)
					{	
				%>	
					<tr>
	                    <td><input style="display: none;" type="text" name="c_id" value="<%	out.println((courseList.get(j).getC_id())); 	%>" /> </td>
	             	</tr>
	             	<tr>
	                	<td>Course NAME: </td>
	                    <td><input type="text" name="c_name" value="<% 	out.println((courseList.get(j).getC_name())); 	%>" /> </td>
	             	</tr>
	                <tr>
	                	 <td>TA Info : </td>
	                     <td><input type="text" name="TA" value="<% 	out.println((courseList.get(j).getO_Hours()));	%>" /></td>
	             	</tr>
	                <tr>
	              	     <td>Office Hours</td>
	                   	 <td><input type="text" name="o_Hours" value="<% 	out.println((courseList.get(j).getTA()));		%>" /></td>
	                </tr>
					<tr>
						<td>Syllabus : </td>
					 	<td><textarea name = "Syllabus"><% 	out.println((courseList.get(j).getSyllabus()));	%></textarea></td>
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