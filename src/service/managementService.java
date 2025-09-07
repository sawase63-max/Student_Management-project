package service;

import java.util.List;

import dao.ManagementDao;
import model.Managemet;
import model.Students;

public class managementService {

	ManagementDao md = new ManagementDao();
	public void addStudent(Students s) {
		md.addStudent(s);
	}
	
	public void updateStudentNameByRollno(String Student_name,int roll_number) {
		md.updateStudentNameByRollno(Student_name, roll_number);
	}
	
	public void updateNumder(String phone_number ,int roll_number , String Student_name) {
		md.updateNumder(phone_number, roll_number, Student_name);
	}
	
	public void deletStudent(int roll_number) {
		md.deleteStudent(roll_number);
	}
	public String getStudentCourseByRoll(int roll_number) {
		
		return md.getStudentCourseByRoll(roll_number);
	}
	public String getStudentCourseMarks(int roll_number) {
		
		return md.getStudentCourseMarks(roll_number);
	}
	public double maxMarks() {
		return md.maxMarks();
	}
	public List<Managemet> getAllManagement(){
		return md.getAllManagement();
	}
	
	public void updateMarks(double marks , int roll_number) {
		md.updateMarks(marks, roll_number);
	}
	
	public void updateCourseByManagementID(String course ,int id) {
		md.updateCourseByManagementID(course ,id);
	}
	
	public void addNewManagement(Managemet m){
		md.addNewManagement(m);
	}
	
	public void deleteManagementById(int id) {
		md.deleteManagementById(id);
	}
}
