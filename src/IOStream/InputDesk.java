package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Base.DeskBase;
import Controller.DeskController;
import model.Desk;

public class InputDesk {

	public InputDesk() throws IOException{
		// TODO Auto-generated constructor stub
	}
	public static void ReadDesks(String file) throws IOException {
		File f = new File(file);
		String line = "";
		Desk deskNull = new Desk("","",-1,0);
		DeskBase.getInstance().addDesk(deskNull);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
				String[] desk = line.split(",");
				DeskController.getInstance().addDesk(new Desk(desk[1],desk[2],Integer.parseInt(desk[3]),Integer.parseInt(desk[0])));
				}
		} finally {
			reader.close();
		}
	}
}
