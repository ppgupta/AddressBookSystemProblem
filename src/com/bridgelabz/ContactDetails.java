package com.bridgelabz;

public class ContactDetails {
	
		private String firstName;
		private String LastName;
		private String address;
		private String city;
		private String state;
		private int zip;
		private int phoneNum;
		private String email;
		public ContactDetails(String FN,String LN,String address,String city,String state,int zip,
				int phone,String mail) {
			this.firstName=FN;
			this.LastName=LN;
			this.address=address;
			this.city=city;
			this.state=state;
			this.zip=zip;
			this.phoneNum=phone;
			this.email=mail;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getFirstName() {
			return firstName;
		}
		
		public void setLastName(String lastName) {
			this.LastName = lastName;
		}
		public String getLastName() {
			return LastName;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}

		public String getAddress() {
			return address;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getCity() {
			return city;
		}
		public void setState(String state) {
			this.state = state;
		}
		
		public String getState() {
			return state;
		}
		
		public void setZip(int zip) {
			this.zip = zip;
		}

		public int getZip() {
			return zip;
		}
		
		public void setMobNum(int mobNum) {
			this.phoneNum = mobNum;
		}
				public int getMobNum() {
			return phoneNum;
		}
		
		public void setEmail(String email) {
					this.email = email;
		}

		public String getEmail() {
			return email;
		}
				
	
}
