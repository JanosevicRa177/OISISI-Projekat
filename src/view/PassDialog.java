package view;

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MarkController;
import Controller.StudentController;
import model.Mark;
import model.Student;
import model.Subject;

public class PassDialog extends JDialog {

	private static final long serialVersionUID = -1704298397863393521L;

	public PassDialog() {
		// TODO Auto-generated constructor stub
		super(MainFrame.getInstance(), "Pass subject", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width*1/5+20, height*1/3);
		setLocationRelativeTo(MainFrame.getInstance());
		Box passSubject = Box.createVerticalBox();
		Dimension labelDim = new Dimension((width*1/6)/2, 20);
		Dimension buttonDim = new Dimension((width*1/8)/2, 30);
		Dimension inputDim = new Dimension((width*1/6+25)/2, 20);
		passSubject.add(Box.createVerticalStrut(10));
		
		int row = UnpassedSubjectTable.getInstance().getSelectedRow();
		int studentNum = StudentTable.getInstance().getSelectedIndex();
		Subject sub = SubjectBase.getInstance().getSubjectByIDNonRemove(StudentBase.getInstance().getAllStudents().get(studentNum).getUnpassedSubjects().get(row));
		JPanel idSubject = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextField idSubjectTxt = new JTextField();
		JLabel labelidSubject = new JLabel("Subject ID:");
		idSubjectTxt.setText(sub.getiDSubject());
		idSubjectTxt.setEditable(false);
		labelidSubject.setPreferredSize(labelDim);
		idSubjectTxt.setPreferredSize(inputDim);
		idSubject.add(labelidSubject);
		idSubject.add(idSubjectTxt);
		
		JPanel subjectName = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextField subjectNameTxt = new JTextField();
		JLabel labelsubjectName = new JLabel("Subject name:");
		subjectNameTxt.setText(sub.getSubjectName());
		subjectNameTxt.setEditable(false);
		labelsubjectName.setPreferredSize(labelDim);
		subjectNameTxt.setPreferredSize(inputDim);
		subjectName.add(labelsubjectName);
		subjectName.add(subjectNameTxt);
		
		
		JPanel gradePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		String[] types = { "6","7","8","9","10"};
		JLabel grade = new JLabel("Grade:");
		JComboBox<String> gradeCombo = new JComboBox<String>(types);
		grade.setPreferredSize(labelDim);
		gradeCombo.setPreferredSize(inputDim);
		gradePanel.add(grade);
		gradePanel.add(gradeCombo);
		
		JPanel	datePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextField date = new JTextField();
		JLabel dateTxt = new JLabel("Date (yyyy-mm-dd):");
		dateTxt.setPreferredSize(labelDim);
		date.setPreferredSize(inputDim);
		datePanel.add(dateTxt);
		datePanel.add(date);
		
		JPanel passButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
		JButton pass = new JButton();
		pass.setText("Pass");
		pass.setPreferredSize(buttonDim);
		pass.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(isValidDate(date.getText())) {
					String[] passDate = date.getText().split("-");
					int pass = UnpassedSubjectTable.getInstance().getSelectedRow();
					int studentNum = StudentTable.getInstance().getSelectedIndex();
					Student st = StudentBase.getInstance().getAllStudents().get(studentNum);
					MarkController.getInstance().addMark(new Mark(st.getIdStudent(),st.getUnpassedSubjects().get(pass),
							Integer.parseInt(gradeCombo.getSelectedItem().toString()),
							LocalDate.of(Integer.parseInt(passDate[0]),Integer.parseInt(passDate[1]),Integer.parseInt(passDate[2]))));
					StudentController.getInstance().passTest(pass);
					setVisible(false);
					}
				}
			});
		passButtons.add(pass);
		passButtons.add(Box.createHorizontalStrut(10));
		passButtons.add(cancel);
		
		passSubject.add(idSubject);
		passSubject.add(subjectName);
		passSubject.add(gradePanel);
		passSubject.add(datePanel);
		passSubject.add(passButtons);

		add(passSubject);
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
}
