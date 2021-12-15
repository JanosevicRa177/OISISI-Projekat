package GUI;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class TabsWithTabels extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private static TabsWithTabels instance = null;

	public static TabsWithTabels getInstance() {
		if (instance == null) {
			instance = new TabsWithTabels();
		}
		return instance;
	}
	
	public TabsWithTabels() {
		// TODO Auto-generated constructor stub
		ProfessorTable professorTable = new ProfessorTable();
		SubjectTable subjectTable = new SubjectTable();
		addTab("Students",new JScrollPane());
		addTab("Professors", new JScrollPane(professorTable));
		addTab("Subjects",new JScrollPane(subjectTable));
		setBackground(new Color(42, 101, 159));
	}
	
}
