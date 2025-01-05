package com.buenosdev.dynamicProgramming.coinchange;

import java.util.HashMap;
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        var dp = new HashMap<Integer, Integer>();
        var resp = dfs(coins, amount, dp);
        return resp == Integer.MAX_VALUE ? -1 : resp;
    }

    private int dfs(int[] c, int a, Map<Integer, Integer> dp) {
        if (a < 0) return -1;
        if (a == 0)
            return 0;

        if (dp.containsKey(a))
            return dp.get(a);

        var min = Integer.MAX_VALUE;

        for (int coin : c) {

            if (a - coin < 0)
                continue;

            var minCoin = dfs(c, a - coin, dp);

            if (minCoin >= 0 && minCoin < min)
                min = 1 + minCoin;
        }

        dp.put(a, (min == Integer.MAX_VALUE) ? -1 : min);
        return dp.get(a);
    }

    // BFS BFS BFS BFS BFS BFS BFS BFS BFS BFS BFS
    public int coinChangeBFS(int[] coins, int amount){
        if(coins == null || coins.length == 0 || amount < 1) return 0;

        Deque<Integer> queue = new ArrayDeque<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.addFirst(amount);
        visited.add(amount);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                int curr = queue.removeLast();
                if(curr == 0) return level;

                if(curr < 0) continue;

                for(int coin : coins){
                    int next = curr - coin;
                    if(next >= 0 && !visited.contains(next)){
                        queue.addFirst(next);
                        visited.add(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}