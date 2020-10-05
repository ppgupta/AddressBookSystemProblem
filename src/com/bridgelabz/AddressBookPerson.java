package com.bridgelabz;
import java.util.*;
public class AddressBookPerson {
	private String bookName;
	//arraylist to store contacts
	private ArrayList<ContactDetails> bookList;

	public AddressBookPerson(String bookName) {
		this.bookList = new ArrayList<>();
		this.bookName = bookName;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of person in address Book");
		int no = sc.nextInt();
		sc.nextLine();
		while(no>0) {
			no--;
			System.out.println("Enter First Name :");
			String firstName = sc.nextLine();
			System.out.println("Enter Last Name :");
			String lastName = sc.nextLine();
			System.out.println("Enter the Address :");
			String address = sc.nextLine();
			System.out.println("Enter the City :");
			String city = sc.nextLine();
			System.out.println("Enter the State :");
			String state = sc.nextLine();
			System.out.println("Enter your Phone Number :");
			int phoneNumber = sc.nextInt();
			System.out.println("Enter your Zip code :");
			int zip = sc.nextInt();
			System.out.println("Enter your Email Address :");
			String emailId = sc.nextLine();
			this.addNewContact(firstName, lastName,address, city, state, phoneNumber,zip, emailId);
		}
}
	// function to add new contacts to the addressbook
		public boolean addNewContact(String firstName, String lastName,String address, String city, String state, int phoneNumber,
				int zip,
				String emailId) {
			ContactDetails contactX = new ContactDetails(firstName, lastName,address, city, state,zip, phoneNumber, emailId);
			for(int i = 0 ; i<bookList.size();i++) {
				if(this.bookList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
					System.out.println("Contact with this name already exists");
					return false;
				}
			}
			this.bookList.add(contactX);
			System.out.println("Contact added successfully:");
			return true;
		}
		//change details of given person
		public void changeDetails() {
			System.out.println("Enter the First Name of person whose details are to be changed :");
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			for (int i = 0; i < this.bookList.size(); i++) {
				if (this.bookList.get(i).getFirstName().equalsIgnoreCase(name)) {
					System.out.println("Enter Last name  :");
					this.bookList.get(i).setLastName(sc.nextLine()); 
					System.out.println("Enter Address  :");
                    this.bookList.get(i).setAddress(sc.nextLine());
					System.out.println("Enter new city :");
					this.bookList.get(i).setCity(sc.nextLine()); 
					System.out.println("Enter new State :");
					this.bookList.get(i).setState(sc.nextLine()); 
					System.out.println("Enter new Phone Number :");
					this.bookList.get(i).setMobNum(sc.nextInt()); ;
					System.out.println("Enter new EmailId :");
					this.bookList.get(i).setEmail(sc.nextLine());
					System.out.println("Changes made successfully");
					return;
				}
			}
			System.out.println(" Record not found for this person");
		}
		//delete contact of given person
		public void deleteContact() {
			System.out.println("Enter the First Name of person whose entry is to be deleted :");
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			for (int i = 0; i < this.bookList.size(); i++) {
				if (this.bookList.get(i).getFirstName().equalsIgnoreCase(name)) {
					this.bookList.remove(this.bookList.get(i));
					System.out.println("Deleted  successfully");
					return;
				}
			}
			System.out.println("No record found for this person");

		}
		// search person by name

		public void search(String firstName) {
			boolean found =  false;
			for(int i = 0; i<this.bookList.size();i++) {
				if(this.bookList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
					System.out.println(firstName+" lives in city :"+this.bookList.get(i).getCity()+" and state :"+this.bookList.get(i).getState());
					found = true;
				}
			}
			if(!found) {
				System.out.println("No record found for "+firstName+" in "+this.bookName+" address book");
			}
			
		}
		// display welcome message
		public void displayMessage() {
			System.out.println("Welcome to Address Book");
		}
		
		
		
}
