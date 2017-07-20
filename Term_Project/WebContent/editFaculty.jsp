<%@include file = "welcome.jsp" %>
<%@page import="Model.Login,servlets.LoginServlet,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Login</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
    String ac = session.getAttribute("name").toString();
	System.out.println("Name is "+ac);
	//ArrayList<Login> loginList = (ArrayList<Login>)request.getAttribute("getedit");
	ArrayList<Login> loginList = (ArrayList<Login>) Login.getAllLogins(ac);
%>
<body >
<br><br><br>
<form action="EditUser" method="post">
<table class="form-table" align="center"  cellpadding="10px" >
				<% for(int j=0; j<1; j++)
					{	
				%>	
					<tr>
	                	<td>First Name : </td>
	                    <td><input type="text" name="f_name" value="<%	out.println((loginList.get(j).getFirst_name())); 	%>" /> </td>
	             	</tr>
	             	<tr>
	                	<td>Last Name : </td>
	                    <td><input type="text" name="l_name" value="<% 	out.println((loginList.get(j).getLast_name())); 	%>" /> </td>
	             	</tr>
					<tr>
	                    <td><input style="display: none;" type="text" name="nid" value="<% 	out.println((loginList.get(j).getNid())); 	%>" /> </td>
	             	</tr>
					<tr>
						<td>Password : </td>
					 	<td><input name = "pass" value ="<% out.println((loginList.get(j).getPass()));	%>"></td>
					</tr>					
					<tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
	                <% } %>
	</table>
	</form>
	</body>
</html>