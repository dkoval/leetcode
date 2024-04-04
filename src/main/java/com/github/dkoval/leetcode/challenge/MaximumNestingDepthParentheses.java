package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/">Maximum Nesting Depth of the Parentheses</a>
 * <p>
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 * <ul>
 *  <li>It is an empty string "", or a single character not equal to "(" or ")",</li>
 *  <li>It can be written as AB (A concatenated with B), where A and B are VPS's, or</li>
 *  <li>It can be written as (A), where A is a VPS.</li>
 * <ul>
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <ul>
 *  <li>depth("") = 0</li>
 *  <li>depth(C) = 0, where C is a string with a single character not equal to "(" or ")"</li>
 *  <li>depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's</li>
 *  <li>depth("(" + A + ")") = 1 + depth(A), where A is a VPS</li>
 * </ul>
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * Given a VPS represented as string s, return the nesting depth of s.
 * <p>
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
            int n = s.length();

            int ans = 0;
            int depth = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    depth++;
                } else if (c == ')') {
                    depth--;
                } else {
                    continue;
                }
                ans = Math.max(ans, depth);
            }
            return ans;
        }
    }
}
