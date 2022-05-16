package com.adi;

import java.util.Scanner;

public class Manager {

	static int password = 0000;
	static int userPw;
	static String searchinput;

	public static void addContact(Contact[] con, Scanner sc) {
		char addmoreContact = 'y';
		if (addmoreContact == 'y' || addmoreContact == 'Y') {
			// fix this - at a time we will be adding single contact and not all at once,
			// update this
			for (int i = 0; i < 5; i++) {
				System.out.print("\n" + "Enter Mobile number : ");
				con[i].mobileNo = sc.nextInt();

				System.out.print("Contact Name : ");
				con[i].name = sc.next();

				System.out.print("Email : ");
				con[i].emailId = sc.next();

				System.out.println("Contact Added");
			}
			System.out.print("\n" + "Do you want to add more contacts?.. y/n :");
			addmoreContact = sc.next().charAt(0);
		}
	}

	public static void searchContact(Contact[] con, Scanner sc) {
		System.out.println("Search Contact based on Name or Email: ");
		String searchInput = sc.next();

		for (int i = 0; i < 5; i++) {
			// fix this - what is name emailId?
			if (name == searchInput || (emailId) == searchInput) {
				// fix this - way to access fields in class is incorrect
				System.out.println(mobileNo + "\t" + name + "\t\t" + emailId);
				break;
			}
		}
		System.out.println(searchInput + " isn't available.");
	}

	public static void searchContactBymobileNo(Contact[] con, Scanner sc) {
		int numberInput;
		Scanner ac = new Scanner(System.in);
		System.out.println("Search Contact based on mobile number: ");
		numberInput = ac.nextInt();

		for (int i = 0; i < 5; i++) {
			// fix this - what is name mobileNo?
			if (mobileNo == numberInput) {
				// fix this - way to access fields in class is incorrect
				System.out.println(mobileNo + "\t" + name + "\t\t" + emailId);
				break;
			}
		}
		System.out.println(numberInput + " isn't available.");
	}

	public static void showAllContacts(Contact[] con) {
		System.out.println("Contact No." + "\t" + "Name" + "\t\t" + "Email Id");
		for (int i = 0; i < 5; i++) {
			System.out.println(con[i].getMobileNo() + "\t" + con[i].getName() + "\t\t" + con[i].getEmailId());
		}
	}

	public static void main(String[] args) {
		char moreOperations = 'y';
		Scanner sc = new Scanner(System.in);
		Contact[] con = new Contact[5];

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
				addContact(con, sc);
				break;

			case 2:// Search Contact base on Name, Mobile or Email
				searchContact(con, sc);
				searchContactBymobileNo(con, sc);
				break;
			case 3:
				break;
			case 4:// To display all the contact details:
				showAllContacts(con);
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