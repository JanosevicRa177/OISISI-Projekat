package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	

	private String indexNumber;
	private int entryYear;
	private int currentYear;
	private StudentStatus status;
	private double avgMark;
	private List<Integer> passedSubjects;
	private List<Integer> unpassedSubjects;
	
	public Student(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email) {
		super(name, surname, dateOfBirth, address, mobilePhone, email);
	}
	public Student()
	{
		
	}
	
	
	public Student(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, String indexNumber, int entryYear, int currentYear, StudentStatus status, double avgMark) {
		super(name, surname, dateOfBirth, address, mobilePhone, email);
		this.indexNumber = indexNumber;
		this.entryYear = entryYear;
		this.currentYear = currentYear;
		this.status = status;
		this.avgMark = avgMark;
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
	
	
	
	
	
	
	

}
