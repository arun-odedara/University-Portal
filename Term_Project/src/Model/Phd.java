package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.LoginDao;

public class Phd {
	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	
	private int id;
	private String first_name;
	
	public static ArrayList<Phd> get_Phd() throws SQLException {
		ArrayList<Phd> phdList = new ArrayList<Phd>();
		try {
			
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            String phd = "PHD";
            ResultSet rs = statement.executeQuery("select * from students where program = '"+ phd +"'");
        
            while(rs.next()) {
            	Phd pd = new Phd();
            	pd.setId(rs.getInt("id"));
            	pd.setFirst_name(rs.getString("first_name"));
            	phdList.add(pd);
            }
		} 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        	System.out.println("Catch Descussion called");
            e.printStackTrace();
        }
		return phdList;
		
    }
	
	
	public static void insert_phd(String id, String name, String sem, String status){		
		conn = null;	
		try 
		{
			
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into phd (id, name, sem, status) values (?,?,?,?) ");
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, sem);
			pst.setString(4, status);
			rs = pst.executeQuery();
			rs.next();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}

	
	
	
	public static ArrayList<Phd> get_One(int id) throws SQLException {
		ArrayList<Phd> oneList = new ArrayList<Phd>();
		try {
		
			System.out.println("Value of i in method is");
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from students where id = '"+ id +"'");
        
            while(rs.next()) {
            	Phd pd = new Phd();
            	pd.setId(rs.getInt("id"));
            		System.out.println("Value of id is: "+pd.getId());
            	pd.setFirst_name(rs.getString("first_name"));
            		System.out.println("Value of i is: "+pd.getFirst_name());
            	oneList.add(pd);
            }
		} 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        	System.out.println("Catch Descussion called");
            e.printStackTrace();
        }
		return oneList;
		
    }
	
	
	
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
			

	}
