package StudentManagement;

import java.util.ArrayList;

public class StudentService {

	    private ArrayList<Student> students = new ArrayList<Student>();

	    public void addStudent(Student student) {

	        for (Student s : students) {

	            if (s.getId() == student.getId()) {
	                System.out.println("Student ID already exists");
	                return;
	            }
	        }

	        students.add(student);
	        System.out.println("Student added successfully");
	    }

	    public void displayAllStudents() {

	        if (students.isEmpty()) {
	            System.out.println("No students available");
	            return;
	        }

	        for (Student s : students) {
	            System.out.println(s);
	        }
	    }

	    public Student searchById(int id) {

	        for (Student s : students) {

	            if (s.getId() == id) {
	                return s;
	            }
	        }

	        return null;
	    }

	    public void searchByName(String name) {

	        boolean found = false;

	        for (Student s : students) {

	            if (s.getName().equalsIgnoreCase(name)) {
	                System.out.println(s);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("Student not found");
	        }
	    }

	    public void updateMarks(int id, double marks) {

	        Student student = searchById(id);

	        if (student == null) {
	            System.out.println("Student not found");
	            return;
	        }

	        if (marks < 0 || marks > 100) {
	            System.out.println("Invalid marks");
	            return;
	        }

	        student.setMarks(marks);
	        System.out.println("Marks updated successfully");
	    }

	    public void updateAttendance(int id, int attendance) {

	        Student student = searchById(id);

	        if (student == null) {
	            System.out.println("Student not found");
	            return;
	        }

	        if (attendance < 0 || attendance > 100) {
	            System.out.println("Invalid attendance");
	            return;
	        }

	        student.setAttendance(attendance);
	        System.out.println("Attendance updated successfully");
	    }

	    public void calculateGrade(int id) {

	        Student student = searchById(id);

	        if (student == null) {
	            System.out.println("Student not found");
	            return;
	        }

	        System.out.println("Student Name : " + student.getName());
	        System.out.println("Marks       : " + student.getMarks());
	        System.out.println("Grade       : " + student.calculateGrade());
	    }

	    public void removeStudent(int id) {

	        Student student = searchById(id);

	        if (student == null) {
	            System.out.println("Student not found");
	            return;
	        }

	        students.remove(student);
	        System.out.println("Student removed successfully");
	    }

	    public void displayTopper() {

	        if (students.isEmpty()) {
	            System.out.println("No students available");
	            return;
	        }

	        Student topper = students.get(0);

	        for (Student s : students) {

	            if (s.getMarks() > topper.getMarks()) {
	                topper = s;
	            }
	        }

	        System.out.println("Topper");
	        System.out.println("------");
	        System.out.println(topper);
	    }

	    public ArrayList<Student> getStudents() {
	        return students;
	    }

	    public void setStudents(ArrayList<Student> students) {
	        this.students = students;
	    }
	}


