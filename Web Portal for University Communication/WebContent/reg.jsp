<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function forStudent(val)
	{
		 var element=document.getElementById('year');
	 	if(val=='Student')
	   		element.style.display='block';
	 	else  
	   		element.style.display='none';
	 	var element=document.getElementById('program');
	 	if(val=='Student')
	   		element.style.display='block';
	 	else  
	   		element.style.display='none';
	}
</script> 
<title>Registration</title>
</head>
<body>
	<div id="about" style="background-color:#33adff	;">
    	<h1><span style="font-weight:normal">Login</span></h1>
        <div class="top-divider" style="background-color:#003d66"></div>
		<form action="loginServlet" method="post">
				<table class="form-table" align="center">
					<tr>
	              	   <td>First Name</td>
	                	<td><input type="text" name="fname" value="" /></td>
	              	</tr>
	                <tr>
	               		<td>Last Name</td>
	                    <td><input type="text" name="lname" value="" /></td>
	                </tr>
	                <tr>
	                	 <td>Role</td>
	                    <td> 
	                    	<select name="role" onchange='forStudent(this.value);'> 
	                    		<option>Choose a Role</option>  
			                    <option value="Student">Student</option>
			                    <option value="Faculty">Faculty</option>
			                    <option value="Staff">Staff</option>
			                </select>
					    </td>
	             	</tr>
	                <tr>
	                	 <td>Net Id</td>
	                     <td><input type="text" name="nid" value="" /></td>
	             	</tr>
	                <tr>
	              	     <td>Password</td>
	                   	 <td><input type="password" name="pass" value="" /></td>
	                </tr>
	                <tr>
			           <td> Year Joined </td>
			           <td><input type="text" name="year" id="year" style='display:none;'/> </td>   
			       </tr>
			       <tr>
			           <td>Program Name </td>
			           <td>
			           <select name="program" id="program" style='display:none;' onchange='forStudent(this.value);'> 
	                    		<option></option>  
			                    <option value="BA">BA</option>
			                    <option value="BS">BS</option>
			                    <option value="MS">MS</option>
			                    <option value="PHD">PHD</option>
			            </select>
			       </tr>
	                <tr>
	                     <td><input type="submit" value="Submit" /></td>
	                     <td><input type="reset" value="Reset" /></td>
	                </tr>
	                <tr>
	                     <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
	                </tr>
	         	</table>
		</form>    
		</div>     	
</body>
</html>