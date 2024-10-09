package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/">Minimum Add to Make Parentheses Valid</a>
 * <p>
 * A parentheses string is valid if and only if:
 * <ul>
 *  <li>It is the empty string,</li>
 *  <li>It can be written as AB (A concatenated with B), where A and B are valid strings, or</li>
 *  <li>It can be written as (A), where A is a valid string.</li>
 * </ul>
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 * <p>
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * <p>
 * Return the minimum number of moves required to make s valid.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s[i] is either '(' or ')'.</li>
 * </ul>
 */
public interface MinimumAddToMakeParenthesesValid {

    int minAddToMakeValid(String s);

    // O(N) time | O(N) space
    class MinimumAddToMakeParenthesesValidRev1 implements MinimumAddToMakeParenthesesValid {

        @Override
        public int minAddToMakeValid(String s) {
            int n = s.length();

            Deque<Character> stack = new ArrayDeque<>();
            int close = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        // match open and close parentheses
                        stack.pop();
                    } else {
                        close++;
                    }
                }
            }
            return stack.size() + close;
        }
    }

    // O(N) time | O(1) space
    class MinimumAddToMakeParenthesesValidRev2 implements MinimumAddToMakeParenthesesValid {

        @Override
        public int minAddToMakeValid(String s) {
            int n = s.length();

            int unmatchedOpen = 0;
            int unmatchedClose = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    unmatchedOpen++;
                } else {
                    if (unmatchedOpen > 0) {
                        // match '(' and ')' parentheses
                        unmatchedOpen--;
                    } else {
                        // need to insert '('
                        unmatchedClose++;
                    }
                }
            }
            // include remaining unclosed parentheses
            return unmatchedClose + unmatchedOpen;
        }
    }
}
