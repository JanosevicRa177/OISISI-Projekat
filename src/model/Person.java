package model;

import java.time.LocalDate;

public class Person {

	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private Address address;
	private int mobilePhone;
	private String email;
	
	public Person(String name, String surname, LocalDate date_of_birth, Address address, int mobile_phone, String email) {
		super();
		this.name = name;
		this.surname = surname;
		dateOfBirth = date_of_birth;
		this.address = address;
		mobilePhone = mobile_phone;
		this.email = email;
	}
	public Person() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getDate_of_birth() {
		return dateOfBirth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		dateOfBirth = date_of_birth;
	}
	public String getAddress() {
		return address.getStreet() + "," + address.getNumber() + "," + address.getCity() + "," + address.getState();
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getMobile_phone() {
		return mobilePhone;
	}
	public void setMobile_phone(int mobile_phone) {
		mobilePhone = mobile_phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
