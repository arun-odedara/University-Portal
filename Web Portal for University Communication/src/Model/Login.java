package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.LoginDao;
import Model.Login;

public class Login {
	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	

	private static String first_name ;
	private static String last_name;
	private static String role;
	private static String nid;
	private static String pass;
	
	

	
	public static void editData(String first_name, String last_name,String pass,String nid)
	{
		try 
	    {
			Class.forName(LoginDao.driver);
			LoginDao ld = new LoginDao();
			ld.connect();	    
			PreparedStatement pst =(PreparedStatement) LoginDao.conn.prepareStatement("update faculty_staff set first_name=?, last_name=?, pass=? where nid='"+nid+"'");
			 pst.setString(1,first_name); 
			 System.out.println("First name in editData()"+first_name);
	         pst.setString(2,last_name);        
	         pst.setString(3,pass);
	         pst.executeUpdate();
	    }
	         
	    catch (SQLException | ClassNotFoundException e) 
	    {
	    	e.printStackTrace();
	    }
	}
	
	public static ArrayList<Login> getAllLogins(String nid) throws SQLException {
		ArrayList<Login> loginList = new ArrayList<Login>();
		try {
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from faculty_staff where nid ='"+nid+"'");
        
            while(rs.next()) {	
            	Login login=new Login();
            	login.setFirst_name(rs.getString("first_name"));
            	//System.out.println("First name :"+login.getFirst_name());
            	login.setLast_name(rs.getString("last_name"));
                login.setRole(rs.getString("role"));
                login.setNid(rs.getString("nid"));
            	login.setPass(rs.getString("pass"));
            	loginList.add(login);
            }
        }
		catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return loginList;
		
    }

	public static boolean validate(String name, String pass) {		
		boolean status = false;
		conn = null;		
		try 
		{
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("select * from students where nid='"+name+"' and pass='"+pass+"'");
			
			rs = pst.executeQuery();
			status = rs.next();
		
			if(status)
			{
				System.out.println("Status is :"+status);
			}
			else
			{
				pst = conn.prepareStatement("select * from faculty_staff where nid='"+name+"' and pass='"+pass+"'");
				rs=pst.executeQuery();
				status = rs.next();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
