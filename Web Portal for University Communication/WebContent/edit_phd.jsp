<%@include file = "welcome.jsp" %>
<%@page import="Model.Phd,servlets.PhdServlet,java.util.ArrayList" %>

<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phd </title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
	//int j = Integer.parseInt(request.getParameter("sid"));
	//int i = Integer.parseInt(request.getParameter("editPhd"));
	ArrayList<Phd> phdList =(ArrayList<Phd>) request.getAttribute("editPhd");
%>
<body >
<div>
<hr>
<form action="PhdServlet?action=try" method="post">
<table class="form-table" align="center" cellpadding="30px"  >

			<% for(int j=0; j<phdList.size(); j++)
				{%>
		
			<tr>
					<td>	Student ID : </td>
					<td>	<input type="text" name = "id" value="<% out.println((phdList.get(j).getId())); %>"/> 	</td>
			</tr>
			<tr>		
					<td>	Student Name : </td>
					<td>	<input type="text" name="name" value="<% out.println((phdList.get(j).getFirst_name()));%>"/>	</td>
			</tr>
			<tr>
					<td>	Student Semester : </td>
					<td>	<input type="text" name ="sem"/> 	</td>
			</tr>
			<tr>		
					<td>	Student Status : </td>
					<td>	<input type="text" name="status" />	</td>
			</tr>
			<tr>
	              	<td><input type="submit" value="Submit" /></td>
	                <td><input type="reset" value="Reset" /></td>
	        </tr>		
	       <%} %>
	</table>
<hr>
</form>
</div>
</body>
</html>