package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/">Matchsticks to Square</a>
 * <p>
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick.
 * You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up,
 * and each matchstick must be used exactly one time.
 * <p>
 * Return true if you can make this square and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= matchsticks.length <= 15</li>
 *  <li>0 <= matchsticks[i] <= 10^9</li>
 * </ul>
 */
public interface MatchsticksToSquare {

    boolean makesquare(int[] matchsticks);

    class MatchsticksToSquareRecursiveWithBacktracking implements MatchsticksToSquare {

        @Override
        public boolean makesquare(int[] matchsticks) {
            int p = sum(matchsticks);
            // perimeter of a square is a multiple of 4
            if (p % 4 != 0) {
                return false;
            }

            // optimization for early termination: sort matchsticks[] in reverse order
            Arrays.sort(matchsticks);
            reverse(matchsticks);

            return makeSquare(matchsticks, 0, new int[4], p / 4);
        }

        private boolean makeSquare(int[] matchsticks, int idx, int[] sides, int a) {
            // reject invalid configurations asap
            for (int side : sides) {
                if (side > a) {
                    return false;
                }
            }

            if (idx == matchsticks.length) {
                return true;
            }

            // try out all options for matchsticks[idx]
            for (int i = 0; i < 4; i++) {
                sides[i] += matchsticks[idx];
                if (makeSquare(matchsticks, idx + 1, sides, a)) {
                    return true;
                }
                // backtrack
                sides[i] -= matchsticks[idx];
            }
            return false;
        }

        private int sum(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result += num;
            }
            return result;
        }

        private void reverse(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = tmp;
            }
        }
    }
}
