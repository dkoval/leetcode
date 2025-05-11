package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/three-consecutive-odds/">Three Consecutive Odds</a>
 * <p>
 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 1000</li>
 *  <li>1 <= arr[i] <= 1000</li>
 * </ul>
 */
public interface ThreeConsecutiveOdds {

    boolean threeConsecutiveOdds(int[] arr);

    class ThreeConsecutiveOddsRev1 implements ThreeConsecutiveOdds {

        @Override
        public boolean threeConsecutiveOdds(int[] arr) {
            final var n = arr.length;

            for (var i = 0; i <= n - 3; i++) {
                if (allOdds(arr, i, 3)) {
                    return true;
                }
            }
            return false;
        }

        private boolean allOdds(int[] arr, int start, int count) {
            var numOdds = 0;
            for (var i = start; i < start + count; i++) {
                if (arr[i] % 2 != 0) {
                    numOdds++;
                }
            }
            return numOdds == count;
        }
    }
}
