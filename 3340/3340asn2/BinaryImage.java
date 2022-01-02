import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * to run the file...
 * 
 */
public class BinaryImage {


	public static void main(String[] args) {
		 
		//initialize single arrays
		int[] unionSet = null;
		int[] unionChar = null;
		int[] sortSet;
		// initialize 2D array
		int[][] img = null;
		boolean[][] truth = null;
		
		//read file
		try {
			
			//buffer reader to get file from the command line
			BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
			
			//File girl.img contains a 71 by 71 binary image. sets up boundaries
			truth = new boolean[71][71];
			img = new int[71][71];
			String line;
			
			//read each line until the end of the file, if it is +, set to true and set value as 1
			for (int x = 0; infile.ready(); x++) {
				line = infile.readLine();
				
				//for the length of the line, read each char, if char is + then set flag to true and image to 1 
				for (int y = 0; y < line.length(); y++) {
					if(line.charAt(y) == '+') {
						truth[x][y] = true;
						img[x][y] = 1;
					}
				}
			}
			infile.close();//close file after reading
		}
		//throws an error if file does not run or read
		catch (Exception e) {
			System.out.println("Error opening and reading file");
		}
		
		//1. prints the input binary image
		System.out.println("part 1.");
		for (int x = 0; x < img.length; x++){
			for (int y = 0; y < img.length; y++) {
				System.out.print(img[x][y]);
			}
			System.out.println();
		}
		System.out.println();
		
		//connects the values based on the criteria
		uandf imgSet = new uandf((img.length*img.length)+ 1);
		for (int x = 0; x < img.length; x++) {
			for(int y = 0; y < img.length; y++) {
				// if the value at [i][j] is 1, we will produce a union of the set
				if (img[x][y] == 1) {
					imgSet.make_set(((img.length*x)+y)+1);
					if (x > 0 && img[x-1][y] ==1) {
						imgSet.union_sets((img.length*(x-1))+y+1, (img.length*x)+y+1);
					}	
					if (y > 0 && img[x][y-1] == 1) {
						imgSet.union_sets((img.length*x)+(y-1)+1, (img.length*x)+y+1);
					}	
				}
			}
		}
		
		unionSet = new int[imgSet.final_sets()];
		unionChar = new int[unionSet.length];
			
		//2. prints the connected component image where each component is labeled with a unique character
		System.out.println("part 2.");
		int j;
		for (int x = 0; x < img.length; x++) {
			for (int y = 0; y < img.length; y++) {
				j =imgSet.find_set((img.length*x)+y+1);//set the chars to j
				j = j+98;
				//start at 97 because of ascii table
				if (j != 98) {//if j is 97 then print a space...(97 was printing ' ???)
					unionSet[j-98-1]++;	
					System.out.print((char)j);
				}
				else {//else, increase the set and print out the char
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//3. prints a list sorted by component size, where each line of the list contains the size and the label of a component
		sortSet = new int[unionSet.length];
		
		for (int i = 0; i < unionSet.length; i++) {
			sortSet[i] = unionSet[i];
		}
		for (int i = 0; i < sortSet.length; i++) {
			unionChar[i] = sortSet[i];
		}
		Arrays.sort(sortSet);
		
		//prints out sorted list
		System.out.println("part 3.");
		System.out.println("Char   size");
		for (int x = 0; x < sortSet.length; x++) {
			for (int y = 0; y < unionChar.length; y++) {
				if (sortSet[x] == unionChar[y]) {
					//prints out the char and the size of the set
					System.out.println(" " + (char)(y+98-1) + "  ->  " + sortSet[x]);
					unionChar[y] =-1;
					break;
				}
			}
		}
		System.out.println();
		
		//4. prints the same as 2 with the connected components whose sizes are less than three deleted
		System.out.println("part 4.");
		for (int x = 0; x < img.length; x++) {
			for (int y = 0; y < img.length; y++) {
				j = imgSet.find_set((img.length*x)+y+1);//set the chars to j
				j = j+98;
				// if the size = 1 or 2, then delete it
				if (j == 98 || unionSet[j-98-1] == 1 || unionSet[j-98-1] == 2) {
					System.out.print(" ");
				}
				
				//if size is larger than 3, print out the associated char
				else {
					System.out.print((char)j);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
