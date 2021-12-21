package Controller;

import model.Subject;
import model.SubjectBase;

public class SubjectController {

	private static SubjectController instance = null;
	
	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	
	public SubjectController() {
		// TODO Auto-generated constructor stub
	}
	public void addSubject(Subject subject) {
		SubjectBase.getInstance().addSubject(subject);
	}
	public void deleteSubject(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Subject subject = SubjectBase.getInstance().getRow(rowSelectedIndex);
    	SubjectBase.getInstance().deleteSubject(subject.getiDSubject());
	}
}
