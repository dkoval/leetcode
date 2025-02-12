package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/">Max Sum of a Pair With Equal Sum of Digits</a>
 * <p>
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j,
 * such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 * <p>
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface MaxSumOfPairWithEqualSumOfDigits {

    int maximumSum(int[] nums);

    class MaxSumOfPairWithEqualSumOfDigitsRev1 implements MaxSumOfPairWithEqualSumOfDigits {

        @Override
        public int maximumSum(int[] nums) {
            // sumOfDigits(x) -> largest x
            final var lookup = new HashMap<Integer, Integer>();
            var best = -1;
            for (var x : nums) {
                final var key = sumOfDigits(x);
                if (!lookup.containsKey(key)) {
                    lookup.put(key, x);
                    continue;
                }

                final var y = lookup.get(key);
                best = Math.max(best, x + y);
                lookup.put(key, Math.max(x, y));
            }
            return best;
        }

        private int sumOfDigits(int x) {
            var sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }
    }
}
