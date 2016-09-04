
public class StackString {
	
	// here are the stack's particular methods
	
	public NodeString top () {return this.head;}
	
	public String peek () {
		return this.top().getData();
	}
	
	public void pop () {
		this.head = this.top().getNextNode();
	}
	
	public void push (String data) {
		this.insertAtHead(data);
	}
	
	// here are the stack's particular methods, and below are the ones of the linkedList it's represented by!
	
	private NodeString head;
	
	public void insertAtHead (String data) {
		NodeString newNode = new NodeString(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public int length () {
		int length = 0;
		NodeString current = this.head;
		while (current != null) {
			current = current.getNextNode();
			length++;
		}
		return length;
	}

	public String toString() {
		String result = "{";
		NodeString current = this.head;
		
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
	
	public NodeString find (String searchingForThis) {
		NodeString current = this.head;
		while (current != null) {
			if (current.getData() == searchingForThis) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
}
