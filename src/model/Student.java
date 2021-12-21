package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum STATUS {B,S}
public class Student extends Person {
	

	private String indexNumber;
	private int entryYear;
	private int currentYear;
	private STATUS status;
	private double avgMark;
	private List<Mark> passedSubjects;
	private List<Subject> unpassedSubjects;
	
	public Student(String name, String surname, LocalDate dateOfBirth, Address adress, int mobilePhone,
			String email) {
		super(name, surname, dateOfBirth, adress, mobilePhone, email);
	}
	
	public Student(String name, String surname, LocalDate dateOfBirth, Address adress, int mobilePhone,
			String email, String indexNumber, int entryYear, int currentYear, STATUS status, double avgMark) {
		super(name, surname, dateOfBirth, adress, mobilePhone, email);
		this.indexNumber = indexNumber;
		this.entryYear = entryYear;
		this.currentYear = currentYear;
		this.status = status;
		this.avgMark = avgMark;
		passedSubjects = new ArrayList<Mark>();
		unpassedSubjects = new ArrayList<Subject>();
	}


	public String getIndexNumber() {
		return indexNumber;
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


	public STATUS getStatus() {
		return status;
	}


	public void setStatus(STATUS status) {
		this.status = status;
	}


	public double getAvgMark() {
		return avgMark;
	}


	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}


	public List<Mark> getPassedSubjects() {
		return passedSubjects;
	}


	public void setPassedSubjects(List<Mark> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}


	public List<Subject> getUnpassedSubjects() {
		return unpassedSubjects;
	}


	public void setUnpassedSubjects(List<Subject> unpassedSubjects) {
		this.unpassedSubjects = unpassedSubjects;
	}

	@Override
	public String toString() {
		return "Student [indexNumber=" + indexNumber + ", entryYear=" + entryYear + ", currentYear=" + currentYear
				+ ", status=" + status + ", avgMark=" + avgMark + ", passedSubjects=" + passedSubjects
				+ ", unpassedSubjects=" + unpassedSubjects + "]";
	}
	
	
	
	
	
	
	

}
