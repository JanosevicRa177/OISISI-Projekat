package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.ProfessorBase;
import Base.SubjectBase;
import Controller.ProfessorController;
import Controller.SubjectController;
import Subject.AbstractTableModelSubjects;
import Subject.SubjectTable;
import model.Professor;
import model.Subject;

public class SubjectUpdateDialog extends JDialog {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField inputName = new JTextField();
	private JTextField inputID = new JTextField();
	private JTextField inputEspb = new JTextField();
	private JTextField inputPass = new JTextField();
	private JTextField inputNotpass = new JTextField();
	private JTextField inputProf = new JTextField();
	private JTextField inputSemester = new JTextField();
	private JTextField inputprofessor = new JTextField();
	
		
	private static SubjectUpdateDialog instance = null;

	public static SubjectUpdateDialog getInstance() {
		if (instance == null) {
			instance = new SubjectUpdateDialog();
		}
		return instance;
	}
	
		public SubjectUpdateDialog(){
			super(MainFrame.getInstance(), "Update Subject", true);
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width*1/4 + 50,height*3/8 + 50);
			setLocationRelativeTo(MainFrame.getInstance());
			setTitle("Dodavanje Predmeta");
			
			JPanel updateSubject = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension labelDim = new Dimension((width*1/10)/2, 30);
			Dimension inputDim = new Dimension((width*1/3)/2, 20);
			
			JPanel ID = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelID = new JLabel("Subject ID:");
			labelID.setPreferredSize(labelDim);
			inputID.setPreferredSize(inputDim);
			int row = SubjectTable.getInstance().getSelectedIndex();
			AbstractTableModelSubjects model = (AbstractTableModelSubjects) SubjectTable.getInstance().getModel();
			inputID.setText(model.getValueAt(row,0).toString());
			
			ID.add(labelID);
			ID.add(inputID);
			updateSubject.add(ID);
			this.add(updateSubject);
			
			JPanel Name = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelName = new JLabel("Name:");
			labelName.setPreferredSize(labelDim);
			inputName.setPreferredSize(inputDim);
			inputName.setText(model.getValueAt(row,1).toString());
			
			Name.add(labelName);
			Name.add(inputName);
			updateSubject.add(Name);
			this.add(updateSubject);
			List<Subject> subjects = new ArrayList<Subject>();
			for(Subject st : SubjectBase.getInstance().getSubjects())
				subjects.add(st);
			
			
			
			JPanel Semester = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelSemester = new JLabel("Semester:");
			String[] types = { "Letnji", "Zimski"};
			labelSemester.setPreferredSize(labelDim);
			JComboBox<String> comboSemester = new JComboBox<String>(types);
			comboSemester.setPreferredSize(inputDim);
			inputSemester.setText(model.getValueAt(row,4).toString());
			String stat = "" + subjects.get(row).getSemesterkind();
			if(stat.equals("Summer"))
				comboSemester.setSelectedIndex(0);
			else
				comboSemester.setSelectedIndex(1);
			
			
			Semester.add(labelSemester);
			Semester.add(comboSemester);
			updateSubject.add(Semester);
			this.add(updateSubject);

			JPanel Execution = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelExecution = new JLabel("Execution:");
			labelExecution.setPreferredSize(labelDim);
			JTextField inputExecution = new JTextField();
			inputExecution.setPreferredSize(inputDim);
			inputExecution.setText(model.getValueAt(row,3).toString());
			
			Execution.add(labelExecution);
			Execution.add(inputExecution);
			updateSubject.add(Execution);
			this.add(updateSubject);
					
			JPanel Espb = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelEspb = new JLabel("Espb:");
			labelEspb.setPreferredSize(labelDim);
			inputEspb.setPreferredSize(inputDim);
			inputEspb.setText(model.getValueAt(row,2).toString());
			
			Espb.add(labelEspb);
			Espb.add(inputEspb);
			updateSubject.add(Espb);
			this.add(updateSubject);
			
//			Box professorOfSubject = Box.createVerticalBox();
			JPanel professorOfSubject = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel buttonsAddProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
			
			Dimension inputDim2 = new Dimension((width*1/5)/2, 20);
			JPanel professor = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelProfessor = new JLabel("Professor:");
			labelProfessor.setPreferredSize(labelDim);
			inputprofessor.setPreferredSize(inputDim2);
			int subject = SubjectTable.getInstance().getSelectedIndex();
			Subject sub = SubjectBase.getInstance().getSubjects().get(subject);
			int profInt = sub.getProfessorOfSubject();
			if(profInt != 0) {
			Professor prof = ProfessorBase.getInstance().getProfessors().get(profInt-1);
			inputprofessor.setText(prof.getName() + " " + prof.getSurname());
			}
			professor.add(labelProfessor);
			professor.add(Box.createHorizontalStrut(20));
			professor.add(inputprofessor);
			inputprofessor.setEnabled(false);
			updateSubject.add(professor);

