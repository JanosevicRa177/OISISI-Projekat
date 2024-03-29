package main;


import java.io.IOException;

import Controller.StudentController;
import view.InputAddress;
import view.InputDesk;
import view.InputMark;
import view.InputProfessor;
import view.InputStudent;
import view.InputSubject;
import view.InputUnpassedSubject;
import view.MainFrame;

public class MyApp {

	public static void main(String[] args) throws IOException {
		InputAddress.ReadAddresses("Addresses.txt");
		InputStudent.ReadStudents("Students.txt");
		InputDesk.ReadDesks("Desks.txt");
		InputProfessor.ReadProfessors("Professors.txt");
		InputSubject.ReadSubject("Subjects.txt");
		InputMark.ReadMarks("Marks.txt");
		InputUnpassedSubject.ReadUnpassedSubject("UnpassedSubjects.txt");
		StudentController.getInstance().calculateAvgGrade();
		MainFrame.getInstance();
	}
}
