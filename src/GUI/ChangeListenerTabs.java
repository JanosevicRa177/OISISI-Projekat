package GUI;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerTabs implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		 if (e.getSource() instanceof TabsWithTabels) {
			 TabsWithTabels pane = (TabsWithTabels) e.getSource();
             if(pane.getTitleAt(pane.getSelectedIndex()) == "Professors") {
            	 TabsWithTabels.getInstance().focusOnProfessor();
             }else if(pane.getTitleAt(pane.getSelectedIndex()) == "Students") {
            	 TabsWithTabels.getInstance().focusOnStudent();
             }else {
            	 TabsWithTabels.getInstance().focusOnSubject();
             }
         }
	}



	
}
