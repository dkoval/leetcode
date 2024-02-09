package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/largest-divisible-subset/">Largest Divisible Subset</a>
 * <p>
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair
 * (answer[i], answer[j]) of elements in this subset satisfies:
 * <ul>
 *  <li>answer[i] % answer[j] == 0, or</li>
 *  <li>answer[j] % answer[i] == 0</li>
 * </ul>
 * If there are multiple solutions, return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 2 * 10^9</li>
 * </ul>
 * All the integers in nums are unique.
 */
public interface LargestDivisibleSubset {

    List<Integer> largestDivisibleSubset(int[] nums);

    // Resource: https://www.youtube.com/watch?v=oYLSnqjN_Zs
    class LargestDivisibleSubsetDPBottomUpWithPathReconstruction implements LargestDivisibleSubset {

        // O(N^2) time | O(N) space
        @Override
        public List<Integer> largestDivisibleSubset(int[] nums) {
            // The problem is similar to "Finding the longest path in a DAG", which can be solved with DP
            int n = nums.length;

            Arrays.sort(nums);

            // dp[i] = k denotes that nums[i] is divisible by previous k numbers that are < nums[i]
            // note that nums[] is sorted in asc order
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            // supporting prev[] array is used for path reconstruction
            // prev[i] = j denotes transition from index j to i, i.e.
            // ... -> j -> i
            int[] prev = new int[n];
            Arrays.fill(prev, -1);

            // the index of the last element in the largest divisible subset
            int lastNumIndex = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[j] + 1 > dp[i]) {
                            // append nums[i] to a subset ending with nums[j]
                            dp[i] = dp[j] + 1;
                            prev[i] = j;

                            if (dp[i] > dp[lastNumIndex]) {
                                lastNumIndex = i;
                            }
                        }
                    }
                }
            }

            // reconstruct the path
            int i = lastNumIndex;
            Deque<Integer> subset = new ArrayDeque<>();
            while (i != -1) {
                subset.offerFirst(nums[i]);
                i = prev[i];
            }
            return new ArrayList<>(subset);
        }
    }
}
