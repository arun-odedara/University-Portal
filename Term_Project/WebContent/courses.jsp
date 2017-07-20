<%@include file = "welcome.jsp" %>
<html>
<body>
			<form action="CourseServlet?action=addCourse" method="post">
			<table class="form-table" align="center">
					<tr>
	                	<td>Course ID: </td>
	                    <td><input type="text" name="c_id" value="" /> </td>
	             	</tr>
	             	<tr>
	                	<td>Course NAME: </td>
	                    <td><input type="text" name="c_name" value="" /> </td>
	             	</tr>
	                <tr>
	                	 <td>TA Info : </td>
	                     <td><input type="text" name="TA" value="" /></td>
	             	</tr>
	                <tr>
	              	     <td>Office Hours</td>
	                   	 <td><input type="text" name="o_Hours" value="" /></td>
	                </tr>
					<tr>
						<td>Syllabus : </td>
					 	<td><textarea name = "Syllabus"></textarea></td>
					</tr>
					<tr>
						<td>Net Id : </td>
						<td><%= session.getAttribute("name")%></td>
					</tr>
					<tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
			</table>
			</form>
</body>
</html>