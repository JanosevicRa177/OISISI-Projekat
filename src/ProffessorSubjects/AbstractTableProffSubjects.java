package ProffessorSubjects;

import javax.swing.table.AbstractTableModel;

import Base.MarkBase;
import Base.ProfessorBase;
import Base.SubjectBase;
import Controller.ProfessorController;
import Controller.StudentController;
import Professor.ProfessorTable;
import Student.StudentTable;
import model.Mark;
import model.Subject;

public class AbstractTableProffSubjects extends AbstractTableModel{
	

	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractTableProffSubjects() {
	}

	public int getRowCount() {
		return ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedRow()).getProfessors_subjects().size();
	}
	public int getColumnCount() {
		return 4;
	}
	public String getColumnName(int column) {
		
		return ProfessorBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int row, int column) {
		if (row >= ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedRow()).getProfessors_subjects().size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			default:
				return null;
			}
		
		} else {
			Subject subject = ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedRow()).getProfessors_subjects().get(row);
			switch (column) {
			case 0:
				return subject.getiDSubject();
			case 1:
				return subject.getSubjectName();
			case 2:
				return Long.toString(subject.getESPBvalue());
			case 3:
				return Long.toString(subject.getsubjectYearExecution());
			default:
				return null;
			}
		}
	}

}
