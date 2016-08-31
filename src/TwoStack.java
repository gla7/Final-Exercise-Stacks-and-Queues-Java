
public class TwoStack {// all operations are O(1)! Push and pop methods change by changing an index that runs up and down in the array
	public int[] arrayTwoStack = new int[100];
	
	public int topTopIndex = -1;
	
	public int topBottomIndex = -2;
	
	private int topTop () {return (topTopIndex >= 0) ? arrayTwoStack[topTopIndex] : -999999;}
	
	private int topBottom () {return (topBottomIndex >= 0) ? arrayTwoStack[topBottomIndex] : -999999;}
	
	public int peekTop () {
		return this.topTop();
	}
	
	public int peekBottom () {
		return this.topBottom();
	}
	
	public void pushTop (int data) {
		this.topTopIndex = this.topTopIndex + 2;
		this.arrayTwoStack[topTopIndex] = data;
	}
	
	public void pushBottom (int data) {
		this.topBottomIndex = this.topBottomIndex + 2;
		this.arrayTwoStack[topBottomIndex] = data;
	}
	
	public void popTop () {
		this.topTopIndex = this.topTopIndex - 2;
	}
	
	public void popBottom () {
		this.topBottomIndex = this.topBottomIndex - 2;
	}

}
