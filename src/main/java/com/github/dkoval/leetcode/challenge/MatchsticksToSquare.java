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

            return canMakeSquare(matchsticks, 0, new int[4], p / 4);
        }

        private boolean canMakeSquare(int[] matchsticks, int idx, int[] sides, int a) {
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
                if (canMakeSquare(matchsticks, idx + 1, sides, a)) {
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

    // O(N*2^N) time | O(2^N) space
    class MatchsticksToSquareUsingBitmaskWithMemoization implements MatchsticksToSquare {

        @Override
        public boolean makesquare(int[] matchsticks) {
            int p = sum(matchsticks);
            // perimeter of a square is a multiple of 4
            if (p % 4 != 0) {
                return false;
            }

            Boolean[][] memo = new Boolean[4][1 << matchsticks.length];
            return canMakeSquare(0, matchsticks, 0, p / 4, memo);
        }

        private boolean canMakeSquare(int numSidesFormed, int[] matchsticks, int usedMatchsticksMask, int a, Boolean[][] memo) {
            if (numSidesFormed == 4) {
                return true;
            }

            if (memo[numSidesFormed][usedMatchsticksMask] != null) {
                return memo[numSidesFormed][usedMatchsticksMask];
            }

            int sumOfUsedMatchsticks = 0;
            for (int i = 0; i < matchsticks.length; i++) {
                // collect used matchsticks by checking if i-th bit of the mask is set
                if (((usedMatchsticksMask >> i) & 1) == 1) {
                    sumOfUsedMatchsticks += matchsticks[i];
                }
            }

            int currSideLength = sumOfUsedMatchsticks % a;

            // try out all options for unused matchsticks
            for (int i = 0; i < matchsticks.length; i++) {
                // ignore used matchsticks
                if ((usedMatchsticksMask >> i & 1) == 1) {
                    continue;
                }

                int newCurrSideLength = currSideLength + matchsticks[i];
                if (newCurrSideLength > a) {
                    // matchsticks[i] is too long to form the current side of length a
                    continue;
                }

                // add matchsticks[i] to the current side by setting i-th bit of the mask
                boolean canMake = canMakeSquare(
                        (newCurrSideLength == a) ? numSidesFormed + 1 : numSidesFormed,
                        matchsticks,
                        usedMatchsticksMask | (1 << i),
                        a,
                        memo);

                memo[numSidesFormed][usedMatchsticksMask] = canMake;
                if (canMake) {
                    return true;
                }
            }

            memo[numSidesFormed][usedMatchsticksMask] = false;
            return false;
        }

        private int sum(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result += num;
            }
            return result;
        }
    }
}
