package Subject;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class SubjectTable  extends JTable {

	private static final long serialVersionUID = 8594197354973187868L;
	
	private static SubjectTable instance = null;
	
	public static SubjectTable getInstance() {
		if (instance == null) {
			instance = new SubjectTable();
		}
		return instance;
	}
	
	public SubjectTable() {
		// TODO Auto-generated constructor stub
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubjects());
//		this.setAutoCreateRowSorter(true);
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				int row = SubjectTable.getInstance().rowAtPoint(e.getPoint());
				SubjectTable.getInstance().setRowSelectionInterval(row,row);
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
