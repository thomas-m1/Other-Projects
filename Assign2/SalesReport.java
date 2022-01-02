//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//stores total volume of sales

import java.util.StringTokenizer;

public class SalesReport {
	
	final int max = 120;
	int highestFigure, numberOfTickets, regularSales, walkinSales, studentSales = 0;
	double averageSales, totalVolume, regularCost, walkinCost, studentCost= 0;
	Ticket[] ticketList = new Ticket[max];
	String stringHighestFigure = "";
	
	//constructor
	public SalesReport() {
		}
	
	// Reads data from file
	public void getData(InStringFile salesReader) { 
		while (!salesReader.endOfFile()) {
			String tLine = salesReader.read();
			StringTokenizer tokenizer = new StringTokenizer(tLine);
			int ticketNumber = Integer.parseInt(tokenizer.nextToken());
			String ticketType = tokenizer.nextToken();
			int numberOfDays = Integer.parseInt(tokenizer.nextToken());
			
			//sorts the type of tickets
			//determines if ticket type is regular
			if (ticketType.equals("regular")) {
				RegularTicket regTic = new RegularTicket(ticketNumber, numberOfDays);
				this.regularSales++;
				
				ticketList[numberOfTickets] = regTic;
				this.numberOfTickets++;
				
				regularCost = regularCost + regTic.getCost();
			}
			
			//determines if ticket type is student
			else if(ticketType.equals("student")) {
				StudentTicket stuTic = new StudentTicket(ticketNumber, numberOfDays);
				this.studentSales++;
				
				ticketList[numberOfTickets] = stuTic;
				this.numberOfTickets++;
				studentCost = studentCost + stuTic.getCost();
			}
			
			//determines if ticket type is walk-in
			else if(ticketType.equals("walkin")) {
				WalkInTicket walkTic = new WalkInTicket(ticketNumber);
				this.walkinSales++;
				
				ticketList[numberOfTickets] = walkTic;
				this.numberOfTickets++;
				walkinCost = walkinCost + walkTic.getCost();
			}
		}
	}
	
	//prints results
	public void computeStats() {
		System.out.println("Sales Status");
		System.out.println("Walk-in tickets' sales: " + walkinSales);
		System.out.println("Regular tickets' sales: " + regularSales);
		System.out.println("Student tickets' sales: " + studentSales);
	}

	//prints report
	public void displayResults() {
		totalVolume = regularCost + studentCost + walkinCost;
		averageSales = totalVolume/numberOfTickets;
		System.out.println("\nSales analytics");
		System.out.println("Total number of tickets sold: " +numberOfTickets+ " tickets");
		System.out.println("Sales volume: $" + totalVolume);
		System.out.println("Average sales is: $" + averageSales);
		
		//determines the highest number of tickets sold
		if(regularSales>walkinSales && regularSales>studentSales) {
			stringHighestFigure = "(Regular)";
			highestFigure = regularSales;
		}
		else if(walkinSales>regularSales && walkinSales>studentSales) {
			stringHighestFigure = "(Walk-in)";
			highestFigure = walkinSales;
		}
		else if(studentSales>regularSales && studentSales>walkinSales) {
			stringHighestFigure = "(Student)";
			highestFigure = studentSales;
		}
		
		System.out.println("Largest sales is " + stringHighestFigure + ": " + highestFigure + " tickets");
	}
	
	//prints out list of tickets
	public void printTicketList() {
		System.out.println("\nTicket List: ");
		for (int i=0; i<numberOfTickets; i++)
		{
			System.out.println(ticketList[i].print());
		}
	}
}
