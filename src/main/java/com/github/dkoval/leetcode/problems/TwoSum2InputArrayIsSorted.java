package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Array Is Sorted</a>
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= numbers.length <= 3 * 10^4</li>
 *  <li>-1000 <= numbers[i] <= 1000</li>
 *  <li>numbers is sorted in non-decreasing order</li>
 *  <li>-1000 <= target <= 1000</li>
 *  <li>The tests are generated such that there is exactly one solution</li>
 * </ul>
 */
public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[0];
    }
}
