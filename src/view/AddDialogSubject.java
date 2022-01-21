package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import AddSubjects.AddSubjectsTable;

public class AddDialogSubject extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9162250925534372358L;

	public AddDialogSubject() {
		// TODO Auto-generated constructor stub
		super(MainFrame.getInstance(), "Add Subject", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		Dimension dim = new Dimension(100,25);
		setSize(width*1/6, height*3/8);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Dodavanje predmeta");
		JPanel jp = new JPanel();
		JButton add = new JButton();
		add.setText("Add");
		add.setPreferredSize(dim);
		JScrollPane addsubpan =new JScrollPane(AddSubjectsTable.getInstance());
		addsubpan.setPreferredSize(new Dimension(200, 200));
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setPreferredSize(dim);
		
		jp.add(addsubpan);
		
		jp.add(add);
		jp.add(cancel);
		
		add(jp);
		
		
		
		
	}
		


}
