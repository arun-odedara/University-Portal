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
    Ann cs = new Ann(); //not recommended.Pass this object from servlet
    ArrayList<Ann> annList = Ann.getAllAnn();
%>
<body >

<table class="form-table" align="center" border="2" bordercolor="white" cellpadding="10px" bgcolor="#4db8ff" >
	<tr>
		<th>Ann ID</th>
		<th>Ann Type</th>
		<th>Announcement</th>
		<th>Posted By </th>
	</tr>
		<% for(int j=0; j<annList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((annList.get(j).getA_id())); 	%> 	</td>
					<td>	<% 	out.println((annList.get(j).getA_type())); 	%>	</td>
					<td>	<% 	out.println((annList.get(j).getA_value()));	%>	</td>
					<td>	<% 	out.println((annList.get(j).getN_id()));		%>	</td>

			</tr>
				<% } %>
	</table>
</body>
</html>