package view;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerTabs implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		 if (e.getSource() instanceof TabsWithTabels) {
			 TabsWithTabels pane = (TabsWithTabels) e.getSource();
             if(pane.getTitleAt(pane.getSelectedIndex()) == "Professors") {
            	 TabsWithTabels.getInstance().focusOnProfessor();
            	 StatusBar.getInstance().setLbl(2);
             }else if(pane.getTitleAt(pane.getSelectedIndex()) == "Students") {
            	 TabsWithTabels.getInstance().focusOnStudent();
            	 StatusBar.getInstance().setLbl(1);
             }else {
            	 TabsWithTabels.getInstance().focusOnSubject();
            	 StatusBar.getInstance().setLbl(3);
             }
             MainFrame.getInstance().validate();
         }
	}
	
}
