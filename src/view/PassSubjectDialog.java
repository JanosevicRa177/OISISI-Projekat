package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class PassSubjectDialog extends JDialog{

	private static final long serialVersionUID = 8021603327342807647L;

	public PassSubjectDialog() {
		// TODO Auto-generated constructor stub
		super(StudentUpdateDialog.getInstance(), "Update Student", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/6, height*3/8);
		setLocationRelativeTo(StudentUpdateDialog.getInstance());
		setTitle("Izmena Studenta");
	}

}
