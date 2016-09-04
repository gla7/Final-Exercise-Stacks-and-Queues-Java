
public class DoublyLinkedNode {
	
	private int data;
	private DoublyLinkedNode nextNode;
	//new for doubly linked lists!
	private DoublyLinkedNode prevNode;
	//new for doubly linked lists!
	
	public int getData () {
		return this.data;
	}
	
	public DoublyLinkedNode getNextNode () {
		return this.nextNode;
	}
	
	//new for doubly linked lists!
	public DoublyLinkedNode getPrevNode () {
		return this.prevNode;
	}
	//new for doubly linked lists!
	
	public void setData (int data) {
		this.data = data;
	}
	
	public void setNextNode (DoublyLinkedNode nextNode) {
		this.nextNode = nextNode;
	}
	
	//new for doubly linked lists!
	public void setPrevNode (DoublyLinkedNode prevNode) {
		this.prevNode = prevNode;
	}
	//new for doubly linked lists!
	
	public DoublyLinkedNode (int data) {
		this.data = data;
	}
	
	public String toString() {
		return "Data: " + this.data;
	}

}

