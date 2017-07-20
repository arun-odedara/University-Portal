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


import Model.Discuss;

/**
 * Servlet implementation class DiscussServlet
 */
@WebServlet("/DiscussServlet")
public class DiscussServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussServlet() {
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
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();  
		//String discuss = request.getParameter("action");
		//if(discuss.equals("post"))
		
			int t_id = Integer.parseInt(request.getParameter("x"));
			System.out.println("t_id is: "+t_id);
			try
			{
				ArrayList<Discuss> dscs = new ArrayList<Discuss>();
				dscs = Discuss.get_Discussion(t_id);
				request.setAttribute("t_id", dscs);
				RequestDispatcher rd = request.getRequestDispatcher("edit_discussion.jsp");
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
		PrintWriter pw = response.getWriter();
		
		String posts = request.getParameter("action");
		if(posts.equals("post"))
		{
			try
			{
				ArrayList<Discuss> dscs = new ArrayList<Discuss>();
				int post_id = Integer.parseInt(request.getParameter("post_id"));
					//System.out.println("Post id is: "+post_id);
				String post = request.getParameter("post");
					//System.out.println("Post is: "+post);
				Discuss.discuss_post(post_id, post);
				dscs = Discuss.getAllPosts(post_id);
				request.setAttribute("posts", dscs);
				RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
				rd.forward(request, response);
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
		}
		
		String news = request.getParameter("action");
		if(news.equals("new"))
		{
			String t_name = request.getParameter("t_name");    	
		   
			Discuss.start_discuss(t_name);
		    boolean i;
			try 
			{
				i = Discuss.pst.execute();
				String msg=" ";
				if(!i){  
					msg="Record has been inserted";
					pw.println("<font size='6' color=blue>" + msg + "</font>"); 
					response.sendRedirect("old_discussion.jsp");
					
	            }  
	          else
	          {  
	            msg="failed to insert the data";
	            pw.println("<font size='6' color=blue>" + msg + "</font>");
	          }  
				Discuss.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
		}
	}
}
