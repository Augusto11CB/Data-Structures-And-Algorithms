package aug.bueno;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int X; //Long
    public static int Y; //Curto
    public static int MAX_DEPTH = Integer.MAX_VALUE; //Curto

    private BagOfItems<Edge> mst = new BagOfItems<Edge>();    // Edge in MST
    private double weight;                      // weight of MST

    public Main(EdgeWeightedGraph G) {
        UF uf = new UF(G.V());
        // repeat at most log V times or until we have V-1 Edge
        for (int t = 1; t < G.V() && mst.size() < G.V() - 1; t = t + t) {
            // foreach tree in forest, find closest edge
            // if edge weights are equal, ties are broken in favor of first edge
            // in G.Edge()
            Edge[] closest = new Edge[G.V()];
            for (Edge e : G.Edge()) {
                int v = e.either(), w = e.other(v);
                int i = uf.find(v), j = uf.find(w);
                if (i == j)
                    continue;   // same tree
                if (closest[i] == null || less(e, closest[i]))
                    closest[i] = e;
                if (closest[j] == null || less(e, closest[j]))
                    closest[j] = e;
            }
            // add newly discovered Edge to MST
            for (int i = 0; i < G.V(); i++) {
                Edge e = closest[i];
                if (e != null) {
                    int v = e.either(), w = e.other(v);
                    // don't add the same edge twice
                    if (!uf.connected(v, w)) {
                        mst.add(e);
                        weight += e.weight();
                        uf.union(v, w);
                    }
                }
            }
        }
        // check optimality conditions
        assert check(G);
    }

    public Iterable<Edge> Edge() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    // is the weight of edge e strictly less than that of edge f?
    private static boolean less(Edge e, Edge f) {
        return e.weight() < f.weight();
    }

    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(EdgeWeightedGraph G) {
        // check weight
        double totalWeight = 0.0;
        for (Edge e : Edge()) {
            totalWeight += e.weight();
        }
        double EPSILON = 1E-12;
        if (Math.abs(totalWeight - weight()) > EPSILON) {
            System.err.printf(
                    "Weight of Edge does not equal weight(): %f vs. %f\n",
                    totalWeight, weight());
            return false;
        }
        // check that it is acyclic
        UF uf = new UF(G.V());
        for (Edge e : Edge()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }
        // check that it is a spanning forest
        for (Edge e : G.Edge()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }
        // check that it is a minimal spanning forest (cut optimality
        // conditions)
        for (Edge e : Edge()) {
            // all Edge in MST except e
            uf = new UF(G.V());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e)
                    uf.union(x, y);
            }
            // check that e is min weight edge in crossing cut
            for (Edge f : G.Edge()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f
                                + " violates cut optimality conditions");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // AUG-MARK
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

        EdgeWeightedGraph G = new EdgeWeightedGraph(n + 2, numbers);

        Main mst = new Main(G);


        System.gc();
        dfs(mst, false, 0, 0, (numbers.length - 1), numbers);
//        for (Edge e : mst.Edge()) {
//            System.out.println(e);
//        }

        System.out.println(MAX_DEPTH != Integer.MAX_VALUE ? MAX_DEPTH - 1 : -1);
    }

    public static void dfs(Main mst, boolean puloLongo, int profundidade, int posicao, int objetivo, int[] numbers) {
        if (profundidade >= MAX_DEPTH) return;

        if (posicao == objetivo) {
            MAX_DEPTH = profundidade;
            return;
        }

        List<Integer> opPulos;

        if (!puloLongo) {
            opPulos = getOptions(posicao, numbers);
            for (Integer proxPosicao : opPulos) {
//                System.out.println("dfs com pulo -> proxPosicao" + proxPosicao);
                dfs(mst, true, profundidade + 1, proxPosicao, objetivo, numbers);
            }
        }

        opPulos = getOptionsShortJump(mst, posicao);
        for (Integer proxPosicao : opPulos) {
//            System.out.println("dfs sem pulo -> proxPosicao" + proxPosicao);
            dfs(mst, puloLongo, profundidade + 1, proxPosicao, objetivo, numbers);
        }

    }

    public static List<Integer> getOptionsShortJump(Main mst, int position) {
        List<Integer> result = new LinkedList<>();

        for (Edge e : mst.Edge()) {
            if (e.src == position) {
                result.add(e.dest);
            }
        }
        return result;
    }

    public static List<Integer> getOptions(int position, int[] numbers) {
        List<Integer> result = new LinkedList<>();
        for (int i = position + 1; i < numbers.length; i++) {

            if ((X <= numbers[i] && numbers[i] <= Y)) {
                result.add(i);
            }
        }
        return result;
    }

}

class BagOfItems<Item> implements Iterable<Item> {
    private int N;               // number of elements in bag
    private Node<Item> first;    // beginning of bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public BagOfItems() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    @SuppressWarnings("hiding")
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

class EdgeWeightedGraph {
    private final int V;
    private final int E;
    private BagOfItems<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V, int[] numbers) {

        this.V = V;

        adj = (BagOfItems<Edge>[]) new BagOfItems[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new BagOfItems<>();
        }

        int numberOfEdges = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] - numbers[i] <= Main.X) {
                    // computar com pulos curtos
                    Edge e = new Edge(i, j, 1);
                    addEdge(e);
                    numberOfEdges++;
                }
            }
        }

        this.E = numberOfEdges;

    }

    public int V() {
        return V;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v
                    + " is not between 0 and " + (V - 1));
        if (w < 0 || w >= V)
            throw new IndexOutOfBoundsException("vertex " + w
                    + " is not between 0 and " + (V - 1));
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v
                    + " is not between 0 and " + (V - 1));
        return adj[v];
    }

    public Iterable<Edge> Edge() {
        BagOfItems<Edge> list = new BagOfItems<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // only add one copy of each self loop (self loops will be
                // consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0)
                        list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}

class Edge implements Comparable<Edge> {
    final int src;
    final int dest;
    final double weight;

    public Edge(int src, int dest, double weight) {
        if (src < 0)
            throw new IndexOutOfBoundsException(
                    "Vertex name must be a nonnegative integer");
        if (dest < 0)
            throw new IndexOutOfBoundsException(
                    "Vertex name must be a nonnegative integer");
        if (Double.isNaN(weight))
            throw new IllegalArgumentException("Weight is NaN");
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return src;
    }

    public int other(int vertex) {
        if (vertex == src)
            return dest;
        else if (vertex == dest)
            return src;
        else
            throw new IllegalArgumentException("Illegal endpoint");
    }

    public int compareTo(Edge that) {
        if (this.weight() < that.weight())
            return -1;
        else if (this.weight() > that.weight())
            return +1;
        else
            return 0;
    }

    public String toString() {
        return String.format("%d-%d %.5f", src, dest, weight);
    }
}

class UF {
    private int[] id;     // id[i] = parent of i
    private byte[] rank;  // rank[i] = rank of subtree rooted at i (cannot be
    // more than 31)
    private int count;    // number of components

    public UF(int N) {
        if (N < 0)
            throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        rank = new byte[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IndexOutOfBoundsException();
        while (p != id[p]) {
            id[p] = id[id[p]];    // path compression by halving
            p = id[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;
        // make root of smaller rank point to root of larger rank
        if (rank[i] < rank[j])
            id[i] = j;
        else if (rank[i] > rank[j])
            id[j] = i;
        else {
            id[j] = i;
            rank[i]++;
        }
        count--;
    }
}
