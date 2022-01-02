//
//
//public class BinarySearchTree {
//	
//	private Node root;
//	
//	//gets root of tree
//	public Node getRoot() {
//		return this.root;
//	}
//	
//	 
//	public BinarySearchTree() {
//			this.root = null; //new Node();
//	}
//	
//	// gets the location in a tree
//	public Node get(Node r, Key k) {
//	//	r = this.root;
//		if (r.isLeaf()) {
//			return r;
//		}
//		else { 
//			if(k.compareTo(r.getContent().getKey()) == 0) {
//				return r;
//			}
//			else if (r.getContent().getKey().compareTo(k) < 0) {
//				return get(r.getLeft(), k);
//			}
//			else {
//				return get(r.getRight(), k);
//			}
//		}
//	}
//	
//	//puts an object in the tree
//	public Boolean put(Node r, DataItem d) {
//		Node p = get(r, d.getKey());
//		
//		if (!p.isLeaf()) {
//			return false;
//		}
//		else {
//			
//			p.setContent(d);
//			p.setLeft(new Node(null,p,null,null));
//			p.setRight(new Node(null,p,null,null));
//			return true;
//			
//		}
//	
//	}
//	
//
//	//removes an object from the tree
//	public Boolean remove(Node r, Key k) {
//		Node p = get(r, k);
//		if (p.isLeaf()) { //  || p == null) {
//			return false;
//		}
//		else {
//			if (p.getLeft().isLeaf() || p.getRight().isLeaf()) {	
//				
//				Node otherChild;
//				if (p.getRight().isLeaf()) {
//					otherChild = p.getLeft();
//				}
//				else {
//					otherChild = p.getRight();
//				}
//				
//				if (p == root) {
//					this.root = otherChild;
//					
//				}
//				
//				else {
//					Node parent = p.getParent();
//					if (parent.getLeft() == p) {
//						parent.setLeft(otherChild);
//						otherChild.setParent(parent);
//					}
//					else if (parent.getRight() == p) {
//						parent.setRight(otherChild);	
//						otherChild.setParent(parent);
//					}
//				}
//			}
//			else {
//				Node s = smallest(p.getRight());
//				DataItem data = s.getContent();
//				
//				//p.setContent(s.getContent());
//				remove(this.root, s.getContent().getKey());	
//				p.setContent(data);
//			}
//			return true;
//		}
//	}
//	
//	
//	//finds smallest object
//	public Node smallest(Node r) {
//		if (r.isLeaf()) {
//			return null;
//		}
//		else {
//			Node p = r;
//			while (!p.getLeft().isLeaf()) {
//				p = p.getLeft();
//			}
//			return p;
//		}
//	}
//	
//	//finds largest object
//	public Node largest(Node r) {
//		if (r.isLeaf()) {
//			return null;
//		}
//		else {
//			Node p = r;
//			while (!p.getRight().isLeaf()) {
//				p = p.getRight();
//			}
//			return p;
//		}
//	}
//	
//	
//
//	
//	public DataItem successor(Key k) {
//		if (this.root == null) return null;
//		Node succ = null;
//		Node curr = this.root;
//		while (curr != null) {
//			if (k.getName().compareTo(curr.getKey().getName()) < 0) { //if the search key is less than the current key
//				succ = curr; //make the current key the successor
//				curr = curr.getLeft(); //traverse left subtree
//			} else { //if search key is equal to or greater than current key
//				curr = curr.getRight(); //traverse right subtree
//			}
//		}
//		if (succ == null) return null;
//		return succ.getContent();
//	}
//	
//	
//	
//	
//	//finds smallest value that is larger than the object
//	public Node predecessor(Node r, Key k) {
//		
//		if (r.isLeaf()) {
//			return null;
//		}
//		else {
//			Node p = get(r, k);//put at top???
//			if (!p.isLeaf() && !p.getLeft().isLeaf()) {
//				return largest(p.getLeft());
//			}
//			else {
//				Node parent = p.getParent();//put top???
//				while (r != p && p == parent.getLeft()) {
//					p = parent;
//					parent = p.getParent();//p.????
//				}
//				if (p == r) {
//					return null;
//				}
//				else {
//					return parent;
//				}
//			}
//		}
//	}
//	
//
//		
//	
//	
//}

public class BinarySearchTree {
	private Node root;
	
	//gets root of search tree
	public Node getRoot() { 
		return this.root; 
	}
	
	// initializes search tree
	public BinarySearchTree() {
		this.root = null;
	}
	
	//Returns DataItem object
	public DataItem get(Key k) {
		Node r = this.root;
		//base case - checks if tree is empty
		if (r == null) {
			return null;
		}
		
		//compare key to find the key you are looking for
		while (!(k.compareTo(r.getKey()) == 0)) {
			// if the key is less than the one being searched for, traverse through the left tree, else traverse right tree
			if (k.compareTo(r.getKey()) == -1) {
				if (r.getLeft() == null) {
					return null;
				}
				r = r.getLeft();
			} else {
				if (r.getRight() == null) {
					return null;
				}
				r = r.getRight();
			}
		}
		return r.getNode(); //returns correct data item once found
	}
	
	
	
	
	
	
	
