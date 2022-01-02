//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//main program for all code

public class MyTickets {

	public static void main (String [] args) {
	//Load sales data
	InStringFile salesReader = new InStringFile("sales.txt"); // create sales report
	SalesReport ticketsSales = new SalesReport(); 
	ticketsSales.getData(salesReader);
	// sales analytics computations ticketsSales.computeStats();
	//Display the results
	ticketsSales.computeStats();
	ticketsSales.displayResults();
	ticketsSales.printTicketList();
	}

}