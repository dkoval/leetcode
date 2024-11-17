package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k">Shortest Subarray with Sum at Least K (Hard)</a>
 * <p>
 * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k.
 * If there is no such subarray, return -1.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-105 <= nums[i] <= 10^5</li>
 *  <li>1 <= k <= 10^9</li>
 * </ul>
 */
public interface ShortestSubarrayWithSumAtLeastK {

    int shortestSubarray(int[] nums, int k);

    // Resource: https://youtu.be/5AY70aAHZiQ?si=YW0ZSC4OIjZ70WgK
    class ShortestSubarrayWithSumAtLeastKRev1 implements ShortestSubarrayWithSumAtLeastK {

        @Override
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;

            // keeps prefix sums in the monotonically increasing order
            Deque<Prefix> dq = new ArrayDeque<>();

            long sum = 0;
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                sum += nums[i];

                if (sum >= k) {
                    best = Math.min(best, i + 1);
                }

                // find the minimum valid subarray ending at index i by
                // removing a prefix that minimizes the length of the subarray
                while (!dq.isEmpty() && sum - dq.peekFirst().sum >= k) {
                    best = Math.min(best, i - dq.pollFirst().endIndex);
                }

                // before adding the current prefix sum can be added to the deque, make sure
                // the recorded prefix sums remain in the monotonically increasing order.
                while (!dq.isEmpty() && dq.peekLast().sum >= sum) {
                    dq.pollLast();
                }

                // at this stage, the current prefix sum can be added to the deque
                dq.offer(new Prefix(sum, i));
            }
            return (best < Integer.MAX_VALUE) ? best : -1;
        }

        private record Prefix(long sum, int endIndex) {
        }
    }
}