	public void put(DataItem d) {
		Node current = this.root;
		
		//if tree is empty, makes data item the root
		if (current == null) {
			this.root = new Node(d, null, null, null);
		} 
		else {//if tree not empty
			//searches for a place to put the key and creates null leaf nodes
			while (true) {
				// if the key is less than the one being searched for, traverse through the left tree, else traverse right tree
				if (d.getKey().compareTo(current.getKey()) == -1) {
					if (current.getLeft() == null) {
						current.setLeft(new Node(d, null, null, current)); //new node
						break;
					}
					else current = current.getLeft();
				} else {
					if (current.getRight() == null) {
						current.setRight(new Node(d, null, null, current)); //new node
						break;
					}
					else current = current.getRight();
				}
			}
		}
	}
	
	
//	public void remove(Key k) {
//		this.root = delete(this.root, k);
//	}
//	
//	private Node delete(Node r, Key k) {
//		//base case checks if first node is null
//		if (r == null) {
//			return r;
//		}
//		
//		//left if key is less than current key, else go right
//		if (k.compareTo(r.getKey()) == -1) {
//			r.setLeft(delete(r.getLeft(), k)); 
//		}
//		else if (k.compareTo(r.getKey()) == 1) {
//			r.setRight(delete(r.getRight(), k));
//		}
//		else {
//			if (r.getLeft() == null) {
//				return r.getRight();
//			}
//			else if (r.getRight() == null) {
//				return r.getLeft();
//			}
////			r= r.getRight();
////			while(r.getLeft() != null) {
////				r = r.getLeft();
////			}
//			Node s = smallest(r.getRight());
//			DataItem data = s.getData();
//			r.setNode(data); 
//			r.setRight(delete(r.getRight(), r.getKey())); //delete the node
//		}
//		return r;
//	}
//	
////	private DataItem min(Node r) {
////		//find left-most (minimal) node of a given tree
////		while(r.getLeft() != null) {
////			r = r.getLeft();
////		}
////		return r.getNode();
////	}
	
	public void remove(Key k) {
		this.root = delete(this.root, k); //start recursive removal
	}
	
	private Node delete(Node r, Key k) {
		if (r == null) return r;
		if (k.compareTo(r.getKey()) == -1) r.setLeft(delete(r.getLeft(), k)); //move left if deletion key is less than current key
		else if (k.compareTo(r.getKey()) == 1) r.setRight(delete(r.getRight(), k)); //move right if deletion key is greater than current key
		else { //if we have found the key
			//if node with one child, use non-null child as replacement
			if (r.getLeft() == null) return r.getRight();
			else if (r.getRight() == null) return r.getLeft();
			r.setNode(min(r.getRight())); //set node to minimum of right subtree (next in inorder traversal)
			r.setRight(delete(r.getRight(), r.getKey())); //delete the node we just got from the inorder call
		}
		return r; //return to keep tree in previous form
	}
	
	private DataItem min(Node r) {
		//find left-most (minimal) node of a given tree
		while(r.getLeft() != null) {
			r = r.getLeft();
		}
		return r.getNode();
	}
	
	public DataItem successor(Key k) {

		Node successor = null;
		Node current = this.root;
		//returns null if current is a leaf
		if (current.isLeaf()) {
			return null;
		}
		while (current != null) {
			//if key is less than current, makes the current the successor and checks left, else traverse right
			if (k.getName().compareTo(current.getKey().getName()) < 0) {
				successor = current;
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		//handles case where predecessor does not exist
		if (successor == null) {
			return null;
		}
		return successor.getNode();
	}
	
	//finds smallest value that is larger than the object
	public DataItem predecessor(Key k) {
//		if (this.root == null) {
//			return null;
//		}
		Node predecessor = null;
		Node current = this.root;
		//returns null if current is a leaf
		if (current.isLeaf()) {
		return null;
		}
		
		//searches for key while not null
		while (current != null) {
			//if key is greater than current, makes the current the predecessor and checks right, else traverse left
			if (k.getName().compareTo(current.getKey().getName()) > 0) {
				predecessor = current;
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		//handles case where predecessor does not exist
		if (predecessor == null) {
			return null;
		}
		return predecessor.getNode();
	}

	//finds smallest object
	public DataItem smallest(Node r) {
		if (r.getLeft() == null) return r.getNode();
		return smallest(r.getLeft());
	}

	//finds largest object
	public DataItem largest(Node r) {
		if (r.getRight() == null) return r.getNode();
		return largest(r.getRight());
	}

}



