<%@include file = "welcome.jsp" %>
<html>
<body>
			<form action="ExamServlet?action=addExam" method="post">
			<table class="form-table" align="center">
	             	<tr>
	                	<td>Exam Name: </td>
	                    <td><input type="text" name="e_name" value="" /> </td>
	             	</tr>
	                <tr>
	                	 <td>Exam Date: </td>
	                     <td><input type="date" name="e_date" value="" /></td>
	             	</tr>
	                <tr>
	              	     <td>Info</td>
	                   	 <td><input type="text" name="Info" value="" /></td>
	                </tr>
					<tr>
						<td>posted by : </td>
						<td><%= session.getAttribute("name")%>" </td>
					</tr>
					<tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
			</table>
			</form>
</body>
</html>