<%@include file = "welcome.jsp" %>
<%@page import="Model.Alumni, servlets.AlumniServlet,java.util.ArrayList" %>
<html>
<% 
	//ArrayList<Alumni> alumniList = (ArrayList<Alumni>) request.getAttribute("alumniList");
	ArrayList<Alumni> alumniList = (ArrayList<Alumni>) request.getAttribute("alumniList");
%>
<body>
			<form action="AlumniServlet?action=editAlumni" method="post">
			<table class="form-table" align="center">
			<% for(int j=0; j<alumniList.size(); j++)
				{%>
					<tr>
	                    <td><input style="display: none;" type="text" name="a_id" value="<%	out.println((alumniList.get(j).getA_id())); 	%>" /> </td>
	             	</tr>
					<tr>
	                	<td>Alumni Name: </td>
	                    <td><input type="text" name="a_name" value="<%	out.println((alumniList.get(j).getA_name())); 	%>" /> </td>
	             	</tr>
	             	<tr>
	                	<td>Founded Year: </td>
	                    <td><input type="text" name="founded" value="<%	out.println((alumniList.get(j).getFounded())); 	%>" /> </td>
	             	</tr>
	                <tr>
	                	 <td>Link : </td>
	                     <td><input type="text" name="link" value="<%	out.println((alumniList.get(j).getLink())); 	%>" /></td>
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