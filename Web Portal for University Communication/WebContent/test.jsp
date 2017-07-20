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
    ArrayList<Discuss> postList = (ArrayList<Discuss>) request.getAttribute("posts");
	//System.out.println("Testing Value"+(postList.get(0).getPost_id()));
%>
<body >
	<form action="DiscussServlet?action=post" method="post"> 
		<table class="form-table" align="center"  >
			<tr>
				<th><h2 style="text-align: center;"> <%	out.println(request.getAttribute("t_name")); 	%></h2> </th>
			</tr>
			<tr>
				<td>	<textarea name ="post" rows="15" cols="25" style="width: 500px; height: 80px"></textarea>	</td>
			</tr>
			<tr>
				<td>	 <input type="submit" style="width: 100px" value="Post" /></td>
			</tr>
		</table>
	</form>
<table class="form-table" align="center"  >
	<% for(int j=0; j<postList.size(); j++)
				{%>
	<tr>
		<td><% out.println(postList.get(j).getPost_id()); %></td>
		<td><% out.println(postList.get(j).getPost()); %></td>
		<td><input type="button" style="width: 100px" name="reply" value="Reply"/></td>
	</tr>
				<% } %>
	</table>
</body>
</html>