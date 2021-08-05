package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3870/">Stone Game</a>
 * <p>
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either
 * the beginning or the end of the row. This continues until there are no more piles left,
 * at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */
public class StoneGame {

    // O(N^2) time | O(N^2) space
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
        // score1 + score2 = sum(piles)
        // score1 - score2 = delta
        // + --------------------------
        // = 2 * score1 = sum(piles) + delta = score1 + score2 + delta
        // score1 = score2 + delta, therefore for the 1st player to win, delta has to be > 0
        return scoreDelta(piles, 0, n - 1, memo) > 0;
    }

    // left index is in [0, N-1], right index is in [left, N - 1], which results in O(N^2) inputs.
    // For each input, O(1) work is being done, therefore the overall time complexity is O(N^2).
    private int scoreDelta(int[] piles, int left, int right, Integer[][] memo) {
        if (left == right) {
            return piles[left];
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        // take the best score while considering left and right piles
        int delta = Integer.MIN_VALUE;
        delta = Math.max(delta, piles[left] - scoreDelta(piles, left + 1, right, memo));
        delta = Math.max(delta, piles[right] - scoreDelta(piles, left, right - 1, memo));

        memo[left][right] = delta;
        return delta;
    }
}
