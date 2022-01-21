package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import Controller.DeskController;
import Controller.MarkController;
import Controller.ProfessorController;
import model.Desk;
import model.Mark;
import model.Professor;

public class OutputMarks {
	public static OutputMarks getInstance() throws IOException {
		if (instance == null) {
			
			instance = new OutputMarks();
		}
		return instance;
	}
	public OutputMarks() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputMarks instance = null;
	
	
	public void WriteMarks(String file) throws IOException {
		File f = new File(file);
		String line = "";
		int j = 0;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Mark> markList = MarkController.getInstance().getAllMarks();
		List<Professor> pList = ProfessorController.getInstance().getAllProf();

		while(j < markList.size()) {
			line = markList.get(j).getStudentWhichPassExam() + " ";
			line = line + markList.get(j).get_Subject() + " ";
			line = line + markList.get(j).getMarkValue() + " ";
			if(markList.get(j).getDate().getDayOfMonth() < 10)
				line = line + "0" + markList.get(j).getDate().getDayOfMonth() + ".";
			else
				line = line + markList.get(j).getDate().getDayOfMonth()  + ".";
		
			if(markList.get(j).getDate().getMonthValue() < 10)
				line = line + "0" + markList.get(j).getDate().getMonthValue()  + ".";
			else
				line = line + markList.get(j).getDate().getMonthValue()  + ".";
			line = line + markList.get(j).getDate().getYear()  + ".";
		
		j++;
		writer.write(line);
		writer.write("\n");
		
		line = "";
		}
		} finally {
			writer.close();
		}
	}

}
