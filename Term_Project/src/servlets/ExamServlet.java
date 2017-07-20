package servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Exam;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
    
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String e_name = request.getParameter("e_name");
		String data = request.getParameter("action");
		
		if(data.equals("postResult"))
		{
			int e_id = Integer.parseInt(request.getParameter("e_id"));
			try
			{
				ArrayList<Exam> exam = new ArrayList<Exam>();
				Exam.addResult(e_id, e_name);
				exam = Exam.get_Exam(e_id);
				request.setAttribute("e_id", exam);
				RequestDispatcher rd = request.getRequestDispatcher("editResult.jsp");
				rd.forward(request, response);
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
		//PrintWriter pw = response.getWriter();
	
		String e_name = request.getParameter("e_name"); 
	    String Info = request.getParameter("Info");
	    String e_date = request.getParameter("e_date");
	    String s_id = request.getParameter("s_id");
	    String result = request.getParameter("result");
		
	    String data = request.getParameter("action");
			
		if(data.equals("addExam"))
	    {
			try 
			{
				Exam.addExam(e_name, e_date, Info);
					//System.out.println("Date is : "+e_date);
				RequestDispatcher rd = request.getRequestDispatcher("viewExam.jsp");
				rd.forward(request, response);
				Exam.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	    }
		
		
		if(data.equals("editExam"))
		{
			try
			{
				int e_id = Integer.parseInt(request.getParameter("e_id"));
				Exam.updateResult(e_id, e_name, s_id, result);
				RequestDispatcher rd = request.getRequestDispatcher("viewResult.jsp");
				rd.forward(request, response);
				Exam.pst.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
