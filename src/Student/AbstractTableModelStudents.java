package Student;

import javax.swing.table.AbstractTableModel;

import model.StudentBase;

public class AbstractTableModelStudents extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AbstractTableModelStudents() {
	}
	public int getRowCount() {
		return StudentBase.getInstance().getRowCount();
	}
	public int getColumnCount() {
		return StudentBase.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return StudentBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentBase.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
