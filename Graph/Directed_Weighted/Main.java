import java.util.Arrays;

/*
  - Adjacency List is the array named: arr
  - EdgeNode is the linked-list node class named: Node
*/

class Node {
    int to;
    int weight;
    Node next;

    Node(int to, int weight, Node next) {
        this.to = to;
        this.weight = weight;
        this.next = next;
    }
}

public class Main {

    // Add a directed edge: from -> to (weight)
    void addEdge(Node[] arr, int from, int to, int weight) {
        arr[from] = new Node(to, weight, arr[from]); // insert at head, prepend
        // arr[to] = new Node(from, weight, arr[to]);
        // Uncomment this line for undirected edge
    }

    int outDegree(Node[] arr, int v) // Outdegree is how many edges come out from this node, v
	{
        int deg = 0;
        Node cur = arr[v];
        while (cur != null) {
            deg++;
            cur = cur.next;
        }
        return deg;
    }

    int inDegree(Node[] arr, int v)  // Indegree is how many edges enter into this node, v
	{
        int deg = 0;
		// You need traverse the whole list
        for (int u = 0; u < arr.length; u++) 
		{
            Node cur = arr[u];
            while (cur != null) 
			{
                if (cur.to == v) deg++;
                cur = cur.next;
            }
        }
        return deg;
    }

    int sumOutgoingWeights(Node[] arr, int v) {
        int sum = 0;
        Node cur = arr[v];
        while (cur != null) 
		{
            sum += cur.weight;
            cur = cur.next;
        }
        return sum;
    }

    int sumIncomingWeights(Node[] arr, int v) {
        int sum = 0;
        for (int u = 0; u < arr.length; u++) 
		{
            Node cur = arr[u];
            while (cur != null) 
			{
                if (cur.to == v) sum += cur.weight;
                cur = cur.next;
            }
        }
        return sum;
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

        Main g = new Main(); // object to call non-static methods

        String[] name = {"Dhaka", "Chattogram", "Sylhet", "Rajshahi", "Khulna"};
        int[] toll = {5, 2, 4, 3, 1};

        int n = name.length;
        Node[] arr = new Node[n];
        Arrays.fill(arr, null);

        // Build directed weighted graph
        g.addEdge(arr, 0, 1, 7);
        g.addEdge(arr, 0, 2, 3);
        g.addEdge(arr, 1, 2, 2);
        g.addEdge(arr, 2, 0, 4);
        g.addEdge(arr, 2, 3, 6);
        g.addEdge(arr, 3, 4, 5);
        g.addEdge(arr, 4, 1, 1);

		// You don't need to memorize these codes to create a graph. You will be given an adjacency list/matrix. Try to understand the classes and functions above. 

        System.out.println("Adjacency List:");
        g.printAdjList(arr, name);
        System.out.println();

        for (int v = 0; v < n; v++) 
		{
            System.out.println(
                "City " + name[v] +
                " has indegree " + g.inDegree(arr, v) +
                ", outdegree " + g.outDegree(arr, v)
            );
        }
    }
}
