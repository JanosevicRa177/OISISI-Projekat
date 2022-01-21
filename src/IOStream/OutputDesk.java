package IOStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import Controller.AddressController;
import Controller.DeskController;
import Controller.ProfessorController;
import model.Address;
import model.Desk;
import model.Professor;

public class OutputDesk {
	public static OutputDesk getInstance() throws IOException {
		if (instance == null) {
			
			instance = new OutputDesk();
		}
		return instance;
	}
	public OutputDesk() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputDesk instance = null;
	
	
	public void WriteDesk(String file) throws IOException {
		File f = new File(file);
		String line = "";
		int j = 0;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Desk> deskList = DeskController.getInstance().getAllDesks();
		List<Professor> pList = ProfessorController.getInstance().getAllProf();

		while(j < deskList.size()) {
			line = deskList.get(j).getIdDesk() + ",";
			line = line + deskList.get(j).getDeskCode() + ",";
			line = line + deskList.get(j).getDeskName() + ",";
			line = line + deskList.get(j).getDeskChief();
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
