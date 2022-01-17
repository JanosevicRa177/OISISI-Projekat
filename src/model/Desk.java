package model;

import java.util.ArrayList;
import java.util.List;

public class Desk {

	private String deskCode;
	private String deskName;
	private int deskChief;
	private List<Professor> professorsOnDesk;
	
	public Desk() {
		super();
	}
	
	public Desk(String deskCode, String deskName, int deskChief) {
		super();
		this.deskCode = deskCode;
		this.deskName = deskName;
		this.deskChief = deskChief;
		professorsOnDesk = new ArrayList<Professor>();
	}
	public void addProfessor(Professor professor) {
		professorsOnDesk.add(professor);
	}
	public void removeProfessor(Professor professor) {
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

	public List<Professor> getProfessorsOnDesk() {
		return professorsOnDesk;
	}

	public void setProfessorsOnDesk(List<Professor> professorsOnDesk) {
		this.professorsOnDesk = professorsOnDesk;
	}
}
