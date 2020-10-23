package aug.bueno;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final char BAIXO = 'v', CIMA = '^', ESQUERDA = '<', DIREITA = '>';

    public static int VISITED = 1;

    public static int NO_VISITED = 0;

    public static int nrMaxInvert = 0;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {

            int nrLinhas = s.nextInt();

            int nrColunas = s.nextInt();

            nrMaxInvert = s.nextInt();

            s.nextLine();

            if (nrLinhas == 0) break;

            final Character[][] map = new Character[nrLinhas][];

            for (int i = 0; i < nrLinhas; i++) {

                map[i] = s.nextLine().chars()
                        .mapToObj(c -> (char) c)
                        .toArray(Character[]::new);
            }

            final int[][] pathHistory = new int[map.length][map[0].length];

            final int[] xy = {0, 0};

            if (tentar(map, xy, pathHistory, nrMaxInvert)) System.out.println("Sim");

            else System.out.println("Nao");

        }

    }

    public static boolean tentar(Character[][] map, int[] xy, int[][] pathHistory, int nrMaxInvert) {

        if (isOutSideMap(map, xy)) return false;

        if (isGoal(map, xy)) return true;

        if (isAlreadyMarkedAsPartOfSolution(xy, pathHistory)) return false;

        markPosition(xy, pathHistory, VISITED);

        Character direction = map[xy[1]][xy[0]];


        int[] newDirection = getNewDirection(direction, xy);

        boolean result = false;


        if (!isOutSideMap(map, newDirection)) {
            result = tentar(map, newDirection, pathHistory, nrMaxInvert);

            if (!result && nrMaxInvert > 0) {
                result = tentar(map, invertDirection(map, newDirection), pathHistory, nrMaxInvert - 1);
            }

        } else {
            result = tentar(map, invertDirection(map, xy), pathHistory, nrMaxInvert - 1);
        }

        if (!result) {
            markPosition(xy, pathHistory, NO_VISITED);
        }

        return result;
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


    private static void markPosition(int[] xy, int[][] pathHistory, int status) {
        pathHistory[xy[1]][xy[0]] = status;
    }


    private static boolean isAlreadyMarkedAsPartOfSolution(int[] xy, int[][] pathHistory) {
        return (pathHistory[xy[1]][xy[0]] == VISITED);
    }


    private static boolean isGoal(Character[][] map, int[] xy) {
        int yGoal = map.length / 2;
        int xGoal = map[0].length / 2;
        return (xy[0] == xGoal) && (xy[1] == yGoal);
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

    public static boolean isOutSideMap(Character[][] map, int[] xy) {

        int numOfLines = map.length;
        int numOfColuns = map[0].length;

        return ((xy[0] < 0) || (xy[0] >= numOfColuns)) || ((xy[1] < 0) || (xy[1] >= numOfLines));
    }


    public static boolean isOddNumber(int num) {
        return !(num % 2 == 0);
    }

    public static <T> void arrayCopy(T[][] aSource, T[][] aDestination) {

        for (int i = 0; i < aSource.length; i++) {
            System.arraycopy(aSource[i], 0, aDestination[i], 0, aSource[i].length);
        }
    }

    public static void print2D(Character mat[][]) {
        // Loop through all rows
        for (Character[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static void main2(String[] args) {
        Character[][] myM = {
                {DIREITA, BAIXO, CIMA},
                {BAIXO, 'X', DIREITA},
                {DIREITA, CIMA, ESQUERDA}
        };

//        Character[][] myM = {
//                {'a','q','c'},
//                {'b','q','c'},
//                {'b','q','c'}
//        };

//        Character[][] myM = {
//                {'a', 'q', 'c'},
//                {'b', 'q', 'c'},
//                {'b', 'q', 'c'},
//                {'b', 'q', 'c'},
//                {'b', 'q', 'c'}
//        };

        int[] xy = {2, 1};
        System.out.println(Arrays.toString(invertDirection(myM, xy)));
    }

    //    public static void main(String[] args) {
//
//        Character[][] map = {
//                {BAIXO, BAIXO, CIMA},
//                {BAIXO, 'X', DIREITA},
//                {DIREITA, DIREITA, CIMA}
//        };
//
//        final int[][] pathHistory = new int[map.length][map[0].length];
//
//
//        final int[] xy = {0, 0};
//
//        if (tentar(map, xy, pathHistory, nrMaxInvert)) System.out.println("Sim");
//
//        else System.out.println("Nao");
//    }

}


















