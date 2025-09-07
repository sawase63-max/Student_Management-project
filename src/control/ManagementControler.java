package control;

import java.util.List;
import java.util.Scanner;
import model.*;
import service.AdminService;
import service.StudentService;
import service.managementService;
public class ManagementControler {
	AdminControler ac = new AdminControler();
	StudentService ss =new StudentService();
	managementService ms = new managementService();
	
	Scanner sc = new Scanner(System.in);
	public ManagementControler() {
		
		AdminService as = new AdminService();
		 int atemp = 3 ;
			
			while(atemp > 0) {
				
				 boolean i = ac.verifiy(); 
						
					
				if(i == true) {
				System.out.println("<=====================================================================>");
				System.out.println("<                    -	ACCESS GRANTED  -                             >");
				System.out.println("<=====================================================================>");
				System.out.println();
				
				int choice3;
				
				do {
					System.out.println("---------------------------MANAGEMENT MENU-----------------------------");
					System.out.println("              1.  ADD STUDENT                                          ");
					System.out.println("              2.  UPDATE STUDENT NAME BY ROLL NO                       ");
					System.out.println("              3.  UPDATE STUDENT PHONE NUMBER BY ROLL NO AND NAME      ");
					System.out.println("              4.  DELETE STUDENT BY ROLL NUMBER                        ");
					System.out.println("              5.  SHOW STUDENT-COURSE DETAILS BY ROLL NUMBER           ");
					System.out.println("              6.  SHOW STUDENT-COURSE-MARKS                            ");
					System.out.println("              7.  SHOW TOP SCORE OF MARKS                              ");	
					System.out.println("              8.  SHOW ALL MANAGEMENT RECORD                           ");
					System.out.println("              9.  UPDATE MARKS BY ROLL NUMBER                          ");
					System.out.println("              10. UPDATE COURSE BY MANAGEMENT ID                       ");
					System.out.println("              11. ADD IN MANAGEMET                                     ");
					System.out.println("              12. DELETE MANAGEMENT_ID BY ROLL NO.                     ");				
					System.out.println("              13. UPDATE PASSWORD OF ADMIN BY USERNAME.                ");
					System.out.println("              14. UPDATE USERNAME OF ADMIN BY OLD NAME                 ");
					System.out.println("              15. FOR GO BACK TO USER MENU                             ");
					System.out.println("");
					System.out.println("              --  ENTER YOUR CHOICE  --                                ");
					choice3 = Integer.parseInt(sc.nextLine());
					
					
					switch(choice3) {
					case 1:{
					    System.out.println("----------------------ENTER NEW STUDENT NAME---------------------------");
						String student_name= sc.nextLine();
					System.out.println("----------------ENTER NEW STUDENT DATE OF BITH  YY/MM/DD-------------------");
						String dob= sc.nextLine();
						System.out.println("--------------------ENTER GENDER OF STUDENT----------------------------");
						String gender= sc.nextLine();
						System.out.println("--------------------------ENTER EMAIL----------------------------------");
						String email= sc.nextLine();
						System.out.println("----------------------ENTER PHONE NUMBER-------------------------------");
						String phone_number= sc.nextLine();
						System.out.println("----------------------ENTER ADDRESS OF STUDENT-------------------------");
						String address= sc.nextLine();
						System.out.println();
						System.out.println("-----------------------------------------------------------------------");
						
						
						ms.addStudent(new Students(student_name,dob,gender,email,phone_number,address));
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("");
						
						
						break;}
					
					case 2:{
						
						System.out.println("-----------------ENTER NEW NAME OF STUDENT FOR UPDATE-----------------");
						String student_name= sc.nextLine();
						System.out.println("--------------------ENTER STUDENT ROLL NUMBER-------------------------");
						try {
						int roll_number = Integer.parseInt(sc.nextLine());
						ms.updateStudentNameByRollno(student_name, roll_number);
						
						
						System.out.println("--------------------STUDENT NAME UPDATED SUCCESSFULLY-----------------");
						System.out.println();
						System.out.println();
						}catch(NumberFormatException e) {
							System.out.println();
							System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
							System.out.println("--------------------PLEASE TRY AGAIN-----------------------------");
							System.out.println();
							}
						
						break;}
					
					case 3:{
						try {
						System.out.println("-----------------ENTER ROLL NUMBER OF STUDENT FOR UPDATE--------------");
						int roll_number = Integer.parseInt(sc.nextLine());
						System.out.println("-----------------ENTER NEW NAME OF STUDENT FOR UPDATE-----------------");
						String student_name= sc.nextLine();
						System.out.println("-----------------ENTER NEW PHONE NUMBER FOR UPDATE--------------------");
						String phone_number= sc.nextLine();
						
						ms.updateNumder(phone_number, roll_number, student_name);
						}catch(NumberFormatException e) {
							System.out.println();
							System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
							System.out.println();
						}
						break;}
					
					case 4:{
						try {
							System.out.println("-----------------ENTER ROLL NUMBER OF STUDENT FOR UPDATE--------------");
							int roll_number = Integer.parseInt(sc.nextLine());
							
							ms.deletStudent(roll_number);
						}catch(NumberFormatException e) {
							System.out.println();
							System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
							System.out.println();
						}
						
						break;}
					
					case 5:{
						try {
							System.out.println("----------------ENTER ROLL NUMBER TO GET COURSE------------------");
							int roll_number = Integer.parseInt(sc.nextLine());
							
							ms.deletStudent(roll_number);
						String s=	ms.getStudentCourseByRoll(roll_number);
						
						System.out.println(s);
						}catch(NumberFormatException e) {
							System.out.println();
							System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
							System.out.println();
						}
						
						break;}
					
					case 6:{
						try {
							System.out.println("--------------------ENTER ROLL NUMBER-------------------------");
							System.out.println("-----------------SHOW STUDENT-COURSE-MARKS--------------------");
							int roll_number = Integer.parseInt(sc.nextLine());
							
							ms.deletStudent(roll_number);
						String s=	ms.getStudentCourseMarks(roll_number);
						
						System.out.println(s);
						}catch(NumberFormatException e) {
							System.out.println();
							System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
							System.out.println();
						}
						
						break;}
					
					case 7:{
						
						double d = ms.maxMarks();
						if(d == 0.0) {
							System.out.println("-----------------------NO MARKS THERE----------------------------");
						}
						else {
							System.out.println("-----------------------TOP SCORE OF MARKS IS---------------------");
							System.out.println(d);
							System.out.println("------------------------------------------------------------------");
							System.out.println();
						}
						break;}
					
					case 8:{
						
						List<Managemet> list=ms.getAllManagement();
						System.out.println("------------------------------------------------LIST OF MANAGEMENT------------------------------------------------------------------------------");
						
						for(Managemet m : list) {
							
							System.out.println(m);
						}
						
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

						break;}
					
					case 9:{
						try {
							System.out.println("-----------------ENTER ROLL NUMBER FOR UPDATE MARKS--------------");
							int roll_number = Integer.parseInt(sc.nextLine());
							System.out.println("-----------------ENTER NEW MAKRS OF STUDENT FOR UPDATE------------");
						   double makrs = Double.parseDouble(sc.nextLine());
							
							
							ms.updateMarks(makrs, roll_number);
							}catch(NumberFormatException e) {
								System.out.println();
								System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
								System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
								System.out.println();
							}
						catch(Exception e1) {
							System.out.println();
							System.out.println("----------------INPUT NUMBER VALUE ONLY--------------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
							System.out.println();
						}
						
					break;}
					
					case 10:{
						try {
							System.out.println("-----------------ENTER MANAGEMENT ID FOR UPDATE--------------");
							System.out.println("--------------------------COURSE-----------------------------");
							int id = Integer.parseInt(sc.nextLine());
							System.out.println("-----------------ENTER NEW COURSE FOR UPDATE-----------------");
							String course= sc.nextLine();
							
							
							ms.updateCourseByManagementID(course,id);
							System.out.println();
							System.out.println("---------------------------------------------------------------------");
							}catch(NumberFormatException e) {
								System.out.println();
								System.out.println("----------------INPUT NUMBER VALUE FOR ID--------------------------");
								System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
								System.out.println();
							}
						break;}
					
					case 11:{
						try {
							 System.out.println("----------------------ENTER NEW MANAGEMENT ROLL NUMBER--------------------");
								int roll = Integer.parseInt(sc.nextLine());
							System.out.println("-----------------------------ENTER NEW COURSE------------------------------");
								String course= sc.nextLine();
								System.out.println("--------------------ENTER NEW DEPARTMENT NAME----------------------------");
								String department= sc.nextLine();
								System.out.println("---------------------ENTER ADDMITION DATE YY/MM/DD-----------------------");
								String addmintion = sc.nextLine();
								System.out.println("---------------------ENTER PASS OUT DATE YY/MM/DD-----------------------");
								String pass= sc.nextLine();
								System.out.println("-------------------------------ENTER MARKS------------------------------");
								double marks = Double.parseDouble(sc.nextLine());
								System.out.println("-----------------------------------------------------------------------");
								
								
								ms.addNewManagement(new Managemet(roll,course,department,addmintion,pass,marks));
								System.out.println("-----------------------------------------------------------------------");

								System.out.println("");
							
						}catch(NumberFormatException e) {
							System.out.println("----------------INPUT NUMBER VALUE FOR ROLL NO.----------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
						}
						
						  break;}
					
					case 12:{
						try {
							 System.out.println("----------------------ENTER NEW MANAGEMENT ROLL NUMBER--------------------");
								int roll = Integer.parseInt(sc.nextLine());
							
							ms.deleteManagementById(roll);
								System.out.println("-----------------------------------------------------------------------");

								System.out.println("");
							
						}catch(NumberFormatException e) {
							System.out.println("----------------INPUT NUMBER VALUE FOR ROLL NO.----------------------");
							System.out.println("-------------------PLEASE TRY AGAIN------------------------------");
						}
						
						break;}
					
					case 13:{
						System.out.println("--------------------ENTER ADMINT USER NAME----------------------------");
						String username= sc.nextLine();
						System.out.println("---------------------ENTER NEW PASSWORD-----------------------");
						String password = sc.nextLine();
						
						ac.updatePassword(password, username);
						System.out.println();
						break;}
					
					case 14:{
						System.out.println("--------------------ENTER OLD ADMINT USER NAME----------------------------");
						String username= sc.nextLine();
						System.out.println("---------------------ENTER NEW USER NAME-----------------------");
						String username1 = sc.nextLine();
						
						ac.updateUsernameByUsername(username, username1);
						System.out.println();
						
						break;}
					case 15:{
						
						System.out.println("---------------------------------------------------------------------------");
						System.out.println("                       EXITING FROM ADMIN LOGIN ...........                ");
						System.out.println("---------------------------------------------------------------------------");
						System.out.println();
						System.out.println("---------------------------------------------------------------------------");
						System.out.println("                          BACK TO USER MENU ...........                    ");
						System.out.println("---------------------------------------------------------------------------");
						break;}
					
					default :{
					System.out.println("-----------------------INVALID CHOICE TYR AGAIN !--------------------------");

					}
					
					}
					
					
					
					
				}while(choice3 != 15);
				 
				
				
				
				
				break;
				}
				
				else {
				System.out.println("<=====================================================================>");
				System.out.println("<                    -	ACCESS DENIDE  -                              >");
				System.out.println("<             -  INCORRECT USERNAME/PASSWORD  -                       >");
				System.out.println("<                     -   TRY AGAIN !   -                             >");
				System.out.println("<=====================================================================>");
				System.out.println();
				
					atemp -- ;
					
					if(atemp == 0) {
				System.out.println();
				System.out.println("<             TO MANY FAILED ATEMPS EXIT ADMIN LOGIN.......     >");
				System.out.println();
				System.out.println();
				break;
					}
				}
				
				}

		 
	}
}
