package a00838629.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import a00838629.assignment.dao.StudentDAO;
import a00838629.assignment.data.Database;
import a00838629.assignment.data.Student;
import a00838629.assignment.data.StudentSorter;
import a00838629.assignment.exceptions.DataInputException;

public class Assignment4 {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {

		Assignment4 assignment = new Assignment4();
		assignment.test();		
	
	}

	private Object database;
	
	public void test() throws FileNotFoundException, ClassNotFoundException, SQLException {
		ArrayList<Student> students = null;
		try {
			students = StudentDAO
					.readData("student_data.txt");
		} catch (DataInputException die) {
			die.printStackTrace();
		}
		try {			
			StudentDAO.writeData(students, "output.txt");
			Collections.sort(students, new StudentSorter.SortByFirstName());
			StudentDAO.writeData(students, "output.txt");
			Collections.sort(students, new StudentSorter.SortByLastName());
			StudentDAO.writeData(students, "output.txt");
			Collections.sort(students, new StudentSorter.SortByStudentID());
			StudentDAO.writeData(students, "output.txt");			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		

	
	Database database = new Database();
	database.connect();
	if (Database.tableExists("A00838629TableName")){		
			System.out.print("Dropping Table.... Result == ");		
			System.out.println(database.dropTable("DROP TABLE A00838629TableName"));	
			database.createTable("CREATE TABLE A00838629TableName(firstName VARCHAR(30) PRIMARY KEY,  lastName VARCHAR(30), studentID VARCHAR(30),  quizzes VARCHAR(30), assignments VARCHAR(30), exams VARCHAR(30))");
	}
	else {
		System.out.println("false");
			database.createTable("CREATE TABLE A00838629TableName(firstName VARCHAR(30) PRIMARY KEY,  lastName VARCHAR(30), studentID VARCHAR(30),  quizzes VARCHAR(30), assignments VARCHAR(30), exams VARCHAR(30))");
	}	
		
	for(Student student : students) {
		database.insertData("A00838629TableName", student);
		
		ResultSet resultSet = database.getData("SELECT * FROM A00838629TableName");
		try {
		while(resultSet.next()){ 
			for (int i=1; i < 6; i++) { System.out.print(resultSet.getString(i) + " ");  
			}}
			}
		
		catch (Exception e) {}
		}
		
	

	//StudentDAO.printResults(database.getData("SELECT * FROM A00838629TableName"));

	

	
	
	
	//public static boolean tableExists(String tableName) throws SQLException {
	//	DatabaseMetaData databaseMetaData = _connection.getMetaData();
	//	ResultSet resultSet = databaseMetaData.getTables(_connection.getCatalog(), "%", "%", null);
	//	String name = null;
	//	while (resultSet.next()) {
	//		name = resultSet.getString("TABLE_NAME");
	//		if (name.equalsIgnoreCase(tableName)) {
	//			return true;
	//		}
	//	}
	//	return false; 			
	
	
	}	
}
	

