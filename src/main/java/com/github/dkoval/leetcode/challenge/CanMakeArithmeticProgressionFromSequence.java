package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/">Can Make Arithmetic Progression From Sequence</a>
 * <p>
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * <p>
 * Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= arr.length <= 1000</li>
 *  <li>-10^6 <= arr[i] <= 10^6</li>
 * </ul>
 */
public interface CanMakeArithmeticProgressionFromSequence {

    boolean canMakeArithmeticProgression(int[] arr);

    // O(N * logN) time | O(1) space
    class CanMakeArithmeticProgressionFromSequenceRev1 implements CanMakeArithmeticProgressionFromSequence {

        @Override
        public boolean canMakeArithmeticProgression(int[] arr) {
            int n = arr.length;

            // if an arithmetic can be formed, the numbers must be ordered (either ASC or DESC)
            Arrays.sort(arr);
            int delta = arr[1] - arr[0];
            for (int i = 2; i < n; i++) {
                if (arr[i] - arr[i - 1] != delta) {
                    return false;
                }
            }
            return true;
        }
    }
}
