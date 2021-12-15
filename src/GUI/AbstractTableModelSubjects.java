package GUI;

import javax.swing.table.AbstractTableModel;

import model.SubjectBase;

public class AbstractTableModelSubjects extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	public AbstractTableModelSubjects() {
	}
	
	public int getRowCount() {
		return SubjectBase.getInstance().getRowCount();
	}
	public int getColumnCount() {
		return SubjectBase.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return SubjectBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SubjectBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
