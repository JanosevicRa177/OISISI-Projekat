package ChooseProfessor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import Professor.AbstractTableModelProfessors;

public class ChooseProfessorTable extends JTable{

	private static final long serialVersionUID = -7143977400143377863L;
	private static ChooseProfessorTable instance = null;
	
	public static ChooseProfessorTable getInstance() {
		if (instance == null) {
			instance = new ChooseProfessorTable();
		}
		return instance;
	}
	private ChooseProfessorTable() {
		// TODO Auto-generated constructor stub
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableChooseProfessorTable());

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
