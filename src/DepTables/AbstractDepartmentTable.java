package DepTables;

import javax.swing.table.AbstractTableModel;

import Base.SubjectBase;
import Controller.DeskController;
import Controller.StudentController;
import Student.StudentTable;
import model.Desk;
import model.Subject;

public class AbstractDepartmentTable extends AbstractTableModel {
	
	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractDepartmentTable() {
	}

	public int getRowCount() {
		return DeskController.getInstance().getAllDesks().size();
	}
	public int getColumnCount() {
		return 3;
	}
	public String getColumnName(int column) {
		return DeskController.getInstance().getColumnName(column);
	}
	public Object getValueAt(int row, int column) {
		if (row >=  DeskController.getInstance().getAllDesks().size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			default:
				return null;
			}
		
		} else {
				
			Desk desk = DeskController.getInstance().getAllDesks().get(row);
				
			switch (column) {
			case 0:
				return desk.getDeskCode();
			case 1:
				return desk.getDeskName();
			case 2:
				return desk.getDeskChief();

			default:
				return null;
			}
				
		}
	}

}
