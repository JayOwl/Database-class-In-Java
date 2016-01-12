package a00838629.assignment.data;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import a00838629.assignment.data.Student;

import java.sql.Connection;
/**
 * Project: a00838629_assign5
 * File: Database.java
 * Date: Dec 5, 2015
 * Time: 4:01:51 PM
 */

public class Database {
	
	private static Connection _connection;
	private Database database;
	
	public Database () {};
		
	public void connect() {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://Beangrinder.bcit.ca";
		String user = "javastudent";
		String password = "compjava";
		try {	
			Class.forName(driver);
			_connection = DriverManager.getConnection(url, user, password);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean createTable(String CreateQuery) throws SQLException {
		return _connection.createStatement().execute(CreateQuery);
	}
	
	public ResultSet getData(String selectQuery)throws SQLException{
		return(_connection.createStatement().executeQuery(selectQuery));		
	}
	
	

	public int insertData(String insertQuery) throws SQLException {
		return _connection.createStatement().executeUpdate(insertQuery);
	}
	
	public int insertData(String tableName, Student student) throws SQLException {
		String insertQuery = "INSERT INTO " + tableName + " VALUES ('"+
							student.getStudentID()+"', '"+ 
							student.getFirstName()+"', '"+ 
							student.getFirstName()+"', " +
							student.getTheMarks().getQuizzes() + ", " + 
							student.getTheMarks().getAssignments() + ", " + 
							student.getTheMarks().getExams() + ")";
		return _connection.createStatement().executeUpdate(insertQuery);
	}	
	

	public boolean dropTable(String dropQuery) throws SQLException {
		return _connection.createStatement().execute(dropQuery);
	}

	public void shutDown() throws SQLException {
		_connection.close();		
	}

	public static boolean tableExists(String tableName) throws SQLException {
		DatabaseMetaData databaseMetaData = _connection.getMetaData();
		ResultSet resultSet = databaseMetaData.getTables(_connection.getCatalog(), "%", "%", null);
		String name = null;
		while (resultSet.next()) {
			name = resultSet.getString("TABLE_NAME");
			if (name.equalsIgnoreCase(tableName)) {
				return true;
			}
		}
		return false; 
	}

}



