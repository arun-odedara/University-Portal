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
    ArrayList<Course> courseList = Course.getAllCourses();
%>
<body >
<div>
<table class="form-table" align="center" cellpadding="30px"  >
	<tr>
		<th>Course ID</th>
		<th>Course Name</th>
	</tr>
	<tr><hr></tr>
		<% for(int j=0; j<courseList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((courseList.get(j).getC_id())); 	%> 	</td>
					<td>	<% 	out.println((courseList.get(j).getC_name())); 	%>	</td>
					<td>	<a href="CourseServlet?c_id=<%=	courseList.get(j).getC_id()%>"> <input type="button" style="width: 100px" value="Choose" /></a>	</td>
			</tr>
				<% } %>
	</table>
<hr>
</div>
</body>
</html>