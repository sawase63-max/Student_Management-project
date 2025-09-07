package control;

import java.util.List;
import java.util.Scanner;

import model.Students;
import service.AdminService;
import service.StudentService;

public class StudentControler {
	
	public  StudentControler() {
		Scanner sc = new Scanner(System.in);
		
		StudentService ss = new StudentService();
		AdminService as = new AdminService();
		
		System.out.println("<=====================================================================>");
		System.out.println("<                [            WELCOME              ]                  >");
		System.out.println("<                [              TO                 ]                  >");
		System.out.println("<                [    STUDENT MANAGEMENT SYSTEM    ]                  >");
		System.out.println("<=====================================================================>");
		

		
			
		
		
		
		
		
		
		
		
		
		while(true) {

		System.out.println("<=====================================================================>");
		System.out.println("<              -  WOULD LIKE TO SEE THE MENU ? -                      >");
		System.out.println("<             -            YES/NO              -                      >");
		System.out.println("<=====================================================================>");	
			
		String choice1 = sc.nextLine();
		
		switch (choice1) {
		case "yes","YES": {
			
			try {
			int choice2;
			do {
				
				
		System.out.println("------------------------------USER MENU-------------------------------");
		System.out.println("                         1. GET ALL STUDENTS                           ");
		System.out.println("                         2. GET STUDENT BY ROLL NO.                    ");
		System.out.println("                         3. GET STUDENT BY ADDRESS                     ");
		System.out.println("                         4. GET STUDENT BY GENDER                      ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("                         YOU HAVE TO LOGIN FIRST                       ");
		System.out.println("            ENTER - 5.       -- TO GET --                              ");
		System.out.println("                          -- MANAGEMENT MENU --                        ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("                         6. FOR GO BACK TO HOME PAGE                   ");

		System.out.println();
		System.out.println("--------------------------PLEASE ENTER YOU CHOICE----------------------");
		
		 choice2 = Integer.parseInt(sc.nextLine());
				
		 switch(choice2) {
		 
		 case 1:{ 
			List<Students>list = ss.getAllStudents();
			System.out.println("------------------------------------------------LIST OF ALL STUDENTS------------------------------------------------------------------------------");
			
			
			if(list.isEmpty()) {
				System.out.println("---------------------EMPTY-----------------------");
			}
			
			else {
				
				for (Students s : list) {
				    String rollNo     = String.format("%-10s", s.getRoll_number());
				    String name       = String.format("%-20s", s.getStudent_name());
				    String dob        = String.format("%-10s", s.getDob());
				    String gender     = String.format("%-6s", s.getGender());
				    String email      = String.format("%-24s", s.getEmail());
				    String phone      = String.format("%-12s", s.getPhone_number());
				    String address    = s.getAddress();

				    System.out.println(rollNo + " | " + name + " | " + dob + " | " + gender + " | " + email + " | " + phone + " | " + address);
				}

			}
			
			System.out.println("---------------------------------------------------------------------------------------------");

			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

			 break;}
		
		 
		 case 2:{ 
				System.out.println("------------------------------------------------ENTER ROLL NUMBER OF STUDENT------------------------------------------------------------------");

			 int roll_number = Integer.parseInt(sc.nextLine());
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

			 List<Students> list= ss.getStudentByRoll(roll_number);
			 
			 if(list.isEmpty()) {
				 System.out.println("-----DATA WITH THIS ROLL NUMBER NOT FOUND------");
				 System.out.println();
			 }
			 else {
			 for(Students s: list) {
				 System.out.println(s);
			 }
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			 }
			 break ;}
		 
		 
		 case 3:{  
			 
			 System.out.println("------------------------------------------------ENTER ADDRESS OF STUDENT----------------------------------------------------------------------");

			 String address = sc.nextLine();
			 System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

			 List<Students> list= ss.getStudentByAddress(address);
			 
			 for(Students s: list) {
				 System.out.println(s);
			 }
			 System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			 
			 
			 break;}
		 
		 
		 case 4:{   
			 System.out.println("------------------------ENTER GENDER OF STUDENT---------------------------------------------------------------");
			 String gender = sc.nextLine();
			 System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

			 List<Students> list= ss.getStudentByGender(gender);
			 
			 for(Students s: list) {
				 System.out.println(s);
			 }
			 System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			 
			 
			 
			 break;}
		 
		 
		 case 5:{
			 ManagementControler mc =new ManagementControler(); 
			 
			 continue;}
		 
		 case 6 :{ break;}
		 default : {
			 System.out.println("-----------------------INVALID CHOICE TYR AGAIN !--------------------------");
			 continue;
		 }
		 }
		 
			}while(choice2 != 6);
					
			
			}catch(NumberFormatException e) {
				System.out.println("---------------------NUMBER ME INPUT DE BHAI----------------------------");
				System.out.println();
			}
			
			
			
			
			break;
		}
		
		case "no","NO" :{
			System.out.println("<=====================================================================>");
			System.out.println("<               .......THANKYOU FOR VISITING.......                   >");
			System.out.println("<=====================================================================>");
			return;
		}
		default:
			System.out.println("---------------INVALID CHOICE....PLEASE TRY AGAIN !-------------------");
		}
		}
		
	}
	
}
