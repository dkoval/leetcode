package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3754/">To Lower Case</a>
 * <p>
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s consists of printable ASCII characters</li>
 * </ul>
 */
public interface ToLowerCase {

    String toLowerCase(String s);

    class ToLowerCaseLib implements ToLowerCase {

        @Override
        public String toLowerCase(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : c);
            }
            return sb.toString();
        }
    }

    class ToLowerCaseAscii implements ToLowerCase {

        @Override
        public String toLowerCase(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.append(c >= 'A' && c <= 'Z' ? (char) (c + ('a' - 'A')) : c);
            }
            return sb.toString();
        }
    }
}
