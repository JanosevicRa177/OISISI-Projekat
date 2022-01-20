package main;


import java.io.IOException;

import IOStream.InputAddress;
import IOStream.InputDesk;
import IOStream.InputMark;
import IOStream.InputProfessor;
import IOStream.InputStudent;
import IOStream.InputSubject;
import IOStream.InputUnpassedSubject;
import view.MainFrame;

public class MyApp {

	public static void main(String[] args) throws IOException {
		InputAddress.ReadAddresses("Addresses.txt");
		InputStudent.ReadStudents("Students.txt");
		InputDesk.ReadDesks("Desks.txt");
		InputProfessor.ReadProfessors("Professors.txt");
		InputSubject.ReadSubject("Subjects.txt");
		InputMark.ReadMarks("Marks.txt");
		InputUnpassedSubject.ReadSubject("UnpassedSubjects.txt");
		
		MainFrame.getInstance();
	}
}
