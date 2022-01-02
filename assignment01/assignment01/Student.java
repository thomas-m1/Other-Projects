//Thomas Michalski
//computer science CS1027
//Assignment 1
//Sep, 27, 2019


public class Student {
	
	//private variables
	private String studentName;
	private String studentEmail;
	private String studentId;
	
	//constructor method
	public Student (String studentName, String studentEmail, String studentId) {
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentId = studentId;		
	}
	
	//getter methods
	public String getStudentName(){
		return studentName;
	}
	public String getStudentEmail(){
		return studentEmail;
	}
	public String getStudentId(){
		return studentId;
	}
	
	//setter methods
	public void setStudentName (String studentName) {
		this.studentName = studentName;
	}
	public void setStudentEmail (String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public void setStudentId (String studentId) {
		this.studentId = studentId;
	}
	
	//printed statement of results
	public String toString() {
		String s = "Student Name: " + studentName + "\nStudent Email:  " + studentEmail + "\nStudent Id: " + studentId;
		return s;
	
	}


}
