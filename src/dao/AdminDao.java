package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
	
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
	
	public boolean verification(String username , String password) {
		Connection c = getConnection();
			String query = "select * from admin where username = ? and password = ?";
			boolean verify = false;
			try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
					verify = true;
				
			}
			
			
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return verify;
	}
	
	public void updatePassword(String password,String username) {
		
		
		Connection c = getConnection();
		String query = "update admin set password =? where username =?";
		
		
		
		try {
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, password);
		ps.setString(2, username);
		int update = ps.executeUpdate();
		if (update > 0) {
			System.out.println("--------------------PASSWORD CHANGED SUCCESSFULLY----------------");
		} else {
			System.out.println("----------------ADMIN USERNAME NOT FOUND----------------------");
			System.out.println();
			System.out.println("---------------------ACCESS DENIDE----------------------------");
			
		}
		
		
		}catch(SQLException e) {
			System.out.println("-------------------USER NAME NOT FOUND--------------------");
			System.out.println("----------------------ACCESS DENIDE-----------------------");
		}
	}
	
	
	public void updateUsernameByUsername(String username, String username1) {
		

		Connection c = getConnection();
		String query = "update admin set username =? where username =?";
		
		
		
		try {
		PreparedStatement ps = c.prepareStatement(query);
	
		
		ps.setString(1, username1);
		ps.setString(2, username);
		int update = ps.executeUpdate();
		if (update > 0) {
			System.out.println("--------------USER NAME CHANGED SUCCESSFULLY------------------");
		} else {
			System.out.println("----------------ADMIN USERNAME NOT FOUND----------------------");
			System.out.println();
			System.out.println("---------------------ACCESS DENIDE----------------------------");
			
		}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------ACCESS DENIDE-----------------------");
		}
		
	}
}
