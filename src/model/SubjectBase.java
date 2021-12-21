package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubjectBase {

	private static SubjectBase instance = null;
	
	public static SubjectBase getInstance() {
		if (instance == null) {
			instance = new SubjectBase();
		}
		return instance;
	}
	private List<Subject> subjects;
	private List<String> colons;
	
	private SubjectBase() {
		this.subjects = new ArrayList<Subject>();
		Professor professor = new Professor("mirko","mirkovic",LocalDate.of(2017, 1, 13),
				new Address("ulica",5,"beograd","srbija"),060,"nekiMail@gmail.com",
				new Address("ulica",5,"beograd","srbija"),567, "nastavnik",56.6);
		Subject subject = new Subject(150,"Matematika",Kind_of_semester.Summer,2019,professor,8);
		subjects.add(subject);
		this.colons = new ArrayList<String>();
		this.colons.add("IDsubject");
		this.colons.add("Subject Name");
		this.colons.add("ESPB value");
		this.colons.add("Year of execution");
		this.colons.add("Kind of Semester");
	}
	public int getColumnCount() {
		return 5;
	}
	public int getRowCount() {
		return subjects.size();
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public String getColumnName(int index) {
		return this.colons.get(index);
	}
	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}
	public String getValueAt(int row, int column) {
		if (row >= subjects.size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			default:
				return null;
			}
		
		} else {
			Subject subject = this.subjects.get(row);
			switch (column) {
			case 0:
				return Long.toString(subject.getiDSubject());
			case 1:
				return subject.getSubjectName();
			case 2:
				return Long.toString(subject.getESPBvalue());
			case 3:
				return Long.toString(subject.getsubjectYearExecution());
			case 4:
				if(subject.getSemesterkind() == Kind_of_semester.Summer) {
					return "Summer";
				}else {
					return "Winter";
				}
			default:
				return null;
			}
		}
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public void deleteSubject(long id) {
		for (Subject subject : subjects) {
			if (subject.getiDSubject() == id) {
				subjects.remove(subject);
				break;
			}
		}
	}

	public void changeSubject(int iDSubject, String subjectName, Kind_of_semester semesterKind, int subjectYearExecution,
			Professor professorsSubjects,int eSPBvalue) {
		for (Subject subject : subjects) {
			if (subject.getiDSubject() == iDSubject) {
				subject.setSubjectName(subjectName);
				subject.setSemesterKind(semesterKind);
				subject.setsubjectYearExecution(subjectYearExecution);
				subject.setProfessor_of_Subject(professorsSubjects);
				subject.setESPBvalue(eSPBvalue);
			}
		}
	}
}
