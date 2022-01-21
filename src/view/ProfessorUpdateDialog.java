package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Controller.ProfessorController;
import Controller.SubjectController;
import model.Address;
import model.Professor;

public class ProfessorUpdateDialog extends JDialog{

	private static final long serialVersionUID = -5514489287735120552L;
	
	private JTextField txtName = new JTextField();
	private JTextField txtSurname = new JTextField();
	private JTextField txtDateOfBirth= new JTextField();
	private JTextField txtAddress = new JTextField();
	private JTextField txtPhoneNumber = new JTextField();
	private JTextField txtOfficeAddress = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtIDnumber = new JTextField();
	private JTextField txtTitle = new JTextField();
	private JTextField txtExperienceYears = new JTextField();
	public int oldID;
	JButton update = new JButton();
	
	public ProfessorUpdateDialog() {
		super(MainFrame.getInstance(), "Updating Professor", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		JTabbedPane informations = new JTabbedPane();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/3, height*3/4-50);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel updateProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim1 = new Dimension((width*1/3)/2, 30);
		Dimension dim2 = new Dimension((width*1/4)/2, 20);
		
		int row = ProfessorTable.getInstance().getSelectedIndex();
		if(row == -1) return;
		ProfessorBase professorsBase = ProfessorBase.getInstance();
		List<Professor> professors = professorsBase.getProfessors();
		
		JPanel Name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim1);
		txtName.setPreferredSize(dim2);
		txtName.setName("txtName");
		txtName.setText(professors.get(row).getName());
		Name.add(lblName);
		Name.add(txtName);
		txtName.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(Name);
		
		JPanel Surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSurname = new JLabel("Surname*:");
		lblSurname.setPreferredSize(dim1);
		txtSurname.setPreferredSize(dim2);
		txtSurname.setName("txtSurname");
		txtSurname.setText(professors.get(row).getSurname());
		Surname.add(lblSurname);
		Surname.add(txtSurname);
		txtSurname.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(Surname);
		
		JPanel dateOfBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDateOfBirth = new JLabel("DateOfBirth* (year-month-day):");
		lblDateOfBirth.setPreferredSize(dim1);
		txtDateOfBirth.setPreferredSize(dim2);
		txtDateOfBirth.setName("txtDateOfBirth");
		txtDateOfBirth.setText("" + professors.get(row).getDate_of_birth());
		dateOfBirth.add(lblDateOfBirth);
		dateOfBirth.add(txtDateOfBirth);
		txtDateOfBirth.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(dateOfBirth);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAddress = new JLabel("Address* (Street,number,city,state):");
		lblAddress.setPreferredSize(dim1);
		txtAddress.setPreferredSize(dim2);
		txtAddress.setName("txtAddress");
		txtAddress.setText(professors.get(row).getAddress());
		address.add(lblAddress);
		address.add(txtAddress);
		txtAddress.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(address);
		
		JPanel phoneNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhoneNumber = new JLabel("PhoneNumber*:");
		lblPhoneNumber.setPreferredSize(dim1);
		txtPhoneNumber.setPreferredSize(dim2);
		txtPhoneNumber.setName("txtPhoneNumber");
		txtPhoneNumber.setText("" + professors.get(row).getMobile_phone());
		phoneNumber.add(lblPhoneNumber);
		phoneNumber.add(txtPhoneNumber);
		txtPhoneNumber.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(phoneNumber);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email*:");
		lblEmail.setPreferredSize(dim1);
		txtEmail.setPreferredSize(dim2);
		txtEmail.setName("txtEmail");
		txtEmail.setText(professors.get(row).getEmail());
		email.add(lblEmail);
		email.add(txtEmail);
		txtEmail.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(email);
		
		JPanel officeAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOfficeAddress = new JLabel("Office Address* (Street,number,city,state):");
		lblOfficeAddress.setPreferredSize(dim1);
		txtOfficeAddress.setPreferredSize(dim2);
		txtOfficeAddress.setName("txtOfficeAddress");
		txtOfficeAddress.setText(professors.get(row).getOfficeAddress());
		officeAddress.add(lblOfficeAddress);
		officeAddress.add(txtOfficeAddress);
		txtOfficeAddress.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(officeAddress);
		
		JPanel iDnumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIDnumber = new JLabel("ID number*:");
		lblIDnumber.setPreferredSize(dim1);
		txtIDnumber.setPreferredSize(dim2);
		txtIDnumber.setName("txtIDnumber");
		txtIDnumber.setText("" + professors.get(row).getIDnumber());
		oldID = professors.get(row).getIDnumber();
		iDnumber.add(lblIDnumber);
		iDnumber.add(txtIDnumber);
		txtIDnumber.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(iDnumber);
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitle = new JLabel("Title*:");
		lblTitle.setPreferredSize(dim1);
		txtTitle.setPreferredSize(dim2);
		txtTitle.setName("txtTitle");
		txtTitle.setText(professors.get(row).getTitle());
		title.add(lblTitle);
		title.add(txtTitle);
		txtTitle.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(title);
		
