package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



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
		Professor professor1 = new Professor("mirko","mirkovic",LocalDate.of(2017, 1, 13),
				new Address("ulica","5","beograd","srbija"),060,"nekiMail@gmail.com",
				new Address("ulica","5","beograd","srbija"),568, "nastavnik",56);
		Professor professor2 = new Professor("mirko","mirkovic",LocalDate.of(2017, 1, 13),
				new Address("ulica","5","beograd","srbija"),060,"nekiMail@gmail.com",
				new Address("ulica","5","beograd","srbija"),567, "nastavnik",56);
		Professor professor3 = new Professor("mirko","mirkovic",LocalDate.of(2017, 1, 13),
				new Address("ulica","5","beograd","srbija"),060,"nekiMail@gmail.com",
				new Address("ulica","5","beograd","srbija"),569, "nastavnik",56);
		professors.add(professor1);
		professors.add(professor2);
		professors.add(professor3);
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
			String email, Address officeAddress, int iDnumber, String title, int experienceYears) {
		for (Professor professor : professors) {
			if (professor.getIDnumber() == iDnumber) {
				professor.setName(name);
				professor.setSurname(surname);
				professor.setDate_of_birth(dateOfBirth);
				professor.setAdress(officeAddress);
				professor.setMobile_phone(iDnumber);
				professor.setEmail(email);
				professor.setAdress(officeAddress);
				professor.setTitle(title);
				professor.setYears_of_experience(experienceYears);
				professor.setOfficeAddress(officeAddress);
			}
		}
	}
	
}
