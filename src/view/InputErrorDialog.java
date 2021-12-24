package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputErrorDialog extends JDialog{

	private static final long serialVersionUID = -7087392391344164569L;

	public InputErrorDialog() {
		super(MainFrame.getInstance(), "Input Error", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/6, height*1/7);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel error = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel errorTxt = new JLabel("Input Error: ID must be unique!");
		error.add(errorTxt);
		Dimension dim = new Dimension(100, 25);
		JButton ok = new JButton();
		ok.setText("Ok");
		ok.setPreferredSize(dim);
		ok.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		error.add(ok);
		this.add(error);
	}

}
