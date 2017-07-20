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
    Course cs = new Course(); //not recommended.Pass this object from servlet
    ArrayList<Course> courseList = Course.getAllCourses();
%>
<body >

<table class="form-table" align="center" border="2" bordercolor="white" cellpadding="10px" bgcolor="#4db8ff" >
	<tr>
		<th>Course ID</th>
		<th>Course Name</th>
		<th>Faculty Office Hours</th>
		<th>Course TA</th>
		<th>Course Syllabus</th>
		<th>Net Id : </th>
	</tr>
		<% for(int j=0; j<courseList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((courseList.get(j).getC_id())); 	%> 	</td>
					<td>	<% 	out.println((courseList.get(j).getC_name())); 	%>	</td>
					<td>	<% 	out.println((courseList.get(j).getO_Hours()));	%>	</td>
					<td>	<% 	out.println((courseList.get(j).getTA()));		%>	</td>
					<td>	<% 	out.println((courseList.get(j).getSyllabus()));	%>	</td>
					<td>	<%	out.println((courseList.get(j).getNid()));		%>	</td>

			</tr>
				<% } %>
	</table>
</body>
</html>