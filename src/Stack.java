
public class Stack {// just a linked list with stack's methods! The clear advantage of using a linkedList is that the size is unlimited and push, pop, and peek are very simple head operations on the linkedList of O(1)
	
	// here are the stack's particular methods
	
	public Node top () {return this.head;}
	
	public int peek () {
		return this.top().getData();
	}
	
	public void pop () {
		this.head = this.top().getNextNode();
	}
	
	public void push (int data) {
		this.insertAtHead(data);
	}
	
	// here are the stack's particular methods, and below are the ones of the linkedList it's represented by!
	
	private Node head;
	
	public void insertAtHead (int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public int length () {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			current = current.getNextNode();
			length++;
		}
		return length;
	}

	public String toString() {
		String result = "{";
		Node current = this.head;
		
		while (current != null) {
			result = result + current.toString() + ", ";
			current = current.getNextNode();
		}
		result = result + "END}";
		return result;
	}
	
	public void deleteFromHead () {
		this.head = this.head.getNextNode();
	}
	
	public Node find (int searchingForThis) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == searchingForThis) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	public void insertNewElement (int data) {
		Node newNode = new Node(data);
		Node current = this.head;
		if (current == null) {
			this.insertAtHead(data);
		}
		while (current != null) {
			if (this.head == current) {
				if (current.getData() > newNode.getData()) {
					this.insertAtHead(data);
					break;
				} else if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					break;
				} else if (current.getNextNode().getData() > newNode.getData()) {
					newNode.setNextNode(current.getNextNode());
					current.setNextNode(newNode);
					break;
				}
			} else {
				if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					break;
				} else if (current.getNextNode().getData() > newNode.getData()) {
					newNode.setNextNode(current.getNextNode());
					current.setNextNode(newNode);
					break;
				}
			}
			current = current.getNextNode();
		}
	}
	
}
