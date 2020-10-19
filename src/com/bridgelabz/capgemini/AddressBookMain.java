package com.bridgelabz.capgemini;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bridgelabz.capgemini.AddressBookPerson.IOAddressBookService;


public class AddressBookMain {
	private Map<String,AddressBookPerson> addressBookMap;
	public AddressBookMain() {
		addressBookMap = new HashMap<>();
		AddressBookList();
	}
	public void AddressBookList() {
		System.out.println("Enter number of Address Book");
		Scanner sc  = new Scanner(System.in);
		int no = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i<no ;i++) {
			System.out.println("Enter the name of your address book :");
			String addressBookName = sc.nextLine();
			addressBookMap.put(addressBookName,new AddressBookPerson(addressBookName));
		}
		
	}
	private void printFileData() {
		for(Map.Entry m : addressBookMap.entrySet()) {
			((AddressBookPerson) m.getValue()).printData(IOAddressBookService.FILE_IO);
		}
	}

	private void readFileDataAndCreateNewAddressBook() {
		for(Map.Entry m : addressBookMap.entrySet()) {
			((AddressBookPerson) m.getValue()).readAddressBookData(IOAddressBookService.FILE_IO);
		}
	}

	private void writeAddressBookDataIntoFile() {
		for(Map.Entry m : addressBookMap.entrySet()) {
			((AddressBookPerson) m.getValue()).writeAddressBookData(IOAddressBookService.FILE_IO);
		}
	}
	public void search() {
		System.out.println("Enter the first name of the person to be searched");
		Scanner sc = new Scanner(System.in);
		String firstName = sc.nextLine();
		for(Map.Entry m:addressBookMap.entrySet()) {
			System.out.println("Searching in "+m.getKey()+" address book :");
			((AddressBookPerson) m.getValue()).search(firstName);
		}
	}
	
	private void findPersonByState() {
		System.out.println("Enter the state to be searched :");
		Scanner sc = new Scanner(System.in);
		String state = sc.nextLine();
		for(Map.Entry m:addressBookMap.entrySet()) {
			System.out.println("Searching in "+m.getKey()+" address book :");
			((AddressBookPerson) m.getValue()).findPersonByState(state);
		}		
	}

	private void findPersonByCity() {
		System.out.println("Enter the city to be searched :");
		Scanner sc = new Scanner(System.in);
		String city = sc.nextLine();
		for(Map.Entry m:addressBookMap.entrySet()) {
			System.out.println("Searching in "+m.getKey()+" address book :");
			((AddressBookPerson) m.getValue()).findPersonByCity(city);
		}
	}
	private void NumberOfContactPerson() {
		System.out.println("Enter the first name of person who is looking for person with same city and state");
		Scanner sc = new Scanner(System.in);
		String personName = sc.nextLine();
		for(Map.Entry m:addressBookMap.entrySet()) {
			System.out.println("Searching in "+m.getKey()+" address book :");
			((AddressBookPerson) m.getValue()).getNumberofContactPerson(personName);
		}
	}
	
	public static void main(String[] args) {
		AddressBookMain obj =new AddressBookMain();
		obj.AddressBookList();
		obj.search();
		obj.findPersonByCity();
		obj.findPersonByState();
		obj.NumberOfContactPerson();
	}
}
