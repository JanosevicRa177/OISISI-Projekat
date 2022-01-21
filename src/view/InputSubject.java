package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Controller.ProfessorController;
import Controller.SubjectController;
import model.KindOfSemester;
import model.Subject;

public class InputSubject {

	public InputSubject() {
		// TODO Auto-generated constructor stub
	}
	public static void ReadSubject(String file) throws IOException {
		File f = new File(file);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
			String[] subject = line.split(",");
			if(subject[6].equals("ZIMSKI")) {
				if(subject[5].equals("null")) {
					SubjectController.getInstance().addSubject(new Subject(subject[1],subject[2],
							KindOfSemester.Winter,Integer.parseInt(subject[3]),Integer.parseInt(subject[4]),0,Integer.parseInt(subject[0])));
				}else {
					SubjectController.getInstance().addSubject(new Subject(subject[1],subject[2],
							KindOfSemester.Winter,Integer.parseInt(subject[3]),Integer.parseInt(subject[4]),Integer.parseInt(subject[5]),Integer.parseInt(subject[0])));
					ProfessorController.getInstance().addSubjProff(Integer.parseInt(subject[5]),Integer.parseInt(subject[0]));
				}
			}else {
				if(subject[5].equals("null")) {
					SubjectController.getInstance().addSubject(new Subject(subject[1],subject[2],
					KindOfSemester.Summer,Integer.parseInt(subject[3]),Integer.parseInt(subject[4]),0,Integer.parseInt(subject[0])));
				}else {
					SubjectController.getInstance().addSubject(new Subject(subject[1],subject[2],
							KindOfSemester.Summer,Integer.parseInt(subject[3]),Integer.parseInt(subject[4]),Integer.parseInt(subject[5]),Integer.parseInt(subject[0])));
					ProfessorController.getInstance().addSubjProff(Integer.parseInt(subject[5]),Integer.parseInt(subject[0]));
				}
			}
		}
	} finally {
			reader.close();
		}
	}
}
