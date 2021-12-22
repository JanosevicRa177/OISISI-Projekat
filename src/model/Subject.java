package model;

import java.util.ArrayList;
import java.util.List;

enum Kind_of_semester{Summer, Winter}

public class Subject {
	
	private int iDSubject;
	private String subjectName;
	private Kind_of_semester semesterKind;
	private int subjectYearExecution;
	private Professor professorOfSubject;
	private int eSPBvalue;
	private List<Student> studentsWhoPassed;
	private List<Student> studentsWhoDidntPass;
	
	public Subject() {
	}
	public Subject(int iDSubject, String subjectName, Kind_of_semester semesterKind, int subjectYearExecution,
			 int eSPBvalue) {
		super();
		this.iDSubject = iDSubject;
		this.subjectName = subjectName;
		this.semesterKind = semesterKind;

		this.subjectYearExecution = subjectYearExecution;
		//this.professorOfSubject = professorOfSubject;
		this.eSPBvalue = eSPBvalue;
		studentsWhoPassed = new ArrayList<Student>();
		studentsWhoDidntPass = new ArrayList<Student>();
	}
	
	public int getiDSubject() {
		return iDSubject;
	}
	
	public void setiDSubject(int iDSubject) {
		this.iDSubject = iDSubject;
	}
	public Kind_of_semester getEnum(String s)
	{
		if(s.equals("Letnji"))return Kind_of_semester.Summer;
		else return Kind_of_semester.Winter;
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Kind_of_semester getSemesterkind() {
		return semesterKind;
	}

	public void setSemesterKind(Kind_of_semester semesterKind) {
		this.semesterKind = semesterKind;
	}

	public int getsubjectYearExecution() {
		return subjectYearExecution;
	}

	public void setsubjectYearExecution(int subjectYearExecution) {
		this.subjectYearExecution = subjectYearExecution;
	}

	public Professor getProfessorOfSubject() {
		return professorOfSubject;
	}

	public void setProfessor_of_Subject(Professor professorOfSubject) {
		this.professorOfSubject = professorOfSubject;
	}

	public int getESPBvalue() {
		return eSPBvalue;
	}

	public void setESPBvalue(int eSPBvalue) {
		this.eSPBvalue = eSPBvalue;
	}
	public List<Student> getStudentsWhoPassed() {
		return studentsWhoPassed;
	}
	public void addStudentsWhoPassed(Student student) {
		studentsWhoPassed.add(student);
	}
	public void deleteStudentsWhoPassed(Student student) {
		studentsWhoPassed.remove(student);
	}
	public List<Student> getStudentsWhoDidntPass() {
		return studentsWhoDidntPass;
	}
	public void addStudentsWhoDidntPass(Student student) {
		studentsWhoDidntPass.add(student);
	}
	public void deleteStudentsWhoDidntPass(Student student) {
		studentsWhoDidntPass.remove(student);
	}
	
	
}
