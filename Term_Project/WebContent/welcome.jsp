<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="sidebar.js"></script>
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
	<div id="about" style="background-color:#3598db	;">
		<form action="loginServlet?action=logout" method="post">
		<table>
			<tr>
				<td ><h2 style="margin-left:300px"><a href="welcome.jsp">UALBANY CS DEPT</a></h2></td>
				<td><input style="margin-left:320px; width: 100px" type="submit" value="Logout"></td>
			</tr>
		</table>
		</form>
		
		<div class="top-divider" style="background-color:#003d66"></div>
		<table class="form-table" align="center">
			<tr>
				<td><div id ="sidebar-btn-course"><a href="#">Courses</a> </div></td>
				<td><div id ="sidebar-btn-resources"><a href="#">Resources </a></div></td>
				<td><div id ="sidebar-btn-exams"><a href="#">Exams </a></div></td>
				<td><div id ="sidebar-btn-phd"><a href="#">PHD </a></div></td>
				<td><div id ="sidebar-btn-alumni"><a href="#">Alumni </a></div></td>
				<td><div id ="sidebar-btn-announcements"><a href="#">Announcements </a></div></td>
				<td><div><a href="discussion.jsp">Discussion </a></div></td>
				<td><div><a href="editFaculty.jsp">Edit Info </a></div></td>
			</tr>
		</table>
		<div class="top-divider" style="background-color:#003d66"></div>
		
		<br><br><br>
		<div id ="sidebar-course">
		<ul>
			<li><a href="courses.jsp">Add Course</a></li>
			<li><a href="facultyCourse.jsp">Edit Course</a></li>
			<li><a href="viewCourse.jsp">View All Course</a></li>
		</ul>
		</div>
		<div id ="sidebar-exams">
		<ul>
			<li><a href="createExam.jsp">Add Exam</a></li>
			<li><a href="viewExam.jsp">View Exam</a></li>
			<li><a href="postResult.jsp">Post Result</a></li>
			<li><a href="#">Sign Up</a></li>
		</ul>
		</div>
		<div id ="sidebar-resources">
		<ul>
			<li><a href="#">Manage Resources</a></li>
			<li><a href="#">Make Reservation</a></li>
			<li><a href="#">Cancel Reservation</a></li>
		</ul>
		</div>
		<div id ="sidebar-phd">
		<ul>
			<li><a href="phd.jsp">View PHD Students</a></li>
			<li><a href="edit_php.jsp">Edit Status</a></li>
		</ul>
		</div>
		<div id ="sidebar-alumni">
		<ul>
			<li><a href="viewAlumni.jsp">View Alumni Students</a></li>
			<li><a href="alumni.jsp">Add New Student</a></li>
			<li><a href="alumniList.jsp">Edit Data</a></li>
		</ul>
		</div>
		<div id ="sidebar-announcements">
		<ul>
			<li><a href="viewAnn.jsp">View Announcements</a></li>
			<li><a href="announcement.jsp">Add New Announcements</a></li>
			<li><a href="#">Add New Job</a></li>
			<li><a href="editAnn.jsp">Edit Announcements</a></li>
		</ul>
		</div>
    </div>
</body>
</html>
