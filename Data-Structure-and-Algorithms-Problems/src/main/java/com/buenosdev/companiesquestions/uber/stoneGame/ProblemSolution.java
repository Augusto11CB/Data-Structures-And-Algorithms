package com.buenosdev.companiesquestions.uber.stoneGame;

import java.util.Arrays;

class ProblemSolution {
    public boolean stoneGame(int[] piles) {
        var cacheDP = new int[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            Arrays.fill(cacheDP[i], -1);
        }

        var result = dfs(piles, 0, piles.length - 1, cacheDP);

        return result > (piles.length / 2);

    }

    public int dfs(int[] piles, int l, int r, int[][] cacheDP) {
        if (l > r) return 0;

        if (cacheDP[l][r] != -1) return cacheDP[l][r];

        var isEven = l - r % 2 == 0;

        var left = isEven ? piles[l] : 0;
        var right = isEven ? piles[r] : 0;

        cacheDP[l][r] = Math.max(
                dfs(piles, l + 1, r, cacheDP) + left,
                dfs(piles, l, r - 1, cacheDP) + right
        );


        return cacheDP[l][r];
    }
}