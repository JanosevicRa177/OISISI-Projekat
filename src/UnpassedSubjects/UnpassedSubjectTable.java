package UnpassedSubjects;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import Subject.AbstractTableModelSubjects;
import Subject.SubjectTable;

public class UnpassedSubjectTable extends JTable {

	private static final long serialVersionUID = 1L;
	
	private static UnpassedSubjectTable instance = null;
	
	public static UnpassedSubjectTable getInstance() {
		if (instance == null) {
			instance = new UnpassedSubjectTable();
		}
		return instance;
	}
	
	private UnpassedSubjectTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelUnpassedSubjects());
		this.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				int row = UnpassedSubjectTable.getInstance().rowAtPoint(e.getPoint());
				UnpassedSubjectTable.getInstance().setRowSelectionInterval(row,row);
			}
		});
	}
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new Color(31, 114, 180));
		} else {
			if (row%2 == 0) {
				c.setBackground(new Color(127, 173, 180));
			} else {
				c.setBackground(new Color(61, 146, 180));
			}
		}
		return c;
	
	}
}
