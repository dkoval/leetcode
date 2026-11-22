package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/">Check if All A's Appears Before All B's</a>
 * <p>
 * Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' appears before every 'b' in the string.
 * Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s[i] is either 'a' or 'b'.</li>
 * </ul>
 */
public interface CheckIfAllAsAppearsBeforeAllBs {

    boolean checkString(String s);

    class CheckIfAllAsAppearsBeforeAllBsRev1 implements CheckIfAllAsAppearsBeforeAllBs {

        @Override
        public boolean checkString(String s) {
            var index = consume(s, 'a', 0);
            index = consume(s, 'b', index);
            return index == s.length();
        }

        private int consume(String s, char c, int start) {
            var index = start;
            while (index < s.length() && s.charAt(index) == c) {
                index++;
            }
            return index;
        }
    }
}
