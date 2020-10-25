package aug.bueno;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainV4 {


    public static final char BAIXO = 'v', CIMA = '^', ESQUERDA = '<', DIREITA = '>';


    public static int INVERTED = 1;

    public static int VISITED = -1;

    public static int VISITED_INVERTED = -2;

    public static int nrMaxInvert = 0;


    class Graph {

        private Character direction;

        private int xy[];

        private LinkedList<Graph> adj;

        // Constructor
        Graph(Character direction, int[] xy) {

            this.direction = direction;

            this.xy = xy;

            adj = new LinkedList<>();

        }

        //Function to add an edge into the graph
        void addEdge(Graph g) {
            adj.add(g);  // Add w to v's list.
        }
    }

/*
    public Graph[][] buildMatrix(Character[][] map) {

        for(int linha = 0; linha)
    }
*/


    public static void main(String[] args) throws IOException {
        File file = new File("resources/input-file.txt");    //creates a new file instance

        Scanner s = new Scanner(System.in);

        while (true) {

            int nrLinhas = s.nextInt();

            int nrColunas = s.nextInt();

            int nrMaxInvert = s.nextInt();

            s.nextLine();

            if (nrLinhas == 0) break;

            final Character[][] map = new Character[nrLinhas][];

            for (int i = 0; i < nrLinhas; i++) {

                map[i] = s.nextLine().chars()
                        .mapToObj(c -> (char) c)
                        .toArray(Character[]::new);
            }


//            if (tentar(map, nrMaxInvert)) System.out.println("Sim");

//            else System.out.println("Nao");
        }
    }

    public static void main2(String[] args) throws IOException {
        File file = new File("resources/input-file.txt");    //creates a new file instance

        Scanner s = new Scanner(file);

        while (true) {

            int nrLinhas = s.nextInt();

            int nrColunas = s.nextInt();

            int nrMaxInvert = s.nextInt();

            if (nrLinhas == 0) break;

            s.nextLine();

            final Character[][] map = new Character[nrLinhas][];

            for (int i = 0; i < nrLinhas; i++) {

                map[i] = s.nextLine().chars()
                        .mapToObj(c -> (char) c)
                        .toArray(Character[]::new);
            }

//            if (tentar(map, nrMaxInvert)) System.out.println("Sim");

//            else System.out.println("Nao");
        }
    }

}
