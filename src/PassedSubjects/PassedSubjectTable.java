package PassedSubjects;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PassedSubjectTable extends JTable {
	
private static final long serialVersionUID = 1L;
	
	private static PassedSubjectTable instance = null;
	
	public static PassedSubjectTable getInstance() {
		if (instance == null) {
			instance = new PassedSubjectTable();
		}
		return instance;
	}
	private PassedSubjectTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPassedSubjects());
		this.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				int row = PassedSubjectTable.getInstance().rowAtPoint(e.getPoint());
				PassedSubjectTable.getInstance().setRowSelectionInterval(row,row);
			}
		});
	}
	public int getESPB()
	{
		int s = 0;
		int i = 0;
		
		while(i < getRowCount())
		{
			String value = "" + getValueAt(i,2);
			s = s + Integer.parseInt(value);
			i++;
		}
		return s;
	}
	public int getProsek()
	{
		int s = 0;
		int i = 0;
		
		while(i < getRowCount())
		{
			String value = "" + getValueAt(i,3);
			s = s + Integer.parseInt(value);
			i++;
		}
		if(getRowCount() != 0)
		s = s / getRowCount();
		else s = 5;
		return s;
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
