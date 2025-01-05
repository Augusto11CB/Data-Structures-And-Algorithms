package com.buenosdev;

import java.util.HashMap;
import java.util.Map;

public class ScoreManager {
    private static final int START_SCORE = 0;
    private Map<String, Integer> playerScore;
    private int targetScore;

    public ScoreManager(final String playerNameA, final String playerNameB, final int targetScore) {
        playerScore = new HashMap<>();
        playerScore.put(playerNameA, START_SCORE);
        playerScore.put(playerNameB, START_SCORE);

        this.targetScore = targetScore;

    }

    public Map<String, Integer> markOnePoint(String player) {
        if (playerScore.containsKey(player)) {
            playerScore.put(player, playerScore.get(player) + 1);
            return playerScore;
        }
        throw new IllegalStateException("Invalid player");
    }

    public int getScore(String player) {
        if (playerScore.containsKey(player)) {
            return playerScore.get(player);
        }
        throw new IllegalStateException("Invalid player");
    }


}
