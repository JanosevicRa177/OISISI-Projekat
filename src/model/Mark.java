package model;

import java.time.LocalDate;

public class Mark {

	private Student studentsPassed;
	private Subject subject;
	private int markValue;
	private LocalDate date;
	
	public Mark() {
		super();
	}
	
	public Mark(Student studentsPassed, Subject subject, int markValue, LocalDate date) {
		super();
		this.studentsPassed = studentsPassed;
		this.subject = subject;
		if((markValue >= 6)&&(markValue <= 10))
		this.markValue = markValue;
		else
		{
			System.out.println("Ocena mora biti izmedju 6 i 10");
		}
		this.date = date;
	}

	public Student getStudentWhichPassExam() {
		return studentsPassed;
	}

	public void setStudentWhichPassExam(Student studentWhichPassExam) {
		studentsPassed = studentWhichPassExam;
	}

	public Subject get_Subject() {
		return subject;
	}

	public void set_Subject(Subject _Subject) {
		this.subject = _Subject;
	}

	public int getMarkValue() {
		return markValue;
	}

	public void setMarkValue(int markValue) {
		if((markValue >= 6)&&(markValue <= 10))
		this.markValue = markValue;
		else
		{
			System.out.println("Ocena mora biti izmedju 6 i 10");
		}
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	

}
