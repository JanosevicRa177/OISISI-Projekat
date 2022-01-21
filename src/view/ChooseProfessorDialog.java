package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import Base.SubjectBase;
import ChooseProfessor.ChooseProfessorTable;
import Controller.ProfessorController;
import Controller.SubjectController;
import Subject.SubjectTable;
import model.Professor;

public class ChooseProfessorDialog extends JDialog{

	private static final long serialVersionUID = -8480805821579924412L;
	
	public ChooseProfessorDialog() {
		// TODO Auto-generated constructor stub
		super(MainFrame.getInstance(), "Choose professor", true);
        setTitle("Choose Professor");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/6 + 20,height*3/8);
		setLocationRelativeTo(MainFrame.getInstance());
		
		Box box = Box.createVerticalBox();
		JScrollPane professors = new JScrollPane(ChooseProfessorTable.getInstance());
		professors.setPreferredSize(new Dimension(200,200));
		box.add(professors);
		Dimension dim = new Dimension(100, 25);
		JButton confirm = new JButton();
		confirm.setText("Confirm");
		confirm.setPreferredSize(dim);
		confirm.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int subject = SubjectTable.getInstance().getSelectedIndex();
				int professorInt = ChooseProfessorTable.getInstance().getSelectedRow();
				Professor professor = ProfessorController.getInstance().getAllProf().get(professorInt);
				ProfessorController.getInstance().getAllProf().get(professorInt).add_Professors_subject(SubjectController.getInstance().getAllSubjects().get(subject));
				SubjectController.getInstance().getAllSubjects().get(subject).setProfessor_of_Subject(professor.getIdProf());
				SubjectUpdateDialog.getInstance().setProfessor(professor);
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
		Box chooseButtonsBox = Box.createHorizontalBox();
		chooseButtonsBox.add(Box.createVerticalStrut(20));
		chooseButtonsBox.add(Box.createHorizontalGlue());
		chooseButtonsBox.add(confirm);
		chooseButtonsBox.add(Box.createHorizontalStrut(10));
		chooseButtonsBox.add(cancel);
		chooseButtonsBox.add(Box.createHorizontalGlue());
        box.add(chooseButtonsBox);
        add(box);
	}

}
