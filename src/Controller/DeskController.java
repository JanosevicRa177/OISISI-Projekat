package Controller;

import java.util.List;

import Base.DeskBase;
import Base.StudentBase;
import model.Desk;
import model.Professor;
import model.Student;

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
	public String getColumnName(int index) {
		return DeskBase.getInstance().getColumnName(index);
  
	public boolean contains(int idProf) {
		return DeskBase.getInstance().contains(idProf);
	}
	public void addDesk(Desk desk) {
		DeskBase.getInstance().addDesk(desk);
	}
	public Desk getAddress(int id) {
		return DeskBase.getInstance().getAddress(id);
	}
	public Desk findSelectedDesk(int row) {
		return DeskBase.getInstance().getDesks().get(row);
	}
	public int getAddressesLength() {
		return DeskBase.getInstance().getAddressesLength();
	}
	public List<Professor> findallneeded()
	{
		return DeskBase.getInstance().findallneeded();
	}
	public List<Desk> getAllDesks()
	{
		return DeskBase.getInstance().getDesks();
	}
}
