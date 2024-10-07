package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings/">Minimum String Length After Removing Substrings</a>
 * <p>
 * You are given a string s consisting only of uppercase English letters.
 * <p>
 * You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings
 * "AB" or "CD" from s.
 * <p>
 * Return the minimum possible length of the resulting string that you can obtain.
 * <p>
 * Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s consists only of uppercase English letters</li>
 * </ul>
 */
public interface MinimumStringLengthAfterRemovingSubstrings {

    int minLength(String s);

    // O(N) time | O(N) space
    class MinimumStringLengthAfterRemovingSubstringsRev1 implements MinimumStringLengthAfterRemovingSubstrings {

        @Override
        public int minLength(String s) {
            int n = s.length();

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                // compare last 2 characters
                char c = s.charAt(i);
                if (!stack.isEmpty() && valid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.size();
        }

        private boolean valid(char c1, char c2) {
            return (c1 == 'A' && c2 == 'B') || (c1 == 'C' && c2 == 'D');
        }
    }
}
