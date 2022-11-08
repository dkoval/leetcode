package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/make-the-string-great/">Make The String Great</a>
 * <p>
 * Given a string s of lower and upper case English letters.
 * <p>
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * <ul>
 *  <li>0 <= i <= s.length - 2</li>
 *  <li>s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.</li>
 * </ul>
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 * <p>
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 * <p>
 * Notice that an empty string is also good.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s contains only lower and upper case English letters.</li>
 * </ul>
 */
public interface MakeStringGreat {

    String makeGood(String s);

    // O(N) time | O(N) space
    class MakeStringGreatRev1 implements MakeStringGreat {

        @Override
        public String makeGood(String s) {
            int n = s.length();

            Deque<Character> stack = new ArrayDeque<>();
            stack.push(s.charAt(0));
            for (int i = 1; i < n; i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() &&
                        (Character.isUpperCase(c) && stack.peek() == Character.toLowerCase(c) ||
                                Character.isLowerCase(c) && stack.peek() == Character.toUpperCase(c))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            char[] ans = new char[stack.size()];
            int i = stack.size() - 1;
            while (!stack.isEmpty()) {
                ans[i] = stack.pop();
                i--;
            }
            return String.valueOf(ans);
        }
    }
}
