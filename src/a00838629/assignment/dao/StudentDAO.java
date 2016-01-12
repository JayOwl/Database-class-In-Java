package a00838629.assignment.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import a00838629.assignment.data.Student;
import a00838629.assignment.data.StudentMarks;
import a00838629.assignment.exceptions.DataInputException;
import a00838629.assignment.ui.UIDisplay;

public class StudentDAO {

	public static ArrayList<Student> readData(String filename)
			throws FileNotFoundException, DataInputException {

		ArrayList<Student> students = new ArrayList<Student>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File(filename));

		while (scanner.hasNext()) {
			// String lineData = scanner.nextLine();
			// System.out.println(lineData);
			String[] studentData = scanner.nextLine().split("\\|");
			if (studentData.length < 6) {
				throw new DataInputException("6 args expected, only "
						+ studentData.length + " received.");
			}

			Student student = new Student(studentData[0], studentData[1],
					studentData[2]);

			try {
				student.setTheMarks(new StudentMarks(Double
						.parseDouble(studentData[3]), Double
						.parseDouble(studentData[4]), Double
						.parseDouble(studentData[5])));
			} catch (NumberFormatException nfe) {
				throw new DataInputException("Input is not a double.");
			}
			students.add(student);
		}
		return students;
	}

	public static void writeData(ArrayList<Student> students, String filename)
			throws IOException {

		// PrintWriter output = new PrintWriter(new File(filename));
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(
				"output.txt", true)));

		for (Student student : students) {
			UIDisplay.display(student);	
			output.print(student.getFullName() + ", " + student.getStudentID());
			output.print(" - Quizzes: " + student.getTheMarks().getQuizzes());
			output.print(", Assignment: "
					+ student.getTheMarks().getAssignments());
			output.println(", Exams: " + student.getTheMarks().getExams());
			
		}
		output.println("-----------------------------\n");
		output.close();
		System.out.println("-----------------------------\n");
	}

	public static Student[] readData_ver2(String filename)
			throws FileNotFoundException {

		Student[] students = new Student[3];
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(filename);

		while (scanner.hasNext()) {
			// String lineData = scanner.nextLine();
			// System.out.println(lineData);
			// String[] studentData = lineData.split("\\|");
			for (int i = 0; i < students.length; i++) {
				students[i] = new Student(scanner.next(), scanner.next(),
						scanner.next());
				students[i].setTheMarks(new StudentMarks(scanner.nextDouble(),
						scanner.nextDouble(), scanner.nextDouble()));
			}

		}

		return students;
	}

	public static void printResults(ResultSet data) {
		// TODO Auto-generated method stub
		
	}

}
