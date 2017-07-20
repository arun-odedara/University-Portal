<%@include file = "welcome.jsp" %>
<%@page import="Model.Ann,servlets.AnnServlet,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Announcement</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
   	HttpSession ssn =request.getSession();
	ArrayList<Ann> annList = Ann.get_Ann(ssn.getAttribute("name").toString());
%>
<body >
<table class="form-table" align="center"  >
	<tr>
		<th>Ann ID</th>
		<th>Ann Type</th>
		<th>Announcement</th>
		<th>Posted By </th>
		<th>Select</th>
	</tr>
		<% for(int j=0; j<annList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((annList.get(j).getA_id())); 	%> 	</td>
					<td>	<% 	out.println((annList.get(j).getA_type())); 	%>	</td>
					<td>	<input  type ="text" name="a_value" value="<%out.println((annList.get(j).getA_value()));	%>"/>	</td>
					<td>	<% 	out.println((annList.get(j).getN_id()));	%>  </td>
					<td><a href="AnnServlet?action=editAnn&an_id=<%=annList.get(j).getA_id()%>"><input style="width: 100px;" type="submit" value="Submit" /></a></td>
			</tr>
				<% } %>
	</table>
</body>
</html>