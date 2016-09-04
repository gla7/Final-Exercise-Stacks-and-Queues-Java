
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
		
		Stack stackWithTopNull = new Stack();
		
		System.out.println(stackWithTopNull.top());

		// demoing a prefix calculator using a single stack:
		
		System.out.println(performOperation("+ 1 2"));
		System.out.println(performOperation("+ 1 * 2 3"));
		System.out.println(performOperation("+ + 1 * 2 3 4"));
		System.out.println(performOperation("* + 1 2 + 3 4"));
		System.out.println(performOperation("+ * 1 2 * 3 4"));
		System.out.println(performOperation("+ + + 1 2 3 4"));
		System.out.println(performOperation("- * + 1 2 3 * - 4 5 + 6 7"));
		
		// demoing a queue through a linkedList
		
		Queue newQueue = new Queue();
		
		newQueue.enqueue(1);
		newQueue.enqueue(2);
		newQueue.enqueue(3);
		newQueue.enqueue(4);
		newQueue.enqueue(5);
		
		System.out.println(newQueue);
		
		newQueue.dequeue();
		newQueue.dequeue();
		newQueue.dequeue();
		
		System.out.println(newQueue);
		
		System.out.println(newQueue.peek());
	}
	
	public static double performOperation (String operation) { // we are implementing a prefix notation string calculator using a stack
		String[] operationArray = operation.split(" "); // turns string into array of strings
		String previous = "#"; // default null value of previous
		String current = "#"; // default null value of current
		StackString stackOfOperation = new StackString(); // define new stack
		for (int i = 0; i < operationArray.length; i++) { // looping over every element in array
			current = operationArray[i]; // setting current to the current element in array
			if (previous.equals("#") || previous.equals("+") || previous.equals("-") || previous.equals("*") || previous.equals("/") || previous.equals("%")) {
				stackOfOperation.push(current); // if previous is an operator or null, then just push the current on top
				previous = stackOfOperation.peek(); // set previous to current for next loop
			} else { // if previous is a number
				if (current.equals("#") || current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/") || current.equals("%")) {
					stackOfOperation.push(current); // if previous is an operator or null, then just push the current on top
					previous = stackOfOperation.peek(); // set previous to current for next loop
				} else {
					stackOfOperation.pop(); // removes previous from the top of the stack, so top two numbers are stored in current and previous
					String lastOperation = stackOfOperation.peek(); // this should be an operator
					stackOfOperation.pop(); // operator is accessible through lastOperation
					String nextOperationOrNumber = "not initialized"; // initialize nextOperationOrNumber (this may be null)
					Boolean mustReturn = false; // initialize the controller for whether we need to return or not yet
					if (stackOfOperation.top() == null) {
						mustReturn = true; // if the top is null, we've reached the end of the stack and need to return
					} else {
						nextOperationOrNumber = stackOfOperation.peek(); // else, we need to continue crunching numbers via the while loop
					}
					if (lastOperation.equals("+")) { // perform the operation and push it into the stack
						stackOfOperation.push(Double.toString(Double.parseDouble(previous) + Double.parseDouble(current)));
					} else if (lastOperation.equals("-")) {
						stackOfOperation.push(Double.toString(Double.parseDouble(previous) - Double.parseDouble(current)));
					} else if (lastOperation.equals("*")) {
						stackOfOperation.push(Double.toString(Double.parseDouble(previous) * Double.parseDouble(current)));
					} else if (lastOperation.equals("/")) {
						stackOfOperation.push(Double.toString(Double.parseDouble(previous) / Double.parseDouble(current)));
					} else if (lastOperation.equals("%")) {
						stackOfOperation.push(Double.toString(Double.parseDouble(previous) % Double.parseDouble(current)));
					} else {
						return -999999.99;
					}
					if (mustReturn == true) {
						return Double.parseDouble(stackOfOperation.peek()); // if that's the end of the stack, return the last value calculated
					} else { // or continue crunching numbers wherever we get a number below the newest one
						current = stackOfOperation.peek();
						previous = nextOperationOrNumber;
					}
					while (!nextOperationOrNumber.equals("+") && !nextOperationOrNumber.equals("-") && !nextOperationOrNumber.equals("*") && !nextOperationOrNumber.equals("/") && !nextOperationOrNumber.equals("%")) { // if the new top of stack is a number
						stackOfOperation.pop();
						stackOfOperation.pop();
						String operationAtHand = stackOfOperation.peek();
						stackOfOperation.pop();
						if (stackOfOperation.top() == null) {
							mustReturn = true;
						} else {
							nextOperationOrNumber = stackOfOperation.peek();
						}
						if (operationAtHand.equals("+")) {
							stackOfOperation.push(Double.toString(Double.parseDouble(previous) + Double.parseDouble(current)));
						} else if (operationAtHand.equals("-")) {
							stackOfOperation.push(Double.toString(Double.parseDouble(previous) - Double.parseDouble(current)));
						} else if (operationAtHand.equals("*")) {
							stackOfOperation.push(Double.toString(Double.parseDouble(previous) * Double.parseDouble(current)));
						} else if (operationAtHand.equals("/")) {
							stackOfOperation.push(Double.toString(Double.parseDouble(previous) / Double.parseDouble(current)));
						} else if (operationAtHand.equals("%")) {
							stackOfOperation.push(Double.toString(Double.parseDouble(previous) % Double.parseDouble(current)));
						} else {
							return -999999.99;
						}
						if (mustReturn == true) {
							return Double.parseDouble(stackOfOperation.peek());
						} else {
							current = stackOfOperation.peek();
							previous = nextOperationOrNumber;
						}
					}
					previous = current;
				}
			}
		}
		return -999999.99;
	} // this function takes O(n) time complexity
	
}
