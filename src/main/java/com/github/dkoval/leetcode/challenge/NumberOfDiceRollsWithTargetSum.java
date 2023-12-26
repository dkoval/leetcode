package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/">Number of Dice Rolls With Target Sum</a>
 * <p>
 * You have n dice and each die has k faces numbered from 1 to k.
 * <p>
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice
 * so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n, k <= 30</li>
 *  <li>1 <= target <= 1000</li>
 * </ul>
 */
public interface NumberOfDiceRollsWithTargetSum {

    int MOD = 1_000_000_007;

    int numRollsToTarget(int n, int k, int target);

    class NumberOfDiceRollsWithTargetSumDPTopDown implements NumberOfDiceRollsWithTargetSum {

        @Override
        public int numRollsToTarget(int n, int k, int target) {
            // DP: top-down
            return count(n, target, k, new Integer[n + 1][target + 1]);
        }

        // Here n is the number of available dices.
        private int count(int n, int target, int k, Integer[][] dp) {
            if (n == 0) {
                return (target == 0) ? 1 : 0;
            }

            if (dp[n][target] != null) {
                return dp[n][target];
            }

            // brute-force on k
            int count = 0;
            for (int i = 1; i <= k; i++) {
                if (target - i >= 0) {
                    count += count(n - 1, target - i, k, dp);
                    count %= MOD;
                }
            }
            return dp[n][target] = count;
        }
    }

    class NumberOfDiceRollsWithTargetSumDpBottomUp implements NumberOfDiceRollsWithTargetSum {

        @Override
        public int numRollsToTarget(int n, int k, int target) {
            // dp[d][s] - number of possible ways to roll d dices such that the sum of the face-up numbers equals to s
            int[][] dp = new int[n + 1][target + 1];
            dp[0][0] = 1;

            for (int dice = 1; dice <= n; dice++) {
                for (int face = 1; face <= k; face++) {
                    for (int sum = target; sum - face >= 0; sum--) {
                        dp[dice][sum] += dp[dice - 1][sum - face];
                        dp[dice][sum] %= MOD;
                    }
                }
            }
            return dp[n][target];
        }
    }
}
