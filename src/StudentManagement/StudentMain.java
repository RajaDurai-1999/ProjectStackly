package StudentManagement;

import java.util.Scanner;

public class StudentMain {
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        StudentService service = new StudentService();

	        StudentFileService fileService =
	                new StudentFileService();

	        service.setStudents(fileService.loadStudents());

	        int choice;

	        do {

	            System.out.println();
	            System.out.println(".....STUDENT MANAGEMENT SYSTEM.........");
	            System.out.println("1. Add Student");
	            System.out.println("2. Display All Students");
	            System.out.println("3. Search By ID");
	            System.out.println("4. Search By Name");
	            System.out.println("5. Update Marks");
	            System.out.println("6. Update Attendance");
	            System.out.println("7. Calculate Grade");
	            System.out.println("8. Remove Student");
	            System.out.println("9. Display Topper");
	            System.out.println("10. Save Students");
	            System.out.println("11. Exit");
	            System.out.print("Enter choice : ");
	            choice = sc.nextInt();

	            switch (choice) {

	            case 1:

	                System.out.print("Enter ID : ");
	                int id = sc.nextInt();

	                sc.nextLine();

	                System.out.print("Enter Name : ");
	                String name = sc.nextLine();

	                System.out.print("Enter Email : ");
	                String email = sc.nextLine();

	                System.out.print("Enter Marks : ");
	                double marks = sc.nextDouble();

	                System.out.print("Enter Attendance : ");
	                int attendance = sc.nextInt();

	                System.out.println("Select Status");
	                System.out.println("1. ACTIVE");
	                System.out.println("2. INACTIVE");
	                System.out.println("3. COMPLETED");

	                System.out.print("Enter status : ");
	                int statusChoice = sc.nextInt();

	                StudentStatus status;

	                if (statusChoice == 1) {
	                    status = StudentStatus.ACTIVE;
	                } else if (statusChoice == 2) {
	                    status = StudentStatus.INACTIVE;
	                } else if (statusChoice == 3) {
	                    status = StudentStatus.COMPLETED;
	                } else {
	                    System.out.println("Invalid status");
	                    break;
	                }

	                sc.nextLine();

	                System.out.print("Enter Course ID : ");
	                int courseId = sc.nextInt();

	                sc.nextLine();

	                System.out.print("Enter Course Name : ");
	                String courseName = sc.nextLine();

	                System.out.print("Enter Duration : ");
	                int duration = sc.nextInt();

	                if (marks < 0 || marks > 100) {
	                    System.out.println("Invalid marks");
	                    break;
	                }

	                if (attendance < 0 || attendance > 100) {
	                    System.out.println("Invalid attendance");
	                    break;
	                }

	                Course course = new Course(
	                        courseId,
	                        courseName,
	                        duration
	                );

	                Student student = new Student(id,name,email,marks,attendance,status,course);

	                service.addStudent(student);

	                break;

	            case 2:

	                service.displayAllStudents();

	                break;

	            case 3:

	                System.out.print("Enter ID : ");
	                id = sc.nextInt();

	                Student studentById = service.searchById(id);

	                if (studentById != null) {
	                    System.out.println(studentById);
	                } else {
	                    System.out.println("Student not found");
	                }

	                break;

	            case 4:

	                sc.nextLine();

	                System.out.print("Enter Name : ");
	                name = sc.nextLine();

	                service.searchByName(name);

	                break;

	            case 5:

	                System.out.print("Enter ID : ");
	                id = sc.nextInt();

	                System.out.print("Enter New Marks : ");
	                marks = sc.nextDouble();

	                service.updateMarks(id, marks);

	                break;

	            case 6:

	                System.out.print("Enter ID : ");
	                id = sc.nextInt();

	                System.out.print("Enter New Attendance : ");
	                attendance = sc.nextInt();

	                service.updateAttendance(id, attendance);

	                break;

	            case 7:

	                System.out.print("Enter ID : ");
	                id = sc.nextInt();

	                service.calculateGrade(id);

	                break;

	            case 8:

	                System.out.print("Enter ID : ");
	                id = sc.nextInt();

	                service.removeStudent(id);

	                break;

	            case 9:

	                service.displayTopper();

	                break;

	            case 10:

	                fileService.saveStudents(
	                        service.getStudents()
	                );

	                break;

	            case 11:

	                fileService.saveStudents(
	                        service.getStudents()
	                );

	                System.out.println("Thank you");

	                break;

	            default:

	                System.out.println("Invalid choice");
	            }

	        } while (choice != 11);

	        sc.close();
	    }
	}


