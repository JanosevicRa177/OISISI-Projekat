 package view;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;

import Controller.ProfessorController;
import Controller.StudentController;
import Controller.SubjectController;

public class AbstractActionDelete extends AbstractAction  {

	private static final long serialVersionUID = 1L;

	private static AbstractActionDelete instance = null;

	public static AbstractActionDelete getInstance() {
		if (instance == null) {
			instance = new AbstractActionDelete();
		}
		return instance;
	}
	
	private AbstractActionDelete() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(TabsWithTabels.getInstance().getFocus().equals("Professors")) {
			int row = ProfessorTable.getInstance().getSelectedIndex();
			ProfessorController.getInstance().deleteProfessor(row);
			AbstractTableModelProfessors model = (AbstractTableModelProfessors) ProfessorTable.getInstance().getModel();
			model.fireTableRowsDeleted(row, row);
			MainFrame.getInstance().validate();
		} else if(TabsWithTabels.getInstance().getFocus().equals("Subjects")) {
			int row = SubjectTable.getInstance().getSelectedIndex();
			SubjectController.getInstance().deleteSubject(row);
			AbstractTableModelSubjects model = (AbstractTableModelSubjects) SubjectTable.getInstance().getModel();
			model.fireTableRowsDeleted(row, row);
			
			MainFrame.getInstance().validate();
			
		}else if(TabsWithTabels.getInstance().getFocus().equals("Students"))
		{
			int row = StudentTable.getInstance().getSelectedIndex();
			System.out.println(row);
			StudentController.getInstance().deleteStudent(row);
			AbstractTableModelStudents model = (AbstractTableModelStudents)StudentTable.getInstance().getModel();
			model.fireTableRowsDeleted(row, row);
			
			MainFrame.getInstance().validate();
		}
		
	}

}
