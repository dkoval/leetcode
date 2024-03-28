package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/">Length of Longest Subarray With at Most K Frequency</a>
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * The frequency of an element x is the number of times it occurs in an array.
 * <p>
 * An array is called good if the frequency of each element in this array is less than or equal to k.
 * <p>
 * Return the length of the longest good subarray of nums.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>1 <= k <= nums.length</li>
 * </ul>
 */
public interface LengthOfLongestSubarrayWithAtMostKFrequency {

    int maxSubarrayLength(int[] nums, int k);

    // O(N) time | O(N) space
    class LengthOfLongestSubarrayWithAtMostKFrequencyRev1 implements LengthOfLongestSubarrayWithAtMostKFrequency {

        @Override
        public int maxSubarrayLength(int[] nums, int k) {
            int n = nums.length;

            // idea: sliding window
            int best = 0;
            int left = 0;
            Map<Integer, Integer> freq = new HashMap<>();
            // try to expand the window as far to the right as possible
            for (int right = 0; right < n; right++) {
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
                // shrink the window from the left to ensure
                // nums[right] appears k times in nums[left : right].
                while (freq.get(nums[right]) > k) {
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    left++;
                }
                best = Math.max(best, right - left + 1);
            }
            return best;
        }
    }
}
