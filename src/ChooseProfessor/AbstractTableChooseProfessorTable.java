package ChooseProfessor;

import javax.swing.table.AbstractTableModel;

import Base.ProfessorBase;

public class AbstractTableChooseProfessorTable extends AbstractTableModel {


	private static final long serialVersionUID = 7564286278653674036L;

	public AbstractTableChooseProfessorTable() {
	}
	public int getRowCount() {
		return ProfessorBase.getInstance().getRowCount();
	}
	public int getColumnCount() {
		return 2;
	}
	public String getColumnName(int column) {
		return ProfessorBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorBase.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
