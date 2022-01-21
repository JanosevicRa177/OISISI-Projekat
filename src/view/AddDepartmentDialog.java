package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import AddSubjects.AddSubjectsTable;
import DepTables.DepartmentTable;

public class AddDepartmentDialog extends JDialog {
	
	private static final long serialVersionUID = -9162250925534372358L;

	public AddDepartmentDialog() {
		// TODO Auto-generated constructor stub
		super(MainFrame.getInstance(), "Departments", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		Dimension dim = new Dimension(100,25);
		setSize(width*1/6, height*3/8);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Departments");
		JPanel jp = new JPanel();
		JButton add = new JButton();
		add.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						AddBossDialog bd = new AddBossDialog();
						bd.setVisible(true);
										}
			
				});
		add.setText("Add");
		add.setPreferredSize(dim);
		JScrollPane addsubpan =new JScrollPane(DepartmentTable.getInstance());
		addsubpan.setPreferredSize(new Dimension(200, 200));
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
		});
		cancel.setPreferredSize(dim);
		
		jp.add(addsubpan);
		
		jp.add(add);
		jp.add(cancel);
		
		add(jp);
		
		
		
		
	}

}
