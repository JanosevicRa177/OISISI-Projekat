package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import model.KindOfSemester;
import model.Professor;
import model.Student;
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
	private List<Subject> subjectsNotVisible;
	private List<Subject> subjectsVisible;
	private List<String> colons;
	
	private SubjectBase() {
		this.subjects = new ArrayList<Subject>();
		this.subjectsNotVisible = new ArrayList<Subject>();
		this.subjectsVisible = new ArrayList<Subject>();
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
	public void sortByID() {
		Collections.sort(subjects, new Comparator<Subject>() {
			  @Override
			  public int compare(Subject subj1,Subject subj2) {
			    return subj1.getiDIntSubject() - subj2.getiDIntSubject();
			  }
			});
	}
	
	public int getID(){
		int id = 1;
		Iterator<Subject> it = subjects.iterator();
		while(it.hasNext()) {
			if(it.next().getiDIntSubject() != id) {
				break;
			}
			id++;
		}
		return id;
	}
	public Subject getStudentByID(int id) {
		Subject subject = new Subject();
		for(Subject sub : subjects) {
			if(sub.getiDIntSubject() == id) {
				subject = sub;
			}
		}
		return subject;
	}
	public void searchSubject(String search) {
		AbstractTableModelSubjects model = (AbstractTableModelSubjects) SubjectTable.getInstance().getModel();
		Iterator<Subject> it2 = subjectsNotVisible.iterator();
		int row = 0;
		Subject subj;
		while(it2.hasNext()) {
			subj = it2.next();
			subjects.add(subj);
			model.fireTableRowsInserted(subjects.size()-1, subjects.size()-1);
		}
		sortByID();
		subjectsVisible = new ArrayList<Subject>();
		subjectsNotVisible = new ArrayList<Subject>();
		if(search.matches("[A-Za-z0-9ŠĆĐŽČšćžđč]+")) {
			Iterator<Subject> it1 = subjects.iterator();
			row = 0;
			while(it1.hasNext()) {
				subj = it1.next();
				if(subj.getiDSubject().toLowerCase().matches(".*"+search.toLowerCase()+".*")) {
					subjectsVisible.add(subj);
				} else {
					subjectsNotVisible.add(subj);
					model.fireTableRowsDeleted(row, row);
				}
				row++;
			}
			subjects = subjectsVisible;
		}else if(search.matches("[A-Za-z0-9ŠĆĐŽČšćžđč]+( )[A-Za-z0-9ŠĆĐŽČšćžđč]+")) {
			String[] search1 = search.split(" ");
			Iterator<Subject> it1 = subjects.iterator();
			row = 0;
			while(it1.hasNext()) {
				subj = it1.next();
				if(subj.getiDSubject().toLowerCase().matches(".*"+search1[0].toLowerCase()+".*") &&
						subj.getSubjectName().toLowerCase().matches(".*"+search1[1].toLowerCase()+".*")) {
					subjectsVisible.add(subj);
				} else {
					subjectsNotVisible.add(subj);
					model.fireTableRowsDeleted(row, row);
				}
				row++;
			}
			subjects = subjectsVisible;
		}
		model.fireTableDataChanged();
		MainFrame.getInstance().validate();
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
	public Subject getSubjectByID(int subjectInt) {
		for (Subject subject : subjects) {
			if (subject.getiDIntSubject() == subjectInt) {
				subjects.remove(subject);
				return subject;
			}
		}
		return null;
	}
	public Subject getSubjectByIDNonRemove(int subjectInt) {
		for (Subject subject : subjects) {
			if (subject.getiDIntSubject() == subjectInt) {
				return subject;
			}
		}
		return null;
	}
	public void addUnpassedStudent(int student,int subjectInt) {
		Subject subject = SubjectBase.getInstance().getSubjectByID(subjectInt);
		subject.addStudentsWhoDidntPass(student);
		subjects.add(subject);
		SubjectBase.getInstance().sortByID();
	}
	public void addPassedStudent(int student,int subjectInt) {
		Subject subject = SubjectBase.getInstance().getSubjectByID(subjectInt);
		subject.addStudentsWhoPassed(student);
		subjects.add(subject);
		SubjectBase.getInstance().sortByID();
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
