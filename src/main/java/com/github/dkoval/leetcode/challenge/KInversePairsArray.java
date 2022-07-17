package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/k-inverse-pairs-array/">K Inverse Pairs Array (Hard)</a>
 * <p>
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].
 * <p>
 * Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
 * Since the answer can be huge, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 1000</li>
 *  <li>0 <= k <= 1000</li>
 * </ul>
 */
public interface KInversePairsArray {

    int MOD = 1_000_000_007;

    int kInversePairs(int n, int k);

    // Results in TLE
    // O(N*K^2) time | O(N*K) space
    class KInversePairsArrayDPTopDown implements KInversePairsArray {

        @Override
        public int kInversePairs(int n, int k) {
            // Recurrence relation:
            // f(n + 1, k) = f(n, k) + f(n, k - 1) + ... + f(n, n - k)
            Integer[][] memo = new Integer[n + 1][k + 1];
            return solve(n, k, memo);
        }

        private int solve(int n, int k, Integer[][] memo) {
            // DP top-down
            if (n == 0) {
                return 0;
            }

            if (k == 0) {
                // only 1 inverse pair can be formed: [1, 2, ..., n]
                return 1;
            }

            if (memo[n][k] != null) {
                return memo[n][k];
            }

            int count = 0;
            for (int i = 0; i <= Math.min(k, n - 1); i++) {
                count += solve(n - 1, k - i, memo) % MOD;
                count %= MOD;
            }
            return memo[n][k] = count;
        }
    }

    // Results in TLE
    // O(N*K^2) time | O(N*K) space
    class KInversePairsArrayDPBottomUp implements KInversePairsArray {

        @Override
        public int kInversePairs(int N, int K) {
            // Recurrence relation:
            // f(n + 1, k) = f(n, k) + f(n, k - 1) + ... + f(n, n - k)
            int[][] dp = new int[N + 1][K + 1];
            for (int n = 1; n <= N; n++) {
                dp[n][0] = 1; // base case
                for (int k = 1; k <= K; k++) {
                    for (int i = 0; i <= Math.min(k, n - 1); i++) {
                        dp[n][k] += dp[n - 1][k - i] % MOD;
                        dp[n][k] %= MOD;
                    }
                }
            }
            return dp[N][K];
        }
    }
}
