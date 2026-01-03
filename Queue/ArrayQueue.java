// Queue using Array (Fixed Size Circular Queue)
class ArrayQueue {
    private int[] queue;
    private int front, rear; // both front and rear are indices
    private int size, capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0; // Storing how many numbers are in the queue
    }

    // Enqueue: Add element
    public void enqueue(int value) {
        // Check for Queue overflow condition
        if (rear == front && size!=0) {
            System.out.println("Queue Overflow! Cannot enqueue " + value);
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity; // Suppose front is at index 3, rear at capacity-1, if we just set rear=rear+1, then the slots 0,1 and 2 will be unused
        size++;
        System.out.println(value + " enqueued to the queue.");
    }

    // Dequeue: Remove element
    public int dequeue() {
        // Check for queue underflow condition
        if (front == rear) {
            System.out.println("Queue Underflow! Cannot dequeue from an empty queue.");
            return -1;
        }
        int removed = queue[front];
        queue[front] = 0; // Clear the slot
        front = (front + 1) % capacity;
        size--;
        System.out.println(removed + " dequeued from the queue.");
        return removed;
    }

    // Peek: Get front element
    public void peek() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Front element is: " + queue[front]);
    }

    

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.peek();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.enqueue(30);

    }
}
