package Controller;

import java.util.List;

import model.Address;
import view.AddressBase;

public class AddressController {

	private static AddressController instance = null;
	
	public static AddressController getInstance() {
		if (instance == null) {
			instance = new AddressController();
		}
		return instance;
	}
	private AddressController() {
		// TODO Auto-generated constructor stub
	}
	public void addAddress(Address address) {
		AddressBase.getInstance().addAddress(address);
	}
	public Address getAddress(int id) {
		return AddressBase.getInstance().getAddress(id);
	}
	public int getAddressesLength() {
		return AddressBase.getInstance().getAddressesLength();
	}
	public List<Address> getAddrList() {
		return AddressBase.getInstance().getListAddress();
	}
}
