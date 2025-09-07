package model;

public class Admin {

	private int id;
	private String usernmae;
	private String password;
	public Admin(int id, String usernmae, String password) {
		super();
		this.id = id;
		this.usernmae = usernmae;
		this.password = password;
	}
	public Admin() {
		super();
		
	}
	public Admin(String usernmae, String password) {
		super();
		this.usernmae = usernmae;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsernmae() {
		return usernmae;
	}
	public void setUsernmae(String usernmae) {
		this.usernmae = usernmae;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", usernmae=" + usernmae + ", password=" + password + "]";
	}

	
}
