package aug.bueno;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainV5 {

    public static final char BAIXO = 'v', CIMA = '^', ESQUERDA = '<', DIREITA = '>';

    public static int VISITED = 5;

    public static int INVERTED = 3;

    public static int NO_VISITED = 0;

    class Move {
        int x;
        int y;
        int valor;

        Move(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.valor = c;
        }
    }

    public static void main2(String[] args) throws IOException {

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

    public static void main(String[] args) throws IOException {
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

    private static boolean tentar(Character[][] map, final int nrMaxInvert) {

        int[] startPoint = getStart(map);

        int aux = nrMaxInvert;

        final int[][] pathHistory = new int[map.length][map[0].length];

        boolean result = false;

        //cima
        int cima = nrMaxInvert;
        final int[][] cimaHistory = new int[map.length][map[0].length];
        result = navigate(map, startPoint, new int[]{startPoint[0], startPoint[1] - 1}, pathHistory, cima);

        //baixo
        if (!result) {
            int baixo = nrMaxInvert;
            final int[][] baixoHistory = new int[map.length][map[0].length];
            result = navigate(map, startPoint, new int[]{startPoint[0], startPoint[1] + 1}, pathHistory, baixo);
        }

        //esquerda
        if (!result) {
            int esquerda = nrMaxInvert;
            final int[][] esqHistory = new int[map.length][map[0].length];
            result = navigate(map, startPoint, new int[]{startPoint[0] - 1, startPoint[1]}, pathHistory, esquerda);
        }

        //direita
        if (!result) {
            int direita = nrMaxInvert;
            final int[][] dirHistory = new int[map.length][map[0].length];
            result = navigate(map, startPoint, new int[]{startPoint[0] + 1, startPoint[1]}, pathHistory, direita);
        }

        return result;

    }

    public static boolean navigate(Character[][] map, int[] previous, int[] current, final int[][] pathHistory, int nrMaxInvert) {

        int[] start = getStart(map);


        if (isOutSideMap(map, current) ||
                isAlreadyMarkedAsPartOfSolution(current, pathHistory)) {
            return false;
        }

        markPosition(current, pathHistory, VISITED);

        if (isGoal(map, current)) {


            if (currentPointsToPrevious(current, previous, map)) {
                return true;
            } else if ((previous[0] != start[0] && previous[1] != start[1]) && previousPointsToCurrent(current, previous, map)) {
                return true;
            } else {
                if (nrMaxInvert > 0) {
                    return currentPointsToPreviousNoInversion(current, previous, map);
                }
                return false;
            }
        }

        int[] newPositionToGo = getPositionToGo(map, current);

        int[] newPositionToGoInverted = getInvertedPositionToGo(map, current);

        boolean result = false;

        int tempNRMaxInvert = nrMaxInvert;

        if (currentPointsToPrevious(current, previous, map)) {

            result = navigate(map, current, newPositionToGoInverted, pathHistory, tempNRMaxInvert);

            nrMaxInvert = tempNRMaxInvert;

        } else {

            if (currentPointsToPreviousNoInversion(current, previous, map)) {

                if (nrMaxInvert > 0) {
                    nrMaxInvert = nrMaxInvert - 1;
                    tempNRMaxInvert = nrMaxInvert;

                    result = navigate(map, current, newPositionToGo, pathHistory, tempNRMaxInvert);

                    nrMaxInvert = tempNRMaxInvert;
                }

            }

            if ((previous[0] != start[0] && previous[1] != start[1]) ||
                    ((previous[0] == start[0] && previous[1] == start[1]) && !isGoal(map, current)) ||
                    previousPointsToCurrent(current, previous, map)) {

                result = navigate(map, current, newPositionToGo, pathHistory, tempNRMaxInvert);
                nrMaxInvert = tempNRMaxInvert;

            }

        }

        return result;
    }


    static boolean currentPointsToPrevious(int[] current, int[] previous, Character[][] map) {

        int[] pointOfTheCurrent = getPositionToGo(map, current);

        return pointOfTheCurrent[0] == previous[0] && pointOfTheCurrent[1] == previous[1];

    }


    static boolean currentPointsToPreviousNoInversion(int[] current, int[] previous, Character[][] map) {

        int[] pointOfTheCurrent = getInvertedPositionToGo(map, current);

        //previues arrive here
        return pointOfTheCurrent[0] == previous[0] && pointOfTheCurrent[1] == previous[1];

    }

    static boolean previousPointsToCurrent(int[] current, int[] previous, Character[][] map) {

//        int[] pointOfTheCurrent = getInvertedPositionToGo(map, current);
        int[] pointOfThePrevious = getPositionToGo(map, previous, current);

        //previues arrive here
        return pointOfThePrevious[0] == current[0] && pointOfThePrevious[1] == current[1];

    }


    private static boolean isGoal(Character[][] map, int[] xy) {
        return xy[1] == 0 || xy[0] == 0 || xy[1] == map.length - 1 || xy[0] == map[0].length - 1;
    }


    private static void markPosition(int[] xy, int[][] pathHistory, int status) {
        pathHistory[xy[1]][xy[0]] = status;
    }


    private static boolean isAlreadyMarkedAsPartOfSolution(int[] xy, int[][] pathHistory) {
        return (pathHistory[xy[1]][xy[0]] == VISITED);
    }


    private static int[] getStart(Character[][] map) {
        int yGoal = map.length / 2;
        int xGoal = (map[0].length - 1) / 2;

        return new int[]{xGoal, yGoal};
    }

    public static int[] getPositionToGo(Character[][] map, int[] xy) {

        int[] newDirection = null;

        switch (map[xy[1]][xy[0]]) {
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
            case 'x':
                newDirection = getStart(map);
        }
        return newDirection;
    }

    public static int[] getPositionToGo(Character[][] map, int[] xy, int[] current) {

        int[] newDirection = null;

        switch (map[xy[1]][xy[0]]) {
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
            case 'x':
                newDirection = current;
        }
        return newDirection;
    }

    public static int[] getInvertedPositionToGo(Character[][] map, int[] xy) {

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
            case 'x':
                newXY = getStart(map);
        }
        return newXY;
    }

    public static boolean isOutSideMap(Character[][] map, int[] xy) {

        int numOfLines = map.length;
        int numOfColuns = map[0].length;

        return ((xy[0] < 0) || (xy[0] >= numOfColuns)) || ((xy[1] < 0) || (xy[1] >= numOfLines));
    }
}
