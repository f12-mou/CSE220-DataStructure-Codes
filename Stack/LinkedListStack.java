// Stack Implementation using Linked List
class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    Node top; // Points to the top of the stack

    // Constructor
    public LinkedListStack() {
        this.top = null;
    }

    // Push Operation: Add an element at the top
    public void push(int value) {
        Node newNode = new Node(value);

        // If stack is empty
        if (top == null) {
            top = newNode;
        } else {
            // New node points to the old top
            newNode.next = top;
            // Update top to new node
            top = newNode;
        }
        System.out.println(value + " pushed to stack.");
    }

    // Pop Operation: Remove the top element
    public void pop() {
        if (top == null) {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
            return;
        }

        // Store current top in a temp variable
        Node temp = top;
        System.out.println(temp.data + " popped from stack.");
        // Move top to next node
        top = top.next;
        // Free the old top node
        temp.next = null;
    }

    // Peek Operation: Return top element without removing it
    public void peek() {
        if (top == null) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }
        System.out.println("Top element is: " + top.data);
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.peek();   // View top element
        stack.pop();    // Remove top element ---- 30
        stack.peek();
        stack.pop();    // 20 popped
        stack.pop();    // 10 popped
        stack.pop();    // Stack Underflow
        stack.peek();   // Stack Undeflow
        // Try to generate an example where Stack Overflow occurs (if any)
        // THE PRINT STATEMENTS ARE GIVEN FOR YOUR UNDERSTANDING. YOU DON'T NEED TO WRITE THE PRINTS IN EXAM.
    }
}
