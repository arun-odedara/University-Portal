package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dao.LoginDao;

public class Course {
	private static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	static HttpSession session;
	
	private String c_id;
    private String c_name;
    private String TA;
    private String o_Hours;
    private String Syllabus;   
    private String nid;
	public static void addCourse(String c_id, String c_name, String o_Hours, String TA, String Syllabus, String n_id){		
		conn = null;	
		try 
		{
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("insert into courses (course_id, c_name,o_Hours, TA, Syllabus, n_id) values (?,?,?,?,?,?) ");
			pst.setString(1, c_id);
			pst.setString(2, c_name);
			pst.setString(3, o_Hours);
			pst.setString(4, TA);
			pst.setString(5, Syllabus);
			pst.setString(6, n_id);
			rs = pst.executeQuery();
			rs.next();
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	public static void editCourse(String c_id, String c_name, String o_Hours, String TA, String Syllabus, String n_id){		
		conn = null;	
		try 
		{
			Class.forName(LoginDao.driver).newInstance();
			conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
			pst = conn.prepareStatement("update courses set c_name=?,o_Hours=?, TA=?, Syllabus=? where course_id ='"+c_id+"' ");
			//pst.setString(1, c_id);
			pst.setString(1, c_name);
				System.out.println("NAme : "+c_name);
			pst.setString(2, o_Hours);
				System.out.println("o_Hours : "+o_Hours);
			pst.setString(3, TA);
				System.out.println("TA : "+TA);
			pst.setString(4, Syllabus);
				System.out.println("Syllabus : "+Syllabus);
			pst.executeUpdate();
			
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
	    {
	    	e.printStackTrace();
	    } 
	}
		
	
			public static ArrayList<Course> getAllCourses() throws SQLException {
				ArrayList<Course> courseList = new ArrayList<Course>();
				try {
				Class.forName(LoginDao.driver).newInstance();
				conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
		        
		            Statement statement = conn.createStatement();
		            ResultSet rs = statement.executeQuery("select * from courses ");
		        
		            while(rs.next()) {	
		            	Course course=new Course();
		            	course.setC_id(rs.getString("course_id"));
		            	course.setC_name(rs.getString("c_name"));
		                course.setO_Hours(rs.getString("o_Hours"));
		                course.setTA(rs.getString("TA"));
		            	course.setSyllabus(rs.getString("Syllabus"));
		            	course.setNid(rs.getString("n_id"));
		            	courseList.add(course);
		            }
		        } 
		        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }
				
				return courseList;
				
		    }
			
			
			
			public static ArrayList<Course> get_Courses(String c_id) throws SQLException {
				ArrayList<Course> courseList2 = new ArrayList<Course>();
				try {
					
				Class.forName(LoginDao.driver).newInstance();
				conn = DriverManager.getConnection(LoginDao.url + LoginDao.dbName, LoginDao.userName, LoginDao.password);
		        
		            Statement statement = conn.createStatement();
		            ResultSet rs = statement.executeQuery("select * from courses where course_id = '"+ c_id+"'");
		        
		            while(rs.next()) {
		            	Course course =new Course();
		            	course.setC_id(rs.getString("course_id"));
		            	course.setC_name(rs.getString("c_name"));
		                course.setO_Hours(rs.getString("o_Hours"));
		                course.setTA(rs.getString("TA"));
		            	course.setSyllabus(rs.getString("Syllabus"));
		            	courseList2.add(course);
		            }
				} 
		        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }
				
				return courseList2;
				
		    }

			public String getC_id() {
				return c_id;
			}

			public void setC_id(String c_id) {
				this.c_id = c_id;
			}

			public String getC_name() {
				return c_name;
			}

			public void setC_name(String c_name) {
				this.c_name = c_name;
			}

			public String getO_Hours() {
				return o_Hours;
			}

			public void setO_Hours(String o_Hours) {
				this.o_Hours = o_Hours;
			}

			public String getTA() {
				return TA;
			}

			public void setTA(String tA) {
				TA = tA;
			}

			public String getSyllabus() {
				return Syllabus;
			}

			public void setSyllabus(String syllabus) {
				Syllabus = syllabus;
			}
			
			public String getNid() {
				return nid;
			}

			public void setNid(String nid) {
					this.nid = nid;
			}

			
	}
