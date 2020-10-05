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
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i<n ;i++) {
			System.out.println("Enter the name of your address book :");
			String addressBookName = sc.nextLine();
			addressBookMap.put(addressBookName,new AddressBookPerson(addressBookName));
		}
		
	}
	public static void main(String[] args) {
		AdressBookMainClass obj =new AdressBookMainClass();
		obj.AddressBookList();
		
	}
	
}
