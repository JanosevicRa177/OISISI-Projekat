package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ProfessorController;
import Professor.AbstractTableModelProfessors;
import Professor.ProfessorTable;
import model.Address;
import model.Professor;

public class ProfessorAddDialog extends JDialog{

	private static final long serialVersionUID = -4151970749929099461L;
	
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
	
	public ProfessorAddDialog() {
		super(MainFrame.getInstance(), "Adding Professor", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/3, height*3/4-50);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel addProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim1 = new Dimension((width*1/3)/2, 30);
		Dimension dim2 = new Dimension((width*1/4)/2, 20);
		
		JPanel Name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim1);
		txtName.setPreferredSize(dim2);
		txtName.setName("txtName");
		Name.add(lblName);
		Name.add(txtName);
		addProfessor.add(Name);
		
		JPanel Surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSurname = new JLabel("Surname*:");
		lblSurname.setPreferredSize(dim1);
		txtSurname.setPreferredSize(dim2);
		txtSurname.setName("txtSurname");
		Surname.add(lblSurname);
		Surname.add(txtSurname);
		addProfessor.add(Surname);
		
		JPanel dateOfBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDateOfBirth = new JLabel("DateOfBirth* (year-month-day):");
		lblDateOfBirth.setPreferredSize(dim1);
		txtDateOfBirth.setPreferredSize(dim2);
		txtDateOfBirth.setName("txtDateOfBirth");
		dateOfBirth.add(lblDateOfBirth);
		dateOfBirth.add(txtDateOfBirth);
		addProfessor.add(dateOfBirth);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAddress = new JLabel("Address* (Street,number,city,state):");
		lblAddress.setPreferredSize(dim1);
		txtAddress.setPreferredSize(dim2);
		txtAddress.setName("txtAddress");
		address.add(lblAddress);
		address.add(txtAddress);
		addProfessor.add(address);
		
		JPanel phoneNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhoneNumber = new JLabel("PhoneNumber*:");
		lblPhoneNumber.setPreferredSize(dim1);
		txtPhoneNumber.setPreferredSize(dim2);
		txtPhoneNumber.setName("txtPhoneNumber");
		phoneNumber.add(lblPhoneNumber);
		phoneNumber.add(txtPhoneNumber);
		addProfessor.add(phoneNumber);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email*:");
		lblEmail.setPreferredSize(dim1);
		txtEmail.setPreferredSize(dim2);
		txtEmail.setName("txtEmail");
		email.add(lblEmail);
		email.add(txtEmail);
		addProfessor.add(email);
		
		JPanel officeAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOfficeAddress = new JLabel("Office Address* (Street,number,city,state):");
		lblOfficeAddress.setPreferredSize(dim1);
		txtOfficeAddress.setPreferredSize(dim2);
		txtOfficeAddress.setName("txtOfficeAddress");
		officeAddress.add(lblOfficeAddress);
		officeAddress.add(txtOfficeAddress);
		addProfessor.add(officeAddress);
		
		JPanel iDnumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIDnumber = new JLabel("ID number*:");
		lblIDnumber.setPreferredSize(dim1);
		txtIDnumber.setPreferredSize(dim2);
		txtIDnumber.setName("txtIDnumber");
		iDnumber.add(lblIDnumber);
		iDnumber.add(txtIDnumber);
		addProfessor.add(iDnumber);
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitle = new JLabel("Title*:");
		lblTitle.setPreferredSize(dim1);
		txtTitle.setPreferredSize(dim2);
		txtTitle.setName("txtTitle");
		title.add(lblTitle);
		title.add(txtTitle);
		addProfessor.add(title);
		
		JPanel experienceYears = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblExperienceYears = new JLabel("Experience Years*:");
		lblExperienceYears.setPreferredSize(dim1);
		txtExperienceYears.setPreferredSize(dim2);
		txtExperienceYears.setName("txtExperienceYears");
		experienceYears.add(lblExperienceYears);
		experienceYears.add(txtExperienceYears);
		addProfessor.add(experienceYears);
		
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim = new Dimension(100, 25);
		JButton add = new JButton();
		add.setText("Add");
		add.setPreferredSize(dim);
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getTxtName().getText().equals("") | getTxtSurname().getText().equals("") | !isValidDate(getTxtDateOfBirth().getText()) | !getTxtAddress().getText().matches("[a-zA-Z( )]+,[a-zA-Z0-9( )]+,[a-zA-Z( )]+,[a-zA-Z( )]+") |
						!getTxtPhoneNumber().getText().matches("[0-9]+") | !getTxtOfficeAddress().getText().matches("[a-zA-Z( )]+,[a-zA-Z0-9( )]+,[a-zA-Z( )]+,[a-zA-Z( )]+") | !getTxtIDnumber().getText().matches("[0-9]+") |
						getTxtTitle().getText().equals("")| !getTxtExperienceYears().getText().matches("[0-9]+")) {
					InputErrorDialog dialog = new InputErrorDialog();
					dialog.setVisible(true);
					return;
				}
				System.out.println(txtName.getText());
				String[] address = txtAddress.getText().split(",");
				String[] oAddress = txtOfficeAddress.getText().split(",");
				int row = ProfessorTable.getInstance().getRowCount();
				Professor professor = new Professor(getTxtName().getText(),getTxtSurname().getText(),LocalDate.parse(getTxtDateOfBirth().getText()),
						new Address(address[0],address[1],address[2],address[3]),Integer.parseInt(getTxtPhoneNumber().getText()),
						getTxtEmail().getText(),new Address(oAddress[0],oAddress[1],oAddress[2],oAddress[3]),Integer.parseInt(getTxtIDnumber().getText()),
						getTxtTitle().getText(),Integer.parseInt(getTxtExperienceYears().getText()));
				ProfessorController.getInstance().addProfessor(professor);
				AbstractTableModelProfessors model = (AbstractTableModelProfessors) ProfessorTable.getInstance().getModel();
				model.fireTableRowsInserted(row, row);
				MainFrame.getInstance().validate();
				setVisible(false);
				
			}
		});
		buttons.add(add);
		
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
		
		addProfessor.add(buttons);
		this.add(addProfessor); 
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
