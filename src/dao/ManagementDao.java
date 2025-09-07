package dao;

import java.sql.Connection;
import model.Managemet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Students;

public class ManagementDao {

	private static String url = "jdbc:mysql://localhost:3306/student_management";
	private static String username = "root";
	private static String password = "Sunil@@@0071";

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void addStudent(Students s) {
		Connection c = getConnection();

		String query = "insert into students(student_name,dob,gender,email,phone_number,address) values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = c.prepareStatement(query);

			ps.setString(1, s.getStudent_name());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getGender());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getPhone_number());
			ps.setString(6, s.getAddress());

			ps.executeUpdate();
			System.out.println("--------------------NEW STUDENT ADDED SUCCESSFULLY--------------------");
		} catch (SQLException e) {
			System.out.println("------------------------NEW STUDENT NOT ADDED-------------------------");
			System.out.println();
			System.out.println("-----------PLEASE ENTER VALID DATE FORMAT YY/MM/DD---------------");
		}
	}

	public void updateStudentNameByRollno(String Student_name, int roll_number) {
		Connection c = getConnection();

		String query = "update students set Student_name =? where roll_number = ? ";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, Student_name);
			ps.setInt(2, roll_number);

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void updateNumder(String phone_number, int roll_number, String Student_name) {
		Connection c = getConnection();

		String query = "update students set phone_number = ? where roll_number = ? and Student_name = ? ";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, phone_number);
			ps.setInt(2, roll_number);
			ps.setString(3, Student_name);

			int effect = ps.executeUpdate();
			if (effect > 0) {
				System.out.println("--------------------NEW NUMBER ADDED SUCCESSFULLY--------------------");
			} else {
				System.out.println("-----------------------STUDENT NOT FOUND-------------------------");
				System.out.println();
				System.out.println("------------------WITH THIS ROLL NUMBER AND NAME-----------------");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void deleteStudent(int roll_number) {
		Connection c = getConnection();

		String query = "delete student where roll_number = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);

			ps.setInt(1, roll_number);
			int effect = ps.executeUpdate();
			if (effect == 0) {
				System.out.println("-----------------------STUDENT NOT FOUND-------------------------");
				System.out.println();
				System.out.println("----------------------WITH THIS ROLL NUMBER------------------------");
			} else {
				System.out.println("--------------------STUDENT REMOVED SUCCESSFULLY--------------------");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getStudentCourseByRoll(int roll_number) {

		Connection c = getConnection();
		String query = "select s.roll_number, s.student_name, m.course " + "from students s "
				+ "join management m on s.roll_number = m.roll_number " + "where s.roll_number = ?";

		try {

			PreparedStatement ps = c.prepareStatement(query);

			ps.setInt(1, roll_number);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int roll = rs.getInt("roll_number");
				String student_name = rs.getString("student_name");
				String course = rs.getString("course");

				return "ROLL NUMBER: " + roll + " \nSTUDENT NAME: " + student_name + " \nCOURSE: " + course;
			} else {
				return "---------------------NO DATA FOUND------------------";
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "---------------------NO DATA FOUND------------------";
	}

	public String getStudentCourseMarks(int roll_number) {

		Connection c = getConnection();

		String query = "select s.roll_number,s.student_name,m.course,m.marks from students s inner join management m on s.roll_number = m.roll_number where s.roll_number =?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, roll_number);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int number = rs.getInt("roll_number");
				String name = rs.getString("student_name");
				String c1 = rs.getString("course");
				double mrk = rs.getDouble("marks");

				return "ROLL NUMBER : " + number + "\n NAME : " + name + "\n COURSE : " + c1 + "\n MARKS : " + mrk;
			}

			else {
				return "---------------------NO DATA FOUND------------------";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "---------------------NO DATA FOUND------------------";
	}

	public double maxMarks() {

		Connection c = getConnection();

		String query = "select max(marks) as max_marks from management";

		try {
			PreparedStatement ps = c.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				double mek = rs.getDouble("max_marks");

				return mek;
			} else {
				return 0.0;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0.0;
	}
	
	public List<Managemet> getAllManagement(){
		List <Managemet> list = new ArrayList<Managemet>();
		
		Connection c = getConnection();
		String query  = "select * from management";
		
		try {
		PreparedStatement ps = c.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Managemet m = new Managemet(
					rs.getInt("id"),
					rs.getInt("roll_number"),
					rs.getString("course"),
					rs.getString("department_name"),
					rs.getString("admission_date"),
					rs.getString("pass_out_date"),
					rs.getDouble("marks")
					);
			list.add(m);
		}
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public void updateMarks(double marks , int roll_number) {
		Connection c = getConnection();
		
	String query = "update management set marks =? where roll_number =?";
	
	try {
	PreparedStatement ps = c.prepareStatement(query);
	ps.setDouble(1, marks);
	ps.setInt(2, roll_number);
	
	int update = ps.executeUpdate();
	if (update > 0) {
		System.out.println("-----------------NEW MARKS UPDATED SUCCESSFULLY------------------");
	} else {
		System.out.println("-----------------------MARKS NOT FOUND---------------------------");
		System.out.println();
		System.out.println("---------------------WITH THIS ROLL NUMBER-----------------------");
	}
	
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
		
	}
	
	public void updateCourseByManagementID(String course ,int id) {
		
		Connection  c= getConnection();
		String query = "update management set course =? where id =?";
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1,course );
			ps.setInt(2, id);
			
			int update = ps.executeUpdate();
			if (update > 0) {
				System.out.println("-----------------COURSE UPDATED SUCCESSFULLY------------------");
			} else {
				System.out.println("-----------------------COURSE NOT FOUND-----------------------");
				System.out.println();
				System.out.println("---------------------WITH THIS MANAGEMENT ID------------------");
			}
			
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		
	}
	
	public void addNewManagement(Managemet m) {
		Connection c = getConnection();
		String query = "insert into management(roll_number,course,department_name,admission_date,pass_out_date,marks) values(?,?,?,?,?,?)";
		
		try {
		PreparedStatement ps = c.prepareStatement(query);
		
		ps.setInt(1, m.getRoll_number());
		ps.setString(2, m.getCourse());
		ps.setString(3, m.getDepartment_name());
		ps.setString(4, m.getAdmission_date());
		ps.setString(5, m.getPass_out_date());
		ps.setDouble(6, m.getMarks());

	
		ps.executeUpdate();
		System.out.println("--------------------NEW DETAILS ADDED SUCCESSFULLY--------------------");
	} catch (SQLException e) {
		System.out.println("------------------------ERROR------------------------------------------");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
	}
			
	}
	
	public void deleteManagementById(int id) {
		Connection c = getConnection();
		
		String query = "delete from management where id = ?";
				
		try {
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		int update = ps.executeUpdate();
		if (update > 0) {
			System.out.println("--------------------DELETED SUCCESSFULLY-------------------------");
		} else {
			System.out.println("-----------------------ID NOT FOUND------------------------------");
			System.out.println();
			System.out.println("---------------------WITH THIS ID----------------------------");
		}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
