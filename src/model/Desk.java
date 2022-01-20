package model;

import java.util.ArrayList;
import java.util.List;

public class Desk {

	private String deskCode;
	private String deskName;
	private int deskChief;
	private List<Integer> professorsOnDesk;
	private int idDesk;
	
	public Desk() {
		super();
	}
	
	public Desk(String deskCode, String deskName, int deskChief, int idDesk) {
		super();
		this.deskCode = deskCode;
		this.deskName = deskName;
		this.deskChief = deskChief;
		this.setIdDesk(idDesk);
		professorsOnDesk = new ArrayList<Integer>();
	}
	public void addProfessor(int professor) {
		professorsOnDesk.add(professor);
	}
	public void removeProfessor(int professor) {
		professorsOnDesk.remove(professor);
	}
	public String getDeskCode() {
		return deskCode;
	}

	public void setDeskCode(String deskCode) {
		this.deskCode = deskCode;
	}

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public int getDeskChief() {
		return deskChief;
	}

	public void setDeskChief(int deskChief) {
		this.deskChief = deskChief;
	}

	public List<Integer> getProfessorsOnDesk() {
		return professorsOnDesk;
	}

	public void setProfessorsOnDesk(List<Integer> professorsOnDesk) {
		this.professorsOnDesk = professorsOnDesk;
	}

	public int getIdDesk() {
		return idDesk;
	}

	public void setIdDesk(int idDesk) {
		this.idDesk = idDesk;
	}
}
