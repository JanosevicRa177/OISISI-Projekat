package main;

import java.time.LocalDate;
import java.util.List;

enum STATUS {B,S}
public class Student extends Person {
	

	private String IndexNumber;
	private int EntryYear;
	private int CurrentYear;
	private STATUS Status;
	private double AvgMark;
	private List<Mark> PassedSubjects;
	private List<Subject>UnpassedSubjects;
	
	public Student(String name, String surname, LocalDate date_of_birth, main.Address adress, int mobile_phone,
			String email) {
		super(name, surname, date_of_birth, adress, mobile_phone, email);
	}
	
	
	public Student(String name, String surname, LocalDate date_of_birth, main.Address adress, int mobile_phone,
			String email, String indexNumber, int entryYear, int currentYear, STATUS status, double avgMark,
			List<Mark> passedSubjects, List<Subject> unpassedSubjects) {
		super(name, surname, date_of_birth, adress, mobile_phone, email);
		IndexNumber = indexNumber;
		EntryYear = entryYear;
		CurrentYear = currentYear;
		Status = status;
		AvgMark = avgMark;
		PassedSubjects = passedSubjects;
		UnpassedSubjects = unpassedSubjects;
	}


	public String getIndexNumber() {
		return IndexNumber;
	}


	public void setIndexNumber(String indexNumber) {
		IndexNumber = indexNumber;
	}


	public int getEntryYear() {
		return EntryYear;
	}


	public void setEntryYear(int entryYear) {
		EntryYear = entryYear;
	}


	public int getCurrentYear() {
		return CurrentYear;
	}


	public void setCurrentYear(int currentYear) {
		CurrentYear = currentYear;
	}


	public STATUS getStatus() {
		return Status;
	}


	public void setStatus(STATUS status) {
		Status = status;
	}


	public double getAvgMark() {
		return AvgMark;
	}


	public void setAvgMark(double avgMark) {
		AvgMark = avgMark;
	}


	public List<Mark> getPassedSubjects() {
		return PassedSubjects;
	}


	public void setPassedSubjects(List<Mark> passedSubjects) {
		PassedSubjects = passedSubjects;
	}


	public List<Subject> getUnpassedSubjects() {
		return UnpassedSubjects;
	}


	public void setUnpassedSubjects(List<Subject> unpassedSubjects) {
		UnpassedSubjects = unpassedSubjects;
	}
	
	
	
	
	
	
	

}
