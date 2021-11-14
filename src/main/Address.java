package main;

public class Address {

	private String street;
	private int Number;
	private String City;
	private String State;
	
	public Address() {
	}
	public Address(String street, int number, String city, String state) {
		super();
		this.street = street;
		Number = number;
		City = city;
		State = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	
}
