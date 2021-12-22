package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		setSize(width*1/4+50, height*3/4-50);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel addProfessor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension dim1 = new Dimension((width*1/4)/2, 30);
		Dimension dim2 = new Dimension((width*1/4+25)/2, 20);
		
		JPanel Name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim1);
		txtName.setPreferredSize(dim2);
		txtName.setName("txtName");
		txtName.addFocusListener(new AddFocusListener());
		Name.add(lblName);
		Name.add(txtName);
		addProfessor.add(Name);
		
		JPanel Surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSurname = new JLabel("Surname*:");
		lblSurname.setPreferredSize(dim1);
		txtSurname.setPreferredSize(dim2);
		txtSurname.setName("txtSurname");
		txtSurname.addFocusListener(new AddFocusListener());
		Surname.add(lblSurname);
		Surname.add(txtSurname);
		addProfessor.add(Surname);
		
		JPanel dateOfBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDateOfBirth = new JLabel("DateOfBirth*:");
		lblDateOfBirth.setPreferredSize(dim1);
		txtDateOfBirth.setPreferredSize(dim2);
		txtDateOfBirth.setName("txtDateOfBirth");
		txtDateOfBirth.addFocusListener(new AddFocusListener());
		dateOfBirth.add(lblDateOfBirth);
		dateOfBirth.add(txtDateOfBirth);
		addProfessor.add(dateOfBirth);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAddress = new JLabel("Address*:");
		lblAddress.setPreferredSize(dim1);
		txtAddress.setPreferredSize(dim2);
		txtAddress.setName("txtAddress");
		txtAddress.addFocusListener(new AddFocusListener());
		address.add(lblAddress);
		address.add(txtAddress);
		addProfessor.add(address);
		
		JPanel phoneNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhoneNumber = new JLabel("PhoneNumber*:");
		lblPhoneNumber.setPreferredSize(dim1);
		txtPhoneNumber.setPreferredSize(dim2);
		txtPhoneNumber.setName("txtPhoneNumber");
		txtPhoneNumber.addFocusListener(new AddFocusListener());
		phoneNumber.add(lblPhoneNumber);
		phoneNumber.add(txtPhoneNumber);
		addProfessor.add(phoneNumber);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email*:");
		lblEmail.setPreferredSize(dim1);
		txtEmail.setPreferredSize(dim2);
		txtEmail.setName("txtEmail");
		txtEmail.addFocusListener(new AddFocusListener());
		email.add(lblEmail);
		email.add(txtEmail);
		addProfessor.add(email);
		
		JPanel officeAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOfficeAddress = new JLabel("Office Address*:");
		lblOfficeAddress.setPreferredSize(dim1);
		txtOfficeAddress.setPreferredSize(dim2);
		txtOfficeAddress.setName("txtOfficeAddress");
		txtOfficeAddress.addFocusListener(new AddFocusListener());
		officeAddress.add(lblOfficeAddress);
		officeAddress.add(txtOfficeAddress);
		addProfessor.add(officeAddress);
		
		JPanel iDnumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIDnumber = new JLabel("ID number*:");
		lblIDnumber.setPreferredSize(dim1);
		txtIDnumber.setPreferredSize(dim2);
		txtIDnumber.setName("txtIDnumber");
		txtIDnumber.addFocusListener(new AddFocusListener());
		iDnumber.add(lblIDnumber);
		iDnumber.add(txtIDnumber);
		addProfessor.add(iDnumber);
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitle = new JLabel("Title*:");
		lblTitle.setPreferredSize(dim1);
		txtTitle.setPreferredSize(dim2);
		txtTitle.setName("txtTitle");
		txtTitle.addFocusListener(new AddFocusListener());
		title.add(lblTitle);
		title.add(txtTitle);
		addProfessor.add(title);
		
		JPanel experienceYears = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblExperienceYears = new JLabel("Experience Years*:");
		lblExperienceYears.setPreferredSize(dim1);
		txtExperienceYears.setPreferredSize(dim2);
		txtExperienceYears.setName("txtExperienceYears");
		txtExperienceYears.addFocusListener(new AddFocusListener());
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
				System.out.println(txtName.getText());
				String[] address = txtAddress.getText().split(",");
				System.out.println(address);
				String[] oAddress = txtOfficeAddress.getText().split(",");
				int row = ProfessorTable.getInstance().getRowCount();
				Professor professor = new Professor(getTxtName().getText(),getTxtSurname().getText(),LocalDate.parse(getTxtDateOfBirth().getText()),
						new Address(address[0],address[1],address[2],address[3]),Integer.parseInt(getTxtPhoneNumber().getText()),
						getTxtEmail().getText(),new Address(oAddress[0],oAddress[1],oAddress[2],oAddress[3]),Integer.parseInt(getTxtIDnumber().getText()),
						getTxtTitle().getText(),Double.parseDouble(getTxtExperienceYears().getText()));
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
	
	public class AddFocusListener implements FocusListener {
		String focusedTxt;
		@Override
		public void focusGained(FocusEvent arg0) {

			JTextField txt = (JTextField) arg0.getComponent();
			focusedTxt = txt.getName();
			txt.setBackground(Color.WHITE);

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setBackground(Color.GRAY);
			if (txt.getName().equals(focusedTxt)) {
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite Vrednost...")) {
					txt.setText("Unesite Vrednost...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
	}
	
}
