package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower-ii/">Guess Number Higher or Lower II</a>
 * <p>
 * We are playing the Guessing Game. The game will work as follows:
 * <p>
 * I pick a number between 1 and n.
 * You guess a number.
 * If you guess the right number, you win the game.
 * If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
 * Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
 * <p>
 * Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.
 */
public abstract class GuessNumberHigherOrLower2 {

    public abstract int getMoneyAmount(int n);

    // Time complexity: O(N!)
    // Space complexity: O(N)
    public static class GuessNumberHigherOrLower2BruteForce extends GuessNumberHigherOrLower2 {

        @Override
        public int getMoneyAmount(int n) {
            return getMoneyAmount(1, n);
        }

        private int getMoneyAmount(int lo, int hi) {
            if (lo >= hi) {
                return 0;
            }
            // cost(1, n) = i + max(cost(1, i − 1), cost(i + 1, n))
            int minCost = Integer.MAX_VALUE;
            int mid = lo + (hi - lo) / 2;
            for (int pivot = mid; pivot <= hi; pivot++) {
                int cost = pivot + Math.max(getMoneyAmount(lo, pivot - 1), getMoneyAmount(pivot + 1, hi));
                minCost = Math.min(minCost, cost);
            }
            return minCost;
        }
    }

    public static class GuessNumberHigherOrLower2TopDown extends GuessNumberHigherOrLower2 {

        @Override
        public int getMoneyAmount(int n) {
            // memo[i][j] - min cost of finding the worst number in the range [i, j]
            // cost(i, j) = pivot + max(cost(i, pivot − 1), cost(pivot + 1, j))
            int[][] memo = new int[n + 1][n + 1];
            return getMoneyAmount(1, n, memo);
        }

        private int getMoneyAmount(int lo, int hi, int[][] memo) {
            if (lo >= hi) {
                return 0;
            }
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }
            // cost(1, n) = i + max(cost(1, i − 1), cost(i + 1, n))
            int minCost = Integer.MAX_VALUE;
            int mid = lo + (hi - lo) / 2;
            for (int pivot = mid; pivot <= hi; pivot++) {
                int cost = pivot + Math.max(getMoneyAmount(lo, pivot - 1, memo), getMoneyAmount(pivot + 1, hi, memo));
                minCost = Math.min(minCost, cost);
            }
            memo[lo][hi] = minCost;
            return minCost;
        }
    }
}
