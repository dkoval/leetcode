package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/check-if-array-is-good/">Check if Array is Good</a>
 * <p>
 * You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
 * <p>
 * base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once,
 * plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
 * <p>
 * Return true if the given array is good, otherwise return false.
 * <p>
 * Note: A permutation of integers represents an arrangement of these numbers.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= num[i] <= 200</li>
 * </ul>
 */
public interface CheckIfArrayIsGood {

    boolean isGood(int[] nums);

    class CheckIfArrayIsGoodRev1 implements CheckIfArrayIsGood {

        @Override
        public boolean isGood(int[] nums) {
            final var n = nums.length;

            if (n < 2) {
                return false;
            }

            Arrays.sort(nums);
            for (var i = 0; i < n - 2; i++) {
                if (nums[i + 1] != nums[i] + 1) {
                    return false;
                }
            }
            return (nums[n - 1] == nums[n - 2]) && (nums[n - 1] == n - 1);
        }
    }

    class CheckIfArrayIsGoodRev2 implements CheckIfArrayIsGood {

        @Override
        public boolean isGood(int[] nums) {
            final var n = nums.length;

            Arrays.sort(nums);

            var expected = 1;
            for (var i = 0; i < n; i++) {
                if (nums[i] != expected) {
                    return false;
                }

                if (i < n - 2) {
                    expected++;
                }
            }
            return nums[n - 1] == n - 1;
        }
    }
}
