<%@include file = "welcome.jsp" %>
<%@page import="Model.Discuss, servlets.AlumniServlet,java.util.ArrayList" %>

<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussion Board</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
    ArrayList<Discuss> topicList = Discuss.getAllDiscussion();
%>
<body >
<form action="DiscussServlet?action=post" method="post">
	<table class="form-table" align="center"  >
	<tr>
		<th>ID</th>
		<th>Topic Name</th>
		<th>Select</th>
	</tr>
		<% for(int j=0; j<topicList.size(); j++)
				{%>
			<tr>
					<th><input type="text" name = "p_id" value="<%= topicList.get(j).getT_id() %>" style="display: none;"></th>
					<th><input type="text" name = "p_name" value="<%= topicList.get(j).getT_name() %>" style="display: none;"></th>
			</tr>
			
			<tr>
					<td>	<%	out.println((topicList.get(j).getT_id())); 	%> 	</td>
					<td>	<%	out.println((topicList.get(j).getT_name())); 	%> 	</td>
					<td>	<input type="submit" style="width: 100px" value="Discuss" /> </td> 			</tr>
			<% } %>
	</table>
</form>
</body>
</html>