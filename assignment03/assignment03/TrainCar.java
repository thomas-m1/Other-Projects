//Thomas Michalski
//computer science CS1027
//Assignment 3
//Nov 18, 2019

package assignment03;

public class TrainCar {
//declare and initialize variables
  private int number;
  private String color;
  
  public TrainCar(int number, String color) {
      this.number = number;
      this.color = color;
  }
  
  //setter methods
  public void setNumber(int number) {
      this.number = number;
  }
  
  public void setColor(String Color) {
      this.number = number;
  }
  
  
  //getter methods
  public int getNumber() {
      return number;  
  }
  public String getColor() {
      return color;   
  }
  
  //returns string representation of the train car by color and number
  public String toString() {
    return "< " + this.color + "," + Integer.toString(this.number) + " >";
  }

}
