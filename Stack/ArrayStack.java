// Stack Implementation using Array
class ArrayStack {
    int[] stack;   // Array to store stack elements
    int top;       // Index of the top element
    int capacity;  // Maximum size of the stack

    // Constructor
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1; // Indicates an empty stack
    }

    // Push Operation: Add an element on top of the stack
    public void push(int value) 
    {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        top = top + 1;
        stack[top] = value;
        // System.out.println(value + " pushed to stack.");
    }

    // Pop Operation: Remove the top element
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow (No elem in Stack)! Cannot pop from an empty stack.");
            return;
        }
        int removed = stack[top];
        top = top - 1;
        // System.out.println(removed + " popped from stack.");
    }

    // Peek Operation: Return the top element without removing it
    public int peek() {
        if (top == -1) {
            System.out.println("Stack Underflow (No elem in Stack)! Stack is empty.");
            return -1;
        }
        System.out.println("Top element is: " + stack[top]);
        return stack[top];
        // See the difference between peek and pop operations
    }
    public boolean isEmpty()
    {
        return top==-1;
    }

    // Main method to test the Stack
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

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
        // Try to generate an example where Stack Overflow occurs
        // THE PRINT STATEMENTS ARE GIVEN FOR YOUR UNDERSTANDING. YOU DON'T NEED TO WRITE THE PRINTS IN EXAM.
    }
}
