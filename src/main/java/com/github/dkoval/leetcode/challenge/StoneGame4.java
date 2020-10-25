package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3507/">Stone Game IV</a>
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there are n stones in a pile.  On each player's turn, that player makes a move consisting of removing
 * any non-zero square number of stones in the pile.
 * <p>
 * Also, if a player cannot make a move, he/she loses the game.
 * <p>
 * Given a positive integer n. Return True if and only if Alice wins the game otherwise return False,
 * assuming both players play optimally.
 */
public abstract class StoneGame4 {

    public abstract boolean winnerSquareGame(int n);

    // Time complexity: O(N^1.5)
    // Space complexity: O(N)
    public static class StoneGame4DPTopDown extends StoneGame4 {
        private final Boolean[] dp = new Boolean[100_000 + 1]; // 1 <= n <= 10^5

        @Override
        public boolean winnerSquareGame(int n) {
            if (n == 0) return false;
            if (dp[n] != null) return dp[n];
            boolean aliceWins = false;
            // this loop runs sqrt(n) times
            for (int i = 1; i * i <= n; i++) {
                // Simulate Bob's turns. If Bob loses, Alice wins.
                if (!winnerSquareGame(n - i * i)) {
                    aliceWins = true;
                    break;
                }
            }
            dp[n] = aliceWins;
            return dp[n];
        }
    }

    // Time complexity: O(N^1.5)
    // Space complexity: O(N)
    public static class StoneGame4DPBottomUp extends StoneGame4 {

        @Override
        public boolean winnerSquareGame(int n) {
            boolean[] dp = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    // Simulate Bob's turns. If Bob loses, Alice wins.
                    if (!dp[i - j * j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
