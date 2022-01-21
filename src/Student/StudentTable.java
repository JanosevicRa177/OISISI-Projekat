package Student;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

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
		studentSort.setComparator(0, new Comparator<String>() {

            @Override
            public int compare(String st1, String st2) {

                String st11 = st1.replaceAll("\\d", "");
                String st21 = st2.replaceAll("\\d", "");


                if(st11.equalsIgnoreCase(st21))
                {
                    return extractInt(st1) - extractInt(st2);
                }
                return st1.compareTo(st2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }


        });
		studentSort.setComparator(5, new Comparator<String>() {

            @Override
            public int compare(String sub1, String sub2) {
            	Float float1 = Float.parseFloat(sub1);
            	Float float2 = Float.parseFloat(sub2);
            	return  float1.compareTo(float2);
            }

        });
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
