package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/keep-multiplying-found-values-by-two/">Keep Multiplying Found Values by Two</a>
 * <p>
 * You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.
 * <p>
 * You then do the following steps:
 * <p>
 * If original is found in nums, multiply it by two (i.e., set original = 2 * original).
 * <p>
 * Otherwise, stop the process.
 * <p>
 * Repeat this process with the new number as long as you keep finding the number.
 * <p>
 * Return the final value of original.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i], original <= 1000</li>
 * </ul>
 */
public interface KeepMultiplyingFoundValuesByTwo {

    int findFinalValue(int[] nums, int original);

    class KeepMultiplyingFoundValuesByTwoRev1 implements KeepMultiplyingFoundValuesByTwo {

        @Override
        public int findFinalValue(int[] nums, int original) {
            final var seen = new HashSet<Integer>();
            for (var x : nums) {
                seen.add(x);
            }

            var ans = original;
            while (seen.contains(ans)) {
                ans *= 2;
            }
            return ans;
        }
    }
}
