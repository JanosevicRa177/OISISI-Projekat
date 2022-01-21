package AddSubjectToProf;

import javax.swing.table.AbstractTableModel;

import Base.SubjectBase;
import Controller.ProfessorController;
import Controller.StudentController;
import Professor.ProfessorTable;
import Student.StudentTable;
import model.Subject;

public class AbstractSubjProfTable extends AbstractTableModel {
	
	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractSubjProfTable() {
	}

	public int getRowCount() {
		return ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedRow()).getProfessorsSubjects().size();
	}
	public int getColumnCount() {
		return 2;
	}
	public String getColumnName(int column) {
		return SubjectBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int row, int column) {
		if (row >= ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedRow()).getProfessorsSubjects().size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			default:
				return null;
			}
		
		} else {
			Subject subject = ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedRow()).getProfessorsSubjects().get(row);

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
