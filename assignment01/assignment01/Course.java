//Thomas Michalski
//computer science CS1027
//Assignment 1
//Sep, 27, 2019


public class Course {
	
	//private variables
	private String courseName;
	private String courseId;
	private String studentId;
	private int studentGrade;
	
	//constructor for course
	public Course(String courseName, String courseId, String studentId, int studentGrade) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.studentId = studentId;	
		this.studentGrade = studentGrade;
	}
	
	//getter methods
	public String getCourseName(){
		return courseName;
	}
	public String getCourseId(){
		return courseId;
	}
	public String getStudentId(){
		return studentId;
	}
	public int getStudentGrade(){
		return studentGrade;
	}
	
	//setter methods
	public void setCourseName (String courseName) {
		this.courseName = courseName;
	}
	public void setCourseId (String courseId) {
		this.courseId = courseId;
	}
	public void setStudentId (String studentId) {
		this.studentId = studentId;
	}
	public void setStudentGrade (int studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	//printed statement of results
	public String toString() {
		String s = "Course Name: " + courseName + "\nCourse Number: " + courseId + "\nStudent Id: " + studentId + "\nStudent Grade: " + studentGrade;
		return s;
	
	}


	

}
