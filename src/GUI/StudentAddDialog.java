package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.StudentController;
import Student.AbstractTableModelStudents;
import Student.StudentTable;
import model.Address;
import model.Student;

public class StudentAddDialog extends JFrame  {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField inputName = new JTextField();
	private JTextField inputSurname = new JTextField();
	private JTextField inputEmail = new JTextField();
	private JTextField inputIndex = new JTextField();
	private JTextField inputYear = new JTextField();
	private JTextField inputCell = new JTextField();
	private int help = 0;
	

	
		
		public StudentAddDialog(){
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width / 2;
			int height = screenSize.height;
			setSize(width*3/4,height*3/4);
			setLocationRelativeTo(MainFrame.getInstance());
			setTitle("Dodavanje Studenta");
			
			JPanel addStudent = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension labelDim = new Dimension((width*1/4)/2, 30);
			Dimension inputDim = new Dimension((width*1/4+25)/2, 20);
			
			
			JPanel Name = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelName = new JLabel("Name:");
			labelName.setPreferredSize(labelDim);
			inputName.setPreferredSize(inputDim);
			Name.add(labelName);
			Name.add(inputName);
			addStudent.add(Name);
			this.add(addStudent);
			
			JPanel Surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelSurname = new JLabel("Surname:");
			labelSurname.setPreferredSize(labelDim);
			inputSurname.setPreferredSize(inputDim);
			Surname.add(labelSurname);
			Surname.add(inputSurname);
			addStudent.add(Surname);
			this.add(addStudent);
			
			JPanel BirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelBirth = new JLabel("Surname:");
			labelBirth.setPreferredSize(labelDim);
			JTextField inputBirth = new JTextField();
			inputBirth.setPreferredSize(inputDim);
			BirthDate.add(labelSurname);
			BirthDate.add(inputSurname);
			addStudent.add(BirthDate);
			this.add(addStudent);
			
			JPanel Address = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelAddress = new JLabel("Address:");
			labelAddress.setPreferredSize(labelDim);
			JTextField inputAddress = new JTextField();
			inputAddress.setPreferredSize(inputDim);
			Address.add(labelAddress);
			Address.add(inputAddress);
			addStudent.add(Address);
			this.add(addStudent);
			
			JPanel CellNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelCell = new JLabel("Cell Phone:");
			labelCell.setPreferredSize(labelDim);
			inputCell.setPreferredSize(inputDim);
			CellNumber.add(labelCell);
			CellNumber.add(inputCell);
			addStudent.add(CellNumber);
			this.add(addStudent);
			
			JPanel Email = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelEmail = new JLabel("Email:");
			labelEmail.setPreferredSize(labelDim);
			inputEmail.setPreferredSize(inputDim);
			Email.add(labelEmail);
			Email.add(inputEmail);
			addStudent.add(Email);
			this.add(addStudent);
			
			JPanel Index = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelIndex = new JLabel("Index Number:");
			labelIndex.setPreferredSize(labelDim);
			inputIndex.setPreferredSize(inputDim);
			Index.add(labelIndex);
			Index.add(inputIndex);
			addStudent.add(Index);
			this.add(addStudent);
			
			JPanel Year = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelYear = new JLabel("Year of sign:");
			labelYear.setPreferredSize(labelDim);
			inputYear.setPreferredSize(inputDim);
			Year.add(labelYear);
			Year.add(inputYear);
			addStudent.add(Year);
			this.add(addStudent);
			
			JPanel Current = new JPanel(new FlowLayout(FlowLayout.LEFT));
			String[] years = { "Prva(1)","Druga(2)", "Treca(3)", "Cetvrta(4)" };
			JLabel labelCurrent = new JLabel("Current year:");
			labelCurrent.setPreferredSize(labelDim);
			JComboBox<String> currentList = new JComboBox<String>(years);
			currentList.setPreferredSize(inputDim);
			Current.add(labelCurrent);
			Current.add(currentList);
			addStudent.add(Current);
			this.add(addStudent);
			
			JPanel Type = new JPanel(new FlowLayout(FlowLayout.LEFT));
			String[] types = { "Budzet","Samofinansiranje"};
			JLabel labelType = new JLabel("Current year:");
			labelType.setPreferredSize(labelDim);
			JComboBox<String> comboType = new JComboBox<String>(types);
			comboType.setPreferredSize(inputDim);
			Type.add(labelType);
			Type.add(comboType);
			addStudent.add(Type);
			this.add(addStudent);
			
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
					System.out.println(inputName.getText());
					
					int row = StudentTable.getInstance().getRowCount();
					help = 1;
					Student student = new Student(getInputName().getText(),getInputSurname().getText(),LocalDate.of(1994, 5, 5),
							new Address("JJZ",7,"Novi Sad","Srbija"),Integer.parseInt(getInputCell().getText()),getInputEmail().getText(),getInputIndex().getText(), Integer.parseInt(getInputYear().getText()),2007,9.12);
					StudentController.getInstance().addStudent(student);
					AbstractTableModelStudents model = (AbstractTableModelStudents)StudentTable.getInstance().getModel();
					model.fireTableRowsInserted(row, row);
					MainFrame.getInstance().validate();
					setVisible(false);
					
					
			
					
				}
			});
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					
					
			
					
				}
			});

			
			
			
			
		}
		

		public int getHelp() {
			return help;
		}


		public void setHelp(int help) {
			this.help = help;
		}


		public JTextField getInputName() {
			return inputName;
		}

		public void setInputName(JTextField inputName) {
			this.inputName = inputName;
		}

		public JTextField getInputSurname() {
			return inputSurname;
		}

		public void setInputSurname(JTextField inputSurname) {
			this.inputSurname = inputSurname;
		}

		public JTextField getInputEmail() {
			return inputEmail;
		}

		public void setInputEmail(JTextField inputEmail) {
			this.inputEmail = inputEmail;
		}

		public JTextField getInputIndex() {
			return inputIndex;
		}

		public void setInputIndex(JTextField inputIndex) {
			this.inputIndex = inputIndex;
		}

		public JTextField getInputYear() {
			return inputYear;
		}

		public void setInputYear(JTextField inputYear) {
			this.inputYear = inputYear;
		}

		public JTextField getInputCell() {
			return inputCell;
		}

		public void setInputCell(JTextField inputCell) {
			this.inputCell = inputCell;
		}
		





	
	

}
