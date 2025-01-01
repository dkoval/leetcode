package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/">Maximum Score After Splitting a String</a>
 * <p>
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings
 * (i.e. left substring and right substring).
 * <p>
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= s.length <= 500</li>
 *  <li>The string s consists of characters '0' and '1' only</li>
 * </ul>
 */
public interface MaximumScoreAfterSplittingString {

    int maxScore(String s);

    // O(N) time | O(N) space
    class MaximumScoreAfterSplittingStringRev1 implements MaximumScoreAfterSplittingString {

        @Override
        public int maxScore(String s) {
            final var n = s.length();

            // ones[i] - the number of 1's in s[0 : i]
            final var ones = new int[n];
            for (var i = 0; i < n; i++) {
                final var c = s.charAt(i);
                if (i > 0) {
                    ones[i] = ones[i - 1];
                }
                if (c == '1') {
                    ones[i]++;
                }
            }

            var best = 0;
            var zeros = 0;
            for (var i = 0; i < n - 1; i++) {
                if (s.charAt(i) == '0') {
                    zeros++;
                }
                best = Math.max(best, zeros + ones[n - 1] - ones[i]);
            }
            return best;
        }
    }

    // O(N) time | O(N) space
    class MaximumScoreAfterSplittingStringRev2 implements MaximumScoreAfterSplittingString {

        @Override
        public int maxScore(String s) {
            final var n = s.length();

            final var counts = new int[2][n];
            for (var left = 0; left < n; left++) {
                final var right = n - left - 1;

                counts[0][left] = (left - 1 >= 0) ? counts[0][left - 1] : 0;
                if (s.charAt(left) == '0') {
                    counts[0][left]++;
                }

                counts[1][right] = (right + 1 < n) ? counts[1][right + 1] : 0;
                if (s.charAt(right) == '1') {
                    counts[1][right]++;
                }
            }

            var best = 0;
            for (var i = 0; i < n - 1; i++) {
                best = Math.max(best, counts[0][i] + counts[1][i + 1]);
            }
            return best;
        }
    }

    // O(N) time | O(1) space
    class MaximumScoreAfterSplittingStringRev3 implements MaximumScoreAfterSplittingString {

        @Override
        public int maxScore(String s) {
            final var n = s.length();

            var rightOnes = 0;
            for (var i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    rightOnes++;
                }
            }

            var best = 0;
            var leftZeros = 0;
            for (var i = 0; i < n - 1; i++) {
                if (s.charAt(i) == '0') {
                    leftZeros++;
                } else {
                    rightOnes--;
                }
                best = Math.max(best, leftZeros + rightOnes);
            }
            return best;
        }
    }
}
