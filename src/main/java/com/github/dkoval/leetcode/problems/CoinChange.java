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
            // DP: top-down with memoization
            // memo[i] - minimum amount of coins needed to make up i amount of money
            return coinChange(coins, amount, new int[amount + 1]);
        }

        private int coinChange(int[] coins, int amount, int[] memo) {
            if (amount == 0) return 0;
            if (memo[amount] != 0) return memo[amount];
            int minNumCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > amount) continue;
                int numCoins = coinChange(coins, amount - coin, memo);
                if (numCoins != -1) {
                    minNumCoins = Math.min(minNumCoins, numCoins);
                }
            }
            memo[amount] = (minNumCoins == Integer.MAX_VALUE) ? -1 : 1 + minNumCoins;
            return memo[amount];
        }
    }

    public static class CoinChangeBottomUp extends CoinChange {

        @Override
        public int coinChange(int[] coins, int amount) {
            // DP: bottom-up
            // dp[i] - minimum amount of coins needed to make up i amount of money
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                int minNumCoins = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (coin > i) continue;
                    int numCoins = dp[i - coin];
                    if (numCoins != -1) {
                        minNumCoins = Math.min(minNumCoins, numCoins);
                    }
                }
                dp[i] = (minNumCoins == Integer.MAX_VALUE) ? -1 : 1 + minNumCoins;
            }
            return dp[amount];
        }
    }
}
