package view;

import javax.swing.table.AbstractTableModel;

import Controller.StudentController;
import model.KindOfSemester;
import model.Subject;

public class AbstractTableModelUnpassedSubjects extends AbstractTableModel {

	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractTableModelUnpassedSubjects() {
	}

	public int getRowCount() {
		return StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getUnpassedSubjects().size();
	}
	public int getColumnCount() {
		return SubjectBase.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return SubjectBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int row, int column) {
		if (row >= StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getUnpassedSubjects().size()) {
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
			case 5:
				return "";
			default:
				return null;
			}
		
		} else {
			int subjectInt = StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getUnpassedSubjects().get(row);
			Subject subject = SubjectBase.getInstance().getStudentByID(subjectInt);
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
}
