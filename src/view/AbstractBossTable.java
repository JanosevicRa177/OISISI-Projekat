package view;

import javax.swing.table.AbstractTableModel;

import Controller.DeskController;
import Controller.ProfessorController;
import Controller.StudentController;
import model.Desk;
import model.Mark;
import model.Professor;
import model.Subject;

public class AbstractBossTable extends AbstractTableModel {
	
	private static final long serialVersionUID = 5195099875567733847L;

	public AbstractBossTable() {
	}

	public int getRowCount() {
		return DeskController.getInstance().findSelectedDesk(DepartmentTable.getInstance().getSelectedRow()).getNeeded().size();
	}
	public int getColumnCount() {
		return 3;
	}
	public String getColumnName(int column) {
		return ProfessorBase.getInstance().getColumnName(column);
	}
	public Object getValueAt(int row, int column) {
		if (row >= DeskController.getInstance().findSelectedDesk(DepartmentTable.getInstance().getSelectedRow()).getNeeded().size()) {
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
				
			int profInt =  DeskController.getInstance().findSelectedDesk(DepartmentTable.getInstance().getSelectedRow()).getNeeded().get(row);
			Professor prof = ProfessorBase.getInstance().getProfbyID(profInt);
			
			//Professor prof = DeskController.getInstance().findallneeded().get(row);
				
			switch (column) {
			case 0:
				return prof.getIDnumber();
			case 1:
				return prof.getName();
			case 2:
				return prof.getSurname();

			default:
				return null;
			}
				
		}
	}

}
