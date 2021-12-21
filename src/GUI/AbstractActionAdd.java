package GUI;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import javax.swing.AbstractAction;

import Controller.StudentController;
import Student.AbstractTableModelStudents;
import Student.StudentTable;
import model.Address;
import model.Student;

public class AbstractActionAdd extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private static AbstractActionAdd instance = null;

	public static AbstractActionAdd getInstance() {
		if (instance == null) {
			instance = new AbstractActionAdd();
		}
		return instance;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(TabsWithTabels.getInstance().getFocus().equals("Professors")) {
			ProfessorAddDialog dialog = new ProfessorAddDialog();
            dialog.setVisible(true);
			
		} 
		else if(TabsWithTabels.getInstance().getFocus().equals("Students")) {
			StudentAddDialog sd = new StudentAddDialog();
			sd.setVisible(true);
			
			
		}
	}

}
