package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import Controller.AddressController;
import Controller.StudentController;
import model.Address;
import model.Student;
import model.StudentStatus;

public class InputStudent {

	public InputStudent() throws IOException {
		// TODO Auto-generated constructor stub
	}
	public static void ReadStudents(String file) throws IOException {
		File f = new File(file);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
				String[] student = line.split(" ");
				
				String[] birth = student[5].split("\\.");
				String date = "" + birth[2] + "-" + birth[1] + "-" + birth[0];
				LocalDate localDate = LocalDate.parse(date);
				
				String[] phone = student[7].split("\\/");
				String[] phone1 = phone[1].split("-");
				int finalPhone = Integer.parseInt(phone[0] + phone1[0] + phone1[1]);
				
				Address address = new Address("","","","");
				if(student[9].equals("B")) {
					if(student[6].equals("null")) {
						StudentController.getInstance().addStudent(new Student(student[2],student[3],localDate,
							address,finalPhone,student[8],student[1], Integer.parseInt(student[10]),
							Integer.parseInt(student[4]),StudentStatus.B,0.0,Integer.parseInt(student[0])));
					} else {
						StudentController.getInstance().addStudent(new Student(student[2],student[3],localDate,
						AddressController.getInstance().getAddress(Integer.parseInt(student[6])-1),finalPhone,student[8],
						student[1], Integer.parseInt(student[10]),Integer.parseInt(student[4]),StudentStatus.B,0.0,Integer.parseInt(student[0])));
					}
				} else {
					if(student[6].equals("null")) {
						StudentController.getInstance().addStudent(new Student(student[2],student[3],localDate,
							address,finalPhone,student[8],student[1], Integer.parseInt(student[10]),
							Integer.parseInt(student[4]),StudentStatus.B,0.0,Integer.parseInt(student[0])));
					} else {
					StudentController.getInstance().addStudent(new Student(student[2],student[3],localDate,
						AddressController.getInstance().getAddress(Integer.parseInt(student[6])-1),finalPhone,student[8],
						student[1], Integer.parseInt(student[10]),Integer.parseInt(student[4]),StudentStatus.S,0.0,Integer.parseInt(student[0])));
						}
				}
			}
		} finally {
			reader.close();
		}
	}
}
