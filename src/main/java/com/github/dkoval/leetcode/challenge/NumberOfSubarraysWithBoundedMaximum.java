package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3782/">Number of Subarrays with Bounded Maximum</a>
 * <p>
 * We are given an array nums of positive integers, and two positive integers left and right (left <= right).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray
 * is at least left and at most right.
 * <p>
 * Constraints:
 * <ul>
 *  <li>left, right, and nums[i] will be an integer in the range [0, 10^9].</li>
 *  <li>The length of nums will be in the range of [1, 50000].</li>
 * </ul>
 */
public class NumberOfSubarraysWithBoundedMaximum {

    // O(N) time | O(1) space
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int count = 0;

        // Each number xi > right divides nums[] into groups, which will be processed individually
        // ..., x1, ..., x2, ..., xn, ...
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                count += countBoundedSubarrays(nums, start, i - 1, left);
                start = i + 1;
            }
        }

        if (start < n) {
            count += countBoundedSubarrays(nums, start, n - 1, left);
        }
        return count;
    }

    private int countBoundedSubarrays(int[] nums, int start, int end, int min) {
        if (start > end) {
            return 0;
        }

        int count = numSubarrays(end - start + 1);

        // Now, find subarrays with elements < min. All subarrays that can be formed from such a found one
        // must be excluded from the total count.
        int i = start;
        while (i <= end) {
            if (nums[i] < min) {
                // try to expand a subarray further out
                int j = i + 1;
                while (j <= end && nums[j] < min) {
                    j++;
                }
                count -= numSubarrays(j - i);
                i = j;
            } else {
                i++;
            }
        }
        return count;
    }

    private int numSubarrays(int n) {
        // N arrays of length 1
        // + (N - 1) arrays of length 2
        // + ...
        // + 1 array if length N
        // = N * (N + 1) / 2 in total
        return n * (n + 1) / 2;
    }
}
