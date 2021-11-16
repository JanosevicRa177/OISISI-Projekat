package main;

import java.util.List;

public class Desk {

	private int DeskCode;
	private String DeskName;
	private Professor DeskChief;
	private List<Professor> ProfessorsOnDesk;
	
	public Desk() {
		super();
	}
	
	public Desk(int deskCode, String deskName, Professor deskChief, List<Professor> professorsOnDesk) {
		super();
		DeskCode = deskCode;
		DeskName = deskName;
		DeskChief = deskChief;
		ProfessorsOnDesk = professorsOnDesk;
		ProfessorsOnDesk.add(deskChief);
	}

	public int getDeskCode() {
		return DeskCode;
	}

	public void setDeskCode(int deskCode) {
		DeskCode = deskCode;
	}

	public String getDeskName() {
		return DeskName;
	}

	public void setDeskName(String deskName) {
		DeskName = deskName;
	}

	public Professor getDeskChief() {
		return DeskChief;
	}

	public void setDeskChief(Professor deskChief) {
		DeskChief = deskChief;
	}

	public List<Professor> getProfessorsOnDesk() {
		return ProfessorsOnDesk;
	}

	public void setProfessorsOnDesk(List<Professor> professorsOnDesk) {
		ProfessorsOnDesk = professorsOnDesk;
	}
	
	
	
	
	
}
