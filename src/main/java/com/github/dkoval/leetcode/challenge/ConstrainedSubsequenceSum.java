package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/constrained-subsequence-sum/">Constrained Subsequence Sum (Hard)</a>
 * <p>
 * Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that
 * for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
 * <p>
 * A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array,
 * leaving the remaining elements in their original order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= nums.length <= 10^5</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 * </ul>
 */
public interface ConstrainedSubsequenceSum {

    int constrainedSubsetSum(int[] nums, int k);

    // TLE
    class ConstrainedSubsequenceSumRev1 implements ConstrainedSubsequenceSum {

        @Override
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;

            int[] dp = new int[n];
            int best = Integer.MIN_VALUE;

             for (int i = 0; i < n; i++) {
                 dp[i] = nums[i];
                 // check if we can get a better subsequence by appending nums[i] to one of the k previous states
                 for (int start = Math.max(i - k, 0); start < i; start++) {
                     dp[i] = Math.max(dp[i], dp[start] + nums[i]);
                 }
                 best = Math.max(best, dp[i]);
             }
             return best;
        }
    }

    // O(N * logK) time | O(K) space
    class ConstrainedSubsequenceSumRev2 implements ConstrainedSubsequenceSum {

        @Override
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;

            int best = nums[0];

            // max heap models the window of <= k previous dp[] elements, where max is obtained in O(1) time
            Queue<IndexedValue> window = new PriorityQueue<>(Comparator.<IndexedValue>comparingInt(it -> it.value).reversed());
            window.offer(new IndexedValue(0, nums[0]));
            for (int i = 1; i < n; i++) {
                // fix the window size
                // since k >= 1, the window is guaranteed to be non-empty
                while (i - window.peek().index > k) {
                    window.poll();
                }

                // note that window.peek().value can be negative
                int curr = Math.max(nums[i], nums[i] + window.peek().value);
                best = Math.max(best, curr);

                window.offer(new IndexedValue(i, curr));
            }
            return best;
        }

        private static class IndexedValue {
            final int index;
            final int value;

            IndexedValue(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
    }

    // O(N) time | O(N) space
    class ConstrainedSubsequenceSumRev3 implements ConstrainedSubsequenceSum {

        @Override
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;

            // dp[i] - the "best" sequence we can have ending at index i
            int[] dp = new int[n];
            int best = Integer.MIN_VALUE;

            // window of size <= k, storing indices of dp[] such that corresponding dp[i] values appear in DESC order
            Deque<Integer> window = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                // fix the window from the left
                while (!window.isEmpty() && i - window.peekFirst() > k) {
                    window.pollFirst();
                }

                // 1st element of the window is the largest one
                dp[i] = nums[i] + (!window.isEmpty() && dp[window.peekFirst()] > 0 ? dp[window.peekFirst()] : 0);
                best = Math.max(best, dp[i]);

                // shrink the window from the right - remove elements of dp[] <= dp[i]
                while (!window.isEmpty() && dp[window.peekLast()] <= dp[i]) {
                    window.pollLast();
                }
                window.offerLast(i);
            }
            return best;
        }
    }
}
