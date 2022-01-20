package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import PassedSubjects.AbstractTableModelPassedSubjects;
import PassedSubjects.PassedSubjectTable;
import Professor.AbstractTableModelProfessors;
import Professor.ProfessorTable;
import UnpassedSubjects.AbstractTableModelUnpassedSubjects;
import UnpassedSubjects.UnpassedSubjectTable;
import view.MainFrame;

public class Student extends Person {
	

	private String indexNumber;
	private int entryYear;
	private int currentYear;
	private StudentStatus status;
	private double avgMark;
	private int idStudent;
	private List<Integer> passedSubjects;
	private List<Integer> unpassedSubjects;
	
	public Student(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email,int idStudent) {
		super(name, surname, dateOfBirth, address, mobilePhone, email);
	}
	public Student()
	{
		
	}
	public void passSubject(int subject) {
		int sub = unpassedSubjects.get(subject);
		unpassedSubjects.remove(subject);
		passedSubjects.add(sub);
		AbstractTableModelUnpassedSubjects model = (AbstractTableModelUnpassedSubjects) UnpassedSubjectTable.getInstance().getModel();
		model.fireTableRowsDeleted(subject, subject);
		MainFrame.getInstance().validate();
	}
	public void unpassSubject(int subject) {
		int sub = 0;
		int row = 0;
		for(int sub1 : passedSubjects) {
			if(subject == sub1) {
				sub = sub1;
				passedSubjects.remove(sub1);
				System.out.println("ulaz");
				break;
			}
			row++;
		}
		unpassedSubjects.add(sub);
		AbstractTableModelPassedSubjects model = (AbstractTableModelPassedSubjects) PassedSubjectTable.getInstance().getModel();
		model.fireTableRowsDeleted(row, row);
		MainFrame.getInstance().validate();
	}
	
	public Student(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, String indexNumber, int entryYear, int currentYear, StudentStatus status, double avgMark,int idStudent) {
		super(name, surname, dateOfBirth, address, mobilePhone, email);
		this.indexNumber = indexNumber;
		this.entryYear = entryYear;
		this.currentYear = currentYear;
		this.status = status;
		this.avgMark = avgMark;
		this.setIdStudent(idStudent);
		passedSubjects = new ArrayList<Integer>();
		unpassedSubjects = new ArrayList<Integer>();
	}
	
//	public Student(String name, String surname, LocalDate dateOfBirth, Address adress, int mobilePhone,
//			String email, String indexNumber, int entryYear, int currentYear, double avgMark) {
//		super(name, surname, dateOfBirth, adress, mobilePhone, email);
//		this.indexNumber = indexNumber;
//		this.entryYear = entryYear;
//		this.currentYear = currentYear;
//		this.status = STATUS.B;
//		this.avgMark = avgMark;
//		passedSubjects = new ArrayList<Mark>();
//		unpassedSubjects = new ArrayList<Subject>();
//	}
	



	public String getIndexNumber() {
		return indexNumber;
	}
	
	public StudentStatus getEnumByString(String s)
	{
		if(s.equals("Budzet"))return StudentStatus.B;
		else return StudentStatus.S;
		
	}
	public void addUnpassedSubject(int unpassedSubject) {
		unpassedSubjects.add(unpassedSubject);
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}


	public int getEntryYear() {
		return entryYear;
	}


	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}


	public int getCurrentYear() {
		return currentYear;
	}


	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}


	public StudentStatus getStatus() {
		return status;
	}


	public void setStatus(StudentStatus status) {
		this.status = status;
	}


	public double getAvgMark() {
		return avgMark;
	}


	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}


	public List<Integer> getPassedSubjects() {
		return passedSubjects;
	}


	public void setPassedSubjects(List<Integer> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}


	public List<Integer> getUnpassedSubjects() {
		return unpassedSubjects;
	}


	public void setUnpassedSubjects(List<Integer> unpassedSubjects) {
		this.unpassedSubjects = unpassedSubjects;
	}

	@Override
	public String toString() {
		return "Student [indexNumber=" + indexNumber + ", entryYear=" + entryYear + ", currentYear=" + currentYear
				+ ", status=" + status + ", avgMark=" + avgMark + ", passedSubjects=" + passedSubjects
				+ ", unpassedSubjects=" + unpassedSubjects + "]";
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	
	
	
	
	
	

}
