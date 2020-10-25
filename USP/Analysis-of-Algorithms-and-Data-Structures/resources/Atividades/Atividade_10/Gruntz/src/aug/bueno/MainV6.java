/*
package aug.bueno;

import java.util.LinkedList;

public class MainV6 {

    static LinkedList<Move> Q = new LinkedList();

    static int k = 0;

    static int m = 0;

    static int n = 0;

    class Move {
        int x;
        int y;
        int c;

        Move(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static char inv(char c) {
        if (c == '<') return '>';
        if (c == '>') return '<';
        if (c == '^') return 'v';
        if (c == 'v') return '^';

        return '^';
    }

    void put(int x, int y, int c, char expected, int[][] M, int[][] V) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return;

        if (M[x][y] == expected && c < V[x][y]) {
            Q.push(new Move(x, y, c));
            V[x][y] = c;

        } else if (M[x][y] == inv(expected) && c + 1 <= k && c < V[x][y]) {
            Q.push(new Move(x, y, c + 1));
            V[x][y] = c + 1;
        }
    }
}
*/
