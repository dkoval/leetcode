package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/palindromic-substrings/">Palindromic Substrings</a>
 * <p>
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s consists of lowercase English letters</li>
 * </ul>
 */
public interface PalindromicSubstrings {

    int countSubstrings(String s);

    // O(N^2) time | O(1) space
    class PalindromicSubstringsRev1 implements PalindromicSubstrings {

        @Override
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                // odd-length palindrome: b a b
                // .........................^ center
                count += expandFromCenter(s, i, i);

                // even-length palindrome: a a
                // .........................^ center
                count += expandFromCenter(s, i - 1, i);
            }
            return count;
        }

        private int expandFromCenter(String s, int left, int right) {
            int count = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
            return count;
        }
    }
}
