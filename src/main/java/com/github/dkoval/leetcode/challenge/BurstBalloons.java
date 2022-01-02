package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3564/">Burst Balloons</a>
 * Difficulty: Hard
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 */
public interface BurstBalloons {

    int maxCoins(int[] nums);

    // O(N^3) time | O(N^2) space
    class BurstBalloonsDPTopDown implements BurstBalloons {

        private static class Pair {
            final int first;
            final int second;

            private Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair that = (Pair) o;
                return (first == that.first) && (second == that.second);
            }

            @Override
            public int hashCode() {
                return Objects.hash(first, second);
            }
        }

        // Resources:
        // https://www.youtube.com/watch?v=VFskby7lUbw
        // https://www.youtube.com/watch?v=Hps6bHDGtqQ
        @Override
        public int maxCoins(int[] nums) {
            int n = nums.length + 2;
            int[] balloons = new int[n];
            // append imaginary balloon painted with 1 to the left and to the right of nums[]
            balloons[0] = 1;
            balloons[n - 1] = 1;
            for (int i = 0; i < nums.length; i++) {
                balloons[i + 1] = nums[i];
            }
            // do not include imaginary balloons
            return maxCoins(balloons, 1, n - 2, new HashMap<>());
        }

        private int maxCoins(int[] balloons, int l, int r, Map<Pair, Integer> memo) {
            Pair key = new Pair(l, r);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // balloon[k] is the last balloon to burst in [l:r]
            int maxCoins = 0;
            for (int k = l; k <= r; k++) {
                int numCoins = balloons[l - 1] * balloons[k] * balloons[r + 1];
                numCoins += maxCoins(balloons, l, k - 1, memo); // add additional coins we get from the left sub-array
                numCoins += maxCoins(balloons, k + 1, r, memo); // add additional coins we get from the right sub-array
                maxCoins = Math.max(maxCoins, numCoins);
            }

            memo.put(key, maxCoins);
            return maxCoins;
        }
    }

    // O(N^3) time | O(N^2) space
    class BurstBalloonsDPBottomUp implements BurstBalloons {

        // Resource: https://www.youtube.com/watch?v=IFNibRVgFBo
        @Override
        public int maxCoins(int[] nums) {
            int n = nums.length;

            // dp[i][j] - the maximum coins you can collect considering balloons[i:j]
            int[][] dp = new int[n][n];
            // consider all sub-arrays of balloons[i:j] and find the last balloon to burst in the sub-array to maximize the number of collected coins
            for (int len = 1; len <= n; len++) {
                for (int l = 0; l <= n - len; l++) {
                    int r = l + len - 1;
                    // balloons[k] is the last balloon to burst in balloons[l:r]
                    for (int k = l; k <= r; k++) {
                        int numCoins = (k == l ? 0 : dp[l][k - 1]) // left side: if k = l, there is nothing to the left
                                + (l == 0 ? 1 : nums[l - 1]) * nums[k] * (r == n - 1 ? 1 : nums[r + 1]) // balloon to burst
                                + (k == r ? 0 : dp[k + 1][r]); // right side: if k = r, there is nothing to the right

                        //System.out.printf("Length = %d, sub-array = [%d:%d], last balloon to burst = %d, coins = %d\n", len, l, r, k, numCoins);
                        dp[l][r] = Math.max(dp[l][r], numCoins);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
