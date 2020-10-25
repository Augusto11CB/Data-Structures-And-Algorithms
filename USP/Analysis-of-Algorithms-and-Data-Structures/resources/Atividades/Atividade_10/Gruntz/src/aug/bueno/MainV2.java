package aug.bueno;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainV2 {

    public static final char BAIXO = 'v', CIMA = '^', ESQUERDA = '<', DIREITA = '>';


    public static int INVERTED = 1;

    public static int VISITED = -1;

    public static int VISITED_INVERTED = -2;

    public static int nrMaxInvert = 0;

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

            if (tentar(map, nrMaxInvert)) System.out.println("Sim");

            else System.out.println("Nao");
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

            if (tentar(map, nrMaxInvert)) System.out.println("Sim");

            else System.out.println("Nao");
        }
    }

    private static boolean tentar(Character[][] map, int nrMaxInvert) {
        boolean result = false;
        //cima
        int cima = nrMaxInvert;
        final int[][] cimaHistory = new int[map.length][map[0].length];
        result = tentar(map, new int[]{0, 0}, cimaHistory, cima);

        //baixo
        if (!result) {
            int baixo = nrMaxInvert;
            final int[][] baixoHistory = new int[map.length][map[0].length];
            result = tentar(map, new int[]{map[0].length - 1, map.length - 1}, baixoHistory, baixo);
        }

        //esquerda
        if (!result) {
            int esquerda = nrMaxInvert;
            final int[][] esqHistory = new int[map.length][map[0].length];
            result = tentar(map, new int[]{0, map.length - 1}, esqHistory, esquerda);
        }

        //direita
        if (!result) {
            int direita = nrMaxInvert;
            final int[][] dirHistory = new int[map.length][map[0].length];
            result = tentar(map, new int[]{map[0].length - 1, 0}, dirHistory, direita);
        }

        return result;

    }

    private static boolean tentar(Character[][] map, int[] startPosition, int[][] pathHistory, int nrMaxInvert) {

        final int[][] inversionMap = new int[map.length][map[0].length];

        LinkedList<int[]> q = new LinkedList();

        q.add(startPosition);

        while (q.size() > 0) {

            int[] p = q.poll();

            if (isInvertedNode(p, inversionMap) && nrMaxInvert < 1) {
                continue;
            }

            pathHistory[p[1]][p[0]] = -1;

            //destination is reached.
            if (isGoal(map, p)) return true;

            pathHistory[p[1]][p[0]] = -1;

            //using the direction array
            int[] nexDirection = getNewDirection(map[p[1]][p[0]], p);
            int[] nexInvertedDirection = invertDirection(map, p);


            //not blocked and valid
            if (!isOutSideMap(map, nexDirection) && pathHistory[nexDirection[1]][nexDirection[0]] != -1) {
                q.add(nexDirection);
            }

            if (!isOutSideMap(map, nexInvertedDirection) /*&& nrMaxInvert > 0*/
                    && pathHistory[nexInvertedDirection[1]][nexInvertedDirection[0]] != -1) {


                inversionMap[nexInvertedDirection[1]][nexInvertedDirection[0]] = 1;

                q.add(nexInvertedDirection);
            }

        }

        return false;
    }

    public static boolean isInvertedNode(int[] p, int[][] inversionMap) {
        return inversionMap[p[1]][p[0]] == 1;
    }


    private static int[] getNewDirection(Character direction, int[] xy) {
        int[] newDirection = new int[2];

        switch (direction) {

            case CIMA:
                newDirection = new int[]{xy[0], xy[1] - 1};
                break;
            case BAIXO:
                newDirection = new int[]{xy[0], xy[1] + 1};
                break;
            case ESQUERDA:
                newDirection = new int[]{xy[0] - 1, xy[1]};
                break;
            case DIREITA:
                newDirection = new int[]{xy[0] + 1, xy[1]};
                break;
        }
        return newDirection;
    }

    public static int[] invertDirection(Character[][] map, int[] xy) {

        int[] newXY = null;

        switch (map[xy[1]][xy[0]]) {
            case CIMA:
                newXY = new int[]{xy[0], xy[1] + 1}; // x, (y-1) -> BAIXO
                break;
            case BAIXO:
                newXY = new int[]{xy[0], xy[1] - 1}; // x, (y+1) -> CIMA
                break;
            case ESQUERDA:
                newXY = new int[]{xy[0] + 1, xy[1]}; // (x+1), y -> DIREITA
                break;
            case DIREITA:
                newXY = new int[]{xy[0] - 1, xy[1]}; // (x-1), y -> ESQUERDA
                break;
        }
        return newXY;
    }

    private static boolean isGoal(Character[][] map, int[] xy) {
        int yGoal = map.length / 2;
        int xGoal = (map[0].length - 1) / 2;
        return (xy[0] == xGoal) && (xy[1] == yGoal);
    }

    public static boolean isOutSideMap(Character[][] map, int[] xy) {

        int numOfLines = map.length;
        int numOfColuns = map[0].length;

        return ((xy[0] < 0) || (xy[0] >= numOfColuns)) || ((xy[1] < 0) || (xy[1] >= numOfLines));
    }
}













