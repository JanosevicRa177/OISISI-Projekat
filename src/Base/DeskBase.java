package Base;

import java.util.ArrayList;
import java.util.List;

import model.Desk;

public class DeskBase {

	private static DeskBase instance = null;
	public static DeskBase getInstance() {
		if (instance == null) {
			instance = new DeskBase();
		}
		return instance;
	}
	private List<Desk> desks;
	private DeskBase() {
		this.desks = new ArrayList<Desk>();
	}
	public void addDesk(Desk desk) {
		desks.add(desk);
	}
	public Desk getAddress(int id) {
		return desks.get(id);
	}
	public int getAddressesLength() {
		return desks.size();
	}
	public List<Desk> getDesks()
	{
		return desks;
	}
}
