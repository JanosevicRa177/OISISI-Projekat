package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentBase {
	
	
	private static StudentBase instance = null;
	
	public static StudentBase getInstance() {
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}
	private List<Student> students;
	private List<String> colons;
	
	public StudentBase() {
		this.students = new ArrayList<Student>();
		Student student = new Student("Pera","Peric",LocalDate.of(1994, 1, 20),
				new Address("Nikole Tesle",5,"Novi Sad","Srbija"),0601241252,"mejlpera@gmail.com",
				"ra123", 2005,2007,STATUS.B,9.32);
		students.add(student);
		Student studentt = new Student("Jova","Jovic",LocalDate.of(1994, 5, 5),
				new Address("JJZ",7,"Novi Sad","Srbija"),0612145421,"mejljova@gmail.com",
				"ra124", 2005,2007,STATUS.B,9.12);
		students.add(studentt);
		this.colons = new ArrayList<String>();
		this.colons.add("Index");
		this.colons.add("Name");
		this.colons.add("Surname");
		this.colons.add("YearOfStudying");
		this.colons.add("Status");
		this.colons.add("Prosek");

	}

	public int getColumnCount() {
		return 6;
	}
	public int getRowCount() {
		return students.size();
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public String getColumnName(int index) {
		return this.colons.get(index);
	}
	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		if (row >= students.size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			case 5:
				return "";
			default:
				return null;
			}
		
		} else {
			Student student = this.students.get(row);
			switch (column) {
			case 0:
				return student.getIndexNumber();
			case 1:
				return student.getName();
			case 2:
				return student.getSurname();
			case 3:
				return "" + student.getCurrentYear();
			case 4:
				return "" + student.getStatus();
			case 5:
				return "" + student.getAvgMark();
			default:
				return null;
			}
		}
	}
	public void setStudent(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

	public void deleteStudent(String index) {
		for (Student student : students) {
			if (student.getIndexNumber() == index) {
				students.remove(student);
				break;
			}
		}
	}

	public void changeStudent(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, String indexNumber, int entryYear, int currentYear, STATUS status,double avgMark, List<Mark> passedSubjects, List<Subject> unpassedSubjects) {
		for (Student student : students) {
			if (student.getIndexNumber() == indexNumber) {
				student.setName(name);
				student.setSurname(surname);
				student.setDate_of_birth(dateOfBirth);
				student.setAdress(address);
				student.setMobile_phone(mobilePhone);
				student.setEmail(email);
				student.setIndexNumber(indexNumber);
				student.setEntryYear(entryYear);
				student.setCurrentYear(currentYear);
				student.setStatus(status);
				student.setAvgMark(avgMark);
				student.setUnpassedSubjects(unpassedSubjects);
				student.setStatus(status);
			}
		}
	}

}
