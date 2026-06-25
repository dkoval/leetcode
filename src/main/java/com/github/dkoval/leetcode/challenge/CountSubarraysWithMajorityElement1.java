package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-subarrays-with-majority-element-i/">Count Subarrays With Majority Element I</a>
 * <p>
 * You are given an integer array nums and an integer target.
 * <p>
 * Return the number of subarrays of nums in which target is the majority element.
 * <p>
 * The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>1 <= target <= 10^9</li>
 * </ul>
 */
public interface CountSubarraysWithMajorityElement1 {

    int countMajoritySubarrays(int[] nums, int target);

    class CountSubarraysWithMajorityElement1Rev1 implements CountSubarraysWithMajorityElement1 {

        @Override
        public int countMajoritySubarrays(int[] nums, int target) {
            final var n = nums.length;

            final var prefix = new int[n];
            for (var i = 0; i < n; i++) {
                prefix[i] = (nums[i] == target) ? 1 : 0;
                if (i > 0) {
                    prefix[i] += prefix[i - 1];
                }
            }

            // brute force
            var count = 0;
            for (var i = 0; i < n; i++) {
                for (var j = i; j < n; j++) {
                    count += subarrayWithMajorityElement(prefix, i, j) ? 1 : 0;
                }
            }
            return count;
        }

        private boolean subarrayWithMajorityElement(int[] prefix, int start, int end) {
            final var count = prefix[end] - (start > 0 ? prefix[start - 1] : 0);
            return 2 * count > (end - start + 1);
        }
    }
}
