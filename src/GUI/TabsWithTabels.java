package GUI;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Professor.ProfessorTable;
import Subject.SubjectTable;


public class TabsWithTabels extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private static TabsWithTabels instance = null;
	private ProfessorTable professorTable;
	private SubjectTable subjectTable;
	private String FocusTable;
	
	public static TabsWithTabels getInstance() {
		if (instance == null) {
			instance = new TabsWithTabels();
		}
		return instance;
	}
	
	public TabsWithTabels() {
		// TODO Auto-generated constructor stub
		//FocusTable = "Students";
		professorTable = new ProfessorTable();
		subjectTable = new SubjectTable();
		addTab("Students",new JScrollPane());
		addTab("Professors", new JScrollPane(professorTable));
		addTab("Subjects",new JScrollPane(subjectTable));
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
