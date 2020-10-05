package com.bridgelabz;
import java.util.*;
import java.util.stream.Collectors;
public class AddressBookPerson {
	private String bookName;
	//array list to store contacts
	private ArrayList<ContactDetails> bookList;
	private Map<String,String> CityPerson;
	private Map<String,String> StatePerson;

	public AddressBookPerson(String bookName) {
		this.CityPerson = new  HashMap<>();
		this.StatePerson = new HashMap<>();
		this.bookList = new ArrayList<>();
		this.bookName = bookName;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of person in address Book");
		int no = sc.nextInt();
		sc.nextLine();
		while(no>0) {
			
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
			boolean check=this.addNewContact(firstName, lastName,address, city, state, phoneNumber,zip, emailId);
		if (check)no--;
		else;
		}
		this.sortContactNames();
		this.sortByCity();
		this.sortByState();
}
	// function to add new contacts to the address book
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
			this.CityPerson.put(contactX.getCity(), contactX.getFirstName());
			this.StatePerson.put(contactX.getState(), contactX.getFirstName());
			return true;
		}
		
		private void sortContactNames() {
			List<ContactDetails> sortedNameList = this.bookList.stream().sorted((n1,n2)->n1.getFirstName().compareTo(n2.getFirstName())).collect(Collectors.toList());
			sortedNameList.stream().forEach(n->{
				System.out.println("Contact name is : "+n.getFirstName());
			});
		}
		private void sortByCity() {
			List<ContactDetails> sortedCityList = this.bookList.stream().sorted((n1,n2)->n1.getCity().compareTo(n2.getCity())).collect(Collectors.toList());
		}
		
		private void sortByState() {
			List<ContactDetails> sortedStateList = this.bookList.stream().sorted((n1,n2)->n1.getState().compareTo(n2.getState())).collect(Collectors.toList());
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

		public boolean search(String firstName) {
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
			return found;
		}
		public void findPersonByCity(String city) {
			boolean found =  false;
			for(Map.Entry m:CityPerson.entrySet()) {
				if(((String) m.getKey()).equalsIgnoreCase(city)) {
					System.out.println(m.getValue()+" also lives in city :"+city);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No person found living  in city : "+city+" in "+this.bookName+" address book");
			}
		}
		public void findPersonByState(String state) {
			boolean found =  false;
			for(Map.Entry m:StatePerson.entrySet()) {
				if(((String) m.getKey()).equalsIgnoreCase(state)) {
					System.out.println(m.getValue()+" also lives in state :"+state);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No person found living in state : "+state+" in "+this.bookName+" address book");
			}
		}
		//number_of_contact_person
		public void getNumberofContactPerson(String personName) {
			// first checking whether a person lives exist in the address book or not
			boolean check = this.search(personName);
			int count1 = 0, count2 = 0;
			if(check) {
				String personInSameCity = null;
				String personInSameState = null;
				for(Map.Entry m:StatePerson.entrySet()) {
					if(((String) m.getValue()).equalsIgnoreCase(personName)) {
						personInSameState = (String) m.getKey();
					}
				}
				for(Map.Entry m:CityPerson.entrySet()) {
					if(((String) m.getValue()).equalsIgnoreCase(personName)) {
						personInSameCity = (String) m.getKey();
					}
				}
				for(Map.Entry m:StatePerson.entrySet()) {
					if(((String) m.getKey()).equalsIgnoreCase(personInSameCity)) {
						count1++;
					}
					if(((String) m.getKey()).equalsIgnoreCase(personInSameState)) {
						count2++;
					}
				}
				System.out.println("Total number of people found in same state as "+personName+" is "+count2);
				System.out.println("Total number of people found in same city as "+personName+" is "+count1);
			}
					}
		
		// display welcome message
		public void displayMessage() {
			System.out.println("Welcome to Address Book");
		}
		
		
		
}
