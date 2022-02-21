package com.github.dkoval.leetcode.challenge;

/**
 * <a href="">Missing Number</a>
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
 * that is missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public interface MissingNumber {

    int missingNumber(int[] nums);

    class MissingNumberByCalculatingSums implements MissingNumber {

        // O(N) time | O(1) space
        @Override
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

    class MissingNumberUsingXOR implements MissingNumber {

        // O(N) time | O(1) space
        @Override
        public int missingNumber(int[] nums) {
            // Property of XOR: a ^ a = 0
            int n = nums.length;
            int ans = n;
            for (int i = 0; i < n; i++) {
                ans ^= i;
                ans ^= nums[i];
            }
            return ans;
        }
    }
}
