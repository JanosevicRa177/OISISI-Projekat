package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Base.SubjectBase;
import model.Subject;
import view.MainFrame;

public class SubjectController {

	private static SubjectController instance = null;
	
	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	
	public SubjectController() {
		// TODO Auto-generated constructor stub
	}
	public void addUnpassedStudent(int student,int subject) {
		SubjectBase.getInstance().addUnpassedStudent(student, subject);
	}
	public void addSubject(Subject subject) {
		SubjectBase.getInstance().addSubject(subject);
	}
	public List<Subject> getAllSubjects()
	{
		return SubjectBase.getInstance().getSubjects();
	}
	public void deleteSubject(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	SubjectDeleteDialog dialog = new SubjectDeleteDialog(rowSelectedIndex);
		dialog.setVisible(true);
	}
	public class SubjectDeleteDialog extends JDialog{

		private static final long serialVersionUID = 5312828189967818799L;
		
		public SubjectDeleteDialog(int rowSelectedIndex) {
			super(MainFrame.getInstance(), "Deleting Subject", true);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width*1/5, height*1/7);
			setLocationRelativeTo(MainFrame.getInstance());
			
			JPanel DeleteProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
			
			JLabel DeleteTxt = new JLabel("Are you sure you want to delete subject?");
			DeleteProfessor.add(DeleteTxt);
			
			JPanel Buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension dim = new Dimension(100, 25);
			JButton delete = new JButton();
			delete.setText("Delete");
			delete.setPreferredSize(dim);
			delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Subject subject = SubjectBase.getInstance().getRow(rowSelectedIndex);
		    	SubjectBase.getInstance().deleteSubject(subject.getiDSubject());
				setVisible(false);
			}
			});
			Buttons.add(delete);
			JButton cancel = new JButton();
			cancel.setText("Cancel");
			cancel.setPreferredSize(dim);
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
			Buttons.add(cancel);
			DeleteProfessor.add(Buttons);
			this.add(DeleteProfessor);
		}
    }
}
