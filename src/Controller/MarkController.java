package Controller;

import java.util.List;

import Base.MarkBase;
import Base.StudentBase;
import model.Mark;

public class MarkController {

	private static MarkController instance = null;
	
	public static MarkController getInstance() {
		if (instance == null) {
			instance = new MarkController();
		}
		return instance;
	}
	
	private MarkController() {
		// TODO Auto-generated constructor stub
	}
	public int getGrade(int student,int subject) {
		return MarkBase.getInstance().getGrade(student, subject);
	}
	public void removeMark(int student, int subject) {
		MarkBase.getInstance().removeMark(student,subject);
	}
	public void addMark(Mark mark) {
		MarkBase.getInstance().addMark(mark);
	}
	public Mark getMark(int id) {
		return MarkBase.getInstance().getMark(id);
	}
	public int getMarksLength() {
		return MarkBase.getInstance().getMarksLength();
	}
	public List<Mark> getAllMarks()
	{
		return MarkBase.getInstance().getMarks();
	}
}
