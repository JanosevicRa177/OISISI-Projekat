package model;

import java.util.List;

public class Desk {

	private int deskCode;
	private String deskName;
	private Professor deskChief;
	private List<Professor> professorsOnDesk;
	
	public Desk() {
		super();
	}
	
	public Desk(int deskCode, String deskName, Professor deskChief, List<Professor> professorsOnDesk) {
		super();
		this.deskCode = deskCode;
		this.deskName = deskName;
		this.deskChief = deskChief;
		this.professorsOnDesk = professorsOnDesk;
		professorsOnDesk.add(deskChief);
	}

	public int getDeskCode() {
		return deskCode;
	}

	public void setDeskCode(int deskCode) {
		this.deskCode = deskCode;
	}

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public Professor getDeskChief() {
		return deskChief;
	}

	public void setDeskChief(Professor deskChief) {
		this.deskChief = deskChief;
	}

	public List<Professor> getProfessorsOnDesk() {
		return professorsOnDesk;
	}

	public void setProfessorsOnDesk(List<Professor> professorsOnDesk) {
		this.professorsOnDesk = professorsOnDesk;
	}
	
	
	
	
	
}
