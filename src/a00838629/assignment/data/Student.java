/**
 * Project: a00838629_assingnment1
 * File: Student.java
 * Date: December 03, 2015
 * Time: 2:53:45 PM
 */
package a00838629.assignment.data;

/**
 * @author Joel Benoit, A00838629
 *
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private String studentID;
	private StudentMarks theMarks;
	
	public Student() {
		//super();
		firstName = "no";
		firstName = "body";
		studentID = "A00000000";
		
	}

	public Student(String firstName, String lastName, String studentID) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	
	public Student(String[] data){
		
		firstName = data[0];
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getFullName() {
		
		return firstName + " " + lastName;
	}

	public StudentMarks getTheMarks() {
		return theMarks;
	}

	public void setTheMarks(StudentMarks theMarks) {
		this.theMarks = theMarks;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", studentID=" + studentID + "]";
	}
	
	
	
}