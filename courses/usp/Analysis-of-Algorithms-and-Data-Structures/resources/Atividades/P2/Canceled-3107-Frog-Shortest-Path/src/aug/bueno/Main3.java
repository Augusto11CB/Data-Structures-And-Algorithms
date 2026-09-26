package aug.bueno;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main3 {
    public static int X; //Long
    public static int Y; //Curto
    public static int MAX_DEPTH = Integer.MAX_VALUE; //Curto

    public static void main(String[] args) throws Exception {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        String[] in = s.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        String[] entrada = s.readLine().split(" ");
        int[] numbers = new int[n + 2];
        numbers[0] = 0;
        numbers[numbers.length - 1] = m;

        for (int i = 0; i < n; i++) {
            numbers[i + 1] = Integer.parseInt(entrada[i]);
        }

        in = s.readLine().split(" ");
        X = Integer.parseInt(in[0]);
        Y = Integer.parseInt(in[1]);

        dfs(false, 0, 0, (numbers.length - 1), numbers);
//        for (Edge e : mst.Edge()) {
//            System.out.println(e);
//        }

        System.out.println(MAX_DEPTH != Integer.MAX_VALUE ? MAX_DEPTH  : -1);
    }

    public static void dfs(boolean puloLongo, int profundidade, int posicao, int objetivo, int[] numbers) {
        if (profundidade >= MAX_DEPTH) return;

        if (posicao == objetivo) {
            MAX_DEPTH = profundidade;
            return;
        }

        List<Integer> opPulos;

        if (!puloLongo) {
            opPulos = getOptions(posicao, numbers);
            for (Integer proxPosicao : opPulos) {
//                System.out.println("dfs com pulo -> proxPosicao" + proxPosicao);
                dfs(true, profundidade + 1, proxPosicao, objetivo, numbers);
            }
        }

        opPulos = getOptionsShortJump(posicao, numbers);
        for (Integer proxPosicao : opPulos) {
//            System.out.println("dfs sem pulo -> proxPosicao" + proxPosicao);
            dfs(puloLongo, profundidade + 1, proxPosicao, objetivo, numbers);
        }

    }

    public static List<Integer> getOptionsShortJump(int position, int[] numbers) {
        List<Integer> result = new LinkedList<>();
        for (int i = position + 1; i < numbers.length; i++) {

            if (numbers[i] <= X) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> getOptions(int position, int[] numbers) {
        List<Integer> result = new LinkedList<>();
        for (int i = position + 1; i < numbers.length; i++) {

            if ((X <= numbers[i] && numbers[i] <= Y)) {
                result.add(i);
            }
        }
        return result;
    }
}
