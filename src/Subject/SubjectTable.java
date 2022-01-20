package Subject;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import Professor.AbstractTableModelProfessors;

public class SubjectTable  extends JTable {

	private static final long serialVersionUID = 8594197354973187868L;
	
	private static SubjectTable instance = null;
	public static JTable subjectTable;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<AbstractTableModelSubjects> subjectSort;
	public static AbstractTableModelSubjects subjectAbstractTable;
	
	public static SubjectTable getInstance() {
		if (instance == null) {
			instance = new SubjectTable();
		}
		return instance;
	}
	public int getSelectedIndex() {
        return rowSelectedIndex;
    }
	public SubjectTable() {
		// TODO Auto-generated constructor stub
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubjects());
		this.setAutoCreateRowSorter(true);
		
		subjectAbstractTable = new AbstractTableModelSubjects();
		subjectAbstractTable = (AbstractTableModelSubjects)this.getModel();
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				subjectTable = (JTable) e.getComponent();
				if(subjectTable.getSelectedRow() != -1) {
					rowSelectedIndex = subjectTable.convertRowIndexToModel(subjectTable.getSelectedRow());
				}
			}
		});
		subjectSort = new TableRowSorter<AbstractTableModelSubjects>(subjectAbstractTable);
		this.setRowSorter(subjectSort);
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
