package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Base.ProfessorBase;
import Controller.StudentController;
import Controller.SubjectController;

public class Professor extends Person {
	private Address officeAddress;
	private int iDnumber;
	private String title;
	private int experienceYears;
	private int idProf;
	List<Subject> professorsSubjects;
	public Professor() {
	}
	public Professor(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, Address officeAddress, int iDnumber, String title, int experienceYears,int idProf) {
		super(name, surname, dateOfBirth, address, mobilePhone, email);
		this.officeAddress = officeAddress;
		this.iDnumber = iDnumber;
		this.title = title;
		this.experienceYears = experienceYears;
		this.setIdProf(idProf);
		professorsSubjects = new ArrayList<Subject>();
	}
	
	public String getOfficeAddress() {
		return officeAddress.getStreet() + "," + officeAddress.getNumber() + "," + officeAddress.getCity() + "," + officeAddress.getState();
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
	public List<Subject> getProfessorsSubjects()
	{
		List<Integer> retList = new ArrayList();
		List<Subject> retList2 = new ArrayList();
		List<Subject> forRet = SubjectController.getInstance().getAllSubjects();
		for(Subject s : forRet)
		{
			if(!professorsSubjects.contains(s))
				retList2.add(s);
		}
		return retList2;
	}
	public int getYears_of_experience() {
		return experienceYears;
	}
	public void setYears_of_experience(int experienceYears) {
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
	public int getIdProfByName(String name)
	{
		return ProfessorBase.getInstance().getProfIdByName(name);
	}
	public int getIdProf() {
		return idProf;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}

}
