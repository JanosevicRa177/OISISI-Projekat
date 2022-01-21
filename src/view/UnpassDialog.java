package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.StudentController;

public class UnpassDialog extends JDialog{

	private static final long serialVersionUID = 2985460275064593116L;

	public UnpassDialog() {
		// TODO Auto-generated constructor stub
		super(MainFrame.getInstance(), "Unpass subject", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/6, height*1/7);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel unpass = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel unpassTxt = new JLabel("Are you sure you want to unpass Subject");
		unpass.add(unpassTxt);
		Dimension dim = new Dimension(100, 25);
		JButton ok = new JButton();
		ok.setText("Yes");
		ok.setPreferredSize(dim);
		ok.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dec = PassedSubjectTable.getInstance().getSelectedRow();
				StudentController.getInstance().unpassTest(dec);
				setVisible(false);
			}
		});
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setPreferredSize(dim);
		cancel.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		Box unpassButtonsBox = Box.createHorizontalBox();
		unpassButtonsBox.add(Box.createVerticalStrut(20));
		unpassButtonsBox.add(Box.createHorizontalGlue());
		unpassButtonsBox.add(ok);
		unpassButtonsBox.add(Box.createHorizontalStrut(10));
		unpassButtonsBox.add(cancel);
		unpassButtonsBox.add(Box.createHorizontalGlue());
		unpass.add(unpassButtonsBox);
		this.add(unpass);
	}

}
