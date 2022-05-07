package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/132-pattern/">132 Pattern</a>
 * <p>
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
 * such that i < j < k and nums[i] < nums[k] < nums[j].
 * <p>
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * <p>
 * Follow up: The O(N^2) is trivial, could you come up with the O(NlogN) or the O(N) solution?
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 2 * 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface Pattern132 {

    boolean find132pattern(int[] nums);

    // Time complexity: O(N^3)
    // Space complexity: O(1)
    class Pattern132BruteForceInCubicTime implements Pattern132 {

        @Override
        public boolean find132pattern(int[] nums) {
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j]) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // Time complexity: O(N^2)
    // Space complexity: O(1)
    class Pattern132BruteForceInQuadraticTime implements Pattern132 {

        @Override
        public boolean find132pattern(int[] nums) {
            int minI = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length - 1; j++) {
                minI = Math.min(minI, nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if (minI < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // O(N) time | O(N) space
    class Pattern132UsingMonoDecreasingStack implements Pattern132 {

        private static class NumberAndMinBefore {
            // nums[j] candidate
            final int x;
            // nums[i] candidate
            final int minBefore;

            NumberAndMinBefore(int x, int minBefore) {
                this.x = x;
                this.minBefore = minBefore;
            }
        }

        // Resource: https://leetcode.com/problems/132-pattern/
        @Override
        public boolean find132pattern(int[] nums) {
            // Idea: minimize nums[i] while maximizing nums[j] to get more flexibility for choosing nums[k]
            int n = nums.length;
            if (n < 3) {
                return false;
            }

            // nums[i] candidate
            int minBefore = nums[0];
            // monotonically decreasing stack stores nums[j] candidates
            Deque<NumberAndMinBefore> stack = new ArrayDeque<>();
            for (int k = 1; k < n; k++) {
                // we want nums[k] < nums[j], therefore pop all invalid nums[j] off the stack
                while (!stack.isEmpty() && nums[k] >= stack.peek().x) {
                    stack.pop();
                }

                // check if nums[i] < nums[k] < nums[j] inequality holds
                if (!stack.isEmpty() /*&& nums[k] < stack.peek().x*/ && nums[k] > stack.peek().minBefore) {
                    return true;
                }

                // store nums[j] candidate
                stack.push(new NumberAndMinBefore(nums[k], minBefore));

                // check if we have a better nums[i]
                minBefore = Math.min(minBefore, nums[k]);
            }
            return false;
        }
    }
}
