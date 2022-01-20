package Base;

import java.util.ArrayList;
import java.util.List;

import model.Mark;
import model.Subject;

public class MarkBase {
private static MarkBase instance = null;
	
	public static MarkBase getInstance() {
		if (instance == null) {
			instance = new MarkBase();
		}
		return instance;
	}
	private List<Mark> marks;
	private List<String> colons;
	
	private MarkBase() {
		this.marks = new ArrayList<Mark>();
		this.colons = new ArrayList<String>();
		this.colons.add("Students passed");
		this.colons.add("Subject");
		this.colons.add("Mark");
		this.colons.add("Date");
	}
	
	public Mark getMarkByStudentAndSubject(int st, int sb)
	{
		Mark mark = new Mark();
		for(Mark m : marks)
		{
			if((m.get_Subject() == sb) && (m.getStudentWhichPassExam() == st))
					{
						mark = m;
						break;
					}
		}
		return mark;
		
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
	public List<Mark> getMarks()
	{
		return marks;
	}
	public int getColumnCount() {
		return 4;
	}
	public int getRowCount() {
		return marks.size();
	}
	public String getColumnName(int index) {
		return this.colons.get(index);
	}

}
