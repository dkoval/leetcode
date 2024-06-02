package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Constraints:
 * <ul>
 *  <li> <= s.length <= 10^5</li>
 *  <li>[i] is a printable ascii character</li>
 * </ul>
 */
public interface ReverseString {

    void reverseString(char[] s);

    class ReverseStringRev2 implements ReverseString {

        @Override
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left++] = s[right];
                s[right--] = tmp;
            }
        }
    }
}
