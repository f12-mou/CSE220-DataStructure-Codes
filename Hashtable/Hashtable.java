import java.util.*;

// Node class: represents a key-value pair in a linked list
class Node {
    int key;
    String value;
    Node next;

    Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// HashTable class with separate chaining
class HashTable {
    private Node[] table;  // Array of linked lists
    private int capacity;  // Number of buckets

    // Constructor
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    // Hash function: simple modulo
    private int hash(int key) {
        return key % capacity;
    }

    // ---------------------------------------------------------------------
    // 1. Normal separate chaining (insert at the END of the chain)
    // ---------------------------------------------------------------------
    public void insertNormal(int key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null)  // no collision
        {
            table[index] = newNode;
            return;
        }
        // collision

        Node current = table[index];
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // ---------------------------------------------------------------------
    // 2.  Insert in ascending order of keys (within the chain)
    // ---------------------------------------------------------------------
    public void insertAscending(int key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null || key < table[index].key) {
            newNode.next = table[index];
            table[index] = newNode;
            return;
        }
        // collision

        Node current = table[index];
        while (current.next != null && current.next.key < key) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // ---------------------------------------------------------------------
    // 3. Insert in descending order of keys (within the chain)
    // ---------------------------------------------------------------------
    public void insertDescending(int key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null || key > table[index].key) {
            newNode.next = table[index];
            table[index] = newNode;
            return;
        }

        Node current = table[index];
        while (current.next != null && current.next.key > key) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // ---------------------------------------------------------------------
    // 4. Odd-Even rule: Odd key -> prepend | Even key -> append
    // ---------------------------------------------------------------------
    public void insertOddEven(int key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
            return;
        }

        // Odd key → prepend
        if (key % 2 != 0) {
            newNode.next = table[index];
            table[index] = newNode;
        }
        // Even key → append
        else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // ---------------------------------------------------------------------
    // Function to display the entire hash table
    // ---------------------------------------------------------------------
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print("[" + current.key + " -> " + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
        System.out.println("-----------------------------------");
    }

    // ---------------------------------------------------------------------
    // Search function
    // ---------------------------------------------------------------------
    public String search(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }
        return null;
    }

    // ---------------------------------------------------------------------
    // Delete function
    // ---------------------------------------------------------------------
    public void delete(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        if (current == null)
            return; // Key not found

        if (prev == null)
            table[index] = current.next;
        else
            prev.next = current.next;
    }

    // ---------------------------------------------------------------------
    // Demo function to test all insertion modes
    // ---------------------------------------------------------------------
    public static void main(String[] args) {
        HashTable ht = new HashTable(5);

        System.out.println("Normal Insertion:");
        ht.insertNormal(11, "Apple");
        ht.insertNormal(6, "Banana");
        ht.insertNormal(16, "Cherry");
        ht.insertNormal(21, "Date");
        ht.display();

        System.out.println("Ascending Order Insertion:");
        ht = new HashTable(5);
        ht.insertAscending(11, "Apple");
        ht.insertAscending(6, "Banana");
        ht.insertAscending(16, "Cherry");
        ht.insertAscending(21, "Date");
        ht.display();

        System.out.println("Descending Order Insertion:");
        ht = new HashTable(5);
        ht.insertDescending(11, "Apple");
        ht.insertDescending(6, "Banana");
        ht.insertDescending(16, "Cherry");
        ht.insertDescending(21, "Date");
        ht.display();

        System.out.println("Odd-Even Insertion:");
        ht = new HashTable(5);
        ht.insertOddEven(11, "Apple");
        ht.insertOddEven(6, "Banana");
        ht.insertOddEven(16, "Cherry");
        ht.insertOddEven(21, "Date");
        ht.insertOddEven(7, "Mango");
        ht.display();
    }
}
