package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main3 {

    public static int NON_CYCLIC_EDGES = 0;
    public static int RECURSION_LEVEL_COUNTER = 0;
    public static int UNVISITED = -1;

    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String line;

        while ((line = s.readLine()) != null) {
            NON_CYCLIC_EDGES = 0;
            RECURSION_LEVEL_COUNTER = 0;

            String[] citiesAndBridges = line.split(" ");

            Graph graph = new Graph(Integer.parseInt(citiesAndBridges[0]) + 1);

            int numOfBridges = Integer.parseInt(citiesAndBridges[1]);

            for (int i = 1; i <= numOfBridges; i++) {
                String[] edge = s.readLine().split(" ");
                graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
            }

            calculate(graph);
            System.out.println(NON_CYCLIC_EDGES);

        }
    }

    static class Graph {

        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            this.V = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        void traverseMapAndCountBridges(int vertice, int[] parent, int[] registerOfRecursionLevelCycleStarted, int[] registerOfFirstNodeAcessInRecursionStack) {
            RECURSION_LEVEL_COUNTER = RECURSION_LEVEL_COUNTER + 1;
            // low aq está recebendo quando foi acessado na pilha da recursão, mas ele nao vai armazenar esse valor caso tenha ciclo.
            // Caso tenha ciclo significa que ele encontrou/acessou algum node adjacente que foi acessado em um nivel de recursão antes dele,
            // dai **quando saimos da recursão** o lowDoAtualVertice recebe o min entre o lowDoAdjacente ou o numDoAtualVertice
            // mas quando detectamos um circulo o lowDoAtualVertice recebe o minino entre o lowDoAtualVertice numDoAdjacente, continua em (***)
            registerOfRecursionLevelCycleStarted[vertice] = RECURSION_LEVEL_COUNTER;
            registerOfFirstNodeAcessInRecursionStack[vertice] = RECURSION_LEVEL_COUNTER; //Marca tipo a ordem/nivel_da_recursao que foi acessado o vertice atual

            Integer adjOfV;
            for (Integer adj : adj[vertice]) {
                adjOfV = adj;

                if (registerOfFirstNodeAcessInRecursionStack[adjOfV] == UNVISITED) {

                    parent[adjOfV] = vertice;
                    traverseMapAndCountBridges(adjOfV, parent, registerOfRecursionLevelCycleStarted, registerOfFirstNodeAcessInRecursionStack);

                    // (***) se o lowDoAdjacente que acabamos de rodar a recursão ainda é maior, significa que ele acessou os seus adjacentes e os adjacentes dele acessaram os seus proprios adjacentes (etc) .... e não encontraram nenhum node que foi acessado em um nivel de recursão anterior
                    // Caso o lowDoAdjacente seja menor que o numDoAtualVertice significa que o atualVertice faz parte de um ciclo e, portando, o lowDoAtualVertice recebera o nivel de recursão onde esse ciclo começou
                    // Essa atualização do low é feita em diante para os pais do verticeAtual; Mas nem todo parent será afetado pois os parents que iniciaram em um nivel de recursão mais "cedo" do nivel de recursão que o ciclo de formou, não serão parte do ciclo

                    // no caso quando há um ciclo  na recursão que acabou de retornar
                    // o low recebeu o menor valor entre low[vertice] num[adjOfV]
                    if (checkIfAdjIsPartOfCycleByRecursionStackLevel(adjOfV, registerOfRecursionLevelCycleStarted, vertice, registerOfFirstNodeAcessInRecursionStack)) {
                        NON_CYCLIC_EDGES = NON_CYCLIC_EDGES + 1;
                    }

                    // Como o node atual tem um adjacente que faz parte de um ciclo, logo ele também faz parte de um ciclo. dai agora a gente pega o nivel da recursão que esse ciclo começou e atribui ao registerOfRecursionLevelCycleStarted do nodeAtual
                    registerOfRecursionLevelCycleStarted[vertice] = Math.min(registerOfRecursionLevelCycleStarted[vertice], registerOfRecursionLevelCycleStarted[adjOfV]);
                } else if (adjOfV != parent[vertice]) {
                    // se é diferente do parent e é visitado significa que houve um cycle
                    registerOfRecursionLevelCycleStarted[vertice] = Math.min(registerOfRecursionLevelCycleStarted[vertice], registerOfFirstNodeAcessInRecursionStack[adjOfV]);
                }
            }
        }

        private boolean checkIfAdjIsPartOfCycleByRecursionStackLevel(Integer adjOfV, int[] registerOfRecursionLevelCycleStarted, int vertice, int[] registerOfFirstNodeAcessInRecursionStack) {
            return registerOfRecursionLevelCycleStarted[adjOfV] > registerOfFirstNodeAcessInRecursionStack[vertice];
        }
    }

    public static void calculate(Graph graph) {

        int[] low = new int[graph.V];
        int[] num = new int[graph.V];
        int[] visited = new int[graph.V];
        for (int i = 0; i < graph.V; i++) {
            visited[i] = -1;
            low[i] = -1;
            num[i] = -1;
        }

        graph.traverseMapAndCountBridges(1, visited, low, num);
    }
}
