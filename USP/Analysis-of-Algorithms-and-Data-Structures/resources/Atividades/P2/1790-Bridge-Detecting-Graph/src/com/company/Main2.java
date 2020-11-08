/*
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main2 {

    public static int NON_CYCLIC_EDGES = 0;

    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String line;

        while ((line = s.readLine()) != null) {

            String[] citiesAndBridges = line.split(" ");

            Graph graph = new Graph(Integer.parseInt(citiesAndBridges[0]) + 1);

            int numOfBridges = Integer.parseInt(citiesAndBridges[1]);

            for (int i = 1; i <= numOfBridges; i++) {
                String[] edge = s.readLine().split(" ");
                graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
            }

            graph.isCyclic();
            System.out.println(NON_CYCLIC_EDGES);
            NON_CYCLIC_EDGES = 0;

        }
    }

    static class Graph {

        // No. of vertices
        private int V;

        // Adjacency List Represntation
        private LinkedList<Integer> adj[];

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList();
        }

        // Function to add an edge
        // into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        void isCyclicUtil(int v, Boolean[] visited, int[] parent) {

            visited[v] = true;
            Integer adjOfV;

            for (Integer integer : adj[v]) {
                adjOfV = integer;

                if (!visited[adjOfV]) {

                    parent[adjOfV] = v;

                    isCyclicUtil(adjOfV, visited, parent);
                    // Depois da recursão deveriamos entender se houve um ciclo ou não
                    // dai a gente conseguiria atualizar o NON_CYCLIC_EDGES
                    NON_CYCLIC_EDGES = NON_CYCLIC_EDGES + 1;

                }

                else if (adjOfV != parent[v]) {
                    continue;
                } else {
//                    NON_CYCLIC_EDGES = NON_CYCLIC_EDGES + 1;
                }
            }

//            NON_CYCLIC_EDGES = NON_CYCLIC_EDGES + 1;
//            return false;
        }

        // Returns true if the graph
        // contains a cycle, else false.
        Boolean isCyclic() {

            // Mark all the vertices as
            // not visited and not part of
            // recursion stack
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper
            // function to detect cycle in
            // different DFS trees
            for (int u = 1; u < V; u++) {

                // Don't recur for u if already visited
                if (!visited[u]) {
                    if (isCyclicUtil(u, visited, -1))
                        return true;
                }
            }
            return false;
        }
    }


}
*/
