<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		$('#sidebar-btn').click(function(){
			$('#sidebar').toggleClass('visible');
		});
	});
	</script>
	<div id="about" style="background-color:#33adff	;">
		<h2>	Hello, <%=session.getAttribute("name")%></h2>
		<div class="top-divider" style="background-color:#003d66"></div>
		<div id ="sidebar">
		<ul>
			<li><a href="#">Add Course</a></li>
			<li><a href="#">View Course</a></li>
			<li><a href="#">Edit Course Info</a></li>
		</ul>
		</div>
		<table class="form-table" align="center">
			<tr>
				<td><div id ="sidebar-btn">Courses </div></td>
					<td><a href="resources.jsp">Resources </a></td>
					<td><a href="exams.jsp">Exams </a></td>
					<td><a href="phd.jsp">PHD </a></td>
					<td><a href="alumni.jsp">Alumni </a></td>
					<td><a href="announcement.jsp">Announcements </a></td>
					<td><a href="logout.jsp">Logout </a></td>
				</tr>
			</table>
			<table class="form-table" align="center">
				<tr>
					
					<td><input type="button" name="view_alumni" value = "View Alumni" /></td>					
					<td><input type="button" name="add_alumni" value = "Add Alumni"/></td>					
					<td><input type="button" name="edit_alumni" value = "Edit Alumni"/></td>
				</tr>
				
			</table>
		</div>
</body>
</html>