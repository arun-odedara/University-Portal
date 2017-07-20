package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.LoginDao;

public class Alumni {
	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	
	private int a_id;
	private String a_name;
    private String founded;
    private String link;
    
	
    
    public static ArrayList<Alumni> getAllAlumnies() throws SQLException {
		ArrayList<Alumni> alumniList = new ArrayList<Alumni>();
		try {
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from alumni ");
        
            while(rs.next()) {	
            	Alumni alumni=new Alumni();
            	alumni.setA_id(rs.getInt("a_id"));
            	alumni.setA_name(rs.getString("a_name"));
            	alumni.setFounded(rs.getString("founded"));
                alumni.setLink(rs.getString("link"));
            	alumniList.add(alumni);
            }
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return alumniList;
		
    }
    
    
    
    public static void addAlumni(String a_name, String founded, String link){		
		conn = null;	
		try 
		{
			
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into alumni (a_name, founded, link) values (?,?,?) ");
			pst.setString(1, a_name);
			pst.setString(2, founded);
			pst.setString(3, link);
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	
	
	
	public static void editAlumni(int a_id, String a_name, String founded, String link){		
		conn = null;	
		try 
		{
			
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("update alumni set a_name=?, founded=?, link=? where a_id ='"+a_id+"'");
			pst.setString(1, a_name);
			pst.setString(2, founded);
			pst.setString(3, link);
			//pst.executeUpdate();
			
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	
	
	
	public static ArrayList<Alumni> get_Alumnies(int a_id) throws SQLException {
		ArrayList<Alumni> alumniList = new ArrayList<Alumni>();
		try {
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from alumni where a_id='"+a_id+"'");
        
            while(rs.next()) {	
            	Alumni alumni=new Alumni();
            	alumni.setA_id(rs.getInt("a_id"));
            	alumni.setA_name(rs.getString("a_name"));
            	alumni.setFounded(rs.getString("founded"));
                alumni.setLink(rs.getString("link"));
            	alumniList.add(alumni);
            }
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return alumniList;
		
    }
	

			public String getA_name() {
				return a_name;
			}

			public void setA_name(String a_name) {
				this.a_name = a_name;
			}

			public String getFounded() {
				return founded;
			}

			public void setFounded(String founded) {
				this.founded = founded;
			}

			public String getLink() {
				return link;
			}

			public void setLink(String link) {
				this.link = link;
			}
			public int getA_id() {
				return a_id;
			}

			public void setA_id(int a_id) {
				this.a_id = a_id;
			}

			
			
	}
