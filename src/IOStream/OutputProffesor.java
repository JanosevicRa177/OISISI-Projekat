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
import Controller.StudentController;
import model.Address;
import model.Desk;
import model.Professor;
import model.Student;
import model.StudentStatus;

public class OutputProffesor {
	public OutputProffesor() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputProffesor instance = null;
	
	public static OutputProffesor getInstance() throws IOException {
		if (instance == null) {
			instance = new OutputProffesor();
		}
		return instance;
	}
	public void WriteProffesor(String file) throws IOException {
		File f = new File(file);
		String line = "";
		int i = 0;
		int p = 0;
		
		List<Address> listAddr = AddressController.getInstance().getAddrList();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Professor> prList = ProfessorController.getInstance().getAllProf();
		List<Desk> dList = DeskController.getInstance().getAllDesks();
		int k = 0;

		int j = 0;
		while(j < prList.size()) {
			line = prList.get(j).getIDnumber() + " ";
			line = line + prList.get(j).getName() + " ";
			line = line + prList.get(j).getSurname() + " ";
			if(prList.get(j).getDate_of_birth().getDayOfMonth() < 10)
				line = line + "0" + prList.get(j).getDate_of_birth().getDayOfMonth() + ".";
			else
				line = line + prList.get(j).getDate_of_birth().getDayOfMonth() + ".";
			if(prList.get(j).getDate_of_birth().getMonthValue() < 10)
				line = line + "0" + prList.get(j).getDate_of_birth().getMonthValue() + ".";
			else
				line = line + prList.get(j).getDate_of_birth().getMonthValue() + ".";
			line = line + prList.get(j).getDate_of_birth().getYear() + ". ";
			while(i < listAddr.size())
			{
				if(prList.get(j).getAddress().equals(",,,"))
				{
					line = line + "null ";
					break;
				}
				else 
				{
					if(prList.get(j).getAddress().equals(listAddr.get(i).getStreet() +"," + listAddr.get(i).getNumber() + "," + listAddr.get(i).getCity() + "," + listAddr.get(i).getState()))
					{
						line = line + "" + (i + 1) + " ";
						i = 0;
						break;
					}
				}
				i++;
				
			}
			String phone = "" + prList.get(j).getMobile_phone();
			String newPhone = ""; 
			if(phone.length() == 8)
			{
			newPhone = newPhone + "0"  + phone.charAt(0) + phone.charAt(1);
			newPhone = newPhone + "/";
			newPhone = newPhone + phone.charAt(2) + phone.charAt(3) + phone.charAt(4);
			newPhone = newPhone + "-";
			newPhone = newPhone + phone.charAt(5) + phone.charAt(6) + phone.charAt(7);
			}
			else
			{
				newPhone = newPhone + "0"  + phone.charAt(0) + phone.charAt(1);
				newPhone = newPhone + "/";
				newPhone = newPhone + phone.charAt(2) + phone.charAt(3) + phone.charAt(4) + phone.charAt(5);
				newPhone = newPhone + "-";
				newPhone = newPhone + phone.charAt(6) + phone.charAt(7) + phone.charAt(8);
				
			}
			
			
			
			line = line + newPhone + " ";
			line = line + prList.get(j).getEmail() + " ";
			while(k < listAddr.size())
			{
				if(prList.get(j).getAddress().equals(",,,"))
				{
					line = line + "null ";
					break;
				}
				else 
				{
					if(prList.get(j).getOfficeAddress().equals(listAddr.get(k).getStreet() +"," + listAddr.get(k).getNumber() + "," + listAddr.get(k).getCity() + "," + listAddr.get(k).getState()))
					{
						line = line + "" + (k + 1) + " ";
						k = 0;
						break;
					}
				}
				k++;
				
			}
			line = line + prList.get(j).getYears_of_experience() + " ";
			line = line + prList.get(j).getTitle() + " ";
			while(p < dList.size())
			{
				
					if(prList.get(j).getOfficeAddress().equals(listAddr.get(k).getStreet() +"," + listAddr.get(k).getNumber() + "," + listAddr.get(k).getCity() + "," + listAddr.get(k).getState()))
					{
						line = line + "" + (p + 1) + " ";
						k = 0;
						break;
					}
				
				p++;
				
			}
			if(k == dList.size()) k = 0;
						
				
			
			
			writer.write(line);
			writer.write("\n");
			line = "";
			j++;
		}
		} finally {
			writer.close();
		}
	}

}
