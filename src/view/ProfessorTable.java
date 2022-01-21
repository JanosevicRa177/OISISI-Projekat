package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;


public class ProfessorTable  extends JTable {

	private static final long serialVersionUID = 1L;

	private static ProfessorTable instance = null;
	public static JTable professorTable;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<AbstractTableModelProfessors> professorSort;
	public static AbstractTableModelProfessors professorAbstractTable;
	
	public static ProfessorTable getInstance() {
		if (instance == null) {
			instance = new ProfessorTable();
		}
		return instance;
	}
	public int getSelectedIndex() {
        return rowSelectedIndex;
    }
	private ProfessorTable() {
		// TODO Auto-generated constructor stub
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessors());
		
		professorAbstractTable = new AbstractTableModelProfessors();
		professorAbstractTable = (AbstractTableModelProfessors)this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				professorTable = (JTable) e.getComponent();
				if(professorTable.getSelectedRow() != -1) {
					rowSelectedIndex = professorTable.convertRowIndexToModel(professorTable.getSelectedRow());
				}
			}
		});
		professorSort =new TableRowSorter<AbstractTableModelProfessors>(professorAbstractTable);
		this.setRowSorter(professorSort);
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
