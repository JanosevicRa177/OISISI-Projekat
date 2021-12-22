package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import Controller.StudentController;
import Student.AbstractTableModelStudents;
import Student.StudentTable;
import model.Address;
import model.Student;
import model.StudentBase;


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
	private JTextField inputBirth = new JTextField();
	

	
		
		public StudentAddDialog(){
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width*1/4 + 50,height*3/4 - 20);
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
			JLabel labelBirth = new JLabel("BirthDate:");
			labelBirth.setPreferredSize(labelDim);
			inputBirth.setPreferredSize(inputDim);
			BirthDate.add(labelBirth);
			BirthDate.add(inputBirth);
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
			String[] years = { "Prva (1)","Druga (2)", "Treca (3)", "Cetvrta (4)" };
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
					String[] adresa = inputAddress.getText().split(",");
					String cmb = currentList.getSelectedItem().toString();
					String[] birth = inputBirth.getText().split("-");
					Student temp = new Student();
					String stat = comboType.getSelectedItem().toString();
					
					
					String[] godina = cmb.split(" ");
					int god;
					if(godina[0].equals("Prva"))god = 1;
					else if(godina[0].equals("Druga"))god = 2;
					else if(godina[0].equals("Treca"))god = 3;
					else god = 4;
					int row = StudentTable.getInstance().getRowCount();
					
					
			        String date = "" + birth[0] + "-" + birth[1] + "-" + birth[2];

			        LocalDate localDate = LocalDate.parse(date);
			        Student student = new Student(getInputName().getText(),getInputSurname().getText(),localDate,
							new Address(adresa[0],adresa[1],adresa[2],adresa[3]),Integer.parseInt(getInputCell().getText()),getInputEmail().getText(),getInputIndex().getText(), Integer.parseInt(getInputYear().getText()),god,temp.getEnumByString(stat),9.12);
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
