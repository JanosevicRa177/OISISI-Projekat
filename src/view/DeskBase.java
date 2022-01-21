package view;

import java.util.ArrayList;
import java.util.List;

import Controller.ProfessorController;
import model.Desk;
import model.Professor;
import model.Subject;

public class DeskBase {

	private static DeskBase instance = null;
	public static DeskBase getInstance() {
		if (instance == null) {
			instance = new DeskBase();
		}
		return instance;
	}
	private List<Desk> desks;
	private List<String> colons;
	private DeskBase() {
		this.desks = new ArrayList<Desk>();
		this.colons = new ArrayList<String>();
		this.colons.add("DeskID");
		this.colons.add("Desk Name");
		this.colons.add("Boss");
	}
	public void addDesk(Desk desk) {
		desks.add(desk);
	}
	public Desk getAddress(int id) {
		return desks.get(id);
	}
	public boolean contains(int idProf) {
		for(Desk d : desks) {
			if(idProf == d.getDeskChief()) {
			return true;
			}
		}
		return false;
	}
	public int getAddressesLength() {
		return desks.size();
	}
	public List<Professor> findallneeded()
	{
		List<Professor> retList = new ArrayList();
		List<Professor> retList2 = new ArrayList();
		List<Professor> lp = ProfessorController.getInstance().DepartmentsBoss();
		for(Professor p : lp)
		{
			for(Desk d : desks)
			{
				if(p.getIDnumber() != d.getDeskChief())
				{
					retList.add(p);
				}
			}
		}
		for(Professor p : retList)
		{
			if(!retList2.contains(p))
				retList2.add(p);
		}
		return retList2;
	}
	public List<Desk> getDesks()
	{
		return desks;
	}
	public String getColumnName(int index) {
		return this.colons.get(index);
	}
}
