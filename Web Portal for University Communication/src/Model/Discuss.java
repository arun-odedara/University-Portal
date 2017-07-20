package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import dao.LoginDao;

public class Discuss {
	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	
	private int t_id;
	private String t_name;
    private String t_comment;
    private int post_id;
    private String post;
	
    
  //********************************Start Discussion****************************************//
	
    
	public static void start_discuss(String t_name){		
		conn = null;	
		try 
		{
			
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into discuss (t_name) values (?) ");
			pst.setString(1, t_name);
			rs = pst.executeQuery();
			rs.next();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	
	//********************************Selected Discussion****************************************//
		
	public static ArrayList<Discuss> get_Discussion(int t_id) throws SQLException {
		ArrayList<Discuss> topicList2 = new ArrayList<Discuss>();
		try {
			
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from discuss where t_id = '"+ t_id+"'");
        
            while(rs.next()) {
            	Discuss dscs2 = new Discuss();
            	dscs2.setT_id(rs.getInt("t_id"));
            			//System.out.println("t_id is: "+dscs2.getT_id());
            	dscs2.setT_name(rs.getString("t_name"));
            			//System.out.println("t_name is: "+dscs2.getT_name());
            	topicList2.add(dscs2);
            }
		} 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        	System.out.println("Catch Descussion called");
            e.printStackTrace();
        }
		return topicList2;
		
    }
	
	
	//********************************All Discussion List****************************************//
	
	
			
		public static ArrayList<Discuss> getAllDiscussion() throws SQLException {
				ArrayList<Discuss> topicList = new ArrayList<Discuss>();
				try {
				Class.forName(LoginDao.driver).newInstance();
				conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
		        
		            Statement statement = conn.createStatement();
		            ResultSet rs = statement.executeQuery("select * from discuss ");
		        
		            while(rs.next()) {	
		            	Discuss dscs = new Discuss();
		            	dscs.setT_id(rs.getInt("t_id"));
		            	dscs.setT_name(rs.getString("t_name"));
		            	topicList.add(dscs);
		            }
		        } 
		        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }
				
				return topicList;
			}
		
		
		//********************************POST****************************************//
		
		
		public static void discuss_post(int post_id,String post){		
			conn = null;	
			try 
			{
				Class.forName(LoginDao.driver).newInstance();
				conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
				pst = conn.prepareStatement("insert into discuss_post (t_id, post) values (?,?)");
				pst.setInt(1, post_id);
				pst.setString(2, post);
				pst.execute();
			}
		    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
		    {
		    	e.printStackTrace();
		    } 
		}
		
		
		//********************************Get All POST****************************************//
		
		
		public static ArrayList<Discuss> getAllPosts(int t_id) throws SQLException {
			ArrayList<Discuss> postList = new ArrayList<Discuss>();
			try {
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
	        
	            
				Statement statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery("select * from discuss_post where t_id='"+t_id+"'");
	        
	            while(rs.next()) {	
	            	Discuss dscs = new Discuss();
	            	dscs.setT_id(rs.getInt("t_id"));
	            		//System.out.println("Getting First Value"+dscs.getT_id());
	            	dscs.setPost_id(rs.getInt("post_id"));
	            		//System.out.println("Getting First Value"+dscs.getPost_id());
	            	dscs.setPost(rs.getString("post"));
	            		//System.out.println("Getting First Value"+dscs.getPost());
	            	
	            	postList.add(dscs);
	            }
	        } 
	        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			
			return postList;
		}
		
	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_comment() {
		return t_comment;
	}

	public void setT_comment(String t_comment) {
		this.t_comment = t_comment;
	}

	public int getT_id() {
		return t_id;
	}


	public void setT_id(int i) {
		this.t_id = i;
	}


	public int getPost_id() {
		return post_id;
	}


	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	}
