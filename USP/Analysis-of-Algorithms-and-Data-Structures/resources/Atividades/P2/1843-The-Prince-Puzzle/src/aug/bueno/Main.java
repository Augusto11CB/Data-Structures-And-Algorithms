package aug.bueno;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Move {
    int x;
    int y;
    int before;
    int after;

    public Move(int x, int y, int before, int after) {
        super();
        this.x = x;
        this.y = y;
        this.before = before;
        this.after = after;
    }
}

class Optionz{
    int [] counts;


    public Optionz() {
        this.counts = new int [10];
    }

    public void add(int n) {
        this.counts[n]+=1;
    }

    public LinkedList<Optionn> getOptions(){

        LinkedList<Optionn> op = new LinkedList<Optionn>();

        for(int i =0;i<10;i++) {
            if(this.counts[i]!=0) {
                op.add(new Optionn(i, this.counts[i]));
            }
        }

        op.sort(Comparator.comparing(Optionn::getCount));
        return op;
    }


}


class Optionn{
    int value;
    int count;

    public Optionn(int v, int c) {
        this.value = v;
        this.count = c;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}

public class Main {

    public static int min_moves;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            String in = sc.nextLine();
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(in.charAt(j) + "");
            }
        }

        min_moves = Integer.MAX_VALUE;

        tentativa(mat, n, m, 1);
        System.out.println(min_moves);

    }

    public static void tentativa(int[][] mat, int n, int m, int profundidade) {

        if (profundidade >= min_moves)
            return;

        //HashSet<Integer> op = new HashSet<Integer>();
        Optionz opp = new Optionz();
        opcoes(opp, 0, 0, mat, n, m);

        for (Optionn o : opp.getOptions()) {
            LinkedList<Move> movez = new LinkedList<Move>();
            get_moves(movez, 0, 0, o.getValue(), mat, n, m);
            apply_moves(movez, mat, false);

            if (check_monocromatic(mat, n, m)) {
                min_moves = profundidade;
                return;
            }
            tentativa(mat, n, m, profundidade + 1);
            apply_moves(movez, mat, true);

        }

    }

    public static void opcoes(Optionz op, int x, int y, int[][] mat, int n, int m) {

        int current_colour = mat[x][y];
        mat[x][y] = -1;

        if (x - 1 > 0) {
            if (mat[x - 1][y] != -1 & mat[x - 1][y] != current_colour)
                op.add(mat[x - 1][y]);
            else if (mat[x - 1][y] == current_colour)
                opcoes(op, x - 1, y, mat, n, m);
        }
        if (y - 1 > 0) {
            if (mat[x][y - 1] != -1 & mat[x][y - 1] != current_colour)
                op.add(mat[x][y - 1]);
            else if (mat[x][y - 1] == current_colour)
                opcoes(op, x, y - 1, mat, n, m);
        }
        if (x + 1 < n) {
            if (mat[x + 1][y] != -1 & mat[x + 1][y] != current_colour)
                op.add(mat[x + 1][y]);
            else if (mat[x + 1][y] == current_colour)
                opcoes(op, x + 1, y, mat, n, m);
        }
        if (y + 1 < m) {
            if (mat[x][y + 1] != -1 & mat[x][y + 1] != current_colour)
                op.add(mat[x][y + 1]);
            else if (mat[x][y + 1] == current_colour)
                opcoes(op, x, y + 1, mat, n, m);
        }

        mat[x][y] = current_colour;

    }

    public static boolean check_monocromatic(int[][] mat, int n, int m) {

        boolean resp = true;
        int aux = mat[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resp = resp & (aux == mat[i][j]);
                if (!resp)
                    return false;
            }
        }
        return true;

    }

    public static void get_moves(LinkedList<Move> moves, int x, int y, int colour, int[][] mat, int n, int m) {

        int current_colour = mat[x][y];
        mat[x][y] = -1;

        if (x - 1 >= 0) {
            if (mat[x - 1][y] == current_colour | mat[x - 1][y] == colour)
                get_moves(moves, x - 1, y, colour, mat, n, m);
        }
        if (y - 1 >= 0) {
            if (mat[x][y - 1] == current_colour | mat[x][y - 1] == colour)
                get_moves(moves, x, y - 1, colour, mat, n, m);
        }
        if (x + 1 < n) {
            if (mat[x + 1][y] == current_colour | mat[x + 1][y] == colour)
                get_moves(moves, x + 1, y, colour, mat, n, m);
        }
        if (y + 1 < m) {
            if (mat[x][y + 1] == current_colour | mat[x][y + 1] == colour)
                get_moves(moves, x, y + 1, colour, mat, n, m);
        }

        moves.add(new Move(x, y, current_colour, colour));

    }

    public static void apply_moves(LinkedList<Move> moves, int[][] mat, boolean reverse) {

        for (Move m : moves) {
            if (!reverse)
                mat[m.x][m.y] = m.after;
            else
                mat[m.x][m.y] = m.before;
        }
    }

}
