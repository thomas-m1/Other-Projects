import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dijkstra {
	public static void main(String[] args)  {
		//calls file
		File f = new File("infile.txt");
		Scanner infile = null;
		try {
			infile = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		//number of vertices... initialize
		int numVertices = Integer.parseInt(infile.nextLine());
		graph graph = new graph(numVertices);
		
		// go through text file and add vertices and weights of edges in graph
		while (infile.hasNext()) {
            int u;//vertex 1
            int v;//vertex2
            int w;//weight
            
            // tokenize string and put in as u, v, and w for vertices and weight
            StringTokenizer tok = new StringTokenizer(infile.nextLine());
            u = Integer.parseInt(tok.nextToken());
            v = Integer.parseInt(tok.nextToken());
            w = Integer.parseInt(tok.nextToken());
			graph.setWeight(u-1, v-1, w);// populates graph, sets the edge with the weight
		}
		infile.close();

		// for loop to print out each one of the vertices for adjacency list
		System.out.println("adjacency list:");
		System.out.println("number of vertices: " + numVertices);

		System.out.println();
		for (int a = 1; a <= numVertices; a++){
			for(int b = 1; b <= numVertices; b++) {
				if (graph.getWeight(a-1, b-1) != -1) {
					System.out.println ("vertices: " +(a) +" and " +(b) + " weight: " +graph.getWeight(a-1, b-1));
				}
			}
			System.out.println();
		}
		
		// make an array for the shortest path in array, and set to infinity
		int[] shortest = new int[numVertices];	
		shortest[0] = 0;		//set start as 0
		int[] key = new int[numVertices];
		key[0] = 0;
		//set each path to infinity
		for (int i = 1; i < shortest.length; i++) {
			shortest[i] = -1;
			key[i] = -1;
		}		
				
		// set heap with values as -1, then check through heap
		heap priorityQ = new heap(key, numVertices);
		while (priorityQ.min_id() > 0) {
			// for the priorityQ store then delete the min
			//int min = priorityQ.min_id();
			//Node n = priorityQ.min_id(min);
			
			
			int u = priorityQ.min_id() - 1;
			priorityQ.delete_min();
//			
//			if (min != 1) {
//				System.out.println("(1, " + (i+1) + ") : " + shortest[i]);
//				
//			}
//			
			
			
			for (int v = 0; v < numVertices; v++) {//check through each vertex
				if (graph.getWeight(u, v) >= 0) {//if there is an edge
					// make shortest smaller if possible
					if ( shortest[v] >shortest[u] +graph.getWeight(u, v) ||shortest[v] == -1) {
						shortest[v] = graph.getWeight(u, v) + shortest[u];
					}
				priorityQ.decrease_key(v +1, shortest[v]);// add to priorityQueue
				}
			}
		}
		//part 2: print the shortest path
		for (int i = 0; i < numVertices; i++) {
			System.out.println("(1, " + (i+1) + ") : " + shortest[i]);
		}
	}
}