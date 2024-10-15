package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/separate-black-and-white-balls/">Separate Black and White Balls</a>
 * <p>
 * There are n balls on a table, each ball has a color black or white.
 * <p>
 * You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.
 * <p>
 * In each step, you can choose two adjacent balls and swap them.
 * <p>
 * Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == s.length <= 10^5</li>
 *  <li>s[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface SeparateBlackAndWhiteBalls {

    long minimumSteps(String s);

    // O(N) time | O(1) space
    class SeparateBlackAndWhiteBallsRev1 implements SeparateBlackAndWhiteBalls {

        @Override
        public long minimumSteps(String s) {
            int n = s.length();

            int blackStartIndex = 0;
            while (blackStartIndex < n && s.charAt(blackStartIndex) == '0') {
                blackStartIndex++;
            }

            long count = 0;
            for (int i = blackStartIndex + 1; i < n; i++) {
                if (s.charAt(i) == '0') {
                    count += i - blackStartIndex;
                    blackStartIndex++;
                }
            }
            return count;
        }
    }
}
