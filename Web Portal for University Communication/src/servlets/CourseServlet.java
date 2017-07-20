package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Course;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String c_id = (request.getParameter("c_id"));
		try
		{
			ArrayList<Course> course = new ArrayList<Course>();
			course = Course.get_Courses(c_id);
			request.setAttribute("c_id", course);
			RequestDispatcher rd = request.getRequestDispatcher("editCourse.jsp");
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
		
		response.setContentType("text/html");  
		
		String c_id = request.getParameter("c_id");    
	    String c_name = request.getParameter("c_name");
	    String o_Hours = request.getParameter("o_Hours");
	    String TA = request.getParameter("TA");
	    String Syllabus = request.getParameter("Syllabus");
	    HttpSession session = request.getSession();
	    String nid = (String) session.getAttribute("name");
	    PrintWriter pw = response.getWriter();
	    
	    String edit = request.getParameter("action");
	    
	    if(edit.equals("addCourse"))
		{
			Course.addCourse(c_id, c_name, o_Hours, TA, Syllabus,nid);
		    int i;
			try 
			{
				i = Course.pst.executeUpdate();
				String msg=" ";
				if(i!=0){  
					msg="Record has been inserted";
					pw.println("<font size='6' color=blue>" + msg + "</font>"); 
					response.sendRedirect("viewCourse.jsp");
					
	            }  
	          else
	          {  
	            msg="failed to insert the data";
	            pw.println("<font size='6' color=blue>" + msg + "</font>");
	          }  
	          Course.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
		}
		
		if(edit.equals("editcourse"))
		{
			Course.editCourse(c_id, c_name, o_Hours, TA, Syllabus, nid);
			int j;
			try 
			{
				j = Course.pst.executeUpdate();
				String msg=" ";
				if(j!=0){  
					msg="Record has been inserted";
					pw.println("<font size='6' color=blue>" + msg + "</font>"); 
					response.sendRedirect("viewCourse.jsp");
					
	            }  
	          else
	          {  
	            msg="failed to insert the data";
	            pw.println("<font size='6' color=blue>" + msg + "</font>");
	          }  
	          Course.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }

		}
		
}
}
