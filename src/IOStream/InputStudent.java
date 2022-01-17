package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import Base.AddressBase;
import Base.StudentBase;
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
				
				String[] birth = student[4].split("\\.");
				String date = "" + birth[2] + "-" + birth[1] + "-" + birth[0];
				LocalDate localDate = LocalDate.parse(date);
				
				String[] phone = student[6].split("\\/");
				String[] phone1 = phone[1].split("-");
				int finalPhone = Integer.parseInt(phone[0] + phone1[0] + phone1[1]);
				
				Address address = new Address("","","","");
				
				if(student[8].equals("B")) {
					if(student[5].equals("null")) {
						StudentController.getInstance().addStudent(new Student(student[1],student[2],localDate,
							address,finalPhone,student[7],student[0], Integer.parseInt(student[9]),
							Integer.parseInt(student[3]),StudentStatus.B,9.32));
					} else {
						StudentController.getInstance().addStudent(new Student(student[1],student[2],localDate,
						AddressController.getInstance().getAddress(Integer.parseInt(student[5])-1),finalPhone,student[7],
						student[0], Integer.parseInt(student[9]),Integer.parseInt(student[3]),StudentStatus.B,9.32));
					}
				} else {
					if(student[5].equals("null")) {
						StudentController.getInstance().addStudent(new Student(student[1],student[2],localDate,
							address,finalPhone,student[7],student[0], Integer.parseInt(student[9]),
							Integer.parseInt(student[3]),StudentStatus.B,9.32));
					} else {
					StudentController.getInstance().addStudent(new Student(student[1],student[2],localDate,
						AddressController.getInstance().getAddress(Integer.parseInt(student[5])-1),finalPhone,student[7],
						student[0], Integer.parseInt(student[9]),Integer.parseInt(student[3]),StudentStatus.S,9.32));
						}
				}
			}
		} finally {
			reader.close();
		}
	}
}
