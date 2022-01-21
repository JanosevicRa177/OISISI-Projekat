package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import AddSubjects.AbstractAddSubjectsTable;
import AddSubjects.AddSubjectsTable;
import Base.AddressBase;
import Base.StudentBase;
import Base.SubjectBase;
import Controller.StudentController;
import Controller.SubjectController;
import PassedSubjects.PassedSubjectTable;
import Professor.AbstractTableModelProfessors;
import Professor.ProfessorTable;
import Student.AbstractTableModelStudents;
import Student.StudentTable;
import Subject.SubjectTable;
import UnpassedSubjects.AbstractTableModelUnpassedSubjects;
import UnpassedSubjects.UnpassedSubjectTable;
import model.Address;
import model.Student;

public class StudentUpdateDialog extends JDialog {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField inputName = new JTextField();
	private JTextField inputSurname = new JTextField();
	private JTextField inputEmail = new JTextField();
	private JTextField inputIndex = new JTextField();
	private JTextField inputYear = new JTextField();
	private JTextField inputCell = new JTextField();
	private JTextField inputBirth = new JTextField();
	private JTextField inputAddress = new JTextField();
	private JButton add = new JButton();
	private String oldID;
	
	private static StudentUpdateDialog instance = null;

	public static StudentUpdateDialog getInstance() {
		if (instance == null) {
			instance = new StudentUpdateDialog();
		}
		return instance;
	}
	
		
		public StudentUpdateDialog(){
			super(MainFrame.getInstance(), "Update Student", true);
			Box addStudent = Box.createVerticalBox();
			JTabbedPane informations = new JTabbedPane();
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setSize(width*1/3 + 50,height*3/4 - 20);
			setLocationRelativeTo(MainFrame.getInstance());
			setTitle("Izmena Studenta");
			
			Dimension labelDim = new Dimension((width*1/3)/2, 30);
			Dimension inputDim = new Dimension((width*1/4+25)/2, 20);
			
			
			JPanel Name = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelName = new JLabel("Name:");
			labelName.setPreferredSize(labelDim);
			inputName.setPreferredSize(inputDim);
			int row = StudentTable.getInstance().getSelectedIndex();
			AbstractTableModelStudents model = (AbstractTableModelStudents) StudentTable.getInstance().getModel();
			inputName.setText(model.getValueAt(row,1).toString());
			Name.add(labelName);
			Name.add(inputName);
			addStudent.add(Name);
			inputName.addFocusListener(new AddStudentFocusListener());
			
			List<Student> students = new ArrayList<Student>();
			students = StudentBase.getInstance().getStudents();
			JPanel Surname = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelSurname = new JLabel("Surname:");
			labelSurname.setPreferredSize(labelDim);
			inputSurname.setPreferredSize(inputDim);
			inputSurname.setText(model.getValueAt(row,2).toString());
			
			Surname.add(labelSurname);
			Surname.add(inputSurname);
			addStudent.add(Surname);

			inputSurname.addFocusListener(new AddStudentFocusListener());
			
			JPanel BirthDate = new JPanel(new FlowLayout(FlowLayout.CENTER));

			JLabel labelBirth = new JLabel("BirthDate (yyyy-mm-dd):");

			labelBirth.setPreferredSize(labelDim);

			inputBirth.setPreferredSize(inputDim);

			
			inputBirth.setText(students.get(row).getDate_of_birth().toString());

			BirthDate.add(labelBirth);
			BirthDate.add(inputBirth);
			addStudent.add(BirthDate);

			inputBirth.addFocusListener(new AddStudentFocusListener());
			
			
			JPanel Address = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelAddress = new JLabel("Address (Street,number,city,state):");
			labelAddress.setPreferredSize(labelDim);
			inputAddress.setPreferredSize(inputDim);
			inputAddress.setText(students.get(row).getAddress());
			Address.add(labelAddress);
			Address.add(inputAddress);
			addStudent.add(Address);

			inputAddress.addFocusListener(new AddStudentFocusListener());
			
			
			JPanel CellNumber = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelCell = new JLabel("Cell Phone:");
			labelCell.setPreferredSize(labelDim);
			inputCell.setPreferredSize(inputDim);

			inputCell.setText("" + students.get(row).getMobile_phone());
			CellNumber.add(labelCell);
			CellNumber.add(inputCell);
			addStudent.add(CellNumber);

			inputCell.addFocusListener(new AddStudentFocusListener());
			
			JPanel Email = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelEmail = new JLabel("Email:");
			labelEmail.setPreferredSize(labelDim);
			inputEmail.setPreferredSize(inputDim);
			inputEmail.setText(students.get(row).getEmail());
			Email.add(labelEmail);
			Email.add(inputEmail);
			addStudent.add(Email);
			
			JPanel Index = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelIndex = new JLabel("Index Number:");
			labelIndex.setPreferredSize(labelDim);
			inputIndex.setPreferredSize(inputDim);
			inputIndex.setText(model.getValueAt(row,0).toString());
			Index.add(labelIndex);
			Index.add(inputIndex);
			addStudent.add(Index);
			oldID = students.get(row).getIndexNumber();

			inputIndex.addFocusListener(new AddStudentFocusListener());
			
			JPanel Year = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelYear = new JLabel("Year of sign:");
			labelYear.setPreferredSize(labelDim);
			inputYear.setPreferredSize(inputDim);

			inputYear.setText("" + students.get(row).getEntryYear());
			Year.add(labelYear);
			Year.add(inputYear);
			addStudent.add(Year);

			inputYear.addFocusListener(new AddStudentFocusListener());
			
			JPanel Current = new JPanel(new FlowLayout(FlowLayout.CENTER));
			String[] years = { "Prva (1)","Druga (2)", "Treca (3)", "Cetvrta (4)" };
			JLabel labelCurrent = new JLabel("Current year:");
			labelCurrent.setPreferredSize(labelDim);
			JComboBox<String> currentList = new JComboBox<String>(years);
			currentList.setPreferredSize(inputDim);

			currentList.setSelectedIndex(Integer.parseInt(model.getValueAt(row,3).toString()) - 1);
			Current.add(labelCurrent);
			Current.add(currentList);
			addStudent.add(Current);

			
			JPanel Type = new JPanel(new FlowLayout(FlowLayout.CENTER));
			String[] types = { "Budzet","Samofinansiranje"};
			JLabel labelType = new JLabel("Status:");
			labelType.setPreferredSize(labelDim);
			JComboBox<String> comboType = new JComboBox<String>(types);
			comboType.setPreferredSize(inputDim);
			String stat = "" + students.get(row).getStatus();
			if(stat.equals("B"))
				comboType.setSelectedIndex(0);
			else
				comboType.setSelectedIndex(1);
			
			Type.add(labelType);
			Type.add(comboType);
			addStudent.add(Type);
			
			JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension dim = new Dimension(100, 25);
			add.setText("Add");
			add.setPreferredSize(dim);
			buttons.add(add);
			
			buttons.add(Box.createHorizontalStrut(width/50));
			
			JButton cancel = new JButton();
			cancel.setText("Cancel");
			cancel.setPreferredSize(dim);
			buttons.add(cancel);
			
			addStudent.add(buttons);
			
			add.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(getInputName().getText().equals("") | getInputSurname().getText().equals("") | !isValidDate(inputBirth.getText()) | !inputAddress.getText().matches("[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z0-9( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+") |
							!getInputCell().getText().matches("[0-9]+") |  getInputEmail().getText().equals("") |
							getInputIndex().getText().equals("")| !getInputYear().getText().matches("[0-9]+")) {
						
						add.setVisible(true);
						return;
					}
					if(StudentController.getInstance().containsUpdateStudent(inputIndex.getText(),oldID)) {
						InputErrorDialog dialog = new InputErrorDialog();
						dialog.setVisible(true);
						add.setEnabled(false);
						return;
					}
					String[] adresa = inputAddress.getText().split(",");
					String[] birth = inputBirth.getText().split("-");
					String cmb = currentList.getSelectedItem().toString();
					String[] godina = cmb.split(" ");
					String stat = comboType.getSelectedItem().toString();
					Student temp = new Student();
					int god;
					if(godina[0].equals("Prva"))god = 1;
					else if(godina[0].equals("Druga"))god = 2;
					else if(godina[0].equals("Treca"))god = 3;
					else god = 4;
					Address adresaInsert = new Address(adresa[0],adresa[1],adresa[2],adresa[3]);
					AddressBase.getInstance().addAddress(adresaInsert);
					StudentBase.getInstance().changeStudent(inputName.getText(), inputSurname.getText(), LocalDate.of(Integer.parseInt(birth[0]),Integer.parseInt(birth[1]),Integer.parseInt(birth[2])), adresaInsert, Integer.parseInt(inputCell.getText()), inputEmail.getText(), inputIndex.getText(), Integer.parseInt(inputYear.getText()), god,temp.getEnumByString(stat),oldID);
					int row = StudentTable.getInstance().getSelectedIndex();
					AbstractTableModelStudents model = (AbstractTableModelStudents)StudentTable.getInstance().getModel();
					model.fireTableRowsUpdated(row, row);
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
		informations.add("Informations",addStudent);
		JPanel unpassedSubjects = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel passedSubjects = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel buttonsUnpassed = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel buttonsPassed = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton addUnpassed = new JButton();
		addUnpassed.setText("Add");
		addUnpassed.setPreferredSize(dim);
		addUnpassed.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						AddDialogSubject sd = new AddDialogSubject();
						
						sd.setVisible(true);
						
						
					}
			
				});
		buttonsUnpassed.add(addUnpassed);
		
		JButton deleteUnpassed = new JButton();
		deleteUnpassed.setText("Delete");
		deleteUnpassed.setPreferredSize(dim);
		deleteUnpassed.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						StudentController.getInstance().findSelectedStudent(StudentTable.getInstance().getSelectedRow()).deleteUnpassedSubject(SubjectController.getInstance().findSelectedSubject(UnpassedSubjectTable.getInstance().getSelectedRow()).getiDIntSubject());
						AbstractTableModelUnpassedSubjects model = (AbstractTableModelUnpassedSubjects) UnpassedSubjectTable.getInstance().getModel();
						model.fireTableRowsDeleted(row, row);
						MainFrame.getInstance().validate();
					}
			
				});
		buttonsUnpassed.add(deleteUnpassed);
		
		JButton pass = new JButton();
		pass.setText("Pass");
		pass.setPreferredSize(dim);
		pass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int pass = UnpassedSubjectTable.getInstance().getSelectedRow();
				StudentController.getInstance().passTest(pass);
			}
			
		});
		buttonsUnpassed.add(pass);
		
		JButton dec = new JButton();
		dec.setText("Ponisti");
		dec.setPreferredSize(dim);
		dec.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				UnpassDialog dialog = new UnpassDialog();
				dialog.setVisible(true);
			}
			
		});
		buttonsPassed.add(dec);
		unpassedSubjects.add(buttonsUnpassed);
		JScrollPane unpassedSubjectsTable =new JScrollPane(UnpassedSubjectTable.getInstance());
		unpassedSubjects.add(unpassedSubjectsTable);
		informations.addTab("Unpassed subjects",unpassedSubjects);
		JScrollPane passedSubjectTable =new JScrollPane(PassedSubjectTable.getInstance());
		passedSubjects.add(buttonsPassed);
		passedSubjects.add(passedSubjectTable);
		int l = PassedSubjectTable.getInstance().getESPB();
		int ll = PassedSubjectTable.getInstance().getProsek();
		String lbl1 = "ESPB: ";
		String lbl2 = "Average grade: ";
		lbl2 = lbl2 + ll;
		lbl1 = lbl1 + l;
		JLabel lbl = new JLabel(lbl1);
		JLabel lbl3 = new JLabel(lbl2);
		
		Box passedInfo = Box.createHorizontalBox();
		passedInfo.add(Box.createVerticalStrut(20));
		passedInfo.add(Box.createHorizontalStrut(10));
		passedInfo.add(lbl);
		passedInfo.add(Box.createHorizontalStrut(10));
		passedInfo.add(lbl3);
		passedInfo.add(Box.createHorizontalGlue());
		passedSubjects.add(passedInfo);
		informations.addTab("Passed subjects",passedSubjects);
		this.add(informations);
			
		}
		public class AddStudentFocusListener implements FocusListener {

			@Override
			public void focusGained(FocusEvent arg0) {
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(getInputName().getText().equals("") | getInputSurname().getText().equals("") | !isValidDate(inputBirth.getText()) | !inputAddress.getText().matches("[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z0-9( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+") |
						!getInputCell().getText().matches("[0-9]+") |  getInputEmail().getText().equals("") |
						getInputIndex().getText().equals("")| !getInputYear().getText().matches("[0-9]+")) {
					add.setEnabled(false);
					return;
				}
				
				add.setEnabled(true);
			}
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
