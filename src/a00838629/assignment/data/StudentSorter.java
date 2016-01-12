package a00838629.assignment.data;

import java.util.Comparator;

public class StudentSorter {

	public StudentSorter() {

	}

	public static class SortByFirstName implements Comparator<Student> {

		public int compare(Student s1, Student s2) {

			return s1.getFirstName().compareTo(s2.getFirstName());
		}
	}

	public static class SortByLastName implements Comparator<Student> {

		public int compare(Student s1, Student s2) {

			return s1.getLastName().compareTo(s2.getLastName());
		}
	}
	
	public static class SortByStudentID implements Comparator<Student> {

		public int compare(Student s1, Student s2) {

			return s1.getStudentID().compareTo(s2.getStudentID());
		}
	}

}
