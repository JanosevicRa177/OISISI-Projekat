package Base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import Professor.AbstractTableModelProfessors;
import Professor.ProfessorTable;
import model.Address;
import model.Professor;
import view.MainFrame;



public class ProfessorBase {

	private static ProfessorBase instance = null;
	
	public static ProfessorBase getInstance() {
		if (instance == null) {
			instance = new ProfessorBase();
		}
		return instance;
	}
	private List<Professor> professors;
	private List<Professor> professorsNotVisible;
	private List<Professor> professorsVisible;
	private List<String> colons;
	
	private ProfessorBase() {
		this.professors = new ArrayList<Professor>();
		this.professorsNotVisible = new ArrayList<Professor>();
		this.professorsVisible = new ArrayList<Professor>();
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
	public void sortByID() {
		Collections.sort(professors, new Comparator<Professor>() {
			  @Override
			  public int compare(Professor pr1,Professor pr2) {
			    return pr1.getIdProf() - pr2.getIdProf();
			  }
			});
	}
	
	public int getID(){
		int id = 1;
		Iterator<Professor> it = professors.iterator();
		while(it.hasNext()) {
			if(it.next().getIdProf() != id) {
				break;
			}
			id++;
		}
		return id;
	}
	public void searchProfessor(String search) {
		AbstractTableModelProfessors model = (AbstractTableModelProfessors) ProfessorTable.getInstance().getModel();
		Iterator<Professor> it2 = professorsNotVisible.iterator();
		int row = 0;
		Professor prof;
		while(it2.hasNext()) {
			prof = it2.next();
			professors.add(prof);
			model.fireTableRowsInserted(professors.size()-1, professors.size()-1);
		}
		sortByID();
		professorsVisible = new ArrayList<Professor>();
		professorsNotVisible = new ArrayList<Professor>();
		if(search.matches("[A-Za-z0-9ŠĆĐŽČšćžđč]+")) {
			Iterator<Professor> it1 = professors.iterator();
			row = 0;
			while(it1.hasNext()) {
				prof = it1.next();
				if(prof.getSurname().toLowerCase().matches(".*"+search.toLowerCase()+".*")) {
					professorsVisible.add(prof);
				} else {
					professorsNotVisible.add(prof);
					model.fireTableRowsDeleted(row, row);
				}
				row++;
			}
			professors = professorsVisible;
		}else if(search.matches("[A-Za-z0-9ŠĆĐŽČšćžđč]+( )[A-Za-z0-9ŠĆĐŽČšćžđč]+")) {
			String[] search1 = search.split(" ");
			Iterator<Professor> it1 = professors.iterator();
			row = 0;
			while(it1.hasNext()) {
				prof = it1.next();
				if(prof.getSurname().toLowerCase().matches(".*"+search1[0].toLowerCase()+".*") &&
						prof.getName().toLowerCase().matches(".*"+search1[1].toLowerCase()+".*")) {
					professorsVisible.add(prof);
				} else {
					professorsNotVisible.add(prof);
					model.fireTableRowsDeleted(row, row);
				}
				row++;
			}
			professors = professorsVisible;
		}
		model.fireTableDataChanged();
		MainFrame.getInstance().validate();
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
		Iterator<Professor> it1 = professors.iterator();
		while(it1.hasNext()) {
			if( it1.next().getIDnumber() == id) {
				it1.remove();
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
