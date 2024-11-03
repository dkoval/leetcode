package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/rotate-string/">Rotate String</a>
 * <p>
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * <p>
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * <p>
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length, goal.length <= 100</li>
 *  <li>s and goal consist of lowercase English letters.</li>
 * </ul>
 */
public interface RotateString {

    boolean rotateString(String s, String goal);

    class RotateStringRev1 implements RotateString {

        @Override
        public boolean rotateString(String s, String goal) {
            int n = s.length();

            if (n != goal.length()) {
                return false;
            }

            // try every possible split position
            for (int i = 0; i < n; i++) {
                String prefix = s.substring(0, i + 1);
                String suffix = s.substring(i + 1);
                if (goal.equals(suffix + prefix)) {
                    return true;
                }
            }
            return false;
        }
    }
}
