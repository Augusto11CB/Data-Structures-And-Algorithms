package aug.bueno;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * Implementação Usando busca em largura
 *
 * */

public class MainV6 {

    public static LinkedList<Move> Q = new LinkedList();
    public static int[][] VISITA = new int[110][110];

    public static int NUM_MAX_INV = 0;


    static class Move {
        int xy[];
        int custo;

        Move(int[] xy, int custo) {
            this.xy = xy;
            this.custo = custo;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while (true) {

            Q.clear();

            int nrLinhas = s.nextInt();

            int nrColunas = s.nextInt();

            NUM_MAX_INV = s.nextInt();

            if (nrLinhas == 0) break;

            s.nextLine();

            final Character[][] map = new Character[nrLinhas][];

            for (int i = 0; i < nrLinhas; i++) {

                map[i] = s.nextLine().chars()
                        .mapToObj(c -> (char) c)
                        .toArray(Character[]::new);
            }

            int[] start = getStart(map);

            VISITA = new int[map.length][map[0].length];

            fillArray(VISITA);

            put(start[1], start[0], 0, 'x', map);

            while (Q.size() > 0) {
                Move move = Q.poll();

                put(move.xy[1] - 1, move.xy[0], move.custo, 'v', map);
                put(move.xy[1] + 1, move.xy[0], move.custo, '^', map);
                put(move.xy[1], move.xy[0] - 1, move.custo, '>', map);
                put(move.xy[1], move.xy[0] + 1, move.custo, '<', map);
            }

            boolean result = false;

            for (int i = 0; i < map.length; i++) {
                result = result || test(i, 0);
                result = result || test(i, map[0].length - 1);
            }

            for (int i = 0; i < map[0].length; i++) {
                result = result || test(0, i);
                result = result || test(map.length - 1, i);
            }

            System.out.println(result ? "Sim" : "Não");
        }
    }

    public static char inv(char c) {
        if (c == '<') return '>';
        if (c == '>') return '<';
        if (c == '^') return 'v';
        if (c == 'v') return '^';

        return '^';
    }

    public static boolean test(int x, int y) {
        for (int i = 0; i <= NUM_MAX_INV; i++) {
            if (VISITA[x][y] <= NUM_MAX_INV) {
                return true;
            }
        }
        return false;
    }

    public static void put(int linha, int coluna, int c, char expected, Character[][] map) {
        if (linha < 0 || linha >= map.length || coluna < 0 || coluna >= map[0].length)
            return;

        if (map[linha][coluna] == expected && c < VISITA[linha][coluna]) {
            Q.push(new Move(new int[]{linha, coluna}, c));
            VISITA[linha][coluna] = c;

        } else if (map[linha][coluna] == inv(expected) && c + 1 <= NUM_MAX_INV && c < VISITA[linha][coluna]) {
            Q.push(new Move(new int[]{linha, coluna}, c + 1));
            VISITA[linha][coluna] = c + 1;
        }
    }

    private static int[] getStart(Character[][] map) {
        int yGoal = map.length / 2;
        int xGoal = (map[0].length - 1) / 2;

        return new int[]{xGoal, yGoal};
    }

    private static void fillArray(int[][] matrix) {
        // Fill each row with 1.0
        for (int[] row : matrix)
            Arrays.fill(row, 63);
    }

    public static void main2(String[] args) throws IOException {
        File file = new File("resources/input-file.txt");    //creates a new file instance

        Scanner s = new Scanner(file);

        while (true) {

            Q.clear();

            int nrLinhas = s.nextInt();

            int nrColunas = s.nextInt();

            NUM_MAX_INV = s.nextInt();

            if (nrLinhas == 0) break;

            s.nextLine();

            final Character[][] map = new Character[nrLinhas][];

            for (int i = 0; i < nrLinhas; i++) {

                map[i] = s.nextLine().chars()
                        .mapToObj(c -> (char) c)
                        .toArray(Character[]::new);
            }

            int[] start = getStart(map);

            VISITA = new int[map.length][map[0].length];

            fillArray(VISITA);

            put(start[1], start[0], 0, 'x', map);

            while (Q.size() > 0) {
                Move move = Q.poll();

                put(move.xy[1] - 1, move.xy[0], move.custo, 'v', map);
                put(move.xy[1] + 1, move.xy[0], move.custo, '^', map);
                put(move.xy[1], move.xy[0] - 1, move.custo, '>', map);
                put(move.xy[1], move.xy[0] + 1, move.custo, '<', map);
            }

            boolean result = false;

            for (int i = 0; i < map.length; i++) {
                result = result || test(i, 0);
                result = result || test(i, map[0].length - 1);
            }

            for (int i = 0; i < map[0].length; i++) {
                result = result || test(0, i);
                result = result || test(map.length - 1, i);
            }

            System.out.println(result ? "Sim" : "Não");
        }
    }
}
