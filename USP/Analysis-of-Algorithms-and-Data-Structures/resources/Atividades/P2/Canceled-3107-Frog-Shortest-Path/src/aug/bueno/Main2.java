/*
package aug.bueno;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

    */
/*
    * 1. calculo curtos  ->
            int[][] graphAdj;
            QualInfoGuarda -> Custo(qtd passos) saindo "i" e indo até "j"
            //Diagonal
    *
    *
    *
    * 2. applicar pulos longos em cima do resultado (1 == graphAdj);
    *       Oq nós queremos -> menor número de passos - tendo 1 passo long no máximo
    *
    * *//*



public class Main2 {
    public static int X; //Long
    public static int Y; //Curto

    public static void main(String[] args) throws Exception {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        String[] in = s.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        String[] entrada = s.readLine().split(" ");
        int[] numbers = new int[n + 2];
        numbers[0] = 0;
        numbers[numbers.length - 1] = m;

        for (int i = 0; i < n; i++) {
            numbers[i + 1] = Integer.parseInt(entrada[i]);
        }

        in = s.readLine().split(" ");
        X = Integer.parseInt(in[0]);
        Y = Integer.parseInt(in[1]);

        Graph graph = new Graph(n + 2);

        Main2 e = new Main2();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] - numbers[i] <= X) {
                    // computar com pulos curtos
                    e.addEdge(graph, i, j, 1);
                }
            }
        }

        int[] parents = e.prims_mst(graph);


    }

    class node1 {

        int dest;
        int weight;

        node1(int a, int b) {
            dest = a;
            weight = b;
        }
    }

    static class Graph {

        int V;
        LinkedList<node1>[] adj;

        Graph(int e) {
            V = e;
            adj = new LinkedList[V];
            for (int o = 0; o < V; o++)
                adj[o] = new LinkedList<>();
        }
    }

    // class to represent a node in PriorityQueue
    // Stores a vertex and its corresponding
    // key value
    class node {
        int vertex;
        int key;
    }

    // Comparator class created for PriorityQueue
    // returns 1 if node0.key > node1.key
    // returns 0 if node0.key < node1.key and
    // returns -1 otherwise
    class comparator implements Comparator<node> {

        @Override
        public int compare(node node0, node node1) {
            return node0.key - node1.key;
        }
    }

    void addEdge(Graph graph, int src, int dest, int weight) {


        node1 node0 = new node1(dest, weight);
        node1 node = new node1(src, weight);
        graph.adj[src].addLast(node0);
        graph.adj[dest].addLast(node);
    }

    int[] prims_mst(Graph graph) {

        // Whether a vertex is in PriorityQueue or not
        Boolean[] mstset = new Boolean[graph.V];
        node[] e = new node[graph.V];

        // Stores the parents of a vertex
        int[] parent = new int[graph.V];

        for (int o = 0; o < graph.V; o++)
            e[o] = new node();

        for (int o = 0; o < graph.V; o++) {
            mstset[o] = false;

            // Initialize key values to infinity
            e[o].key = Integer.MAX_VALUE;
            e[o].vertex = o;
            parent[o] = -1;
        }

        // Include the source vertex in mstset
        mstset[0] = true;

        // Set key value to 0
        // so that it is extracted first
        // out of PriorityQueue
        e[0].key = 0;

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<node> queue = new TreeSet<node>(new comparator());

        for (int o = 0; o < graph.V; o++)
            queue.add(e[o]);

        // Loops until the queue is not empty
        while (!queue.isEmpty()) {

            // Extracts a node with min key value
            node node0 = queue.pollFirst();

            // Include that node into mstset
            mstset[node0.vertex] = true;

            // For all adjacent vertex of the extracted vertex V
            for (node1 iterator : graph.adj[node0.vertex]) {

                // If V is in queue
                if (mstset[iterator.dest] == false) {
                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (e[iterator.dest].key > iterator.weight) {
                        queue.remove(e[iterator.dest]);
                        e[iterator.dest].key = iterator.weight;
                        queue.add(e[iterator.dest]);
                        parent[iterator.dest] = node0.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int o = 1; o < graph.V; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);

        return parent;
    }


}
*/
