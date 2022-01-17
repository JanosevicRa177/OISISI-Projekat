package Base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.Student;
import model.StudentStatus;

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
		this.colons = new ArrayList<String>();
		this.colons.add("Index");
		this.colons.add("Name");
		this.colons.add("Surname");
		this.colons.add("YearOfStudying");
		this.colons.add("Status");
		this.colons.add("Prosek");

	}
	public void addUnpassedSubject(int student,int subject) {
		students.get(student-1).addUnpassedSubject(subject);
	}
	
	public void AddStudent(Student s) {
		students.add(s);
	}
	public boolean contains(String ID) {
		for(Student st : students) {
			if(st.getIndexNumber().equals(ID)) {
				return true;
			}
		}
		return false;
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
	public boolean containsadd(String ID) {
		for(Student st : students) {
			if(st.getIndexNumber().equals(ID)) {
				return true;
			}
		}
		return false;
	}
	public boolean containsUpdate(String ID,String oldID) {
		if(ID.equals(oldID)) {
			return false;
		}
		for(Student st : students) {
			if(st.getIndexNumber().equals(ID)) {
				return true;
			}
		}
		return false;
	}
	public List<Student> getAllStudents()
	{
		return students;
	}
	public void printStudente()
	{
		for(Student student : students)
		{
			System.out.println(student.getName());
		}
	}

	public void changeStudent(String name, String surname, LocalDate dateOfBirth, Address address, int mobilePhone,
			String email, String indexNumber, int entryYear, int currentYear, StudentStatus status,String oldID) {
		for (Student student : students) {
			if (student.getIndexNumber().equals(oldID)) {
				student.setName(name);
				student.setSurname(surname);
				student.setDate_of_birth(dateOfBirth);
				student.setAddress(address);
				student.setMobile_phone(mobilePhone);
				student.setEmail(email);
				student.setIndexNumber(indexNumber);
				student.setEntryYear(entryYear);
				student.setCurrentYear(currentYear);
				student.setStatus(status);

			}
		}
	}

}