			JButton Add = new JButton();
			ImageIcon Add_icon = new ImageIcon("images/Add.png");
			Image Scaled_Add_icon = Add_icon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon Add_icon_real = new ImageIcon(Scaled_Add_icon);
			Add.setIcon(Add_icon_real);
			Add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ChooseProfessorDialog dialog = new ChooseProfessorDialog();
					dialog.setVisible(true);
				}
			});
			JButton Remove = new JButton();
			ImageIcon Remove_icon = new ImageIcon("images/Minus.png");
			Image Scaled_Remove_icon = Remove_icon.getImage().getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon Remove_icon_real = new ImageIcon(Scaled_Remove_icon);
			Remove.setIcon(Remove_icon_real);
			Remove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int subject = SubjectTable.getInstance().getSelectedIndex();
					ProfessorController.getInstance().getAllProf().get(SubjectBase.getInstance().getSubjects().get(subject).getProfessorOfSubject()).add_Professors_subject(SubjectController.getInstance().getAllSubjects().get(subject));
					SubjectBase.getInstance().getSubjects().get(subject).removeProfessor();
					inputprofessor.setText("");
					
				}
				
			});
			buttonsAddProfessor.add(Add);
			buttonsAddProfessor.add(Remove);
			professorOfSubject.add(buttonsAddProfessor);
			updateSubject.add(professorOfSubject);
			
			
			
			JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension dim = new Dimension(60, 25);
			
			JButton add = new JButton();
			add.setText("Update");
			add.setSize(dim);
			add.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(getInputName().getText().equals("") | !getInputEspb().getText().matches("[0-9]+") |!getInputID().getText().matches("[A-Za-z0-9ŠĆĐŽČšćžđč]+") |  inputExecution.getText().equals("") )
					{
						InputErrorDialog dialog = new InputErrorDialog();
						dialog.setVisible(true);
						return;
					}
					Subject s = new Subject();
					SubjectBase.getInstance().changeSubject(inputID.getText() , inputName.getText(),s.getEnum(comboSemester.getSelectedItem().toString()),Integer.parseInt(inputExecution.getText()), Integer.parseInt(inputEspb.getText()));
					int row = SubjectTable.getInstance().getSelectedRow();
					AbstractTableModelSubjects model = (AbstractTableModelSubjects)SubjectTable.getInstance().getModel();
					model.fireTableRowsUpdated(row, row);
					MainFrame.getInstance().validate();
					setVisible(false);	
				}
			});
			buttons.add(add);
			
			buttons.add(Box.createHorizontalStrut(20));
			
			JButton cancel = new JButton();
			cancel.setText("Cancel");
			cancel.setSize(dim);
			this.add(updateSubject);
			
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
		
				}
			});
			buttons.add(cancel);
			
			updateSubject.add(buttons);
	
		}
		public void setProfessor(Professor prof) {
			inputprofessor.setText(prof.getName() + " " + prof.getSurname());
		}
		boolean isValidDate(String input) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		     try {
		          format.parse(input);
		          return true;
		     }
		     catch(ParseException e){
		          return false;
		     }
		}

		public JTextField getInputName() {
			return inputName;
		}

		public void setInputName(JTextField inputName) {
			this.inputName = inputName;
		}


		public JTextField getInputID() {
			return inputID;
		}

		public void setInputID(JTextField inputID) {
			this.inputID = inputID;
		}

		public JTextField getInputProf() {
			return inputProf;
		}

		public void setInputProf(JTextField inputProf) {
			this.inputProf = inputProf;
		}

		public JTextField getInputSemester() {
			return inputSemester;
		}

		public void setInputSemester(JTextField inputSemester) {
			this.inputSemester = inputSemester;
		}

		public JTextField getInputEspb() {
			return inputEspb;
		}

		public void setInputEspb(JTextField inputEspb) {
			this.inputEspb = inputEspb;
		}

		public JTextField getInputPass() {
			return inputPass;
		}

		public void setInputPass(JTextField inputPass) {
			this.inputPass = inputPass;
		}

		public JTextField getInputNotpass() {
			return inputNotpass;
		}

		public void setInputNotpass(JTextField inputNotpass) {
			this.inputNotpass = inputNotpass;
		}

		public JTextField getinputProf() {
			return inputProf;
		}

		public void setinputProf(JTextField inputProf) {
			this.inputProf = inputProf;
		}
		







}
