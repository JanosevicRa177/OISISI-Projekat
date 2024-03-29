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

import model.Professor;
import model.Student;
import model.Subject;
import view.ErrorDialogProfessorsChiefDialog;
import view.MainFrame;
import view.ProfessorBase;
import view.ProfessorTable;
import view.StudentBase;
import view.SubjectBase;
import view.SubjectTable;

public class ProfessorController {

	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	public ProfessorController() {
		// TODO Auto-generated constructor stub
	}
	public void removeSubjectofProfessor(Subject subject) {
		ProfessorBase.getInstance().removeSubjectofProfessor(subject);
	}
	public int getID() {
		return ProfessorBase.getInstance().getID();
	}
	public void addSubjProff(int i, int j)
	{
		ProfessorBase.getInstance().addSubjToProff(i, j);
	}
	public Professor findSelectedProffessor(int row) {
		return ProfessorBase.getInstance().getProfessors().get(row);
	}
	public void searchProfessor(String search) {
		ProfessorBase.getInstance().searchProfessor(search);
	}
	public List<Professor> DepartmentsBoss()
	{
		return ProfessorBase.getInstance().DepartmentsBoss();
	}
	public void addProfessor(Professor professor) {
			ProfessorBase.getInstance().addProfessor(professor);
	}
	public boolean containsProfessor(int id) {
		return ProfessorBase.getInstance().contains(id);
	}
	public boolean containsUpdateProfessor(int id, int oldId) {
		return ProfessorBase.getInstance().containsUpdate(id, oldId);
	}
	public List<Professor> getAllProf()
	{
		return ProfessorBase.getInstance().getProfessors();
	}
	
    public void deleteProfessor(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	ProfessorDeleteDialog dialog = new ProfessorDeleteDialog(rowSelectedIndex);
		dialog.setVisible(true);
    }

    public class ProfessorDeleteDialog extends JDialog{

		private static final long serialVersionUID = 5312828189967818799L;
		
		public ProfessorDeleteDialog(int rowSelectedIndex) {
			super(MainFrame.getInstance(), "Deleting Professor", true);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width*1/5, height*1/7);
			setLocationRelativeTo(MainFrame.getInstance());
			
			JPanel DeleteProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
			
			JLabel DeleteTxt = new JLabel("Are you sure you want to delete professor?");
			DeleteProfessor.add(DeleteTxt);
			
			JPanel Buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension dim = new Dimension(100, 25);
			JButton delete = new JButton();
			delete.setText("Delete");
			delete.setPreferredSize(dim);
			delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Professor professor = ProfessorBase.getInstance().getProfessors().get(ProfessorTable.getInstance().getSelectedIndex());
					if(DeskController.getInstance().contains(professor.getIdProf())) {
						ErrorDialogProfessorsChiefDialog dialog = new ErrorDialogProfessorsChiefDialog();
						dialog.setVisible(true);
						setVisible(false);
						return;
						}
			    	ProfessorBase.getInstance().deleteProfessor(professor.getIDnumber());
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
