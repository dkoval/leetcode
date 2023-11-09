package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-number-of-homogenous-substrings/">Count Number of Homogenous Substrings</a>
 * <p>
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * A string is homogenous if all the characters of the string are the same.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase letters.</li>
 * </ul>
 */
public interface CountNumberOfHomogenousSubstrings {

    int MOD = 1_000_000_007;

    int countHomogenous(String s);

    // O(N) time | O(1) space
    class CountNumberOfHomogenousSubstringsRev1 implements CountNumberOfHomogenousSubstrings {

        @Override
        public int countHomogenous(String s) {
            // idea: sliding window
            int n = s.length();

            int count = 0;
            int start = 0;
            for (int end = 0; end < n; end++) {
                if (s.charAt(end) != s.charAt(start)) {
                    // reset the current window
                    start = end;
                }
                // keep on expanding the current window
                count += end - start + 1;
                count %= MOD;
            }
            return count;
        }
    }
}
