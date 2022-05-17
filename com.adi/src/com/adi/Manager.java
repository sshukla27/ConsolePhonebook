package com.adi;

import java.util.Scanner;

public class Manager {

	public static void addContact(Contact[] con, Scanner sc, int count)	
	{
				con[count] = new Contact();
				System.out.print("\n" + "Enter Mobile number : ");
				con[count].setMobileNo(sc.nextLong());

				System.out.print("Contact Name : ");
				con[count].setName(sc.next()); 
				
				System.out.print("Email : ");
				con[count].setEmailId(sc.next());

				System.out.println("Contact Added");
	}

	public static int searchContact(Contact[] con, Scanner sc, int count) {
		int location = -1;
		System.out.print("Search Contact by 1 Name 2 Email 3 Mobile : ");
		int choice = sc.nextInt();
		System.out.print("Enter Search Term : ");
		String searchInput = sc.next();

		for (int i = 0; i < count; i++) {
			if (choice == 1 && con[i].getName().equals(searchInput)) {
				System.out.println(con[i].getMobileNo() + "\t" + con[i].getName() + "\t\t" + con[i].getEmailId());
				location = i;
				break;
			}
			if (choice == 2 && con[i].getEmailId().equals(searchInput)) {
				System.out.println(con[i].getMobileNo() + "\t" + con[i].getName() + "\t\t" + con[i].getEmailId());
				location = i;
				break;
			}
			if (choice == 3 && con[i].getMobileNo() == Long.valueOf(searchInput)) {
				System.out.println(con[i].getMobileNo() + "\t" + con[i].getName() + "\t\t" + con[i].getEmailId());
				location = i;
				break;
			}			
		}
		if(location == -1)
			{
			System.out.println(searchInput + " isn't available.");
			}
		return location;
	}
	
	public static void editContact(Contact[] con, Scanner sc, int count)
	{
		int position = searchContact(con, sc, count);
		if(position != -1) 
		{	
			System.out.print("\n" + "Enter Mobile number : ");
			con[position].setMobileNo(sc.nextLong());

			System.out.print("Contact Name : ");
			con[position].setName(sc.next()); 
			
			System.out.print("Email : ");
			con[position].setEmailId(sc.next());

			System.out.println("Contact Updated");
		}
	}
	public static boolean deleteContact(Contact[] con, Scanner sc, int count)
	{
		boolean status = false;
		int position = searchContact(con, sc, count);
		if(position != -1) 
		{		
			// case 1 - single contact 
			if(count == 1)
			{
				con[position].setMobileNo(0);			
				con[position].setName(""); 
				con[position].setEmailId("");
			}			
			else // case count > 1 
			{
				// deleting contact at lower index when contact(s) are available at higher index
				for(int i = position; i < count-1; i++)
				{					
					con[i]= con[i+1]; // object copied into object
				}	
				con[count]=null;
			}
			System.out.println("Contact Deleted");
			status = true;
		}
		return status;
	}

	public static void showAllContacts(Contact[] con, int count) {
		System.out.println("Contact No." + "\t" + "Name" + "\t\t" + "Email Id");
		if(count == 0)
		{
			System.out.println("\n\n\t There are no contacts available!");	
		}
		else
		{
			for (int i = 0; i < count; i++) {
				System.out.println(con[i].getMobileNo() + "\t" + con[i].getName() + "\t\t" + con[i].getEmailId());
			}	
		}		
	}

	public static void main(String[] args) {
		char moreOperations = 'y';
		int count=0;
		Scanner sc = new Scanner(System.in);
		Contact[] con = new Contact[5];
		int password = 0000, userPw;
		
		do {
			System.out.print("Enter Password to unlock mobile : ");
			userPw = sc.nextInt();
		} while (password != userPw);

		while (moreOperations == 'y' || moreOperations == 'Y') {
			System.out.println("\t" + "Press 1 to ADD CONTACT" + "\n" + "\t" + "Press 2 to EDIT CONTACT" + "\n" + "\t"
					+ "Press 3 to DELETE CONTACT" + "\n" + "\t"
					+ "Press 4 to SHOW ALL THE CONTACTS AND TOTAL OF CONTACT SAVED" + "\n" + "\t"
					+ "Press 5 to SEARCH CONTACT BASED ON NAME, MOBILE,EMAIL" + "\n");

			int input = sc.nextInt();

			switch (input) {
			case 1:
				addContact(con, sc, count);
				count++;
				break;

			case 2:// edit Contact
				editContact(con, sc, count);	
				break;
			case 3:
				if(deleteContact(con, sc, count))
					{
					count--;					
					}
				break;
			case 4:// To display all the contact details:
				showAllContacts(con, count);				
				break;
			case 5:// Search
				searchContact(con,sc,count);				
				break;
			default:
				System.out.println("Choose correct option  ");
			}
			System.out.println("Do you want to use further operations?..y/n : ");
			moreOperations = sc.next().charAt(0);

		} // while loop for more operations closed
		sc.close();
	}
}