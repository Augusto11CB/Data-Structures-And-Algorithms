package aug.bueno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class Maim {

    public static void main(String[] args) throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        String[] lineOne = s.readLine().split(" ");

        int noelGift = Integer.parseInt(lineOne[0]);
        int brunoGift = Integer.parseInt(lineOne[1]);

        String coinStringList = s.readLine();

        int[] vLinha = Stream.of(coinStringList.split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (isThereChange(vLinha, noelGift)) {
            System.out.println("S");
        } else {
            System.out.println("N");

        }
    }

    public static boolean isThereChange(int[] vLinha, int purchaseTotalValue) {
        Map<String, Integer> mem = new HashMap<>();

        int x = dp(vLinha, purchaseTotalValue, vLinha.length - 1, mem);
        return x > 0;
    }

    private static int dp(int[] vLinha, int purchaseTotalValue, int i, Map<String, Integer> mem) {
        String key = purchaseTotalValue + ":" + i;

        int toReturn;

        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        if (purchaseTotalValue == 0) {
            return 1;
        } else if (purchaseTotalValue < 0) {
            return 0;
        } else if (i < 0) {
            return 0;
        } else if (purchaseTotalValue < vLinha[i]) {
            toReturn = dp(vLinha, purchaseTotalValue, i - 1, mem);
        } else {
            toReturn = dp(vLinha, purchaseTotalValue - vLinha[i], i - 1, mem) + dp(vLinha, purchaseTotalValue, i - 1, mem);
        }

        mem.put(key, toReturn);

        return toReturn;
    }

}
