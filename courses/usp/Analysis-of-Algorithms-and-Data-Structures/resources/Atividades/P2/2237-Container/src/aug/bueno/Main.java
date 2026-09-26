package aug.bueno;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {



        class Node {
            Integer[] container;
            int custo;
            String hash;

            public Node(Integer[] container, int custo) {
                super();
                this.container = container;
                this.custo = custo;
                this.hash = generate_hash();
            }

            public String generate_hash() {
                String s = "";
                for (int i = 0; i < 8; i++) {
                    s = s + "/ " + i;
                }
                return s;
            }

            public int getCusto() {
                return custo;
            }
        }


    public static Integer[][] trocar(Integer[][] m, int x, int y, int x1, int y1) {

        Integer[][] newMat = cloneArray(m);

        Integer aux = m[x][y];
        newMat[x][y] = m[x1][y1];
        newMat[x1][y1] = aux;

        return newMat;

    }

    public static Integer[][] cloneArray(Integer[][] src) {
        int length = src.length;
        Integer[][] target = new Integer[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }


    public static void trocar2(Integer[][] m, int x, int y, int x1, int y1,
                               LinkedList<Long> visited,
                               LinkedList<Integer[][]> queue) {

        Integer[][] m1 = trocar(m, x, y, x1, y1);
        long m1Hash = NodeWrapper.insert_matrix(m1);

        long mHash = NodeWrapper.get_hash(m);

        if (m1Hash == visited.peekLast()) {
            int custo = m1[x][y] + m1[x1][y1] + NodeWrapper.custos.get(mHash);
            NodeWrapper.custos.put(m1Hash, custo);
            queue.addLast(m1);
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer[][] start = new Integer[2][4];
        Integer[][] finish = new Integer[2][4];

        for (int i = 0; i < 2; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                start[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 2; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                finish[i][j] = Integer.parseInt(input[j]);
            }
        }


        PriorityQueue<Node> queue = new PriorityQueue<>(5, (a, b) -> a.getCusto() - b.getCusto());
        queue.ad

        // or pq = new PriorityQueue<String>(5, Comparator.comparing(String::length));
        NodeWrapper.insert_matrix(start);
        NodeWrapper.custos.put(NodeWrapper.get_hash(start), 0);
        NodeWrapper.insert_matrix(finish);

        long final_hash = NodeWrapper.get_hash(finish);
        LinkedList<Long> visited = new LinkedList<Long>();
        LinkedList<Integer[][]> queue = new LinkedList<Integer[][]>();
        queue.addLast(start);

        while (!queue.isEmpty()) {
            Integer[][] state = queue.pop();
            long h = NodeWrapper.get_hash(state);

            if (visited.contains(h)) continue;

            if (h == final_hash) {
                System.out.println(NodeWrapper.custos.get(h));
            }

            visited.add(h);

            trocar2(state, 0, 0, 0, 1, visited, queue);


            trocar2(state, 0, 1, 0, 2, visited, queue);


            trocar2(state, 0, 2, 0, 3, visited, queue);


            trocar2(state, 1, 0, 1, 1, visited, queue);


            trocar2(state, 1, 1, 1, 2, visited, queue);


            trocar2(state, 1, 2, 1, 3, visited, queue);


            trocar2(state, 0, 0, 1, 0, visited, queue);


            trocar2(state, 0, 1, 1, 1, visited, queue);


            trocar2(state, 0, 2, 1, 2, visited, queue);


            trocar2(state, 0, 3, 1, 3, visited, queue);


        }

    }
}
