package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/">Find the Smallest Divisor Given a Threshold</a>
 * <p>
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it,
 * and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * <p>
 * Each result of the division is rounded to the nearest integer greater than or equal to that element.
 * (For example: 7/3 = 3 and 10/2 = 5).
 * <p>
 * The test cases are generated so that there will be an answer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 5 * 10^4</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 *  <li>nums.length <= threshold <= 10^6</li>
 * </ul>
 */
public interface FindSmallestDivisorGivenThreshold {

    int smallestDivisor(int[] nums, int threshold);

    // O(logN) time | O(1) space
    class FindSmallestDivisorGivenThresholdUsingBinarySearch implements FindSmallestDivisorGivenThreshold {

        @Override
        public int smallestDivisor(int[] nums, int threshold) {
            int left = 1;
            int right = 1_000_000;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isGood(nums, mid, threshold)) {
                    // mid might be the answer;
                    // check if there is a better option to the left of mid
                    right = mid;
                } else {
                    // mid is not the answer (i.e. selected divisor is too low) + everything to the left of it
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean isGood(int[] nums, int divisor, int threshold) {
            int sum = 0;
            for (int x : nums) {
                sum += (x - 1) / divisor + 1; // round up
            }
            return sum <= threshold;
        }
    }
}
