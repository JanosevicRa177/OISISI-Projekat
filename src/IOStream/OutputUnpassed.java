package IOStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import Controller.ProfessorController;
import Controller.StudentController;
import Controller.SubjectController;
import model.KindOfSemester;
import model.Professor;
import model.Student;
import model.Subject;

public class OutputUnpassed {
	public static OutputUnpassed getInstance() throws IOException {
		if (instance == null) {
			
			instance = new OutputUnpassed();
		}
		return instance;
	}
	public OutputUnpassed() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputUnpassed instance = null;
	
	
	public void WriteUnpassed(String file) throws IOException {
		File f = new File(file);
		String line = "";
		int j = 0;
		int k = 0;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Student> sList = StudentController.getInstance().getStudents();
		
		while(j < sList.size()) {
			List<Integer> subList = sList.get(j).getUnpassedSubjects();
			while(k < subList.size())
			{
				line = line + sList.get(j).getIdStudent() + " ";
				line = line +  subList.get(k);
				line = line + "\n";
				
				k++;
			}
			k = 0;
			j++;
			writer.write(line);
			
			line = "";
		}
		} finally {
			writer.close();
		}
	}

}
