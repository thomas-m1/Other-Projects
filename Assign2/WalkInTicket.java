//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//this class computes all walk in tickets 

public class WalkInTicket extends Ticket {
	double price;
	double cost = 0;
	
	public WalkInTicket(int number) {
		super(number);
		this.price = 40.00;
		cost = cost + 40.00;//adds to cost
	}
	
	//returns to super to print price
	public String print() {
		return(super.print()+ "" + price );
	}
	
	//returns cost
	public double getCost() {
		return cost;
	}
	
	
}