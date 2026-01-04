package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/four-divisors/">Four Divisors</a>
 * <p>
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 * If there is no such integer in the array, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^4</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface FourDivisors {

    int sumFourDivisors(int[] nums);

    class FourDivisorsRev1 implements FourDivisors {

        @Override
        public int sumFourDivisors(int[] nums) {
            var total = 0;
            for (var x : nums) {
                total += sumOf4DivisorsIfExist(x);
            }
            return total;
        }

        private int sumOf4DivisorsIfExist(int x) {
            var sum = 0;
            var count = 0;
            for (var d1 = 1; d1 * d1 <= x && count <= 4; d1++) {
                if (x % d1 != 0) {
                    continue;
                }

                // 2nd divisor: d1 * d2 = x
                final var d2 = x / d1;
                sum += d1;
                count++;

                // corner case: d1 * d1 = x
                if (d1 != d2) {
                    sum += d2;
                    count++;
                }
            }
            return (count == 4) ? sum : 0;
        }
    }
}
