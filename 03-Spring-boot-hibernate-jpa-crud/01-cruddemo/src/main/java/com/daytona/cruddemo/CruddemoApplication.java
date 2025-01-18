package com.daytona.cruddemo;

import com.daytona.cruddemo.dao.StudentDAO;
import com.daytona.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);\
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all record..");
		int numOfRowDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count" +numOfRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrive student based on the id: primaryKey
		int studentId=2;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);

		//change the lastName to "Don"
		System.out.println("Updating the student....");
		myStudent.setLastName("PinkMan");

		// update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findByLastName("Snow");

		//print a list of students
		for(Student tempStudents:theStudents){
			System.out.println(theStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();

		//display a list of students
		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating a multiple student object..");
		Student tempStudent1=new Student("John","Snow","john@mail.com");

		//Save the student
		System.out.println("Saving student data..");
		studentDAO.save(tempStudent1);

		//display id of the saved student
		System.out.println("Saved students Generated id: "+tempStudent1.getId());

		//retrieving student based on the id: primary key
		System.out.println("Retrieving the student with id: "+tempStudent1.getId());
		Student myStudent=studentDAO.findById(tempStudent1.getId());

		//display students
		System.out.println("Found the student: "+myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating a multiple student object..");
		Student tempStudent1=new Student("John","Snow","john@mail.com");
		Student tempStudent2=new Student("Amit","Kumar","amit@mail.com");
		Student tempStudent3=new Student("Aman","Kumar","aman@mail.com");

		System.out.println("Saving student data..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved students generated id: "+tempStudent1.getId());
		System.out.println("Saved students generated id: "+tempStudent2.getId());
		System.out.println("Saved students generated id: "+tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating a student object..");
		Student tempStudent=new Student("Rohan","kR","rohan@gmail.com");

		System.out.println("Saving student data");
		studentDAO.save(tempStudent);

		System.out.println("Saved students generated id: "+tempStudent.getId());
	}

}
