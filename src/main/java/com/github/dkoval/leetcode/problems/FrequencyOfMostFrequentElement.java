package com.github.dkoval.leetcode.problems;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">Frequency of the Most Frequent Element</a>
 * <p>
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 *  <li>1 <= k <= 10^5</li>
 * </ul>
 */
public interface FrequencyOfMostFrequentElement {

    int maxFrequency(int[] nums, int k);

    // O(N*logN) time | O(1) space
    class FrequencyOfMostFrequentElementRev1 implements FrequencyOfMostFrequentElement {

        @Override
        public int maxFrequency(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);

            // Idea: greedy + sliding window
            int left = 0;
            int right = 0;
            long sum = 0;
            int best = 0;
            while (right < n) {
                // Greedy: try to make all elements in the sliding window equal to nums[right] (the largest element in the window)
                // Invariant to preserve: nums[right] * windowSize <= sum + k
                sum += nums[right];
                while ((long) nums[right] * (right - left + 1) > sum + k) {
                    // shrink the window
                    sum -= nums[left];
                    left++;
                }
                best = Math.max(best, right - left + 1);
                right++;
            }
            return best;
        }
    }

    // O(N*logN) time | O(1) space
    class FrequencyOfMostFrequentElementRev2 implements FrequencyOfMostFrequentElement {

        @Override
        public int maxFrequency(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);

            // sliding window
            int left = 0;
            int right = 1;
            int cost = 0;
            int best = 1;
            while (right < n) {
                // turn numbers to the left of nums[right] into nums[right]
                int diff = nums[right] - nums[right - 1];
                cost += (right - left) * diff;

                // if cost is too big, shrink the window
                while (cost > k && left <= right) {
                    cost -= nums[right] - nums[left];
                    left++;
                }

                best = Math.max(best, right - left + 1);
                right++;
            }
            return best;
        }
    }
}
