package main;

import java.time.LocalDate;
import java.util.List;

public class Professor extends Person {
	private String Office_adress;
	private int ID_number;
	private String Title;
	private double Years_of_experience;
	List<Subject> Professors_subjects;
	public Professor() {
	}
	public Professor(String name, String surname, LocalDate date_of_birth, Address address, int mobile_phone,
			String email, String office_adress, int iD_number, String title, double years_of_experience,
			List<Subject> professors_subjects) {
		super(name, surname, date_of_birth, address, mobile_phone, email);
		Office_adress = office_adress;
		ID_number = iD_number;
		Title = title;
		Years_of_experience = years_of_experience;
		Professors_subjects = professors_subjects;
	}
	public String getOffice_adress() {
		return Office_adress;
	}
	public void setOffice_adress(String office_adress) {
		Office_adress = office_adress;
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
	public void setProfessors_subjects(List<Subject> professors_subjects) {
		Professors_subjects = professors_subjects;
	}

}
