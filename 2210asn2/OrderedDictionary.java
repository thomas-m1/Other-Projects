//
//public class OrderedDictionary implements OrderedDictionaryADT {
//	
//	BinarySearchTree tree;
//	
//	//constructor for ordered dictionary
//	public OrderedDictionary() {
//		tree = new BinarySearchTree();
//	}
//
//	//returns DataItem object with key k, else null
//	public DataItem get(Key k) {
//		Node get = tree.get(tree.getRoot(), k);
//		if(get.isLeaf()) {
//			return null;
//		}
//		else {
//			return get.getContent();			
//		}
//	}
//	
//	
//	//inserts d into ordered dictionary, throws exception
//	public void put (DataItem d) throws DictionaryException {
//		if (!tree.put(tree.getRoot(), d)) {
//			throw new DictionaryException();
//		}
//	}
//	
//	//removes dataItem with key k from dictionary throws exception
//	public void remove (Key k) throws DictionaryException {
//		if (tree.remove(tree.getRoot(), k) == false) {
//			throw new DictionaryException();
//		}
//	}
//	
//		//returns dataItem with smallest key in ordered dictionary, else null
//	public DataItem smallest () {
//		Node smallest = tree.smallest(tree.getRoot());
//		if(smallest != null) {
//			return smallest.getContent();			
//		}
//		else {
//			return null;
//		}
//	}
//	
//	//returns dataItem with largest key in ordered dictionary, else null
//	public DataItem largest () {
//		Node largest = tree.largest(tree.getRoot());
//		if(largest != null) {
//			return largest.getContent();			
//		}
//		else {
//			return null;
//		}
//	}
//	
//	
//	//returns predecessor of k, else null
//	public DataItem predecessor (Key k) {
//		Node predecessor = tree.predecessor(tree.getRoot() ,k);
//		if(predecessor != null) {
//			return predecessor.getContent();			
//		}
//		else {
//			return null;
//		}
//	}
//	
//	//returns successor of k, else null
////	public DataItem successor (Key k) {
////		Node successor = tree.successor(tree.getRoot(), k);
////		if(successor != null) {
////			return successor.getContent();			
////		}
////		else {
////			return null;
////		}
////	}
//	public DataItem successor(Key k) {
//		return this.tree.successor(k);
//	}
//
//}

public class OrderedDictionary implements OrderedDictionaryADT {
	private BinarySearchTree tree;
	
	//create new tree
	public OrderedDictionary() {
		this.tree = new BinarySearchTree(); 
	}

	//get object from tree
	public DataItem get(Key k) {
		return this.tree.get(k);
	}

	//put object in tree
	public void put(DataItem d) throws DictionaryException {
		if (get(d.getKey()) != null) {
			throw new DictionaryException();
		}
		this.tree.put(d);
	}

	//remove object from tree
	public void remove(Key k) throws DictionaryException {
		if (get(k) == null) {
			throw new DictionaryException();
		}
		this.tree.remove(k);
	}

	//finds successor
	public DataItem successor(Key k) {
		return this.tree.successor(k);
	}

	//finds predecessor
	public DataItem predecessor(Key k) {
		return this.tree.predecessor(k);
	}

	//returns dataItem with smallest key in ordered dictionary
	public DataItem smallest() {
		return this.tree.smallest(this.tree.getRoot());
	}
	
	//returns dataItem with largest key in ordered dictionary
	public DataItem largest() {
		return this.tree.largest(this.tree.getRoot());
	}

}
