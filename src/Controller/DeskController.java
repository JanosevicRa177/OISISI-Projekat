package Controller;

import java.util.List;

import Base.DeskBase;
import model.Desk;

public class DeskController {

	private static DeskController instance = null;
	
	public static DeskController getInstance() {
		if (instance == null) {
			instance = new DeskController();
		}
		return instance;
	}
	private DeskController() {
		// TODO Auto-generated constructor stub
	}
	public void addDesk(Desk desk) {
		DeskBase.getInstance().addDesk(desk);
	}
	public Desk getAddress(int id) {
		return DeskBase.getInstance().getAddress(id);
	}
	public int getAddressesLength() {
		return DeskBase.getInstance().getAddressesLength();
	}
	public List<Desk> getAllDesks()
	{
		return DeskBase.getInstance().getDesks();
	}
}
