package Controller;


import model.Professor;
import model.ProfessorBase;

public class ProfessorController {

	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	
	public ProfessorController() {
		// TODO Auto-generated constructor stub
	}
	public void addProfessor(Professor professor) {
			ProfessorBase.getInstance().addProfessor(professor);
	}
    public void deleteProfessor(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Professor professor = ProfessorBase.getInstance().getRow(rowSelectedIndex);
    	ProfessorBase.getInstance().deleteProfessor(professor.getIDnumber());
    }

}
