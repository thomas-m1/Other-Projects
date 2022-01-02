public class asn1_b {
	
	private static int array_size = 105;// array must be large enough to hold number for f(500) (increase if f(n) is larger)
	
	
	public static void main(String[] args) {
		// calls fibonacci method and prints values to f(500)
		for(int i = 0; i <= 25; i++) {
			//prints every 20th value of f(n)
			System.out.print("F(" +i*20 + ") = ");
			print(fibonacci(i*20));// call fibonacci method
			System.out.println();
			}
		}
	
	//strips 0s and prints the value of fn from the array
	public static void print(int[] values) {
		
		//prints the numbers from i=0 to the end of the array
		for (int i = 0; i < array_size; i++) {
			
			//removes all the 0,s in front of value
			while(i < array_size && values[i] == 0) {
				i++;
			}
			
			//prints value
			if(i < array_size) {
				System.out.print(values[i]);
			}
			
			else {
				System.out.print("0");
			}
		}
	}
	
	public static int[] fibonacci(long n) {
		
		//arrays to store n-1,n-2 and value of fn and starts array at 1
		int[] subtract1 = new int[array_size];
		subtract1[array_size-1] = 1;
		int[] subtract2 = new int[array_size];
		int[] fn = new int[array_size];
		fn[array_size-1] = 1;
		
		//at n=0 value set value to 0
		if(n == 0) {
			fn = new int[array_size];
			}
		
		//checks if n is greater than 2
		else if (n>2){
			//finds f(n)
			for(int i = 2; i <= n; i++) {
				fn = add(subtract1, subtract2);
				//sets new values of n-1 and n-2
				subtract2 = subtract1;
				subtract1 = fn;
			}
		}
		return fn;
	}
	
	//adds the two arrays and returns total
	public static int[] add(int[] array1, int[] array2) {
		
		int[] total = new int[array_size];// array to store total from addition
		int nextNum = 0;
		int i = array_size;
		
		// while loop runs for the size of the array and adds the index at i-1 for the size of the array
		while(i != 0) {
			int index = 0;//index position in array
			
			//if there is a number is more than 1 digit
			if(nextNum != 0) {	
				nextNum = 0;
				index = 1;

			}
			//adds inde i-1 from both arrays
			index= index + array1[i-1] + array2[i-1];
			
			//if the index is greater than 9 we must carry over the number to calculate it in the previous loop
			if(index > 9) {
				nextNum = 1;
			}
			//makes the total the value at i-1, takes remainder
			total[i-1] = index % 10;
			i = i-1;
		}
		return total;
	}
}