package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AbstractActionUpdate extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static AbstractActionUpdate instance = null;
	
	public static AbstractActionUpdate getInstance() {
		if (instance == null) {
			instance = new AbstractActionUpdate();
		}
		return instance;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(TabsWithTabels.getInstance().getFocus().equals("Students")) {
			
			if(StudentTable.getInstance().getSelectedRow() != -1)
			{
			StudentUpdateDialog sd = new StudentUpdateDialog();
			sd.setVisible(true);
			}
		}else if(TabsWithTabels.getInstance().getFocus().equals("Professors")) {
			ProfessorUpdateDialog dialog = new ProfessorUpdateDialog();

			if(ProfessorTable.getInstance().getSelectedRow() != -1)
			dialog.setVisible(true);
		}else if(TabsWithTabels.getInstance().getFocus().equals("Subjects")){
			if(SubjectTable.getInstance().getSelectedRow() != -1)
			{
				SubjectUpdateDialog sd = new SubjectUpdateDialog();
				sd.setVisible(true);
			}
		}
	}

}
