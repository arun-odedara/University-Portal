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
    ArrayList<Phd> phdList = Phd.get_Phd();
%>
<body >
<div>
<table class="form-table" align="center" cellpadding="30px"  >
	<tr>
		<th>Student ID</th>
		<th>Student Name</th>
	</tr>
	<tr><hr></tr>
		<% for(int j=0; j<phdList.size(); j++)
				{%>
			<tr>
					<td>	<%	out.println((phdList.get(j).getId())); 	%> 	</td>
					<td>	<% 	out.println((phdList.get(j).getFirst_name())); 	%>	</td>
					<td>	<a href="PhdServlet?action=editPhd&sid=<%=phdList.get(j).getId() %>"> <input type="button" style="width: 100px" value="Edit" /></a>	</td>
			</tr>
				<% } %>
	</table>
<hr>
</div>
</body>
</html>