

public class uandf {
	
	//initiate variables
	private int[] parent, rank;
	private int last = 0;// truth
	

	//constructs a disjoint-set data type with n elements 
	public uandf(int n) {
		// Set parent and rank
		parent = new int[n];
		rank = new int[n];
	}
	
	//creates new set whose only representative is i
	public void make_set(int i) {
		//set parent i equal to i
		parent[i] = i;
	}
    
	//unites dynamic sets that contains i and j, respectively, into new set that is union of these two sets
	public  void union_sets(int i, int j) {
		//calls function to find the i and j in the set
		i = find_set(i);
		j = find_set(j);
		
		//if rank i is smaller than rank j, set parent i to parent j to move i under j
		if (rank[i] < rank[j]) {
			parent[i] = parent[j];
		}
		//if rank j is smaller than rank i set parent j to parent i to move j under i
		else if (rank[j] < rank[i]) {
			parent[j] = parent[i];
		}
		//if the ranks are equal, set parent at j to parent i and increase rank of i by 1
		else {
			parent[j] = parent[i];
			rank[i]++;
		}
	}
	
	//returns representative of the set containing i
	public int find_set(int i) {
		
		//checks if final set is false
		if (last == 0) {
			//if the parent i does not equal i (i is not the parent of itself)
			if (parent[i] != i) {
				parent[i] = find_set(parent[i]);//recursively call find, and returns the set that has the parent at i
			}
			return parent[i];
		}
		
		//if finalSet == true, return parent at i
		else {
			return parent[i];
		}
	}
	
	//returns the total number of current sets and finalizes the current sets
	//resets the representatives of the sets so that integers from 1 to final sets() will be used as representatives
	public int final_sets() {
		int currentNode = 1;
		
		//checks through the parent
		for (int i = 1; i < parent.length; i++) {
			
			//if parent i is not 0, call findset to search for set i
			if(parent[i] != 0) {
				find_set(i);
			}
		}
		
		//checks through the parent
		for (int i = 1; i < parent.length; i++) {
			
			//checks if parent i is the same as i, if true, parent i is set to the current node and the rank is set to 1
			if (parent[i] == i) {
				parent[i] = currentNode++;
				rank[i] = 1;
			}
			else { // if parent is not the same as i, change rank i to 0
				rank[i] = 0;
			}
		}
		
		//checks through the parent
		for(int i = 1; i < parent.length; i++) {
			//if rank i is 0 and parent i is > 0. make the parent i the parent of parent i(moves up one node)
			if (rank[i] == 0 && parent[i] > 0) {
				parent[i] = parent[parent[i]];
			}
		}
		
		//sets the last to true for final sets and subtract 1 from current
		last = 1;
		return currentNode - 1;
	}
}






