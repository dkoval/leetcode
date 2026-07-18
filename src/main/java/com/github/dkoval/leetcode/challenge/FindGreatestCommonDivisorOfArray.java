package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-greatest-common-divisor-of-array/">Find Greatest Common Divisor of Array</a>
 * <p>
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * <p>
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface FindGreatestCommonDivisorOfArray {

    int findGCD(int[] nums);

    class FindGreatestCommonDivisorOfArrayRev1 implements FindGreatestCommonDivisorOfArray {

        @Override
        public int findGCD(int[] nums) {
            var min = Integer.MAX_VALUE;
            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            return gcd(max, min);
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
}
