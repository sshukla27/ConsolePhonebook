package com.adi;

import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Contactt 
{
	
	public static String name;
	public static int mobileNo;
	public static String emailId;
	
	public static int password=0000;
	public static int userPw;
	public static char addmoreContact='y', moreOperations='y';
	public static int numberInput; public static String searchinput;
	
	Scanner sc=new Scanner(System.in);
	public static Contactt[] con=new Contactt[5];
	
	con[0]=con1;
	con[1]=con2;		
	con[2]=con3;
	con[3]=con4;
	con[4]=con5;
	
	public static void addContact()
	{
		int i;
		
		Scanner sc=new Scanner(System.in);
		if(addmoreContact=='y' || addmoreContact=='Y' && i<5) 
		{
			for( i=0;i<5;i++)
			{
				System.out.print("\n"+"Enter Mobile number : ");
				con[i].mobileNo= sc.nextInt();
				
				System.out.print("Contact Name : ");
				con[i].name= sc.next();

				System.out.print("Email : ");
				con[i].emailId= sc.next();

				System.out.println("Contact Added");
			}
			System.out.print("\n"+"Do you want to add more contacts?.. y/n :");
			addmoreContact=sc.next().charAt(0);
		}
	}
			
	public static void searchContact()
	{
	

		Scanner cc=new Scanner(System.in);
		System.out.println("Search Contact based on Name or Email: ");		
		String searchInput=cc.next();
	
		for(int i=0;i<5;i++)
		{
			if(name==searchInput || (emailId)==searchInput)
			{
			System.out.println(mobileNo+"\t"+name+"\t\t"+emailId);
				break;
			}
		}
		System.out.println(searchInput+" isn't available.");
	}
		
	
	
	public static void searchContactBymobileNo()
	{
		Scanner ac =new Scanner(System.in);
		System.out.println("Search Contact based on mobile number: ");		
		numberInput=ac.nextInt();

		
		for(int i=0;i<5;i++)
		{
			if(mobileNo==numberInput)
			{
				System.out.println(mobileNo+"\t"+name+"\t\t"+emailId);
				break;
			}
		}
		System.out.println(numberInput+" isn't available.");
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		
		
		Scanner sc=new Scanner(System.in);
		
		do
		{
			System.out.print("Enter Password to unlock mobile : ");
			userPw=sc.nextInt();
		}
		
		while(password!=userPw);
		
		
		while(moreOperations=='y' || moreOperations=='Y')
		{
			System.out.println("\t"+"Press 1 to ADD CONTACT"  + "\n"
					+"\t"+"Press 2 to EDIT CONTACT" + "\n"
					+"\t"+"Press 3 to DELETE CONTACT" + "\n"
					+"\t"+"Press 4 to SHOW ALL THE CONTACTS AND TOTAL OF CONTACT SAVED" + "\n"
					+"\t"+"Press 5 to SEARCH CONTACT BASED ON NAME, MOBILE,EMAIL" + "\n");
			
					int input = sc.nextInt();
					
					
					
					switch(input) 
					{
						case 1:
							
							addContact();
							
							break;
						
						
						case 2://Search Contact base on Name, Mobile or Email
							
							
							searchContact();
							searchContactBymobileNo();
							
						break;

						
						
						default:
							
							System.out.println("Choose correct option  ");
					
							
							
						case 4://To display all the contact details:
							
							System.out.println("Contact No."+"\t"+"Name"+"\t\t"+"Email Id");

							
							for(int i=0;i<5;i++)
							{
								
									System.out.println(mobileNo+"\t"+name+"\t\t"+emailId);
							}
						break;
						
					}//Switch case loop closed	
					System.out.println("Do you want to use further operations?..y/n : ");
					moreOperations=sc.next().charAt(0);
		
		}//while loop for more operations closed 
					
	}//main method closed
}//class closed
					
			
			
			
	
	
	

		

