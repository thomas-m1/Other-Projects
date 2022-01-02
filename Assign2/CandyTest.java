//Thomas Michalski
//computer science CS1027
//Assignment 2
//July 12th, 2019
//main program that computes the candy in the container

public class CandyTest {
	
	public static void main(String[] args) {
		
		Candy topCandy;
		LinkedStack<Candy> candyStack = new LinkedStack<Candy>();
		LinkedStack<Candy> secondcandyStack = new LinkedStack<Candy>();

		
		//declares
		Candy Red = new Candy("red\n");
		Candy Purple = new Candy("purple\n");
		Candy Green = new Candy("green\n");
		Candy Pink = new Candy("pink\n");
		Candy Yellow = new Candy("yellow\n");
				
		
		//adds the candy to the stack
		candyStack.push(Red); 
		candyStack.push(Purple);
		candyStack.push(Green);
		candyStack.push(Pink);
		candyStack.push(Yellow);
		candyStack.push(Pink);
		candyStack.push(Red);
		candyStack.push(Yellow);
		candyStack.push(Green);
		candyStack.push(Yellow);
		
		System.out.println("The plastic contaier contains the following coloured candies: \n" + candyStack.toString());	
		int eatencandy = 0;
		
		//calculates the amount of candy eaten
		while(!candyStack.isEmpty()) {
			topCandy = candyStack.pop();
			if(topCandy.equals(Yellow))
			{
				eatencandy = eatencandy +1;
			}
			else
			{
				secondcandyStack.push(topCandy);
			}
		}
		
		//puts candy back in first stack after removing them, not including the eaten one
		while (!secondcandyStack.isEmpty())
		{
			topCandy = secondcandyStack.pop();
			candyStack.push(topCandy);
		}
		
		
		//returns candies in new stack and the number of candies eaten
		System.out.println("The plastic contaier now contains the following coloured candies: \n" + candyStack.toString());
		System.out.println("The number of candies eaten is: " + eatencandy);
	}
}

