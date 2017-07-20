String e_name = request.getParameter("e_name"); 
	    String Info = request.getParameter("Info");
	    String e_date = request.getParameter("e_date");
		
	    String data = request.getParameter("action");
			
		if(data.equals("addExam"))
	    {
			try 
			{
				Exam.addExam(e_name, e_date, Info);
					System.out.println("Date is : "+e_date);
				RequestDispatcher rd = request.getRequestDispatcher("viewExam.jsp");
				rd.forward(request, response);
				Exam.pst.close();
			}
			catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	    }