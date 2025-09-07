package control;

import java.util.Scanner;

import service.AdminService;

public class AdminControler {
	Scanner sc = new Scanner(System.in);
	AdminService as = new AdminService();
	
	public boolean verifiy() {
	System.out.println("<=====================================================================>");
	System.out.println("<                  --  ENTER ADMIN'S USER NAME --                     >");
	System.out.println("<=====================================================================>");
			String name = sc.nextLine();
	System.out.println("<=====================================================================>");
	System.out.println("<                  --  ENTER ADMIN PASSWORD --                        >");
	System.out.println("<=====================================================================>");		
			String password = sc.nextLine();
			
			boolean i = as.verification(name, password);
			return i ;
	}
	
	public void updatePassword(String password,String username) {
		as.updatePassword(password, username);
	}
	public void updateUsernameByUsername(String username,String username1) {
		as.updateUsernameByUsername(username,username1);
	}
}
