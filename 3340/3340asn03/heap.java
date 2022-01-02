


public class heap implements heapADT {
	
	int nlength;
	public int[] A, H;//A array for original order and heap array of indices
	
	//constructs heap, populates with keys for n
	public heap(int[] keys, int n) {
		nlength = n;
		A = keys;
		H = new int[n*2];//-1??? took out
		
		//set leaves to heap array
		for (int i = 1; i <= n; i++) {
			H[i+n-2] = i;
		}
		
		//inner heap
		for (int i = n-2; i >= 0; i--){
			 if(A[H[(2*(i+1))-1]-1]== -1) {// check if child is set to infinity
				H[i] = H[2*(i+1)];
			}			
			 else if(A[H[2*(i+1)]-1]== -1) {// check if child is set to infinity
				H[i] = H[(2*(i+1))-1];
			}
			else if(A[H[(2*(i+1))-1]-1] < A[H[2*(i+1)]-1]) {// if left smaller than right
				H[i] = H[(2*(i+1))-1];
			} 
			else if(A[H[(2*(i+1))-1]-1] > A[H[2*(i+1)]-1]){//if right smaller than left
				H[i] = H[2*(i+1)];
			}
		}
	}
	
	//returns true if the element whose id is id is in the heap
	public boolean in_heap(int id) {
		if (H[id + nlength - 2] != 0){
			return true;
		}
		return false;
	}
	
	// returns the minimum key of the heap
	public int min_key(){
		return A[H[0]-1];
	}
	
	// returns the id of the element with minimum key in the heap
	public int min_id() {
		return H[0];
	}
	
	//returns the key of the element whose id is id in the heap
	public int key(int id){
		return A[id-1];
	}
	
	//deletes the element with minimum key from the heap
	public void delete_min() {
		
		A[min_id()-1] = -1;
		H[H[0] + nlength - 2] = 0;
		
		//rebuild tree
		int i = (H[0] + nlength - 1) / 2;
		while (i >= 1) {
			if (H[2*i] == 0 || A[H[2*i]-1] == -1){
				H[i-1] = H[2*i-1];
			}
			else if (H[2*i-1] == 0 || A[H[2*i-1]-1] == -1){
				H[i-1] = H[2*i];
			}
			else if (A[H[2*i-1]-1] < A[H[2*i]-1]) {
				H[i-1] = H[2*i-1];
			} else {
				H[i-1] = H[2*i];
			}
            i = (int)Math.floor(i/2);
		}
	}
	
	// sets the key of the element whose id is id to new key if its current key is greater than new key
	public void decrease_key(int id, int new_key) {
		
		if (A[id-1] == -1 || A[id-1] > new_key ) {
			A[id-1] = new_key;
			
			//rebuild tree
			int i = (id + nlength - 1) / 2;
			while (i >= 1) {
				if (H[2*i] == 0 || A[H[2*i]-1] == -1){
					H[i-1] = H[2*i-1];
				}
				else if (H[2*i-1] == 0 || A[H[2*i-1]-1] == -1){
					H[i-1] = H[2*i];
				}
				else if (A[H[2*i-1]-1] < A[H[2*i]-1]) {
					H[i-1] = H[2*i-1];
				} else {
					H[i-1] = H[2*i];
				}
	            i = (int)Math.floor(i/2);
			}
		}
	}
}
