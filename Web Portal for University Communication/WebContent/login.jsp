<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles.css" rel="stylesheet" type="text/css">
<title>Login Application</title>
</head>
<body>
		
<div id="about" style="background-color:#33adff	; margin-top: 70px;">
    	<h1><span style="font-weight:normal">Login</span></h1>
        <div class="top-divider" style="background-color:#003d66"></div>
		<form action="loginServlet?action=login" method="get">
				<p align="center" style="color: purple;">	${login_error}	</p>			
				<table class="form-table" align="center">
					<tr>
						<td>Net ID</td>
						<td><input type="text" name="username" required="required" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="userpass" required="required" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Login" /></td>
					</tr>
					<tr>
	                    <td colspan="2">Yet Not Registered!! <a href="reg.jsp">Register Here</a></td>
	                </tr>
				</table>
		</form>
		</div>
</body>
</html>