package model;

public class Managemet {

	private int id;
	private int roll_number;
	private String course;
	private String department_name;
	private String admission_date;
	private String pass_out_date;
	private double marks;
	
	public Managemet() {}

	
	public Managemet(int id, int roll_number, String course, String department_name, String admission_date,
			String pass_out_date, double marks) {
		super();
		this.id = id;
		this.roll_number = roll_number;
		this.course = course;
		this.department_name = department_name;
		this.admission_date = admission_date;
		this.pass_out_date = pass_out_date;
		this.marks = marks;
	}


	 

	public Managemet(int roll_number, String course, String department_name, String admission_date,
			String pass_out_date, double marks) {
		super();
		this.roll_number = roll_number;
		this.course = course;
		this.department_name = department_name;
		this.admission_date = admission_date;
		this.pass_out_date = pass_out_date;
		this.marks = marks;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getAdmission_date() {
		return admission_date;
	}

	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}

	public String getPass_out_date() {
		return pass_out_date;
	}

	public void setPass_out_date(String pass_out_date) {
		this.pass_out_date = pass_out_date;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String toString() {
		return " id = " + id + "\n roll_number = " + roll_number + "\n course = " + course + "\n department_name = "
				+ department_name + "\n admission_date = " + admission_date + "\n pass_out_date = " + pass_out_date
				+ "\n marks = " + marks + "\n--------------------------------------";
	}

	
}
