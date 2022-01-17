package Base;

import java.util.ArrayList;
import java.util.List;

import model.KindOfSemester;
import model.Subject;

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
		this.colons = new ArrayList<String>();
		this.colons.add("IDsubject");
		this.colons.add("Subject Name");
		this.colons.add("ESPB value");
		this.colons.add("Year of execution");
		this.colons.add("Kind of Semester");
	}
	public boolean contains(String ID) {
		for(Subject sub : subjects) {
			if(sub.getiDSubject().equals(ID)) {
				return true;
			}
		}
		return false;
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
				return subject.getiDSubject();
			case 1:
				return subject.getSubjectName();
			case 2:
				return Long.toString(subject.getESPBvalue());
			case 3:
				return Long.toString(subject.getsubjectYearExecution());
			case 4:
				if(subject.getSemesterkind() == KindOfSemester.Summer) {
					return "Summer";
				}else {
					return "Winter";
				}
			default:
				return null;
			}
		}
	}
	public void addUnpassedStudent(int student,int subject) {
		subjects.get(subject-1).addStudentsWhoDidntPass(student);
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public void deleteSubject(String id) {
		for (Subject subject : subjects) {
			if (subject.getiDSubject().equals(id)) {
				subjects.remove(subject);
				break;
			}
		}
	}

	public void changeSubject(String iDSubject, String subjectName, KindOfSemester semesterKind, int subjectYearExecution,
		int eSPBvalue) {
		for (Subject subject : subjects) {
			if (subject.getiDSubject().equals(iDSubject)) {
				subject.setiDSubject(iDSubject);
				subject.setSubjectName(subjectName);
				subject.setSemesterKind(semesterKind);
				subject.setsubjectYearExecution(subjectYearExecution);
				subject.setESPBvalue(eSPBvalue);
			}
		}
	}
}
