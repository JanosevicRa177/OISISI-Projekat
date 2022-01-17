package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import Controller.AddressController;
import Controller.ProfessorController;
import model.Professor;

public class InputProfessor {

	public InputProfessor() throws IOException {
		// TODO Auto-generated constructor stub
	}
	public static void ReadProfessors(String file) throws IOException {
		File f = new File(file);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
			String[] professor = line.split(" ");
			
			String[] birth = professor[3].split("\\.");
			String date = "" + birth[2] + "-" + birth[1] + "-" + birth[0];
			LocalDate localDate = LocalDate.parse(date);
			
			String[] phone = professor[5].split("\\/");
			String[] phone1 = phone[1].split("-");
			int finalPhone = Integer.parseInt(phone[0] + phone1[0] + phone1[1]);
			
			ProfessorController.getInstance().addProfessor(new Professor(professor[1],professor[2],localDate,
					AddressController.getInstance().getAddress(Integer.parseInt(professor[4])-1),finalPhone,professor[6],
					AddressController.getInstance().getAddress(Integer.parseInt(professor[7])-1),Integer.parseInt(professor[0]), professor[9],
					Integer.parseInt(professor[8])));
			}
		} finally {
			reader.close();
		}
	}
}
