package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.LoginDao;

public class Ann {

	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	
	private int a_id;
	private String a_type;
	private String a_value;
	private String n_id;
	
	
	
	public static void addAnn(String a_type, String a_value, String n_id){		
		conn = null;	
		try 
		{
						System.out.println("In Add Announcementr ");
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into ann (a_type, a_value, n_id) values (?,?,?) ");
			pst.setString(1, a_type);
						System.out.println("In Add Announcementr "+a_type);
			pst.setString(2, a_value);
						System.out.println("In Add Announcementr "+a_value);
			pst.setString(3, n_id);
						System.out.println("In Add Announcementr "+n_id);
						
			pst.executeUpdate();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	
	public static ArrayList<Ann> getAllAnn() throws SQLException {
		ArrayList<Ann> annList = new ArrayList<Ann>();
		try {
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from ann ");
        
            while(rs.next()) {	
            	Ann ann=new Ann();
            	ann.setA_id(rs.getInt("an_id"));
            	ann.setA_type(rs.getString("a_type"));
            	ann.setA_value(rs.getString("a_value"));
                ann.setN_id(rs.getString("n_id"));
            	annList.add(ann);
            }
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return annList;
		
    }
	
	
	public static ArrayList<Ann> get_Ann(String n_id) throws SQLException {
		ArrayList<Ann> annList2 = new ArrayList<Ann>();
		try {
			
			System.out.println("In The GET EXAM");
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from ann where n_id = '"+ n_id+"'");
        
            while(rs.next()) {
            	Ann ann=new Ann();
            	ann.setA_id(rs.getInt("an_id"));
            	ann.setA_type(rs.getString("a_type"));
            	ann.setA_value(rs.getString("a_value"));
                ann.setN_id(rs.getString("n_id"));
            	annList2.add(ann);
            }
		} 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return annList2;
		
    }

	
	
	public static void edit_Ann(int an_id, String a_value){		
		conn = null;	
		try 
		{
			System.out.println("In Edit Announcementr ");
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("update ann set a_value=? where an_id='"+an_id+"' ");
			pst.setString(1, a_value);
						System.out.println("In Add Announcementr "+a_value);
						
			pst.executeUpdate();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}


	public String getA_type() {
		return a_type;
	}

	public void setA_type(String a_type) {
		this.a_type = a_type;
	}

	public String getA_value() {
		return a_value;
	}

	public void setA_value(String a_value) {
		this.a_value = a_value;
	}

	public String getN_id() {
		return n_id;
	}

	public void setN_id(String n_id) {
		this.n_id = n_id;
	}


	public int getA_id() {
		return a_id;
	}


	public void setA_id(int i) {
		this.a_id = i;
	}
}
