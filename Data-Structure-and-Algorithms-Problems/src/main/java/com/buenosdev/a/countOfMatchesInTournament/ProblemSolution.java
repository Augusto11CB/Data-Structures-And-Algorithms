package com.buenosdev.a.countOfMatchesInTournament;

class ProblemSolution {
    public int numberOfMatches(int n) {

        if(n == 1) return 0;

        var aux = 0;
        var carried = 0;
        var count = 0;


        if (n % 2 == 0) {
            aux = n;
        } else {
            carried = 1;
            aux = n - 1;
        }


        while (aux > 1) {
            // If n is odd, (n - 1) / 2 matches are played and (n - 1) / 2 + 1 teams play next round.
            if (aux % 2 != 0) {
                carried += 1;
                aux = aux - 1;
            }
            aux = aux / 2;
            count += aux;
        }

        count += carried;

        return count;
    }
}