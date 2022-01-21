package view;

import javax.swing.table.AbstractTableModel;

import Controller.StudentController;
import model.KindOfSemester;
import model.Mark;
import model.Subject;

public class AbstractTableModelPassedSubjects extends AbstractTableModel {
	
	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractTableModelPassedSubjects() {
	}

	public int getRowCount() {
		return StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getPassedSubjects().size();
	}
	public int getColumnCount() {
		return 5;
	}
	public String getColumnName(int column) {
		if(column < 3)
			return SubjectBase.getInstance().getColumnName(column);
		else
			return MarkBase.getInstance().getColumnName(column-1);
	}
	public Object getValueAt(int row, int column) {
		if (row >= StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getPassedSubjects().size()) {
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
			int subjectInt = StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getPassedSubjects().get(row);
			Subject subject = SubjectBase.getInstance().getStudentByID(subjectInt);
			int st =  StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getIdStudent();
			Mark mark = MarkBase.getInstance().getMarkByStudentAndSubject(st, subjectInt);
			switch (column) {
			case 0:
				return subject.getiDSubject();
			case 1:
				return subject.getSubjectName();
			case 2:
				return Long.toString(subject.getESPBvalue());
			case 3:
				return Long.toString(mark.getMarkValue());
			case 4:
				return "" + mark.getDate();
			default:
				return null;
			}
		}
	}
	

}
