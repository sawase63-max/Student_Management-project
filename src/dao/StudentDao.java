package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Students;

public class StudentDao {

	private static String url = "jdbc:mysql://localhost:3306/student_management";
	private static String username = "root";
	private static String password = "Sunil@@@0071";
	public static Connection getConnection() {
		
		try {
		return DriverManager.getConnection(url,username,password);
		
		
		}catch(SQLException e) { 
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//get all students
	
	public  List<Students> getAllStudents(){
		
		List<Students> list = new ArrayList<Students>();
		Connection c = getConnection();
		String query = "select * from students";
		
		try {
		PreparedStatement ps =c.prepareStatement(query); 
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Students s = new Students(					
					rs.getInt("roll_number"),
					rs.getString("student_name"),
					rs.getString("dob"),
					rs.getString("gender"),
					rs.getString("email"),
					rs.getString("phone_number"),
					rs.getString("address")														
					);
			
			list.add(s);
		}
		
		
		
		}catch(SQLException e) {
			System.out.println("ERROR :"+e.getMessage());
		}
		return list;
	}
	
	
	public List<Students> getStudentByRoll(int roll_number){
		List<Students> list =new ArrayList<Students>();
		
		Connection  c = getConnection();
		String query = "select * from students where roll_number = ? ";
		try {
		PreparedStatement ps = c.prepareStatement(query);
		
			ps.setInt(1, roll_number);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Students s = new Students(					
					rs.getInt("roll_number"),
					rs.getString("student_name"),
					rs.getString("dob"),
					rs.getString("gender"),
					rs.getString("email"),
					rs.getString("phone_number"),
					rs.getString("address")														
					);
			
			list.add(s);
		}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			}
		return list;
		}
	
	public List<Students> getStudentByAddress(String address){
		List<Students> list =new ArrayList<Students>();
		
		Connection  c = getConnection();
		String query = "select * from students where address = ? ";
		try {
		PreparedStatement ps = c.prepareStatement(query);
		
			ps.setString(1, address);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Students s = new Students(					
					rs.getInt("roll_number"),
					rs.getString("student_name"),
					rs.getString("dob"),
					rs.getString("gender"),
					rs.getString("email"),
					rs.getString("phone_number"),
					rs.getString("address")														
					);
			
			list.add(s);
		}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			}
		return list;
		}
	public List<Students> getStudentByGender(String gender){
		List<Students> list =new ArrayList<Students>();
		
		Connection  c = getConnection();
		String query = "select * from students where gender = ? ";
		try {
			PreparedStatement ps = c.prepareStatement(query);
			
			ps.setString(1, gender);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Students s = new Students(					
						rs.getInt("roll_number"),
						rs.getString("student_name"),
						rs.getString("dob"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getString("address")														
						);
				
				list.add(s);
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	 
	
}
