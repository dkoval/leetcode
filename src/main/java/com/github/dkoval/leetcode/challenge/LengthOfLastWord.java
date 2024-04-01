package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word/description/">Length of Last Word</a>
 * <p>
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^4</li>
 *  <li>s consists of only English letters and spaces ' '</li>
 *  <li>There will be at least one word in s</li>
 * </ul>
 */
public interface LengthOfLastWord {

    int lengthOfLastWord(String s);

    class LengthOfLastWordRev3 implements LengthOfLastWord {

        @Override
        public int lengthOfLastWord(String s) {
            int n = s.length();

            // ignore trailing whitespaces
            int i = n - 1;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int end = i;

            // find the starting index of the last word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            return end - i;
        }
    }
}
