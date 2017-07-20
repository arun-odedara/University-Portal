<%@include file = "welcome.jsp" %>
<html>
<body>
			<form action="AlumniServlet?action=addAlumni" method="post">
			<table class="form-table" align="center">
					<tr>
	                	<td>Alumni Name: </td>
	                    <td><input type="text" name="a_name" value="" /> </td>
	             	</tr>
	             	<tr>
	                	<td>Founded Year: </td>
	                    <td><input type="text" name="founded" value="" /> </td>
	             	</tr>
	                <tr>
	                	 <td>Link : </td>
	                     <td><input type="text" name="link" value="" /></td>
	             	</tr>
					<tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
			</table>
			</form>
</body>
</html>