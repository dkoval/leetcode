package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/">Maximum Nesting Depth of the Parentheses</a>
 * <p>
 * Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'</li>
 *  <li>It is guaranteed that parentheses expression s is a VPS</li>
 * </ul>
 */
public interface MaximumNestingDepthParentheses {

    int maxDepth(String s);

    class MaximumNestingDepthParenthesesRev1 implements MaximumNestingDepthParentheses {

        @Override
        public int maxDepth(String s) {
            final var n = s.length();

            var best = 0;
            var depth = 0;
            for (var i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    depth++;
                    best = Math.max(best, depth);
                } else if (s.charAt(i) == ')') {
                    depth--;
                }
            }
            return best;
        }
    }
}
