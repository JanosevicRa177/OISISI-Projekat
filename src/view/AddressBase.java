package view;

import java.util.ArrayList;
import java.util.List;

import model.Address;

public class AddressBase {

private static AddressBase instance = null;
	
	public static AddressBase getInstance() {
		if (instance == null) {
			instance = new AddressBase();
		}
		return instance;
	}
	private List<Address> addresses;
	private AddressBase() {
		this.addresses = new ArrayList<Address>();
	}
	public void addAddress(Address address) {
		if(!addresses.contains(address))
		addresses.add(address);
	}
	public Address getAddress(int id) {
		return addresses.get(id);
	}
	public List<Address> getListAddress() {
		return addresses;
	}
	public int getAddressesLength() {
		return addresses.size();
	}
}
