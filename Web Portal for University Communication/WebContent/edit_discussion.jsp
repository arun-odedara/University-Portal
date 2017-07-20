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
    ArrayList<Discuss> topicList = (ArrayList<Discuss>) request.getAttribute("t_id");
%>
<body >

<form action="DiscussServlet?action=post" method="post"> 
<table class="form-table" align="center"  >
	<% for(int j=0; j<1; j++)
				{%>
<!-- 	<tr> -->
<%-- 		<th><input type="text" name = "post_id" value="<%= topicList.get(j).getT_id() %>" style="display: none;"></th> --%>
<!-- 	</tr> -->
	<tr>
		<th><h2 style="text-align: center;" name ="post_name"> <%	out.println((topicList.get(j).getT_name())); 	%></h2> </th>
	</tr>
	<tr>
		<td>	<textarea name ="post" rows="15" cols="25" style="width: 500px; height: 80px"></textarea>	</td>
	</tr>
	<tr>
		<td>	 <input type="submit" style="width: 100px" value="Post" />	</td>
	</tr>
				<% } %>
	</table>
</form>
</body>
</html>