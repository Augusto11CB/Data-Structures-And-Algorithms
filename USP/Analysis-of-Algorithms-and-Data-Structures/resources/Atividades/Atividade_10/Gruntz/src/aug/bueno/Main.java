package aug.bueno;

import java.util.Arrays;

public class Main {

    public static final char BAIXO = 'v', CIMA = '^', ESQUERDA = '<', DIREITA = '>';

    public static int VISITED = 1;

    public static int NO_VISITED = 0;

    public static int nrMaxInvert;

//    public static void main(String[] args) {
//
//        Scanner s = new Scanner(System.in);
//
//        while (true) {
//
//            // TODO - Adicionar regra para nrLinhas >= 3
//            // TODO - Validate that nrLinhas is odd
//            int nrLinhas = s.nextInt();
//
//            // TODO - Adicionar regra para nrColunas < 100
//            // TODO - Validate that nrColunas is odd
//            int nrColunas = s.nextInt();
//
//            // TODO - Adicionar regra para nrLinhas 0 <= nrMaxInvert >=n
//            nrMaxInvert = s.nextInt();
//
//            s.nextLine();
//
//            if (nrLinhas == 0) break;
//
//            final Character[][] map = new Character[nrLinhas][];
//
//            for (int i = 0; i < nrLinhas; i++) {
//
//                map[i] = s.nextLine().chars()
//                        .mapToObj(c -> (char) c)
//                        .toArray(Character[]::new);
//            }
//
//            final int[][] pathHistory = new int[map.length][map[0].length];
//
//
//            final int[] xy = {0, 0};
//
//            if (tentar(map, xy, pathHistory, nrMaxInvert)) System.out.println("Sim");
//
//            else System.out.println("Nao");
//
//        }
//
//    }

    // TODO - Talvez atribuir o valor subtraido ao nrMaxInvert :thinking:
    public static boolean tentar(Character[][] map, int[] xy, int[][] pathHistory, int nrMaxInvert) {

        if (isOutSideMap(map, xy)) {

            if (nrMaxInvert > 0) {

                int[] newXY = invertDirection(map, xy);
                // TODO  - Talvez marcar a posição atual como visitada..... xy
                return tentar(map, newXY, pathHistory, nrMaxInvert - 1);
            }

            return false;
        }

        if (isGoal(map, xy)) return true;

        if (isAlreadyMarkedAsPartOfSolution(xy, pathHistory)) return false;

        markPosition(xy, pathHistory, VISITED);

        Character direction = map[xy[1]][xy[0]];
        boolean result = false;

        switch (direction) {
            case CIMA:
                // TODO Ajustar essa atribuição -> usar nova variável;
                xy[1] = xy[1] - 1; // x, (y+1)
                result = tentar(map, xy, pathHistory, nrMaxInvert);

                if (!result && nrMaxInvert > 0) {
                    result = tentar(map, invertDirection(map, xy), pathHistory, nrMaxInvert);
                }

                break;
            case BAIXO:
                xy[1] = xy[1] + 1; // x, (y-1)
                result = tentar(map, xy, pathHistory, nrMaxInvert);

                if (!result && nrMaxInvert > 0) {
                    result = tentar(map, invertDirection(map, xy), pathHistory, nrMaxInvert);
                }

                break;
            case ESQUERDA:
                xy[0] = xy[0] - 1; // (x-1), y
                result = tentar(map, xy, pathHistory, nrMaxInvert);

                if (!result && nrMaxInvert > 0) {
                    result = tentar(map, invertDirection(map, xy), pathHistory, nrMaxInvert);
                }

                break;
            case DIREITA:
                xy[0] = xy[0] + 1; // (x+1), y
                result = tentar(map, xy, pathHistory, nrMaxInvert);

                if (!result && nrMaxInvert > 0) {
                    result = tentar(map, invertDirection(map, xy), pathHistory, nrMaxInvert);
                }

                break;
        }

        // unmark x,y as part of solution path
        if (!result) {
            markPosition(xy, pathHistory, NO_VISITED);
        }

        return result;
    }


    private static void markPosition(int[] xy, int[][] pathHistory, int status) {
        pathHistory[xy[0]][xy[1]] = status;
    }


    private static boolean isAlreadyMarkedAsPartOfSolution(int[] xy, int[][] pathHistory) {
        return (pathHistory[xy[0]][xy[1]] == VISITED);
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

        return ((xy[0] < 0) || (xy[0] >= numOfColuns)) || ((xy[1] < 0) && (xy[1] >= numOfLines));
    }


    public static boolean isOddNumber(int num) {
        return !(num % 2 == 0);
    }

    public static <T> void arrayCopy(T[][] aSource, T[][] aDestination) {

        for (int i = 0; i < aSource.length; i++) {
            System.arraycopy(aSource[i], 0, aDestination[i], 0, aSource[i].length);
        }
    }

    public static void main(String[] args) {
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

        int[] xy = {2,1};
        System.out.println(Arrays.toString(invertDirection(myM, xy)));
    }
}
