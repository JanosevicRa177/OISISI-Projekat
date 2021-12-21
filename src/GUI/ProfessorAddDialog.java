package GUI;

import java.awt.Frame;

import javax.swing.JDialog;

public class ProfessorAddDialog extends JDialog{

	private static final long serialVersionUID = -4151970749929099461L;

	public ProfessorAddDialog() {
		super(MainFrame.getInstance(), "Adding Professor", true);
		setSize(250, 250);
		setLocationRelativeTo(MainFrame.getInstance());
	}

}
