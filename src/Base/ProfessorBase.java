package Base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.Professor;



public class ProfessorBase {

	private static ProfessorBase instance = null;
	
	public static ProfessorBase getInstance() {
		if (instance == null) {
			instance = new ProfessorBase();
		}
		return instance;
	}
	private List<Professor> professors;
	private List<String> colons;
	
	private ProfessorBase() {
		this.professors = new ArrayList<Professor>();
		this.colons = new ArrayList<String>();
		this.colons.add("Name");
		this.colons.add("Surname");
		this.colons.add("Title");
		this.colons.add("Email");

	}
	public boolean contains(int ID) {
		for(Professor pr : professors) {
			if(pr.getIDnumber() == ID) {
				return true;
			}
		}
		return false;
	}
	public boolean containsUpdate(int ID,int oldID) {
		if(ID == oldID) {
			return false;
		}
		for(Professor pr : professors) {
			if(pr.getIDnumber() == ID) {
				return true;
			}
		}
		return false;
	}
	public int getColumnCount() {
		return 4;
	}
	public int getRowCount() {
		return professors.size();
	}

	public List<Professor> getProfessors() {
		return professors;
	}
	
	public String getColumnName(int index) {
		return this.colons.get(index);
	}
	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}
	public List<Professor> getProfList()
	{
		return professors;
	}
	
	public String getValueAt(int row, int column) {
		if (row >= professors.size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			default:
				return null;
			}
		
		} else {
			Professor professor = this.professors.get(row);
			switch (column) {
			case 0:
				return professor.getName();
			case 1:
				return professor.getSurname();
			case 2:
				return professor.getTitle();
			case 3:
				return professor.getEmail();
			default:
				return null;
			}
		}
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	
	public void addProfessor(Professor professor) {
		professors.add(professor);
	}

	public void deleteProfessor(long id) {
		for (Professor professor : professors) {
			if (professor.getIDnumber() == id) {
				professors.remove(professor);
				break;
			}
		}
	}

	public void changeProfessor(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, Address officeAddress, int iDnumber, String title, int experienceYears,int oldID) {
		for (Professor professor : professors) {
			if (professor.getIDnumber() == oldID) {
				professor.setName(name);
				professor.setSurname(surname);
				professor.setDate_of_birth(dateOfBirth);
				professor.setAddress(address);
				professor.setMobile_phone(mobilePhone);
				professor.setEmail(email);
				professor.setOfficeAddress(officeAddress);
				professor.setIDnumber(iDnumber);
				professor.setTitle(title);
				professor.setYears_of_experience(experienceYears);
			}
		}
	}
	
}
