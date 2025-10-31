package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/">The Two Sneaky Numbers of Digitville</a>
 * <p>
 * In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1.
 * Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time,
 * making the list longer than usual.
 * <p>
 * As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order),
 * so peace can return to Digitville.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 100</li>
 *  <li>nums.length == n + 2</li>
 *  <li>0 <= nums[i] < n</li>
 *  <li>The input is generated such that nums contains exactly two repeated elements.</li>
 * </ul>
 */
public interface TwoSneakyNumbersOfDigitville {

    int[] getSneakyNumbers(int[] nums);

    class TwoSneakyNumbersOfDigitvilleRev1 implements TwoSneakyNumbersOfDigitville {

        @Override
        public int[] getSneakyNumbers(int[] nums) {
            final var n = nums.length;

            final var ans = new int[]{-1, -1};
            var index = 0;

            final var counts = new int[n - 2];
            for (var x : nums) {
                counts[x]++;
                if (counts[x] == 2) {
                    ans[index++] = x;
                }
                if (index == 2) {
                    break;
                }
            }
            return ans;
        }
    }
}
