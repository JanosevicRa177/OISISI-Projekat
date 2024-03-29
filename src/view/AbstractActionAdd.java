package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;



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
		else if(TabsWithTabels.getInstance().getFocus().equals("Subjects")) {
			SubjectAddDialog sd = new SubjectAddDialog();
			sd.setVisible(true);
		}
	}

}
