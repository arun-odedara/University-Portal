/**
 * 
 */
package Model;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dao.LoginDao;

/**
 * @author Arun
 *
 */
public class Exam {
	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	static HttpSession session;
	
	private int e_id;
    private String e_name;
    private String e_date;
    private String Info;
    private String s_id;
    private String result;

	
    public static void addExam(String e_name, String e_date, String Info){		
		conn = null;	
		try 
		{
			
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into exam (e_name, e_date, Info) values (?,?,?) ");
			pst.setString(1, e_name);
			pst.setString(2, e_date);
			pst.setString(3, Info);
			pst.executeUpdate();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
    
    public static void addResult(int e_id, String e_name){		
		conn = null;	
		try 
		{
			System.out.println("In THE ADD RESULT");
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into result (e_id, e_name) values (?,?) ");
			pst.setInt(1, e_id);
				System.out.println("E_id in adding result is :"+e_id);
			pst.setString(2, e_name);
			System.out.println("E_Name in adding result is :"+e_name);
			pst.executeUpdate();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
    
    
    
    public static void updateResult(int e_id, String e_name, String s_id, String result){		
		conn = null;	
		try 
		{
			System.out.println("In THE ADD RESULT");
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("update result set s_id=?, result=? where e_id='"+e_id+"' ");
			/*pst.setInt(1, e_id);
				System.out.println("E_id in adding result is :"+e_id);
			pst.setString(2, e_name);
				System.out.println("E_Name in adding result is :"+e_name);*/
			pst.setString(1, s_id);
				System.out.println("E_Name in adding result is :"+s_id);
			pst.setString(2, result);
				System.out.println("E_Name in adding result is :"+result);
			pst.executeUpdate();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
    
    
    public static ArrayList<Exam> getAllExames() throws SQLException {
		ArrayList<Exam> examList = new ArrayList<Exam>();
		try {
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from exam ");
        
            while(rs.next()) {	
            	Exam exam=new Exam();
            	exam.setE_id(rs.getInt("e_id"));
            		//System.out.println("A_id in mehod is");
            	exam.setE_name(rs.getString("e_name"));
            	exam.setE_date(rs.getString("e_date"));
                exam.setInfo(rs.getString("Info"));
            	examList.add(exam);
            }
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return examList;
		
    }
    
    
    public static ArrayList<Exam> getAllResults() throws SQLException {
		ArrayList<Exam> examList = new ArrayList<Exam>();
		try {
		Class.forName(LoginDao.driver).newInstance();
		conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from result ");
        
            while(rs.next()) {	
            	Exam exam=new Exam();
            	exam.setE_id(rs.getInt("e_id"));
            		//System.out.println("A_id in mehod is");
            	exam.setE_name(rs.getString("e_name"));
            	exam.setS_id(rs.getString("s_id"));
                exam.setResult(rs.getString("result"));
            	examList.add(exam);
            }
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return examList;
		
    }
    
    
    public static ArrayList<Exam> get_Exam(int e_id2) throws SQLException {
		ArrayList<Exam> examList2 = new ArrayList<Exam>();
		try {
			
			System.out.println("In The GET EXAM");
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
        
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from result where e_id = '"+ e_id2+"'");
        
            while(rs.next()) {
            	Exam exam =new Exam();
            	exam.setE_id(rs.getInt("e_id"));
            	exam.setE_name(rs.getString("e_name"));
                exam.setS_id(rs.getString("s_id"));
                exam.setResult(rs.getString("result"));
            	examList2.add(exam);
            }
		} 
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return examList2;
		
    }
    
    public int getE_id() {
		return e_id;
	}
	public void setE_id(int i) {
		this.e_id = i;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}


	public String getS_id() {
		return s_id;
	}


	public void setS_id(String s_id) {
		this.s_id = s_id;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

}
