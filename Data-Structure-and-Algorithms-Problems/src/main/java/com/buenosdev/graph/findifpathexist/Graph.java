package com.buenosdev.graph.findifpathexist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(int node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new ArrayList<>());
        }
    }

    public void removeNode(int node) {
        if (!adjacencyList.containsKey(node)) {
            return;
        }
        adjacencyList.remove(node);
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighbors.removeIf(v -> v == node);
        }
    }

    public void addEdge(int node1, int node2) {
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    public void removeEdge(int node1, int node2) {
        adjacencyList.get(node1).removeIf(v -> v == node2);
        adjacencyList.get(node2).removeIf(v -> v == node1);
    }

    public List<Integer> getNodes() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public List<Pair<Integer, Integer>> getEdges() {
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int node1 = entry.getKey();
            for (int neighbor : entry.getValue()) {
                int node2 = neighbor;
                if (node1 < node2) {
                    edges.add(new Pair<>(node1, node2));
                }
            }
        }
        return edges;
    }

    public List<Integer> getNeighbors(int node) {
        return new ArrayList<>(adjacencyList.getOrDefault(node, new ArrayList<>()));
    }

    public boolean isAdjacent(int node1, int node2) {
        List<Integer> neighbors = adjacencyList.getOrDefault(node1, new ArrayList<>());
        return neighbors.contains(node2);
    }

    public int getNodeCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count / 2;
    }

        public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        System.out.print("Nodes: ");
        for (int node : graph.getNodes()) {
            System.out.print(node + " ");
        }
        System.out.println();

        System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getFirst() + ", " + edge.getSecond() + ") ");
        }
        System.out.println();

        System.out.print("Neighbors of node 1: ");
        for (int neighbor : graph.getNeighbors(1)) {
            System.out.print(neighbor + " ");
        }
        System.out.println();

        System.out.println("Is node 1 adjacent to node 2? " + graph.isAdjacent(1, 2));

        graph.removeEdge(1, 2);
        graph.removeNode(3);

        System.out.println("After removing some edges and Nodes:");

        System.out.print("Nodes: ");
        for (int node : graph.getNodes()) {
            System.out.print(node + " ");
        }
        System.out.println();

        System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getFirst() + ", " + edge.getSecond() + ") ");
        }
        System.out.println();
    }
}