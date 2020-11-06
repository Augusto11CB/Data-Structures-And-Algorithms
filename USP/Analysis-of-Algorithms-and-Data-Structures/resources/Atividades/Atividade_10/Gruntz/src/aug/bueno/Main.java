package aug.bueno;

import java.util.Scanner;

/**
 * backtracking 2 - Resolução do problema utilizando backtracking e começando apartir das pontas do mapa
 * <p>
 * Input 1
 * 5 5 0
 * >>v<<
 * >>v<<
 * >>x<<
 * >>^<<
 * >>^<<
 * <p>
 * Output 1
 * Sim
 * <p>
 * Input 2
 * 5 5 1
 * >>v<<
 * ^^^>>
 * ^^x^^
 * vvv>>
 * >>^<<
 * <p>
 * Output 2
 */

public class Main {

    public static final char BAIXO = 'v', CIMA = '^', ESQUERDA = '<', DIREITA = '>';

    public static int VISITED = 1;
    public static int NO_VISITED = 0;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {

            int nrLinhas = s.nextInt();

            int nrColunas = s.nextInt();

            int nrMaxInvert = s.nextInt();

            s.nextLine();

//            if (nrLinhas == 0) break;

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

        final int[][] pathHistory = new int[map.length][map[0].length];

        boolean result = false;

        // verificamos se ao colocar o jogador nas pontas do mapa, como especificado no enunciado, é possivel se atingir o objetivo

        //cima
        int cima = nrMaxInvert;
        final int[][] cimaHistory = new int[map.length][map[0].length];
        result = navigate(map, new int[]{0, 0}, cimaHistory, cima);

        //baixo
        if (!result) {
            int baixo = nrMaxInvert;
            final int[][] baixoHistory = new int[map.length][map[0].length];
            result = navigate(map, new int[]{map[0].length - 1, map.length - 1}, baixoHistory, baixo);
        }

        //esquerda
        if (!result) {
            int esquerda = nrMaxInvert;
            final int[][] esqHistory = new int[map.length][map[0].length];
            result = navigate(map, new int[]{0, map.length - 1}, esqHistory, esquerda);
        }

        //direita
        if (!result) {
            int direita = nrMaxInvert;
            final int[][] dirHistory = new int[map.length][map[0].length];
            result = navigate(map, new int[]{map[0].length - 1, 0}, dirHistory, direita);
        }

        return result;

    }

    public static boolean navigate(Character[][] map, int[] xy, final int[][] pathHistory, int nrMaxInvert) {

        // Valida se não é posição invalida OU
        // Se já não foi visitado
        if (isOutSideMap(map, xy) ||
                isAlreadyMarkedAsPartOfSolution(xy, pathHistory)) {
            return false;
        }

        markPosition(xy, pathHistory, VISITED);

        if (isGoal(map, xy)) return true;

        int[] newPositionToGo = getPositionToGo(map, xy);

        int[] newPositionToGoInverted = getInvertedPositionToGo(map, xy);

        boolean result = false;

        int tempNRMaxInvert = nrMaxInvert;

        // Verifica se não está fora do mapa
        if (!isOutSideMap(map, newPositionToGo)) {

            // Faz chamada recursiva para posição seguinte
            result = navigate(map, newPositionToGo, pathHistory, tempNRMaxInvert);

            // Se não deu certo e temos como inverter a posição (nrMaxInvert > 0), então invertemos e realizamos outra chamada recursiva
            if (!result && nrMaxInvert > 0) {

                if (!isOutSideMap(map, newPositionToGoInverted)) {

                    nrMaxInvert = nrMaxInvert - 1;

                    tempNRMaxInvert = nrMaxInvert;

                    result = navigate(map, newPositionToGoInverted, pathHistory, tempNRMaxInvert);

                    nrMaxInvert = tempNRMaxInvert;
                }
            }

        } else {

            //Caso esteja fora do mapa, verificamos se com inversão existe um caminho a se seguir. este else é o novo caminho
            // gerado após a inversão de uma posição que estáva fora dos limits do mapa

            if (nrMaxInvert > 0) {

                nrMaxInvert = nrMaxInvert - 1;

                tempNRMaxInvert = nrMaxInvert;

                result = navigate(map, newPositionToGoInverted, pathHistory, tempNRMaxInvert);

                nrMaxInvert = tempNRMaxInvert;
            }
        }

        if (!result) {
            markPosition(xy, pathHistory, NO_VISITED);
        }

        return result;
    }

    private static void markPosition(int[] xy, int[][] pathHistory, int status) {
        pathHistory[xy[1]][xy[0]] = status;
    }


    private static boolean isAlreadyMarkedAsPartOfSolution(int[] xy, int[][] pathHistory) {
        return (pathHistory[xy[1]][xy[0]] == VISITED);
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
        }
        return newXY;
    }

    public static boolean isOutSideMap(Character[][] map, int[] xy) {

        int numOfLines = map.length;
        int numOfColuns = map[0].length;

        return ((xy[0] < 0) || (xy[0] >= numOfColuns)) || ((xy[1] < 0) || (xy[1] >= numOfLines));
    }

    private static boolean isGoal(Character[][] map, int[] xy) {
        int yGoal = map.length / 2;
        int xGoal = (map[0].length - 1) / 2;

        return (xy[0] == xGoal) && (xy[1] == yGoal);
    }
    
}



















