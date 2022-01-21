package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.StudentController;
import Controller.SubjectController;
import Controller.MarkController;
import view.AbstractTableModelPassedSubjects;
import view.AbstractTableModelProfessors;
import view.AbstractTableModelStudents;
import view.AbstractTableModelUnpassedSubjects;
import view.MainFrame;
import view.PassedSubjectTable;
import view.ProfessorTable;
import view.StudentBase;
import view.StudentTable;
import view.StudentUpdateDialog;
import view.UnpassedSubjectTable;

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
		StudentBase.getInstance().calculateAvgGrade();
		AbstractTableModelUnpassedSubjects model1 = (AbstractTableModelUnpassedSubjects) UnpassedSubjectTable.getInstance().getModel();
		model1.fireTableRowsDeleted(UnpassedSubjectTable.getInstance().getSelectedRow(), UnpassedSubjectTable.getInstance().getSelectedRow());
		AbstractTableModelPassedSubjects model2 = (AbstractTableModelPassedSubjects) PassedSubjectTable.getInstance().getModel();
		model2.fireTableRowsInserted(UnpassedSubjectTable.getInstance().getSelectedRow()+1, UnpassedSubjectTable.getInstance().getSelectedRow()+1);
		AbstractTableModelStudents model = (AbstractTableModelStudents)StudentTable.getInstance().getModel();
		model.fireTableRowsUpdated(StudentTable.getInstance().getSelectedIndex(),StudentTable.getInstance().getSelectedIndex());
		MainFrame.getInstance().validate();
	}
	public void unpassSubject(int subject) {
		int sub = passedSubjects.get(subject);
		passedSubjects.remove(subject);
		unpassedSubjects.add(sub);
		StudentBase.getInstance().calculateAvgGrade();
		int studentNum = StudentTable.getInstance().getSelectedRow();
		int studentID = StudentBase.getInstance().getAllStudents().get(studentNum).getIdStudent();
		MarkController.getInstance().removeMark(studentID,sub);
		AbstractTableModelUnpassedSubjects model1 = (AbstractTableModelUnpassedSubjects) UnpassedSubjectTable.getInstance().getModel();
		model1.fireTableRowsInserted(UnpassedSubjectTable.getInstance().getSelectedRow()+1, UnpassedSubjectTable.getInstance().getSelectedRow()+1);
		AbstractTableModelPassedSubjects model2 = (AbstractTableModelPassedSubjects) PassedSubjectTable.getInstance().getModel();
		model2.fireTableRowsDeleted(UnpassedSubjectTable.getInstance().getSelectedRow(), UnpassedSubjectTable.getInstance().getSelectedRow());
		AbstractTableModelStudents model = (AbstractTableModelStudents)StudentTable.getInstance().getModel();
		model.fireTableRowsUpdated(StudentTable.getInstance().getSelectedIndex(),StudentTable.getInstance().getSelectedIndex());
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
		this.idStudent = idStudent;
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
	public void addPassedSubject(int passedSubject) {
		passedSubjects.add(passedSubject);
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
	public void deleteUnpassedSubject(int i)
	{
		unpassedSubjects.remove(i-1);
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
	public List<Integer> getForAddSubjects()
	{
		List<Integer> retList = new ArrayList();
		List<Integer> retList2 = new ArrayList();
		List<Subject> forRet = SubjectController.getInstance().getAllSubjects();
		for(Subject s : forRet)
		{
			if(!unpassedSubjects.contains(s.getiDIntSubject()))
			{
				if(StudentController.getInstance().getYear() == s.getsubjectYearExecution())
					retList.add(s.getiDIntSubject());
			}
			
			
		}
		for(Integer i : retList)
		{
			if(!passedSubjects.contains(i))retList2.add(i);
		}
		
		return retList2;
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
