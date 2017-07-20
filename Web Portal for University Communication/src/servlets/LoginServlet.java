package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import Model.Login;
import dao.LoginDao;


public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String n=request.getParameter("username");  
		String p=request.getParameter("userpass"); 
		
		HttpSession session = request.getSession(false);
		if(session!=null)
		session.setAttribute("name", n);
		

		if(Login.validate(n, p)){  
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
			rd.forward(request,response);  
		}  
		else{  
			String err ="Sorry username or password does not match";
			request.setAttribute("login_error", err);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			rd.include(request,response);  
		}  

		out.close();  
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String logout = request.getParameter("action");
		if(logout.equals(logout))
		{
			request.getSession().invalidate();
	        response.sendRedirect("login.jsp");
		}
		
		
		String user = request.getParameter("nid");    
	    String pwd = request.getParameter("pass");
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String role = request.getParameter("role");
	    String year = request.getParameter("year");
	    String program = request.getParameter("program");
	    //PrintWriter pw = response.getWriter(); 
	    
	    
	    
	//***************************************Edit User- Calling editData()*************************************//    
		
		//****************************************Calling getAllLogins()*****************************************************//
		
		
	//**********************************************Validation Checking**************************************************************//	
		 if(year == "" && program == "")
		 {
		    try 
			    {
					Class.forName(LoginDao.driver);
					Connection conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
				    
					PreparedStatement pst =(PreparedStatement) conn.prepareStatement
							("insert into faculty_staff(first_name, last_name, role, nid, pass) values (?,?,?,?,?)");
					 pst.setString(1,fname);  
			         pst.setString(2,lname);        
			         pst.setString(3,role);
			         pst.setString(4,user);
			         pst.setString(5,pwd);
			         
			         int i = pst.executeUpdate();
			         if(i!=0)
			         {
			        	 pst.close();
			         }
				}
			    catch (SQLException | ClassNotFoundException e) 
			    {
			    	e.printStackTrace();
			    }
		 }
		 else
		 {
		    try
		    {
		    	Class.forName(LoginDao.driver);
				Connection conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
				
		          PreparedStatement pst =(PreparedStatement) conn.prepareStatement
							("insert into students(first_name, last_name, role, nid, pass, year, program) values (?,?,?,?,?,?,?)");
					 pst.setString(1,fname);  
			         pst.setString(2,lname);        
			         pst.setString(3,role);
			         pst.setString(4,user);
			         pst.setString(5,pwd);
			         pst.setString(6,year);
			         pst.setString(7,program);
			         
			         int i = pst.executeUpdate();
			         if(i!=0)
			         {
			        	 pst.close();
			         }
		    }
			    catch (SQLException | ClassNotFoundException e) 
			    {
			    	e.printStackTrace();
			    }
		 }	 
		 
	//**********************************************************************************************************************//
	}
		
}  