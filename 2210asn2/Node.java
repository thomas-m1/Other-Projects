/* Thomas Michalski
 * 2210 asn3
 * 251027332
 * 2020-12-08
 */

//public class Node {
//
//        private int name;
//        private boolean mark;
//
//        public Node(int name) {
//                this.name = name;
//                this.mark = false;
//        }
//
//        public void setMark(boolean mark) {
//                this.mark = mark;
//        }
//
//        public boolean getMark() {
//                return this.mark;
//        }
//
//        public int getName() {
//                return this.name;
//        }
//
//}
public class Node {
	private DataItem node;
	private Node parent, left, right;
	
	//constructor for node class
	public Node(DataItem node, Node left, Node right, Node parent) {
		this.node = node; //data item stored in this node
		this.left = left; //left child node
		this.right = right; //right child node
		this.parent = parent; //parent node
	}
	
	//gets dataitem node
	public DataItem getNode() {
		return this.node; 
	}
	
	//sets dataitem node
	public void setNode(DataItem item) { 
		this.node = item; 
	}
	
	//gets left node
	public Node getLeft() { 
		return this.left; 
	}
	
	//sets left node
	public void setLeft(Node item) { 
		this.left = item; 
	}
	
	//gets right node
	public Node getRight() { 
		return this.right; 
	}
	
	//sets right node
	public void setRight(Node item) { 
		this.right = item; 
	}
	
	//gets parent node
	public Node getParent() { 
		return this.parent; 
	}
	
	//sets parent node
	public void setParent(Node item) { 
		this.parent = item; 
	}
	
	//gets key
	public Key getKey() { 
		return this.node.getKey(); 
	}
	
	// Method to check if the node is a leaf
	public boolean isLeaf() {
		return node == null;
	}
	//returns dataItem of a node
	public DataItem getData() {
		return this.node;
	}


}
