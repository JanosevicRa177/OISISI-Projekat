package main;

import java.util.List;

enum Kind_of_semester{Summer, Winter}
public class Subject {

	private String Subject_name;
	private Kind_of_semester Semester_kind;
	private int Year_of_subject_execution;
	private Professor Professor_of_Subject;
	private int ESPB_value;
	private List<Student> Students_who_passed_subject;
	private List<Student> Students_who_didnt_pass_subject;
	
	public Subject() {
	}
	public Subject(String subject_name, Kind_of_semester semester_kind, int year_of_subject_execution,
			Professor professor_of_Subject, int eSPB_value) {
		super();
		Subject_name = subject_name;
		Semester_kind = semester_kind;
		Year_of_subject_execution = year_of_subject_execution;
		Professor_of_Subject = professor_of_Subject;
		ESPB_value = eSPB_value;
	}
	public String getSubject_name() {
		return Subject_name;
	}

	public void setSubject_name(String subject_name) {
		Subject_name = subject_name;
	}

	public Kind_of_semester getSemester_kind() {
		return Semester_kind;
	}

	public void setSemester_kind(Kind_of_semester semester_kind) {
		Semester_kind = semester_kind;
	}

	public int getYear_of_subject_execution() {
		return Year_of_subject_execution;
	}

	public void setYear_of_subject_execution(int year_of_subject_execution) {
		Year_of_subject_execution = year_of_subject_execution;
	}

	public Professor getProfessor_of_Subject() {
		return Professor_of_Subject;
	}

	public void setProfessor_of_Subject(Professor professor_of_Subject) {
		Professor_of_Subject = professor_of_Subject;
	}

	public int getESPB_value() {
		return ESPB_value;
	}

	public void setESPB_value(int eSPB_value) {
		ESPB_value = eSPB_value;
	}
	public List<Student> getStudents_who_passed_subject() {
		return Students_who_passed_subject;
	}
	public void addStudents_who_passed_subject(Student students_who_passed_subject) {
		Students_who_passed_subject.add(students_who_passed_subject);
	}
	public void deleteStudents_who_passed_subject(Student students_who_passed_subject) {
		Students_who_passed_subject.remove(students_who_passed_subject);
	}
	public List<Student> getStudents_who_didnt_pass_subject() {
		return Students_who_didnt_pass_subject;
	}
	public void addStudents_who_didnt_pass_subject(Student students_who_didnt_pass_subject) {
		Students_who_didnt_pass_subject.add(students_who_didnt_pass_subject);
	}
	public void deleteStudents_who_didnt_pass_subject(Student students_who_didnt_pass_subject) {
		Students_who_didnt_pass_subject.remove(students_who_didnt_pass_subject);
	}
	
	
}
