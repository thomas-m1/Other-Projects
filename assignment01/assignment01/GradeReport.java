//Thomas Michalski
//computer science CS1027
//Assignment 1
//Sep, 27, 2019


public class GradeReport {
	
	//private variables
	private String studentId;
	private String courseId;
	private int studentCt;
	private int courseCt;
	private Student[] studentArray;
	private Course[] courseArray;

	//constructor method
	public GradeReport(Student[] studentArray, Course[] courseArray, int studentCt, int courseCt) {
		this.studentArray = studentArray.clone();
		this.courseArray = courseArray.clone();
		this.studentCt = studentCt;	
		this.courseCt = courseCt;
		
	}
	
	
	public String getGradesOfCourse(String courseId) {
		System.out.println("Grades for course id: " + courseId);
		String s = "";
		double total = 0;
		int n = 0;
		for(int i = 0; i < courseCt; i++) { 
			for(int j = 0; j < studentCt; j++){
				if (courseArray[i].getCourseId().equals(courseId)) {
					if (courseArray[i].getStudentId().equals(studentArray[j].getStudentId())){
						s += "Student Name: " + studentArray[j].getStudentName() + ", Grade: " + courseArray[j].getStudentGrade() + "\n";
						total += courseArray[i].getStudentGrade();
						n++;
					}
				}
			}
		}
		//finds average and rounds it
		double average = total/n;
		double roundAverage = (double)Math.round( average * 100) / 100;
		s = s + "The average of the course: " + roundAverage;
		return s;
	}
	
	
	public String getGradesOfStudent(String studentId) {
		String s = "";
		double total = 0;
		int n = 0;
		for(int i = 0; i < studentCt; i++) { 
			for(int j = 0; j < courseCt; j++){
				if (studentArray[i].getStudentId().equals(studentId)) {
					if (courseArray[j].getStudentId().equals(studentArray[i].getStudentId())){
						s += "Student Name: " + studentArray[i].getStudentName() + ", Course: " + courseArray[j].getCourseId() + ", Grade: " + courseArray[j].getStudentGrade() + "\n";
						total += courseArray[i].getStudentGrade();
						n++;
					}
				}
			}
		}
		
		double average = total / n;
		
		if(s.contentEquals("")) {
			System.out.println("There are No Grades for Student Id: " + studentId);
		}
		else {
			System.out.println("Grades for Student Id: " + studentId);
			s = s + "The Average of the Student: " + average;
		}
		return s;
	}
	
	public String toString() {
		String s = "Complete Listing of Courses\n";
				for(int i = 0; i < courseCt; i++) {
					s += "Student Id: " + courseArray[i].getStudentId() + ", Grade: " + courseArray[i].getStudentGrade() + ", Course: " + courseArray[i].getCourseId() + "\n";
				}
			return s;
	}
}
