//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//this class computes all regular tickets 

public class RegularTicket extends Ticket {
	
	double price;
	int numberOfDays;
	double cost = 0;
	
	//determines whether ticket is more or less than 10 days before event and determines its price in relation
	public RegularTicket(int number, int days) {
		super(number);
		this.numberOfDays = days;
		if(numberOfDays>=10 && numberOfDays>1)//checks # of days ticket was purchased before event
		{
			this.price = 20.00;
			cost += 20.00;
		}
		else
		{
			this.price = 30.00;
			cost += 30.00;
		}
	}
	
	//returns to super to print price
	public String print() {
		return(super.print() + "" + price);
	}
	
	//returns cost
	public double getCost() {
		return cost;
	}

}
