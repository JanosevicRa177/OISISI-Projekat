package Base;

import java.util.ArrayList;
import java.util.List;

import model.Mark;

public class MarkBase {
private static MarkBase instance = null;
	
	public static MarkBase getInstance() {
		if (instance == null) {
			instance = new MarkBase();
		}
		return instance;
	}
	private List<Mark> marks;
	private MarkBase() {
		this.marks = new ArrayList<Mark>();
	}
	public void addMark(Mark mark) {
		marks.add(mark);
	}
	public Mark getMark(int id) {
		return marks.get(id);
	}
	public int getMarksLength() {
		return marks.size();
	}

}
