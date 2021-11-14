package main;

import java.time.LocalDate;

public class Person {

	private String Name;
	private String Surname;
	private LocalDate Date_of_birth;
	private Address Address;
	private int Mobile_phone;
	private String Email;
	
	public Person(String name, String surname, LocalDate date_of_birth, Address adress, int mobile_phone, String email) {
		super();
		Name = name;
		Surname = surname;
		Date_of_birth = date_of_birth;
		Address = adress;
		Mobile_phone = mobile_phone;
		Email = email;
	}
	public Person() {
		super();
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public LocalDate getDate_of_birth() {
		return Date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		Date_of_birth = date_of_birth;
	}
	public String getAdress() {
		return Address.getStreet() + Address.getNumber() + Address.getCity() + Address.getState();
	}
	public void setAdress(Address address) {
		Address.setStreet(address.getStreet());
		Address.setNumber(address.getNumber());
		Address.setCity(address.getCity());
		Address.setState(address.getState());
	}
	public int getMobile_phone() {
		return Mobile_phone;
	}
	public void setMobile_phone(int mobile_phone) {
		Mobile_phone = mobile_phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
