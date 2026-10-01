package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * <p>
 * Open brackets must be closed in the correct order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^4</li>
 *  <li>s consists of parentheses only '()[]{}'.</li>
 * </ul>
 */
public interface ValidParentheses {

    boolean isValid(String s);

    class ValidParenthesesRev1 implements ValidParentheses {

        private static final Set<Character> OPEN_BRACKETS = Set.of('(', '{', '[');

        // close bracket -> open bracket
        private static final Map<Character, Character> MATCHING_BRACKETS = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        private static boolean isOpenBracket(char c) {
            return OPEN_BRACKETS.contains(c);
        }

        private static char getMatchingOpenBracket(char c) {
            return MATCHING_BRACKETS.get(c);
        }

        @Override
        public boolean isValid(String s) {
            final var n = s.length();

            final var stack = new ArrayDeque<Character>();
            for (var i = 0; i < n; i++) {
                final var c = s.charAt(i);
                if (isOpenBracket(c)) {
                    stack.push(c);
                } else {
                    final var openBracket = getMatchingOpenBracket(c);
                    if (stack.isEmpty() || stack.pop() != openBracket) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
