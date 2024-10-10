package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-width-ramp/">Maximum Width Ramp</a>
 * <p>
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j].
 * The width of such a ramp is j - i.
 * <p>
 * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 5 * 10^4</li>
 *  <li>0 <= nums[i] <= 5 * 10^4</li>
 * </ul>
 */
public interface MaximumWidthRamp {

    int maxWidthRamp(int[] nums);

    // O(N * logN) time | O(N) space
    class MaximumWidthRampRev1 implements MaximumWidthRamp {

        @Override
        public int maxWidthRamp(int[] nums) {
            int n = nums.length;

            IndexedValue[] items = new IndexedValue[n];
            for (int i = 0; i < n; i++) {
                items[i] = new IndexedValue(i, nums[i]);
            }

            // sort indices of nums[] based on values of nums
            Arrays.sort(items, Comparator.comparingInt(it -> it.value));

            // nums   =  [6, 0, 8, 2, 1, 5]
            // values =  [0, 1, 2, 5, 6, 8]
            // indices = [1, 4, 3, 5, 0, 2]

            int best = 0;
            int left = n; // the smallest index in nums[] seen so far
            for (IndexedValue item : items) {
                int right = item.index;
                if (left < right) {
                    best = Math.max(best, right - left);
                }
                left = Math.min(left, right);
            }
            return best;
        }

        private record IndexedValue(int index, int value) {
        }
    }

    // O(N) time | O(N) space
    class MaximumWidthRampRev2 implements MaximumWidthRamp {

        @Override
        public int maxWidthRamp(int[] nums) {
            int n = nums.length;

            // maxRight[i] denotes the largest number to the right of nums[i]
            int[] maxRight = new int[n];
            maxRight[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
            }

            int best = 0;
            int left = 0;
            for (int right = 1; right < n; right++) {
                // shrink the range to maintain invariant
                // nums[left] <= nums[right]
                while (nums[left] > maxRight[right]) {
                    left++;
                }
                best = Math.max(best, right - left);
            }
            return best;
        }
    }
}
