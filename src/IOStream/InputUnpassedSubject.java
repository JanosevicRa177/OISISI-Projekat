package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Controller.StudentController;
import Controller.SubjectController;

public class InputUnpassedSubject {

	public InputUnpassedSubject() {
		// TODO Auto-generated constructor stub
	}
	public static void ReadSubject(String file) throws IOException {
		File f = new File(file);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
			String[] unpassedSubject = line.split(" ");
			StudentController.getInstance().addUnpassedSubject(Integer.parseInt(unpassedSubject[0]), Integer.parseInt(unpassedSubject[1]));
			SubjectController.getInstance().addUnpassedStudent(Integer.parseInt(unpassedSubject[0]), Integer.parseInt(unpassedSubject[1]));
			}
		} finally {
			reader.close();
		}
	}
}
