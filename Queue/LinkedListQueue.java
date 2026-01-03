// Queue using Linked List (Dynamic Size)
class Node {
    int elem;
    Node next;

    public Node(int elem) {
        this.elem = elem;
        this.next = null;
    }
}
class LinkedListQueue {
    private Node front, rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue: Add element at the end
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null)  // Queue is empty now
        {
            front = rear = newNode;
            System.out.println(value + " enqueued to the queue.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println(value + " enqueued to the queue.");
    }

    // Dequeue: Remove element from the front
    public int dequeue() {
        // Checking for Underflow
        if (front == null) {
            System.out.println("Queue Underflow! Cannot dequeue from an empty queue.");
            return -1;
        }
        int temp = front.elem;
        System.out.println(front.elem + " dequeued from the queue.");
        front = front.next;
        if (front == null) // Queue becomes empty now
            rear = null; 
        return temp;
    }

    // Peek: Show front element
    public void peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Front element is: " + front.elem);
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.peek();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
    }
}
