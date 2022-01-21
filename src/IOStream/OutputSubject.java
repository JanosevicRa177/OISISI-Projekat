package IOStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import Controller.MarkController;
import Controller.ProfessorController;
import Controller.SubjectController;
import model.KindOfSemester;
import model.Mark;
import model.Professor;
import model.StudentStatus;
import model.Subject;

public class OutputSubject {

	public static OutputSubject getInstance() throws IOException {
		if (instance == null) {
			
			instance = new OutputSubject();
		}
		return instance;
	}
	public OutputSubject() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputSubject instance = null;
	
	
	public void WriteSubjects(String file) throws IOException {
		File f = new File(file);
		String line = "";
		String check = "";
		int j = 0;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Subject> subjectList = SubjectController.getInstance().getAllSubjects();
		List<Professor> pList = ProfessorController.getInstance().getAllProf();

		while(j < subjectList.size()) {
			line = subjectList.get(j).getiDIntSubject() + ",";
			line = line + subjectList.get(j).getiDSubject() + ",";
			line = line + subjectList.get(j).getSubjectName() + ",";
			line = line + subjectList.get(j).getsubjectYearExecution() + ",";
			line = line + subjectList.get(j).getESPBvalue()  + ",";
			 
			if(subjectList.get(j).getProfessorOfSubject() != 0)
				line = line + subjectList.get(j).getProfessorOfSubject()  + ",";
			else
				line = line + "null"  + ",";
			if(subjectList.get(j).getSemesterkind() == KindOfSemester.Winter)
				line = line + "ZIMSKI";
			else
				line = line + "LETNJI";
		
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
