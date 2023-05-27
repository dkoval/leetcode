package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/stone-game-iii/">Stone Game III (Hard)</a>
 * <p>
 * Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each stone
 * has an associated value which is an integer given in the array stoneValue.
 * <p>
 * Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones
 * from the first remaining stones in the row.
 * <p>
 * The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.
 * <p>
 * The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie.
 * The game continues until all the stones have been taken.
 * <p>
 * Assume Alice and Bob play optimally.
 * <p>
 * Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= stoneValue.length <= 5 * 10^4</li>
 *  <li>-1000 <= stoneValue[i] <= 1000</li>
 * </ul>
 */
public interface StoneGame3 {

    String stoneGameIII(int[] values);

    class StoneGame3DPTopDown implements StoneGame3 {

        @Override
        public String stoneGameIII(int[] values) {
            int n = values.length;

            // DP top-down + MinMax
            Integer[] dp = new Integer[n];
            int comp = calculate(values, 0, dp);
            return (comp == 0) ? "Tie" : (comp > 0 ? "Alice" : "Bob");
        }

        // MinMax - returns either Alice's score - Bob's score, if taken from Alice's perspective;
        // or Bob's score - Alice's score, if taken from Bob's perspective
        private int calculate(int[] stoneValue, int idx, Integer[] dp) {
            int n = stoneValue.length;

            if (idx >= n) {
                return 0;
            }

            // already solved?
            if (dp[idx] != null) {
                return dp[idx];
            }

            int best = Integer.MIN_VALUE;
            int total = 0;
            for (int i = idx; i < Math.min(idx + 3, n); i++) {
                total += stoneValue[i];
                int diff = total - calculate(stoneValue, i + 1, dp);
                best = Math.max(best, diff);
            }
            return dp[idx] = best;
        }
    }
}
