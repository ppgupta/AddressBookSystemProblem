package com.bridgelabz;
import java.util.Collections;
import java.util.*;
public class AdressBookMainClass {
	private Map<String,AddressBookPerson> addressBookMap;
	public AdressBookMainClass() {
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
	public void search() {
		System.out.println("Enter the first name of the person to be searched");
		Scanner sc = new Scanner(System.in);
		String firstName = sc.nextLine();
		for(Map.Entry m:addressBookMap.entrySet()) {
			System.out.println("Searching in "+m.getKey()+" address book :");
			((AddressBookPerson) m.getValue()).search(firstName);
		}
	}
	
	public static void main(String[] args) {
		AdressBookMainClass obj =new AdressBookMainClass();
		obj.AddressBookList();
		obj.search();
	}
	
}
