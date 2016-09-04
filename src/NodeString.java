

public class NodeString {
	
	private String data;
	private NodeString nextNode;
	
	public String getData () {
		return this.data;
	}
	
	public NodeString getNextNode () {
		return this.nextNode;
	}
	
	public void setData (String data) {
		this.data = data;
	}
	
	public void setNextNode (NodeString nextNode) {
		this.nextNode = nextNode;
	}
	
	public NodeString (String data) {
		this.data = data;
	}
	
	public String toString() {
		return "Data: " + this.data;
	}
	
}

