package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/coin-change-2/">Coin Change 2</a>
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */
public interface CoinChange2 {

    int change(int amount, int[] coins);

    // O(N * A) time | O(N * A) space, where N = len(coins), A - amount
    // Resource: https://www.youtube.com/watch?v=zAnD3AVufsI
    class CoinChange2TopDown implements CoinChange2 {

        @Override
        public int change(int amount, int[] coins) {
            int n = coins.length;
            return change(amount, coins, 0, new Integer[n][amount + 1]);
        }

        private int change(int amount, int[] coins, int idx, Integer[][] memo) {
            // base cases
            if (amount == 0) {
                return 1;
            }

            if (amount < 0 || idx >= coins.length) {
                return 0;
            }

            // already solved?
            if (memo[idx][amount] != null) {
                return memo[idx][amount];
            }

            // Option #1: include coins[idx]. Note that idx is not incremented since we have infinite number of coins[idx] at our disposal.
            int incl = change(amount - coins[idx], coins, idx, memo);
            // Option #2: exclude coins[idx].
            int excl = change(amount, coins, idx + 1, memo);

            // case solution
            memo[idx][amount] = incl + excl;
            return memo[idx][amount];
        }
    }
}
