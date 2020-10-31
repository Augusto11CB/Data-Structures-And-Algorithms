package aug.bueno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));


        String[] lineOne = s.readLine().split(" ");

        int purchaseTotalValue = Integer.parseInt(lineOne[0]);

        int quantityOfCoins = Integer.parseInt(lineOne[1]);

        String listaMoedas = s.readLine();

        int[] vLinha = Stream.of(listaMoedas.split(" "))
                .mapToInt(Integer::parseInt).toArray();

        listaMoedas = "";

        final int[][] map = new int[quantityOfCoins + 1][purchaseTotalValue + 1];

        if (isThereChange(vLinha, map, purchaseTotalValue, quantityOfCoins)) {
            System.out.println("S");
        } else {
            System.out.println("N");

        }
    }

    public static boolean isThereChange(int[] vLinha, int[][] valueOf, int purchaseTotalValue, int quantityOfCoins) {

        for (int i = 1; i <= quantityOfCoins; i++) {
            for (int y = 1; y <= purchaseTotalValue; y++) {
                if (vLinha[i - 1] > y) {
                    valueOf[i][y] = valueOf[i - 1][y];
                } else {
                    int notUseCoin = valueOf[i - 1][y];
                    int useCoin = valueOf[i - 1][y - vLinha[i - 1]] + vLinha[i - 1];

                    valueOf[i][y] = Math.max(notUseCoin, useCoin);
                }
            }
        }
        return valueOf[quantityOfCoins][purchaseTotalValue] == purchaseTotalValue;
    }

}
