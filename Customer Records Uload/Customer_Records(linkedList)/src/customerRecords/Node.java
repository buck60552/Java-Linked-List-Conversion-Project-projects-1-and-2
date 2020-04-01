package customerRecords;

public class Node {
	
	
	/** Node of a singly linked list of strings. */
	private CustomerRecord element; // we assume elements are character strings
	private Node next;

	/** Creates a node with the given element and next node. */
	public Node(CustomerRecord cr, Node n) {
		element = cr;
		next = n;
	}

	public Node(CustomerRecord cr) {
		element = cr;
		next = null;
	}
	
	/** Returns the element of this node. */
	public CustomerRecord getElement() {
		return element;
	}

	/** Returns the next node of this node. */
	public Node getNext() {
		return next;
	}

	// Modifier methods:
	/** Sets the element of this node. */
	public void setElement(CustomerRecord cr) {
		element = cr;
	}

	/** Sets the next node of this node. */
	public void setNext(Node newNext) {
		next = newNext;
	}

}