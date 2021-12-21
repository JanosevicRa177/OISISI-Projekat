package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentAddDialog extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentAddDialog(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width / 2;
		int height = screenSize.height;
		setSize(width*3/4,height*3/4);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Dodavanje Studenta");
		
	}

}
