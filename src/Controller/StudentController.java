package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Student;
import view.MainFrame;
import view.MarkBase;
import view.ProfessorBase;
import view.StudentBase;
import view.StudentTable;
import view.SubjectBase;

public class StudentController {
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	public void calculateAvgGrade() {
		StudentBase.getInstance().calculateAvgGrade();
	}
	public void addPassedSubject(int student,int subject) {
		StudentBase.getInstance().addPassedSubject(student, subject);
	}
	public void addUnpassedSubject(int student,int subject) {
		StudentBase.getInstance().addUnpassedSubject(student, subject);
	}
	public int getYear()
	{
		return StudentBase.getInstance().getYear();
	}
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	public Student findSelectedStudent(int row) {
		return StudentBase.getInstance().getAllStudents().get(row);
	}
	public void passTest(int subject) {
		int studentNum = StudentTable.getInstance().getSelectedIndex();
		StudentBase.getInstance().getAllStudents().get(studentNum).passSubject(subject);
		SubjectBase.getInstance().getSubjects().get(subject).addStudentsWhoPassed(StudentBase.getInstance().getAllStudents().get(studentNum).getIdStudent());
	}
	public void unpassTest(int subject) {
		int studentNum = StudentTable.getInstance().getSelectedIndex();
		StudentBase.getInstance().getAllStudents().get(studentNum).unpassSubject(subject);
		SubjectBase.getInstance().getSubjects().get(subject).addStudentsWhoDidntPass(StudentBase.getInstance().getAllStudents().get(studentNum).getIdStudent());
	}
	public void searchStudent(String search) {
		StudentBase.getInstance().searchStudents(search);
	}
	public int getID() {
		return StudentBase.getInstance().getID();
	}
	public void addStudent(Student student) {
		StudentBase.getInstance().addStudent(student);
	}
	public List<Student> getStudents() {
		return StudentBase.getInstance().getStudents();
	}
	public void deleteStudent(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
        StudentDeleteDialog dialog = new StudentDeleteDialog(rowSelectedIndex);
        dialog.setVisible(true);
//    	Student student = StudentBase.getInstance().getRow(rowSelectedIndex);
//    	StudentBase.getInstance().deleteStudent(student.getIndexNumber());
	}
	public boolean containsStudent(String id) {
		return StudentBase.getInstance().containsadd(id);
	}
	public boolean containsUpdateStudent(String id, String oldId) {
		return StudentBase.getInstance().containsUpdate(id, oldId);
	}
	 public class StudentDeleteDialog extends JDialog{

	        private static final long serialVersionUID = 5312828189967818799L;
	        
	        public StudentDeleteDialog(int rowSelectedIndex) {
	            super(MainFrame.getInstance(), "Deleting Student", true);
	            Toolkit kit = Toolkit.getDefaultToolkit();
	            Dimension screenSize = kit.getScreenSize();
	            int width = screenSize.width;
	            int height = screenSize.height;
	            setSize(width*1/5, height*1/7);
	            setLocationRelativeTo(MainFrame.getInstance());
	            
	            JPanel DeleteStudent = new JPanel(new FlowLayout(FlowLayout.CENTER));
	            
	            JLabel DeleteTxt = new JLabel("Are you sure you want to delete student?");
	            DeleteStudent.add(DeleteTxt);
	            
	            JPanel Buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
	            Dimension dim = new Dimension(100, 25);
	            JButton delete = new JButton();
	            delete.setText("Delete");
	            delete.setPreferredSize(dim);
	            delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 Student student = StudentBase.getInstance().getRow(rowSelectedIndex);
		                StudentBase.getInstance().deleteStudent(student.getIndexNumber());
		                setVisible(false);
				}
	            });
	            Buttons.add(delete);
	            JButton cancel = new JButton();
	            cancel.setText("Cancel");
	            cancel.setPreferredSize(dim);
	            cancel.addActionListener(new ActionListener() {
	                
	                public void actionPerformed(ActionEvent e) {
	                    // TODO Auto-generated method stub
	                    setVisible(false);
	                }
	            });
	            Buttons.add(cancel);
	            DeleteStudent.add(Buttons);
	            this.add(DeleteStudent);
	        }
	    }
	 


}
