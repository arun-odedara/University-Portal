<%@include file = "welcome.jsp" %>
<%@page import="Model.Discuss, servlets.DiscussServlet,java.util.ArrayList" %>
<html>
<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussion Board</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<%
	int i =1;
	ArrayList<Discuss> postList = Discuss.getAllPosts(i);
%>
<body >

<table class="form-table" align="center"  >
	<% for(int j=0; j<1; j++)
				{%>
	<tr>
		<th><h2 style="text-align: center;"> <%	out.println((postList.get(j).getT_name())); 	%></h2> </th>
	</tr>
	<tr>
		<td>	<textarea name ="post" rows="15" cols="25" style="width: 500px; height: 80px"></textarea>	</td>
	</tr>
	<tr>
		<td>	 <input type="submit" style="width: 100px" value="Post" /></td>
	</tr>
	<tr>
		<td><p> <%= out.println(postList.get(j).getPost_id()) %></p></td>
		<td><p><%= out.println(postList.get(j).getPost()) %></p></td>
		<td><input type="text" name="reply" value="Reply"/></td>
	</tr>
				<% } %>
	</table>
</body>
</html>