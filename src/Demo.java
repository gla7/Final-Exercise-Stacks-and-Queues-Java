
public class Demo {
	
	public static void main (String[] args) {
		// demo-ing stack using linkedList...
		Stack newStack = new Stack();
		
		newStack.push(1);
		newStack.push(2);
		newStack.push(3);
		newStack.push(4);
		newStack.push(5);
		
		System.out.println(newStack);
		
		newStack.pop();
		
		System.out.println(newStack);
		
		newStack.pop();
		
		System.out.println(newStack);
		
		newStack.pop();
		
		System.out.println(newStack);
		
		System.out.println(newStack.peek());
		
		//demo-ing twoStack using array...
		
		TwoStack newTwoStack = new TwoStack();
		
		newTwoStack.pushTop(1);
		newTwoStack.pushTop(2);
		newTwoStack.pushBottom(3);
		newTwoStack.pushBottom(4);
		newTwoStack.pushBottom(5);
		
		System.out.println(newTwoStack.peekTop());
		System.out.println(newTwoStack.peekBottom());
		
		newTwoStack.popTop();
		newTwoStack.popBottom();
		newTwoStack.popBottom();
		
		System.out.println(newTwoStack.peekTop());
		System.out.println(newTwoStack.peekBottom());
	}
	
}
