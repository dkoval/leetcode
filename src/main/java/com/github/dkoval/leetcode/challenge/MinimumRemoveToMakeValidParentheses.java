package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/">Minimum Remove to Make Valid Parentheses</a>
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <ul>
 *  <li>It is the empty string, contains only lowercase characters, or</li>
 *  <li>It can be written as AB (A concatenated with B), where A and B are valid strings, or</li>
 *  <li>It can be written as (A), where A is a valid string.</li>
 * </ul>
 */
public interface MinimumRemoveToMakeValidParentheses {

    String minRemoveToMakeValid(String s);

    class MinimumRemoveToMakeValidParenthesesUsingCounter implements MinimumRemoveToMakeValidParentheses {

        private final static char MARKER = '#';

        @Override
        public String minRemoveToMakeValid(String s) {
            char[] chars = s.toCharArray();

            // scan chars[] left-to-right to mark ')' chars that do not have a match
            matchParentheses(chars, true);
            // scan chars[] right-to-left to mark '(' chars that do not have a match
            matchParentheses(chars, false);

            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (c != MARKER) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        private void matchParentheses(char[] chars, boolean forward) {
            int i = forward ? 0 : chars.length - 1;
            final int end = forward ? chars.length : -1;
            final int step = forward ? 1 : -1;

            final char parenthesisToMatchWith = forward ? '(' : ')';
            final char matchingParenthesis = forward ? ')' : '(';

            int count = 0;
            while (i != end) {
                if (chars[i] == parenthesisToMatchWith) {
                    count++;
                } else if (chars[i] == matchingParenthesis) {
                    if (count > 0) {
                        count--;
                    } else {
                        chars[i] = MARKER;
                    }
                }
                i += step;
            }
        }
    }

    class MinimumRemoveToMakeValidParenthesesUsingStack implements MinimumRemoveToMakeValidParentheses {

        @Override
        public String minRemoveToMakeValid(String s) {
            // Each prefix for a balanced parentheses string has a number of '(' >= ')'.
            // Similar idea with each suffix.
            int n = s.length();
            Stack<Character> stack = new Stack<>();
            Set<Integer> badIndices = new HashSet<>();

            // step #1: going from left to right, find obsolete ')' parentheses
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        badIndices.add(i);
                    }
                }
            }

            stack.clear();

            // step #2: going from right to left, find obsolete '(' parentheses
            for (int i = n - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == ')') {
                    stack.push(c);
                } else if (c == '(') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        badIndices.add(i);
                    }
                }
            }

            // finally, construct the result
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (!badIndices.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
