package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import Controller.MarkController;
import Controller.StudentController;
import Controller.SubjectController;
import model.Mark;

public class InputMark {

	public InputMark() {
		// TODO Auto-generated constructor stub
	}
	public static void ReadMarks(String file) throws IOException {
		File f = new File(file);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
				String[] mark = line.split(" ");
				String[] passDate = mark[3].split("\\.");
				String date = "" + passDate[2] + "-" + passDate[1] + "-" + passDate[0];
				LocalDate localDate = LocalDate.parse(date);
				MarkController.getInstance().addMark(new Mark(Integer.parseInt(mark[0]),Integer.parseInt(mark[1]),Integer.parseInt(mark[2]),localDate));
				SubjectController.getInstance().addPassedStudent(Integer.parseInt(mark[0]),Integer.parseInt(mark[1]));
				StudentController.getInstance().addPassedSubject(Integer.parseInt(mark[0]),Integer.parseInt(mark[1]));
				}
		} finally {
			reader.close();
		}
	}
}
