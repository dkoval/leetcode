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
            int n = s.length();
            // ones[i] - the number of 1's in s[0 : i]
            int[] ones = new int[n];
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (i > 0) {
                    ones[i] = ones[i - 1];
                }
                if (c == '1') {
                    ones[i]++;
                }
            }

            int best = 0;
            int zeros = 0;
            for (int i = 0; i < n - 1; i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    zeros++;
                }
                best = Math.max(best, zeros + ones[n - 1] - ones[i]);
            }
            return best;
        }
    }
}
