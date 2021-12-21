package Student;

import javax.swing.table.AbstractTableModel;

import model.ProfessorBase;

public class AbstractTableModelStudents extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AbstractTableModelStudents() {
	}
	public int getRowCount() {
		return ProfessorBase.getInstance().getRowCount();
	}
	public int getColumnCount() {
		return ProfessorBase.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return ProfessorBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorBase.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
