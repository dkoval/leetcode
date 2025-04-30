package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-numbers-with-even-number-of-digits/">Find Numbers with Even Number of Digits</a>
 * <p>
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 500</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface FindNumbersWithEvenNumberOfDigits {

    int findNumbers(int[] nums);

    class FindNumbersWithEvenNumberOfDigitsRev1 implements FindNumbersWithEvenNumberOfDigits {

        @Override
        public int findNumbers(int[] nums) {
            var count = 0;
            for (var x : nums) {
                if (countDigits(x) % 2 == 0) {
                    count++;
                }
            }
            return count;
        }

        private int countDigits(int x) {
            // 1 <= nums[i] <= 10^5
            var count = 0;
            while (x != 0) {
                x /= 10;
                count++;
            }
            return count;
        }
    }
}