		JPanel experienceYears = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblExperienceYears = new JLabel("Experience Years*:");
		lblExperienceYears.setPreferredSize(dim1);
		txtExperienceYears.setPreferredSize(dim2);
		txtExperienceYears.setName("txtExperienceYears");
		txtExperienceYears.setText("" + professors.get(row).getYears_of_experience());
		experienceYears.add(lblExperienceYears);
		experienceYears.add(txtExperienceYears);
		txtExperienceYears.addFocusListener(new AddProfessorFocusListener());
		updateProfessor.add(experienceYears);
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim = new Dimension(100, 25);
		update.setText("Update");
		update.setPreferredSize(dim);
		update.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getTxtName().getText().equals("") | getTxtSurname().getText().equals("") | !isValidDate(getTxtDateOfBirth().getText()) |
						!getTxtAddress().getText().matches("[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z0-9( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+") |
						!getTxtPhoneNumber().getText().matches("[0-9]+") | !getTxtOfficeAddress().getText().matches("[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z0-9( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+") |
						!getTxtIDnumber().getText().matches("[0-9]+") | getTxtTitle().getText().equals("")| !getTxtExperienceYears().getText().matches("[0-9]+")) {
					update.setEnabled(false);
					return;
				}
				if(ProfessorController.getInstance().containsUpdateProfessor(Integer.parseInt(getTxtIDnumber().getText()),oldID)) {
					InputErrorDialog dialog = new InputErrorDialog();
					dialog.setVisible(true);
					update.setEnabled(false);
					return;
				}
				String[] address = txtAddress.getText().split(",");
				String[] oAddress = txtOfficeAddress.getText().split(",");
				int row = ProfessorTable.getInstance().getSelectedIndex();
				Address addressInsert = new Address(address[0],address[1],address[2],address[3]);
				AddressBase.getInstance().addAddress(addressInsert);
				Address oAddressInsert = new Address(oAddress[0],oAddress[1],oAddress[2],oAddress[3]);
				AddressBase.getInstance().addAddress(oAddressInsert);
				ProfessorBase.getInstance().changeProfessor(getTxtName().getText(),getTxtSurname().getText(),LocalDate.parse(getTxtDateOfBirth().getText()),
						addressInsert,Integer.parseInt(getTxtPhoneNumber().getText()),
						getTxtEmail().getText(),oAddressInsert,Integer.parseInt(getTxtIDnumber().getText()),
						getTxtTitle().getText(),Integer.parseInt(getTxtExperienceYears().getText()),oldID);
				AbstractTableModelProfessors model = (AbstractTableModelProfessors) ProfessorTable.getInstance().getModel();
				model.fireTableRowsUpdated(row, row);
				MainFrame.getInstance().validate();
				setVisible(false);
			}
		});
		buttons.add(update);
		
		buttons.add(Box.createHorizontalStrut(width/50));
		
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setPreferredSize(dim);
		cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		buttons.add(cancel);
		
		updateProfessor.add(buttons);
		informations.add("Informations",updateProfessor);
		JPanel Subjects = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JScrollPane ProffSub =new JScrollPane(ProffSubjectsTable.getInstance());
		
		JPanel butons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addSub = new JButton();
		addSub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDialogSubjectProf ads = new AddDialogSubjectProf();
				ads.setVisible(true);
			}
		
		});
		addSub.setText("Add");
		addSub.setPreferredSize(dim);
		JButton denie = new JButton();
		denie.setText("Remove");
		denie.setPreferredSize(dim);
		denie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfessorController.getInstance().findSelectedProffessor(ProfessorTable.getInstance().getSelectedIndex()).delete_Professors_subject(SubjectController.getInstance().findSelectedSubject(ProffSubjectsTable.getInstance().getSelectedRow()));
				AbstractTableProffSubjects model = (AbstractTableProffSubjects) ProffSubjectsTable.getInstance().getModel();
				model.fireTableDataChanged();

				MainFrame.getInstance().validate();

			}
			
		});
		butons.add(addSub);
		butons.add(denie);
		Subjects.add(butons);
		Subjects.add(ProffSub);
		informations.addTab("Subjects",Subjects);
		this.add(informations); 
		
	}
	public class AddProfessorFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			if(getTxtName().getText().equals("") | getTxtSurname().getText().equals("") | !isValidDate(getTxtDateOfBirth().getText()) | !getTxtAddress().getText().matches("[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z0-9( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+") |
					!getTxtPhoneNumber().getText().matches("[0-9]+") | !getTxtOfficeAddress().getText().matches("[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z0-9( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+,[a-zA-Z( )ŠĆĐŽČšćžđč]+") | !getTxtIDnumber().getText().matches("[0-9]+") |
					getTxtTitle().getText().equals("")| !getTxtExperienceYears().getText().matches("[0-9]+")) {
				update.setEnabled(false);
				return;
			}
			
			update.setEnabled(true);
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
	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtSurname() {
		return txtSurname;
	}

	public JTextField getTxtDateOfBirth() {
		return txtDateOfBirth;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public JTextField getTxtPhoneNumber() {
		return txtPhoneNumber;
	}
	
	public JTextField getTxtOfficeAddress() {
		return txtOfficeAddress;
	}
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	
	public JTextField getTxtIDnumber() {
		return txtIDnumber;
	}
	
	public JTextField getTxtTitle() {
		return txtTitle;
	}
	
	public JTextField getTxtExperienceYears() {
		return txtExperienceYears;
	}

}
