package service;

import java.sql.Connection;
import java.util.List;
import dao.StudentDao;
import model.Students;

public class StudentService {
	static StudentDao sd = new StudentDao();

	public List<Students> getAllStudents() {
		try {
			return sd.getAllStudents();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return List.of();
	}

	public List<Students> getStudentByRoll(int roll_number) {
		try {
			return sd.getStudentByRoll(roll_number);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return List.of();
	}

	public List<Students> getStudentByAddress(String address) {
		try {
			return sd.getStudentByAddress(address);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return List.of();
	}

	public List<Students> getStudentByGender(String gender) {
		try {
			return sd.getStudentByGender(gender);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
