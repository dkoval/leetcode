package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public abstract class CoinChange {

    public abstract int coinChange(int[] coins, int amount);

    // Time complexity : O(S*N) where S is the amount, N is denomination count.
    // In the worst case the recursive tree of the algorithm has height of S and the algorithm solves only S subproblems
    // because it caches precalculated solutions in a table.
    //
    // Space complexity : O(S). We use extra space for the memoization table.
    public static class CoinChangeTopDownWithMemoization extends CoinChange {

        @Override
        public int coinChange(int[] coins, int amount) {
            // top-down with memoization:
            // memo[i] - minimum amount of coins needed to make up i amount of money
            return doCoinChange(coins, amount, new int[amount + 1]);
        }

        private int doCoinChange(int[] coins, int amount, int[] memo) {
            // base cases
            if (amount < 0) return -1;
            if (amount == 0) return 0;

            // check if we solved the same problem before
            if (memo[amount] != 0) return memo[amount];

            int minResult = Integer.MAX_VALUE;
            for (int coin : coins) {
                int result = doCoinChange(coins, amount - coin, memo);
                if (result >= 0 && result < minResult) {
                    minResult = 1 + result;
                }
            }

            memo[amount] = (minResult == Integer.MAX_VALUE) ? -1 : minResult;
            return memo[amount];
        }
    }

    public static class CoinChangeBottomUp extends CoinChange {

        @Override
        public int coinChange(int[] coins, int amount) {
            // bottom-up DP
            // dp[i] - minimum amount of coins needed to make up i amount of money
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                int minResult = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (coin > i) continue;
                    int prevResult = dp[i - coin];
                    if (prevResult >= 0 && prevResult < minResult) {
                        minResult = 1 + prevResult;
                    }
                }
                dp[i] = (minResult == Integer.MAX_VALUE) ? -1 : minResult;
            }
            return dp[amount];
        }
    }
}
