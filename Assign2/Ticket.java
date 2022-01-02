//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//super class for the different kinds of tickets

abstract class Ticket {

	double price;
	int ticketNumber;
    
    public Ticket(int number) {
    	this.ticketNumber = number;
    }
    
    //gets ticket number and returns it
    public int getTicketNumber() {
    	return(ticketNumber);
    }
    
    //gets ticket price and returns it
    public double getTicketPrice() {
    	return(price);
    }
    
    //prints ticket number and price in a list format
    public String print() {
    	String result = "Number: " +ticketNumber+ ", Price: $";
    	return result;
   }
    
}