package model;

public class Students {

	private int roll_number ;
	private String student_name ;
	private String dob ;
	private String gender ;
	private String email ;
	private String phone_number ;
	private String address ;
	
	public Students() {
		
	}

	public Students(int roll_number, String student_name, String dob, String gender, String email, String phone_number,
			String address) {
		super();
		this.roll_number = roll_number;
		this.student_name = student_name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}  

	public Students(String student_name, String dob, String gender, String email, String phone_number, String address) {
		super();
		this.student_name = student_name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}

	

	public int getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [roll_number =" + roll_number + ", student_name=" + student_name + ", dob=" + dob + ", gender="
				+ gender + ", email=" + email + ", phone_number=" + phone_number + ", address=" + address + "]";
	}
	
	 
}
