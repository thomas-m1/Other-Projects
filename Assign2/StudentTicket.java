//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//this class computes all student tickets 

public class StudentTicket extends Ticket {
	double price;
	int numberOfDays;
	double cost = 0;

	public StudentTicket(int number, int days) {
		super(number);
		this.numberOfDays = days;
		if(numberOfDays>=10 && numberOfDays>0)//checks # of days ticket was purchased before event
		{
			this.price = 10.00;
			cost += 10.00;
		}
		else
		{
			this.price = 15.00;
			cost += 15.00;
		}
		
	}
	
	//returns to super to print price
	public String print() {
		return(super.print() + "" + price + " (ID required)");
	}
	
	//returns cost
	public double getCost() {
		return cost;
	}
	
	
}


