package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import Controller.AddressController;
import Controller.StudentController;
import model.Address;
import model.Student;
import model.StudentStatus;

public class OutputStudent {

	public OutputStudent() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputStudent instance = null;
	
	public static OutputStudent getInstance() throws IOException {
		if (instance == null) {
			instance = new OutputStudent();
		}
		return instance;
	}
	public void WriteStudent(String file) throws IOException {
		File f = new File(file);
		String line = "";
		int i = 0;
		
		List<Address> listAddr = AddressController.getInstance().getAddrList();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Student> stList = StudentController.getInstance().getStudents();

		int j = 0;
		while(j < stList.size()) {
			line = stList.get(j).getIdStudent() + " ";
			line = line + stList.get(j).getIndexNumber() + " ";
			line = line + stList.get(j).getName() + " ";
			line = line + stList.get(j).getSurname() + " ";
			line = line + stList.get(j).getCurrentYear() + " ";
			if(stList.get(j).getDate_of_birth().getDayOfMonth() < 10)
				line = line + "0" + stList.get(j).getDate_of_birth().getDayOfMonth() + ".";
			else
				line = line + stList.get(j).getDate_of_birth().getDayOfMonth() + ".";
			if(stList.get(j).getDate_of_birth().getMonthValue() < 10)
				line = line + "0" + stList.get(j).getDate_of_birth().getMonthValue() + ".";
			else
				line = line + stList.get(j).getDate_of_birth().getMonthValue() + ".";
			line = line + stList.get(j).getDate_of_birth().getYear() + ". ";
			while(i < listAddr.size())
			{
				if(stList.get(j).getAddress().equals(",,,"))
				{
					line = line + "null ";
					break;
				}
				else 
				{
					if(stList.get(j).getAddress().equals(listAddr.get(i).getStreet() +"," + listAddr.get(i).getNumber() + "," + listAddr.get(i).getCity() + "," + listAddr.get(i).getState()))
					{
						line = line + "" + (i + 1) + " ";
						i = 0;
						break;
					}
				}
				i++;
				
			}
			String phone = "" + stList.get(j).getMobile_phone();
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
			line = line + stList.get(j).getEmail() + " ";

			if(stList.get(j).getStatus() == StudentStatus.B)
			line = line + "B ";
			else
			line = line + "S ";
				
			line = line + stList.get(j).getEntryYear();
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
