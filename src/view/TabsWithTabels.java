package view;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class TabsWithTabels extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private static TabsWithTabels instance = null;
	private String FocusTable;
	
	public static TabsWithTabels getInstance() {
		if (instance == null) {
			instance = new TabsWithTabels();
		}
		return instance;
	}
	
	private TabsWithTabels() {
		// TODO Auto-generated constructor stub
		FocusTable = "Students";
		addTab("Students",new JScrollPane(StudentTable.getInstance()));
		addTab("Professors", new JScrollPane(ProfessorTable.getInstance()));
		addTab("Subjects",new JScrollPane(SubjectTable.getInstance()));
		addChangeListener(new ChangeListenerTabs());
		setBackground(new Color(42, 101, 159));
	}
	public void focusOnProfessor() {
		FocusTable = "Professors";
	}
	public void focusOnStudent() {
		FocusTable = "Students";
	}
	public void focusOnSubject() {
		FocusTable = "Subjects";
	}
	public String getFocus() {
		return FocusTable;
	}
	
}
