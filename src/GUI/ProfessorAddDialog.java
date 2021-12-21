package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class ProfessorAddDialog extends JDialog{

	private static final long serialVersionUID = -4151970749929099461L;

	public ProfessorAddDialog() {
		super(MainFrame.getInstance(), "Adding Professor", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/4+50, height*3/4-50);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel addProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim1 = new Dimension((width*1/4)/2, 30);
		Dimension dim2 = new Dimension((width*1/4+25)/2, 20);
		
		JPanel Name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim1);
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(dim2);
		Name.add(lblName);
		Name.add(txtName);
		addProfessor.add(Name);
		
		JPanel Surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSurname = new JLabel("Surname*:");
		lblSurname.setPreferredSize(dim1);
		JTextField txtSurname = new JTextField();
		txtSurname.setPreferredSize(dim2);
		Surname.add(lblSurname);
		Surname.add(txtSurname);
		addProfessor.add(Surname);
		
		JPanel dateOfBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDateOfBirth = new JLabel("DateOfBirth*:");
		lblDateOfBirth.setPreferredSize(dim1);
		JTextField txtDateOfBirth= new JTextField();
		txtDateOfBirth.setPreferredSize(dim2);
		dateOfBirth.add(lblDateOfBirth);
		dateOfBirth.add(txtDateOfBirth);
		addProfessor.add(dateOfBirth);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAddress = new JLabel("Address*:");
		lblAddress.setPreferredSize(dim1);
		JTextField txtAddress = new JTextField();
		txtAddress.setPreferredSize(dim2);
		address.add(lblAddress);
		address.add(txtAddress);
		addProfessor.add(address);
		
		JPanel phoneNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhoneNumber = new JLabel("PhoneNumber*:");
		lblPhoneNumber.setPreferredSize(dim1);
		JTextField txtPhoneNumber = new JTextField();
		txtPhoneNumber.setPreferredSize(dim2);
		phoneNumber.add(lblPhoneNumber);
		phoneNumber.add(txtPhoneNumber);
		addProfessor.add(phoneNumber);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email*:");
		lblEmail.setPreferredSize(dim1);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim2);
		email.add(lblEmail);
		email.add(txtEmail);
		addProfessor.add(email);
		
		JPanel officeAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOfficeAddress = new JLabel("Office Address*:");
		lblOfficeAddress.setPreferredSize(dim1);
		JTextField txtOfficeAddress = new JTextField();
		txtOfficeAddress.setPreferredSize(dim2);
		officeAddress.add(lblOfficeAddress);
		officeAddress.add(txtOfficeAddress);
		addProfessor.add(officeAddress);
		
		JPanel iDnumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIDnumber = new JLabel("ID number*:");
		lblIDnumber.setPreferredSize(dim1);
		JTextField txtIDnumber = new JTextField();
		txtIDnumber.setPreferredSize(dim2);
		iDnumber.add(lblIDnumber);
		iDnumber.add(txtIDnumber);
		addProfessor.add(iDnumber);
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitle = new JLabel("Title*:");
		lblTitle.setPreferredSize(dim1);
		JTextField txtTitle = new JTextField();
		txtTitle.setPreferredSize(dim2);
		title.add(lblTitle);
		title.add(txtTitle);
		addProfessor.add(title);
		
		JPanel experienceYears = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblExperienceYears = new JLabel("Experience Years*:");
		lblExperienceYears.setPreferredSize(dim1);
		JTextField txtExperienceYears = new JTextField();
		txtExperienceYears.setPreferredSize(dim2);
		experienceYears.add(lblExperienceYears);
		experienceYears.add(txtExperienceYears);
		addProfessor.add(experienceYears);
		
		
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
		
		addProfessor.add(buttons);
		this.add(addProfessor);
	}
	
	

}
