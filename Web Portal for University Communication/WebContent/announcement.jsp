<%@include file="welcome.jsp"%>
<html>
<body>
	<form action="AnnServlet?action=createAnn" method="post">
		<table class="form-table" align="center">
			<tr>
				<td>Announcement Type :</td>
				<td><select name="a_type">
						<option>Choose Announcement Type</option>
						<option value="Job">Job</option>
						<option value="Event">Event</option>
						<option value="News">News</option>
				</select></td>
			</tr>
			<tr>
				<td>Posted by :</td>
				<td><%= session.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>Announcement :</td>
				<td><textarea name = "a_value" rows="6" cols="8"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>