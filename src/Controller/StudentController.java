package Controller;

import model.Student;
import model.StudentBase;

public class StudentController {
	

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	public void addStudent(Student student) {
		StudentBase.getInstance().addStudent(student);
	}
	public void deleteStudent(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Student student = StudentBase.getInstance().getRow(rowSelectedIndex);
    	StudentBase.getInstance().deleteStudent(student.getIndexNumber());
	}

}
