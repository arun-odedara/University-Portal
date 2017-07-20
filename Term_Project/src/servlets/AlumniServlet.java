package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Alumni;

/**
 * Servlet implementation class AlumniServlet
 */
@WebServlet("/AlumniServlet")
public class AlumniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		//int a_id = Integer.parseInt(request.getParameter("a_id"));
		try
		{
			ArrayList<Alumni> alumni = new ArrayList<Alumni>();
			alumni = Alumni.getAllAlumnies();
			request.setAttribute("alumniList", alumni);;
			RequestDispatcher rd = request.getRequestDispatcher("editAlumni.jsp");
			rd.forward(request, response);
		}
		catch (SQLException e) 
	    {
	    	e.printStackTrace();
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
		
		String a_name = request.getParameter("a_name");    
	    String founded = request.getParameter("founded");
	    String link = request.getParameter("link");
	    
	    PrintWriter pw = response.getWriter();
		
	    String data = request.getParameter("action");
	    
	    if(data.equals("editAlumni"))
	    {
	    	int a_id = Integer.parseInt(request.getParameter("a_id"));
	    	Alumni.editAlumni(a_id, a_name, founded, link);
		    int i;
			try 
			{
				i = Alumni.pst.executeUpdate();
				if(i!=0){  
					response.sendRedirect("viewAlumni.jsp");
					
	            }  
	          else
	          {  
	            String msg="failed to insert the data";
	            pw.println("<font size='6' color=blue>" + msg + "</font>");
	          }  
	          Alumni.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	    }
	    
	    
	    
	    if(data.equals("addAlumni"))
	    {
		    Alumni.addAlumni(a_name, founded, link);
		    int i;
			try 
			{
				i = Alumni.pst.executeUpdate();
				String msg=" ";
				if(i!=0){  
					msg="Record has been inserted";
					pw.println("<font size='6' color=blue>" + msg + "</font>"); 
					response.sendRedirect("viewAlumni.jsp");
					
	            }  
	          else
	          {  
	            msg="failed to insert the data";
	            pw.println("<font size='6' color=blue>" + msg + "</font>");
	          }  
	          Alumni.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	    }
	}

}
