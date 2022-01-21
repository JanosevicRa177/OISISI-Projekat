package model;

import java.util.ArrayList;
import java.util.List;


public class Subject {
	
	private String iDSubject;
	private String subjectName;
	private KindOfSemester semesterKind;
	private int subjectYearExecution;
	private int professorOfSubject;
	private int eSPBvalue;
	private int iDIntSubject;
	private List<Integer> studentsWhoPassed;
	private List<Integer> studentsWhoDidntPass;
	
	public Subject() {
	}
	public Subject(String iDSubject, String subjectName, KindOfSemester semesterKind, int subjectYearExecution,
			 int eSPBvalue,int professorOfSubject,int iDIntSubject) {
		super();
		this.iDSubject = iDSubject;
		this.subjectName = subjectName;
		this.semesterKind = semesterKind;
		this.setiDIntSubject(iDIntSubject);
		this.professorOfSubject = professorOfSubject;

		this.subjectYearExecution = subjectYearExecution;
		//this.professorOfSubject = professorOfSubject;
		this.eSPBvalue = eSPBvalue;
		studentsWhoPassed = new ArrayList<Integer>();
		studentsWhoDidntPass = new ArrayList<Integer>();
	}
	
	public String getiDSubject() {
		return iDSubject;
	}
	public void removeProfessor() {
		professorOfSubject = 0;
	}
	public void setiDSubject(String iDSubject) {
		this.iDSubject = iDSubject;
	}
	public KindOfSemester getEnum(String s)
	{
		if(s.equals("Letnji"))return KindOfSemester.Summer;
		else return KindOfSemester.Winter;
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public KindOfSemester getSemesterkind() {
		return semesterKind;
	}

	public void setSemesterKind(KindOfSemester semesterKind) {
		this.semesterKind = semesterKind;
	}

	public int getsubjectYearExecution() {
		return subjectYearExecution;
	}

	public void setsubjectYearExecution(int subjectYearExecution) {
		this.subjectYearExecution = subjectYearExecution;
	}

	public int getProfessorOfSubject() {
		return professorOfSubject;
	}

	public void setProfessor_of_Subject(int professorOfSubject) {
		this.professorOfSubject = professorOfSubject;
	}

	public int getESPBvalue() {
		return eSPBvalue;
	}

	public void setESPBvalue(int eSPBvalue) {
		this.eSPBvalue = eSPBvalue;
	}
	public List<Integer> getStudentsWhoPassed() {
		return studentsWhoPassed;
	}
	public void addStudentsWhoPassed(int student) {
		studentsWhoPassed.add(student);
	}
	public void deleteStudentsWhoPassed(int student) {
		studentsWhoPassed.remove(student);
	}
	public List<Integer> getStudentsWhoDidntPass() {
		return studentsWhoDidntPass;
	}
	public void addStudentsWhoDidntPass(int student) {
		studentsWhoDidntPass.add(student);
	}
	public void deleteStudentsWhoDidntPass(int student) {
		studentsWhoDidntPass.remove(student);
	}
	public int getiDIntSubject() {
		return iDIntSubject;
	}
	public void setiDIntSubject(int iDIntSubject) {
		this.iDIntSubject = iDIntSubject;
	}
	
	
}
