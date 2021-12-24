package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Professor.AbstractTableModelProfessors;
import Professor.ProfessorTable;
import model.Address;
import model.Professor;
import model.ProfessorBase;

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
	public ProfessorUpdateDialog() {
		super(MainFrame.getInstance(), "Updating Professor", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/3, height*3/4-50);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel updateProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim1 = new Dimension((width*1/3)/2, 30);
		Dimension dim2 = new Dimension((width*1/4)/2, 20);
		
		int row = ProfessorTable.getInstance().getSelectedRow();
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
		updateProfessor.add(Name);
		
		JPanel Surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSurname = new JLabel("Surname*:");
		lblSurname.setPreferredSize(dim1);
		txtSurname.setPreferredSize(dim2);
		txtSurname.setName("txtSurname");
		txtSurname.setText(professors.get(row).getSurname());
		Surname.add(lblSurname);
		Surname.add(txtSurname);
		updateProfessor.add(Surname);
		
		JPanel dateOfBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDateOfBirth = new JLabel("DateOfBirth* (year-month-day):");
		lblDateOfBirth.setPreferredSize(dim1);
		txtDateOfBirth.setPreferredSize(dim2);
		txtDateOfBirth.setName("txtDateOfBirth");
		txtDateOfBirth.setText("" + professors.get(row).getDate_of_birth());
		dateOfBirth.add(lblDateOfBirth);
		dateOfBirth.add(txtDateOfBirth);
		updateProfessor.add(dateOfBirth);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAddress = new JLabel("Address* (Street,number,city,state):");
		lblAddress.setPreferredSize(dim1);
		txtAddress.setPreferredSize(dim2);
		txtAddress.setName("txtAddress");
		txtAddress.setText(professors.get(row).getAdress());
		address.add(lblAddress);
		address.add(txtAddress);
		updateProfessor.add(address);
		
		JPanel phoneNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhoneNumber = new JLabel("PhoneNumber*:");
		lblPhoneNumber.setPreferredSize(dim1);
		txtPhoneNumber.setPreferredSize(dim2);
		txtPhoneNumber.setName("txtPhoneNumber");
		txtPhoneNumber.setText("" + professors.get(row).getMobile_phone());
		phoneNumber.add(lblPhoneNumber);
		phoneNumber.add(txtPhoneNumber);
		updateProfessor.add(phoneNumber);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email*:");
		lblEmail.setPreferredSize(dim1);
		txtEmail.setPreferredSize(dim2);
		txtEmail.setName("txtEmail");
		txtEmail.setText(professors.get(row).getEmail());
		email.add(lblEmail);
		email.add(txtEmail);
		updateProfessor.add(email);
		
		JPanel officeAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOfficeAddress = new JLabel("Office Address* (Street,number,city,state):");
		lblOfficeAddress.setPreferredSize(dim1);
		txtOfficeAddress.setPreferredSize(dim2);
		txtOfficeAddress.setName("txtOfficeAddress");
		txtOfficeAddress.setText(professors.get(row).getOfficeAddress());
		officeAddress.add(lblOfficeAddress);
		officeAddress.add(txtOfficeAddress);
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
		updateProfessor.add(iDnumber);
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitle = new JLabel("Title*:");
		lblTitle.setPreferredSize(dim1);
		txtTitle.setPreferredSize(dim2);
		txtTitle.setName("txtTitle");
		txtTitle.setText(professors.get(row).getTitle());
		title.add(lblTitle);
		title.add(txtTitle);
		updateProfessor.add(title);
		
		JPanel experienceYears = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblExperienceYears = new JLabel("Experience Years*:");
		lblExperienceYears.setPreferredSize(dim1);
		txtExperienceYears.setPreferredSize(dim2);
		txtExperienceYears.setName("txtExperienceYears");
		txtExperienceYears.setText("" + professors.get(row).getYears_of_experience());
		experienceYears.add(lblExperienceYears);
		experienceYears.add(txtExperienceYears);
		updateProfessor.add(experienceYears);
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim = new Dimension(100, 25);
		JButton update = new JButton();
		update.setText("Update");
		update.setPreferredSize(dim);
		update.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getTxtName().getText().equals("") | getTxtSurname().getText().equals("") | !isValidDate(getTxtDateOfBirth().getText()) | !getTxtAddress().getText().matches("[a-zA-Z( )]+,[a-zA-Z0-9( )]+,[a-zA-Z( )]+,[a-zA-Z( )]+") |
						!getTxtPhoneNumber().getText().matches("[0-9]+") | !getTxtOfficeAddress().getText().matches("[a-zA-Z( )]+,[a-zA-Z0-9( )]+,[a-zA-Z( )]+,[a-zA-Z( )]+") | !getTxtIDnumber().getText().matches("[0-9]+") |
						getTxtTitle().getText().equals("")| !getTxtExperienceYears().getText().matches("[0-9]+")| ProfessorBase.getInstance().containsUpdate(Integer.parseInt(getTxtIDnumber().getText()),oldID)) {
					InputErrorDialog dialog = new InputErrorDialog();
					dialog.setVisible(true);
					return;
				}
				String[] address = txtAddress.getText().split(",");
				String[] oAddress = txtOfficeAddress.getText().split(",");
				int row = ProfessorTable.getInstance().getSelectedRow();
				ProfessorBase.getInstance().changeProfessor(getTxtName().getText(),getTxtSurname().getText(),LocalDate.parse(getTxtDateOfBirth().getText()),
						new Address(address[0],address[1],address[2],address[3]),Integer.parseInt(getTxtPhoneNumber().getText()),
						getTxtEmail().getText(),new Address(oAddress[0],oAddress[1],oAddress[2],oAddress[3]),Integer.parseInt(getTxtIDnumber().getText()),
						getTxtTitle().getText(),Integer.parseInt(getTxtExperienceYears().getText()));
				AbstractTableModelProfessors model = (AbstractTableModelProfessors) ProfessorTable.getInstance().getModel();
				model.fireTableRowsInserted(row, row);
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
		this.add(updateProfessor); 
		
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
