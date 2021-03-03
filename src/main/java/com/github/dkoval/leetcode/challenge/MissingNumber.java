package com.github.dkoval.leetcode.challenge;

/**
 * <a href="">Missing Number</a>
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
 * that is missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class MissingNumber {

    // O(N) time | O(1) space
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // 0 + 1 + 2 + ... + n = n * (n + 1) / 2
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}
