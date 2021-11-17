package main;

import java.time.LocalDate;
import java.util.List;

public class Professor extends Person {
	private Address Office_address;
	private int ID_number;
	private String Title;
	private double Years_of_experience;
	List<Subject> Professors_subjects;
	public Professor() {
	}
	public Professor(String name, String surname, LocalDate date_of_birth, Address address, int mobile_phone,
			String email, Address office_address, int iD_number, String title, double years_of_experience,
			List<Subject> professors_subjects) {
		super(name, surname, date_of_birth, address, mobile_phone, email);
		Office_address = office_address;
		ID_number = iD_number;
		Title = title;
		Years_of_experience = years_of_experience;
		Professors_subjects = professors_subjects;
	}
	public Address getOffice_address() {
		return Office_address;
	}
	public void setOffice_address(Address office_address) {
		Office_address = office_address;
	}
	public int getID_number() {
		return ID_number;
	}
	public void setID_number(int iD_number) {
		ID_number = iD_number;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public double getYears_of_experience() {
		return Years_of_experience;
	}
	public void setYears_of_experience(double years_of_experience) {
		Years_of_experience = years_of_experience;
	}
	public List<Subject> getProfessors_subjects() {
		return Professors_subjects;
	}
	public void add_Professors_subject(Subject professors_subjects) {
		Professors_subjects.add(professors_subjects);
	}
	public void delete_Professors_subject(Subject professors_subjects) {
		Professors_subjects.remove(professors_subjects);
	}

}
