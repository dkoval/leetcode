package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome-ii/>"Valid Palindrome II</a>
 * <p>
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters</li>
 * </ul>
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        return doValidPalindrome(s, 0, s.length() - 1, false);
    }

    private boolean doValidPalindrome(String s, int l, int r, boolean deleted) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (deleted) {
                    return false;
                }
                // check if s can be a palindrome after removing either s[l] or s[r] character
                return doValidPalindrome(s, l + 1, r, true) || doValidPalindrome(s, l, r - 1, true);
            }
        }
        return true;
    }
}
