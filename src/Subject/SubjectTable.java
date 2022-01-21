package Subject;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import Professor.AbstractTableModelProfessors;
import model.Subject;

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
		subjectSort.setComparator(0, new Comparator<String>() {

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
		subjectSort.setComparator(2, new Comparator<String>() {

            @Override
            public int compare(String sub1, String sub2) {
            	int int1 = Integer.parseInt(sub1);
            	int int2 = Integer.parseInt(sub2);
                return  int1 - int2;
            }

        });
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
