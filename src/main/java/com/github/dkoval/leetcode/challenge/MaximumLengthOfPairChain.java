package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">Maximum Length of Pair Chain</a>
 * <p>
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 * <p>
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 * <p>
 * Return the length longest chain which can be formed.
 * <p>
 * You do not need to use up all the given intervals. You can select pairs in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == pairs.length</li>
 *  <li>1 <= n <= 1000</li>
 *  <li>-1000 <= lefti < righti <= 1000</li>
 * </ul>
 */
public interface MaximumLengthOfPairChain {

    int findLongestChain(int[][] pairs);

    // O(N^2) time | O(N) space
    class MaximumLengthOfPairChainDP implements MaximumLengthOfPairChain {

        @Override
        public int findLongestChain(int[][] pairs) {
            int n = pairs.length;
            Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));

            // idea: ~ LIS (longest increasing subsequence)
            // dp[i] - the max length of pair chain ending at index i
            int[] dp = new int[n];

            int best = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                // can we further extend an existing chain of pairs with the pairs[i]?
                for (int j = i - 1; j >= 0; j--) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                best = Math.max(best, dp[i]);
            }
            return best;
        }
    }

    // O(NlogN) time | O(1) space
    class MaximumLengthOfPairChainGreedy implements MaximumLengthOfPairChain {

        @Override
        public int findLongestChain(int[][] pairs) {
            int n = pairs.length;
            Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));

            // idea: ~ merge intervals
            int ans = n;
            int last = 0; // index of the last pair in the chain
            for (int i = 1; i < n; i++) {
                if (pairs[i][0] <= pairs[last][1]) {
                    // There's a conflict!
                    // Greedy: to resolve a conflict, remove a pair with > ending number
                    if (pairs[last][1] > pairs[i][1]) {
                        last = i;
                    }
                    ans--;
                } else {
                    last = i;
                }
            }
            return ans;
        }
    }
}
