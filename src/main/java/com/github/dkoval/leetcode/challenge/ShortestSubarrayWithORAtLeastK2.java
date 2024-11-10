package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/">Shortest Subarray With OR at Least K II</a>
 * <p>
 * You are given an array nums of non-negative integers and an integer k.
 * <p>
 * An array is called special if the bitwise OR of all of its elements is at least k.
 * <p>
 * Return the length of the shortest special non-empty
 * subarray
 * of nums, or return -1 if no special subarray exists.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 2 * 10^5</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 *  <li>0 <= k <= 10^9</li>
 * </ul>
 */
public interface ShortestSubarrayWithORAtLeastK2 {

    int minimumSubarrayLength(int[] nums, int k);

    class ShortestSubarrayWithORAtLeastK2Rev1 implements ShortestSubarrayWithORAtLeastK2 {

        @Override
        public int minimumSubarrayLength(int[] nums, int k) {
            int n = nums.length;

            // sliding window
            BitwiseOR window = new BitwiseOR();
            int best = Integer.MAX_VALUE;

            int left = 0;
            for (int right = 0; right < n; right++) {
                window.add(nums[right]);
                // keep on shrinking the valid window to make it as small as possible
                while (left <= right && window.result >= k) {
                    best = Math.min(best, right - left + 1);
                    window.rem(nums[left]);
                    left++;
                }
            }
            return (best < Integer.MAX_VALUE) ? best : -1;
        }

        private static class BitwiseOR {
            // counts[i] - the number of 1's in the i-th bit position
            final int[] counts = new int[32];
            int result = 0;

            void add(int x) {
                result |= x;
                for (int i = 0; i < 32; i++) {
                    if (((x >> i) & 1) == 1) {
                        counts[i]++;
                    }
                }
            }

            // NB. The method assumes add(x) was called before.
            void rem(int x) {
                for (int i = 0; i < 32; i++) {
                    if (((x >> i) & 1) == 1) {
                        if (--counts[i] == 0) {
                            // unset i-th bit in the result
                            result ^= 1 << i;
                        }
                    }
                }
            }
        }
    }
}
