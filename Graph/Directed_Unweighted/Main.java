import java.util.Arrays;

/*
  - Adjacency List is the array named: arr
  - EdgeNode is the linked-list node class named: Node
*/

class Node {
    int to;
    int weight;   // always 1 for unweighted graph
    Node next;

    Node(int to, Node next) {
        this.to = to;
        this.weight = 1;   // default weight = 1
        this.next = next;
    }
}

public class Main {

    // Add a directed UNWEIGHTED edge: from -> to
    void addEdge(Node[] arr, int from, int to) {
        arr[from] = new Node(to, arr[from]); // insert at head
        // arr[to] = new Node(from, arr[to]); // uncomment for undirected
    }

    int outDegree(Node[] arr, int v) {
        int deg = 0;
        Node cur = arr[v];
        while (cur != null) {
            deg++;
            cur = cur.next;
        }
        return deg;
    }

    int inDegree(Node[] arr, int v) {
        int deg = 0;
        for (int u = 0; u < arr.length; u++) {
            Node cur = arr[u];
            while (cur != null) {
                if (cur.to == v) deg++;
                cur = cur.next;
            }
        }
        return deg;
    }

    void printAdjList(Node[] arr, String[] name) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " (" + name[i] + "):");
            Node cur = arr[i];
            while (cur != null) {
                System.out.print(" -> (" + name[cur.to] + ", w=" + cur.weight + ")");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Main g = new Main();

        String[] name = {"Dhaka", "Chattogram", "Sylhet", "Rajshahi", "Khulna"};

        int n = name.length;
        Node[] arr = new Node[n];
        Arrays.fill(arr, null);

        // Build directed UNWEIGHTED graph
        g.addEdge(arr, 0, 1);
        g.addEdge(arr, 0, 2);
        g.addEdge(arr, 1, 2);
        g.addEdge(arr, 2, 0);
        g.addEdge(arr, 2, 3);
        g.addEdge(arr, 3, 4);
        g.addEdge(arr, 4, 1);

        // You don't need to memorize these codes to create a graph.
        // You will be given an adjacency list/matrix.
        // Try to understand the classes and functions above.

        System.out.println("Adjacency List:");
        g.printAdjList(arr, name);
        System.out.println();

        for (int v = 0; v < n; v++) {
            System.out.println(
                "City " + name[v] +
                " has indegree " + g.inDegree(arr, v) +
                ", outdegree " + g.outDegree(arr, v)
            );
        }
    }
}
