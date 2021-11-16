package main;

import java.time.LocalDate;

public class Mark {

	private Student StudentWhichPassExam;
	private Subject _Subject;
	private int MarkValue;
	private LocalDate Date;
	
	public Mark() {
		super();
	}
	
	public Mark(Student studentWhichPassExam, Subject _Subject, int markValue, LocalDate date) {
		super();
		StudentWhichPassExam = studentWhichPassExam;
		this._Subject = _Subject;
		if((markValue >= 6)&&(markValue <= 10))
		MarkValue = markValue;
		else
		{
			System.out.println("Ocena mora biti izmedju 6 i 10");
		}
		Date = date;
	}

	public Student getStudentWhichPassExam() {
		return StudentWhichPassExam;
	}

	public void setStudentWhichPassExam(Student studentWhichPassExam) {
		StudentWhichPassExam = studentWhichPassExam;
	}

	public Subject get_Subject() {
		return _Subject;
	}

	public void set_Subject(Subject _Subject) {
		this._Subject = _Subject;
	}

	public int getMarkValue() {
		return MarkValue;
	}

	public void setMarkValue(int markValue) {
		if((markValue >= 6)&&(markValue <= 10))
		MarkValue = markValue;
		else
		{
			System.out.println("Ocena mora biti izmedju 6 i 10");
		}
	}

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}
	
	
	
	

}
