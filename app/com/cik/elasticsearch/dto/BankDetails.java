package com.cik.elasticsearch.dto;

public class BankDetails {
	@Override
	public String toString() {
		return "BankDetails [account_Number=" + account_number + ", balance="
				+ balance + ", firstName=" + firstname + ", lastName="
				+ lastname + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", employer=" + employer
				+ ", email=" + email + ", city=" + city + ", state=" + state
				+ "]";
	}
	String account_number;
	String balance;
	String firstname;
	String lastname;
	String age;
	String gender;
	String address;
	String employer;
	String email;
	String city;
	String state;

	public String getBalance() {
		return balance;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
