package Student;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import Professor.AbstractTableModelProfessors;
import Professor.ProfessorTable;

public class StudentTable extends JTable{
	
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;

private static StudentTable instance = null;
public static JTable studentTable;
public static int rowSelectedIndex = -1;
public static TableRowSorter<AbstractTableModelStudents> studentSort;
public static AbstractTableModelStudents studentAbstractTable;
	
	public static StudentTable getInstance() {
		if (instance == null) {
			instance = new StudentTable();
		}
		return instance;
	}
	
	public int getSelectedIndex() {
        return rowSelectedIndex;
    }
	
	public StudentTable() {
		// TODO Auto-generated constructor stub
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudents());
		studentAbstractTable = new AbstractTableModelStudents();
		studentAbstractTable = (AbstractTableModelStudents)this.getModel();
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				studentTable = (JTable) e.getComponent();
				if(studentTable.getSelectedRow() != -1) {
					rowSelectedIndex = studentTable.convertRowIndexToModel(studentTable.getSelectedRow());
				}
			}
			
		});
		studentSort =new TableRowSorter<AbstractTableModelStudents>(studentAbstractTable);
		this.setRowSorter(studentSort);
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
