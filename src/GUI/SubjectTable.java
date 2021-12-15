package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class SubjectTable  extends JTable {

	public SubjectTable() {
		// TODO Auto-generated constructor stub
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubjects());
	}
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (row%2 == 0) {
			c.setBackground(new Color(127, 173, 180));
		} else {
			c.setBackground(new Color(61, 146, 180));
		}
		return c;
	}

}
