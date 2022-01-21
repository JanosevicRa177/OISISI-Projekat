package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.DeskController;
import Controller.ProfessorController;
import DepTables.AbstractDepartmentTable;
import DepTables.DepartmentTable;
import DepartmentsBoss.BossTable;
import Professor.ProfessorTable;

public class AddBossDialog extends JDialog {
	
	private static final long serialVersionUID = -9162250925534372358L;

	public AddBossDialog() {
		// TODO Auto-generated constructor stub
		super(MainFrame.getInstance(), "Boss", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		Dimension dim = new Dimension(100,25);
		setSize(width*1/6, height*3/8);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Boss");
		JPanel jp = new JPanel();
		JButton add = new JButton();
		add.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						DeskController.getInstance().findSelectedDesk(DepartmentTable.getInstance().getSelectedRow()).setDeskChief(ProfessorController.getInstance().findSelectedProffessor(BossTable.getInstance().getSelectedRow()).getIdProfByName(ProfessorController.getInstance().findSelectedProffessor(BossTable.getInstance().getSelectedRow()).getName()));
						AbstractDepartmentTable model = (AbstractDepartmentTable) DepartmentTable.getInstance().getModel();
						model.fireTableDataChanged();

						setVisible(false);
						MainFrame.getInstance().validate();
					}
			
				});
		add.setText("Add");
		add.setPreferredSize(dim);
		JScrollPane addsubpan =new JScrollPane(BossTable.getInstance());
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
