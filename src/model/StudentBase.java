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
	
	private StudentBase() {
		this.students = new ArrayList<Student>();
		Student student = new Student("mirko","mirkovic",LocalDate.of(2017, 1, 13),
				new Address("ulica",5,"beograd","srbija"),060,"nekiMail@gmail.com",
				new Address("ulica",5,"beograd","srbija"),567, "nastavnik",56.6);
		students.add(student);
		students.add(student);
		students.add(student);
		students.add(student);
		students.add(student);
		this.colons = new ArrayList<String>();
		this.colons.add("Index");
		this.colons.add("Name");
		this.colons.add("Surname");
		this.colons.add("YearOfStudying");
		this.colons.add("Status");
		this.colons.add("Prosek");

	}

	public int getColumnCount() {
		return 4;
	}
	public int getRowCount() {
		return students.size();
	}

	public List<Student> getProfessors() {
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
				return student.getCurrentYear();
			case 4:
				return student.getStatus();
			case 5:
				return student.getAvgMark();
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
