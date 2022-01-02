//Thomas Michalski
//computer science CS1027
//Assignment 2
//Oct 22, 2019

public class ArrayStack<T> implements ArrayStackADT<T> {
	
	private T[] stack;
	private int top;
	
	//creates empty stack 
	public ArrayStack() {	
		top = -1;
		stack = (T[])(new Object[25]);
		}
	
	//creates an empty stack
	public ArrayStack(int initialCapacity) {
		top = -1;
		stack = (T[])(new Object[initialCapacity]);
	}

	//adds element to top of stack expanding capacity stack if needed
	public void push(T dataItem) {
		if (size() == stack.length) {
			if (stack.length<100) {
				T[] larger = (T[]) (new Object[stack.length*3]);
				for (int i=0; i < stack.length; i++) {
					larger[i]=stack[i];
				}
				stack=larger;
			}
			else {
				T[] larger = (T[]) (new Object[stack.length+25]);
				for (int i=0; i < stack.length; i++) {
					larger[i]=stack[i];
				}	
				stack=larger;
			}
		}
		stack[top +1] = dataItem;
		top++;
	}
	
	//removes the element at top of the stack and returns reference, throws EmptyCollectionException if stack is empty.
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		}
		T s = stack[top];
		stack[top] = null;
		top--;
		if ((size()) < (stack.length/4) && stack.length>40) {
			T[] half = (T[]) (new Object[stack.length/2]);
			for (int i=0; i < stack.length/2; i++) {
				half[i] = stack[i];
			}
			stack = half;
		}
		return s;
		}

	
	// returns reference to element at top of stack and throws EmptyCollectionException if stack is empty
	public T peek() throws EmptyStackException{
		 if (isEmpty()) {
	         throw new EmptyStackException("stack is empty");
		 }
	     return stack[top];
	}
	
	//returns true if stack is empty and false otherwise
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//returns the number of elements in stack
	public int size() {
		return top + 1;
	}
	
	//returns length of stack
	public int length() {
		return stack.length;
	}
	
	// Returns a string representation of stack
	public String toString() {
		String s = "";
		for(int i = 0; i < top; i++){  
			s = s+ stack[i].toString() + ", ";
		}
		s = "Stack: "+ s + stack[top];
		return s;		
	}
}
