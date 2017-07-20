package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Ann;

/**
 * Servlet implementation class AnnServlet
 */
@WebServlet("/AnnServlet")
public class AnnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	   
	    //System.out.println("A Value is of Announcement in servlet :"+a_value);
		
	    String data = request.getParameter("action");
	    
		if(data.equals("editAnn"))
	    { 
			String a_value = request.getParameter("a_value");
			System.out.println("In Edit Ann Servlet");
			try 
			{
				int an_id = Integer.parseInt(request.getParameter("an_id"));
				Ann.edit_Ann(an_id, a_value);
					//System.out.println("Date is : "+e_date);
				RequestDispatcher rd = request.getRequestDispatcher("viewAnn.jsp");
				rd.forward(request, response);
				Ann.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	    }
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String a_type = request.getParameter("a_type"); 
	    String a_value = request.getParameter("a_value");
	    HttpSession session = request.getSession();
	    String n_id = (String) session.getAttribute("name");
		
	    String data = request.getParameter("action");
			
		if(data.equals("createAnn"))
	    {
			try 
			{
				Ann.addAnn(a_type, a_value, n_id);
					//System.out.println("Date is : "+e_date);
				RequestDispatcher rd = request.getRequestDispatcher("viewAnn.jsp");
				rd.forward(request, response);
				Ann.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	    }
		
	}

}
