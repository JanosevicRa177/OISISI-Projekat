package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
			if(subject[5].equals("ZIMSKI")) {
				if(subject[4].equals("null")) {
					SubjectController.getInstance().addSubject(new Subject(subject[0],subject[1],
							KindOfSemester.Winter,Integer.parseInt(subject[2]),Integer.parseInt(subject[3]),0));
				}else {
					SubjectController.getInstance().addSubject(new Subject(subject[0],subject[1],
							KindOfSemester.Winter,Integer.parseInt(subject[2]),Integer.parseInt(subject[3]),Integer.parseInt(subject[4])));
				}
			}else {
				if(subject[4].equals("null")) {
					SubjectController.getInstance().addSubject(new Subject(subject[0],subject[1],
					KindOfSemester.Summer,Integer.parseInt(subject[2]),Integer.parseInt(subject[3]),0));
				}else {
					SubjectController.getInstance().addSubject(new Subject(subject[0],subject[1],
							KindOfSemester.Summer,Integer.parseInt(subject[2]),Integer.parseInt(subject[3]),Integer.parseInt(subject[4])));
				}
			}
		}
	} finally {
			reader.close();
		}
	}
}
