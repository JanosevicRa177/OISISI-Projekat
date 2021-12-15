package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Person {
	private Address officeAddress;
	private int iDnumber;
	private String title;
	private double experienceYears;
	List<Subject> professorsSubjects;
	public Professor() {
	}
	public Professor(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, Address officeAddress, int iDnumber, String title, double experienceYears) {
		super(name, surname, dateOfBirth, address, mobilePhone, email);
		this.officeAddress = officeAddress;
		this.iDnumber = iDnumber;
		this.title = title;
		this.experienceYears = experienceYears;
		professorsSubjects = new ArrayList<Subject>();
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public int getIDnumber() {
		return iDnumber;
	}
	public void setIDnumber(int iDnumber) {
		this.iDnumber = iDnumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getYears_of_experience() {
		return experienceYears;
	}
	public void setYears_of_experience(double experienceYears) {
		this.experienceYears = experienceYears;
	}
	public List<Subject> getProfessors_subjects() {
		return professorsSubjects;
	}
	public void add_Professors_subject(Subject subject) {
		professorsSubjects.add(subject);
	}
	public void delete_Professors_subject(Subject subject) {
		professorsSubjects.remove(subject);
	}

}
