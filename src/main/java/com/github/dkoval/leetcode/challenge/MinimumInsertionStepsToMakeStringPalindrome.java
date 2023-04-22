package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">Minimum Insertion Steps to Make a String Palindrome (Hard)</a>
 * <p>
 * Given a string s. In one step you can insert any character at any index of the string.
 * <p>
 * Return the minimum number of steps to make s palindrome.
 * <p>
 * A Palindrome String is one that reads the same backward as well as forward.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 500</li>
 *  <li>s consists of lowercase English letters.</li>
 * </ul>
 */
public interface MinimumInsertionStepsToMakeStringPalindrome {

    int minInsertions(String s);

    // O(N^2) time | O(N^2) space
    class MinimumInsertionStepsToMakeStringPalindromeDPTopDown implements MinimumInsertionStepsToMakeStringPalindrome {

        @Override
        public int minInsertions(String s) {
            int n = s.length();

            // DP: top-down
            // dp[i][j] - the min number of insertions needed to make s[i : j] a palindrome
            Integer[][] dp = new Integer[n][n];
            return calculate(s, 0, n - 1, dp);
        }

        private int calculate(String s, int left, int right, Integer[][] dp) {
            if (left > right) {
                return 0;
            }

            // already solved?
            if (dp[left][right] != null) {
                return dp[left][right];
            }

            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            int best = Integer.MAX_VALUE;
            if (c1 == c2) {
                best = Math.min(best, calculate(s, left + 1, right - 1, dp));
            } else {
                // option #1: insert c2 before c1
                best = Math.min(best, 1 + calculate(s, left, right - 1, dp));
                // option #2: insert c1 after c2
                best = Math.min(best, 1 + calculate(s, left + 1, right, dp));
            }
            // cache and return the answer
            return dp[left][right] = best;
        }
    }
}
