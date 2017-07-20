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

import Model.Discuss;
import Model.Phd;

/**
 * Servlet implementation class PhdServlet
 */
@WebServlet("/PhdServlet")
public class PhdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String insert = request.getParameter("action");
		if(insert.equals("editPhd"))
		{
			
			int i = Integer.parseInt(request.getParameter("sid"));
			System.out.println("Value of i is: "+i);
			
			ArrayList<Phd> pd = new ArrayList<Phd>();
			try {
				pd = Phd.get_One(i);
				request.setAttribute("editPhd", pd);
				
				RequestDispatcher rd = request.getRequestDispatcher("edit_phd.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		String insert = request.getParameter("action");
		
		
		
		
		if(insert.equals("try"))
		{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String sem = request.getParameter("sem");
			String status = request.getParameter("status");
			
			Phd.insert_phd(id, name, sem, status);
			boolean i;
			try 
			{
				i = Phd.pst.execute();
				if(!i)
				{  
					response.sendRedirect("phd.jsp");	
	            } 
				Phd.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
		}
	}

}
