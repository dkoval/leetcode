package com.github.dkoval.leetcode.challenge

/**
 * [Coin Change 2](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/)
 *
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 */
object CoinChange2BottomUp : CoinChange2 {

    // Resources:
    // https://www.educative.io/edpresso/coin-change-problem-2-finding-the-number-of-ways-to-make-a-sum
    // https://www.youtube.com/watch?v=Nvrhx4lbfLI
    override fun change(amount: Int, coins: IntArray): Int {
        val dp = Array(coins.size + 1) { IntArray(amount + 1) }
        // dp[i][j] denotes the number of ways amount j can be made with coins[0:i]
        // initializing 1st column of the `dp` 2D-array to 1
        // because zero-amount can be made in one possible way: {0}
        for (i in 0..coins.size) {
            dp[i][0] = 1
        }

        for (i in 1..coins.size) {
            for (x in 0..amount) {
                dp[i][x] = if (coins[i - 1] > x) {
                    // can't pick the highest coin
                    dp[i - 1][x]
                } else {
                    // pick the highest coin
                    val y = x - coins[i - 1] // remaining amount
                    dp[i - 1][x] + dp[i][y]
                }
            }
        }
        return dp[coins.size][amount]
    }
}