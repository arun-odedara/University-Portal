<%@include file = "welcome.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussion Board</title>
</head>
<body>
		
		<form action="DiscussServlet?action=new" method="post">
			<table class="form-table" align="center">
					<tr>
	                	<td>Topic Name : </td>
	                    <td><input type="text" name="t_name" value="" /> </td>
	             	</tr>
	             	<tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
	         </table>
	     </form>
	
</body>
</html>