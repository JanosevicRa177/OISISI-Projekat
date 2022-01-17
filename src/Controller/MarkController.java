package Controller;

import Base.MarkBase;
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
	public void addMark(Mark mark) {
		MarkBase.getInstance().addMark(mark);
	}
	public Mark getMark(int id) {
		return MarkBase.getInstance().getMark(id);
	}
	public int getMarksLength() {
		return MarkBase.getInstance().getMarksLength();
	}
}
