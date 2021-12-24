package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Subject.AbstractTableModelSubjects;
import Subject.SubjectTable;
import model.Subject;
import model.SubjectBase;

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
	

	
		
		public SubjectUpdateDialog(){
			super(MainFrame.getInstance(), "Update Subject", true);
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width*1/4 + 50,height*3/8 + 50);
			setLocationRelativeTo(MainFrame.getInstance());
			setTitle("Dodavanje Predmeta");
			
			JPanel addStudent = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension labelDim = new Dimension((width*1/4)/2, 30);
			Dimension inputDim = new Dimension((width*1/4+25)/2, 20);
			

			JPanel ID = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelID = new JLabel("Subject ID:");
			labelID.setPreferredSize(labelDim);
			inputID.setPreferredSize(inputDim);
			int row = SubjectTable.getInstance().getSelectedRow();
			AbstractTableModelSubjects model = (AbstractTableModelSubjects) SubjectTable.getInstance().getModel();
			inputID.setText(model.getValueAt(row,0).toString());
			
			ID.add(labelID);
			ID.add(inputID);
			addStudent.add(ID);
			this.add(addStudent);
			
			JPanel Name = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelName = new JLabel("Name:");
			labelName.setPreferredSize(labelDim);
			inputName.setPreferredSize(inputDim);
			inputName.setText(model.getValueAt(row,1).toString());
			
			Name.add(labelName);
			Name.add(inputName);
			addStudent.add(Name);
			this.add(addStudent);
			List<Subject> subjects = new ArrayList<Subject>();
			for(Subject st : SubjectBase.getInstance().getSubjects())
				subjects.add(st);
			
			
			
			JPanel Semester = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
			addStudent.add(Semester);
			this.add(addStudent);

			JPanel Execution = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelExecution = new JLabel("Execution:");
			labelExecution.setPreferredSize(labelDim);
			JTextField inputExecution = new JTextField();
			inputExecution.setPreferredSize(inputDim);
			inputExecution.setText(model.getValueAt(row,3).toString());
			
			Execution.add(labelExecution);
			Execution.add(inputExecution);
			addStudent.add(Execution);
			this.add(addStudent);
			
//			JPanel Prof = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			JLabel labelProf = new JLabel("Proffesor:");
//			labelProf.setPreferredSize(labelDim);
//			inputProf.setPreferredSize(inputDim);
//			Prof.add(labelProf);
//			Prof.add(inputProf);
//			addStudent.add(Prof);
//			this.add(addStudent);
//			
			JPanel Espb = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelEspb = new JLabel("Espb:");
			labelEspb.setPreferredSize(labelDim);
			inputEspb.setPreferredSize(inputDim);
			inputEspb.setText(model.getValueAt(row,2).toString());
			
			Espb.add(labelEspb);
			Espb.add(inputEspb);
			addStudent.add(Espb);
			this.add(addStudent);
			
			
			
			
//			JPanel Pass = new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//			JLabel labelPass = new JLabel("Pass:");
//			labelPass.setPreferredSize(labelDim);
//			JComboBox<String> comboPass = new JComboBox<String>();
//			comboPass.setPreferredSize(inputDim);
//			Pass.add(labelPass);
//			Pass.add(comboPass);
//			addStudent.add(Pass);
//			this.add(addStudent);
//			
//			
			JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension dim = new Dimension(100, 25);
			JButton add = new JButton();
			add.setText("Add");
			add.setPreferredSize(dim);
			buttons.add(add);
			
			buttons.add(Box.createHorizontalStrut(width/50));
			
			JButton cancel = new JButton();
			cancel.setText("Cancel");
			cancel.setPreferredSize(dim);
			buttons.add(cancel);
			
			addStudent.add(buttons);
			this.add(addStudent);
			
			add.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(getInputName().getText().equals("") | !getInputEspb().getText().matches("[0-9]+") |!getInputID().getText().matches("[0-9]+") |  inputExecution.getText().equals("") )
					{
						InputErrorDialog dialog = new InputErrorDialog();
						dialog.setVisible(true);
						return;
					}
					Subject s = new Subject();
					SubjectBase.getInstance().changeSubject(Integer.parseInt(inputID.getText()) , inputName.getText(),s.getEnum(comboSemester.getSelectedItem().toString()),Integer.parseInt(inputExecution.getText()), Integer.parseInt(inputEspb.getText()));
					int row = SubjectTable.getInstance().getSelectedRow();
					AbstractTableModelSubjects model = (AbstractTableModelSubjects)SubjectTable.getInstance().getModel();
					model.fireTableRowsUpdated(row, row);
					MainFrame.getInstance().validate();
					setVisible(false);
					
////					
					
			
					
				}
			});
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					
					
			
					
				}
			});

			
			
			
			
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
