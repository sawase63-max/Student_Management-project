package service;
import dao.AdminDao;
public class AdminService {
	
		AdminDao ad= new AdminDao();
		
	public boolean verification(String username , String password) {
		
		
		return ad.verification(username, password);
		
	}
	
	public void updatePassword(String password,String username) {
		ad.updatePassword(password, username);
	}
	
	public void updateUsernameByUsername(String username,String username1) {
		ad.updateUsernameByUsername(username,username1);
	}
}
