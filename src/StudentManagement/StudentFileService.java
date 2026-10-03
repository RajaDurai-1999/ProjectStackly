package StudentManagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentFileService {
	    private String fileName ="students.dat";

	    public void saveStudents(ArrayList<Student> students) {

	        try {

	            FileOutputStream fos = new FileOutputStream(fileName);

	            ObjectOutputStream oos = new ObjectOutputStream(fos);

	            oos.writeObject(students);

	            oos.close();
	            fos.close();

	            System.out.println("Students saved successfully");

	        } catch (Exception e) {

	            System.out.println("Error while saving students");
	        }
	    }

	    public ArrayList<Student> loadStudents() {

	        try {

	            FileInputStream fis = new FileInputStream(fileName);

	            ObjectInputStream ois = new ObjectInputStream(fis);

	            ArrayList<Student> students =(ArrayList<Student>) ois.readObject();
	                   
	            ois.close();
	            fis.close();

	            return students;

	        } catch (Exception e) {

	            return new ArrayList<Student>();
	        }
	    }
	}


