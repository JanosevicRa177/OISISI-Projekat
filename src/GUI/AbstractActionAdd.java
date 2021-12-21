package GUI;

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
			
		} 
		else if(TabsWithTabels.getInstance().getFocus().equals("Students")) {
			StudentAddDialog sd = new StudentAddDialog();
			sd.setVisible(true);
	
			
		}
	}

}
