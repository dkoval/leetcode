package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/">Number of Ways to Stay in the Same Place After Some Steps (Hard)</a>
 * <p>
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left,
 * 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).
 * <p>
 * Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after exactly steps steps.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= steps <= 500</li>
 *  <li>1 <= arrLen <= 10^6</li>
 * </ul>
 */
public interface NumberOfWaysToStaySamePlaceAfterSomeSteps {

    int MOD = 1_000_000_007;

    int numWays(int steps, int arrLen);

    class NumberOfWaysToStaySamePlaceAfterSomeStepsDPTopDownRev1 implements NumberOfWaysToStaySamePlaceAfterSomeSteps {

        @Override
        public int numWays(int steps, int arrLen) {
            // DP top-down
            int n = Math.min(steps, arrLen);
            Integer[][] dp = new Integer[n][steps + 1];
            return calculate(0, steps, n, dp);
        }

        private int calculate(int index, int steps, int n, Integer[][] dp) {
            if (index < 0 || index == n) {
                return 0;
            }

            // base case
            if (steps == 0) {
                return (index == 0) ? 1 : 0;
            }

            // already solved?
            if (dp[index][steps] != null) {
                return dp[index][steps];
            }

            // 3 choices to be made: move left, stay in the same place, move right
            int count = 0;
            for (int dx = -1; dx <= 1; dx++) {
                count += calculate(index + dx, steps - 1, n, dp);
                count %= MOD;
            }

            // cache and return the answer
            return dp[index][steps] = count;
        }
    }
}
