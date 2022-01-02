public class asn1_a {
	
	public static void main(String[] args) {
		System.out.println("output:");
		//calls fibonacci method and returns values to f(50)
		for(int i = 0; i <= 10; i++) {
			System.out.println("F(" + i*5 + ") = " + fibonacci(i*5));
		}
	}

	//calculation for fibanocci sequence. returns f(n)
	public static long fibonacci(long n) {
		if(n == 1) {
			return 1;
		} 
		else if(n == 0) {
			return 0;
		}
		else {
			//finds sum of n-1 and n-2 and returns the values
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}