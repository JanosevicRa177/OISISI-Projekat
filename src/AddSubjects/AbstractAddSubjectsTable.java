package AddSubjects;

import javax.swing.table.AbstractTableModel;

import Base.SubjectBase;
import Controller.StudentController;
import Student.StudentTable;
import model.Subject;

public class AbstractAddSubjectsTable extends AbstractTableModel {

	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractAddSubjectsTable() {
	}

	public int getRowCount() {
		return StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getForAddSubjects().size();
	}
	public int getColumnCount() {
		return 2;
	}
	public String getColumnName(int column) {
		return SubjectBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int row, int column) {
		if (row >= StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getForAddSubjects().size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			default:
				return null;
			}
		
		} else {
			int subjectInt = StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).getForAddSubjects().get(row);
			Subject subject = SubjectBase.getInstance().getStudentByID(subjectInt);
			switch (column) {
			case 0:
				return subject.getiDSubject();
			case 1:
				return subject.getSubjectName();

			default:
				return null;
			}
		}
	}
}
