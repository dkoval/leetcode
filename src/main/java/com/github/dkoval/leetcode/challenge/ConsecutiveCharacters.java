package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/consecutive-characters/">Consecutive Characters</a>
 * <p>
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * <p>
 * Given a string s, return the power of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 500</li>
 *  <li>s consists of only lowercase English letters</li>
 * </ul>
 */
public class ConsecutiveCharacters {

    // O(N) time | O(1) space
    public int maxPower(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            int currLength = 0;
            while (end < n && s.charAt(end) == s.charAt(start)) {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }
            start = end;
        }
        return maxLength;
    }
}
