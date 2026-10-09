package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/remove-outermost-parentheses/">Remove Outermost Parentheses</a>
 * <p>
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings,
 * and + represents string concatenation.
 * <p>
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * <p>
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B,
 * with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk,
 * where Pi are primitive valid parentheses strings.
 * <p>
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s[i] is either '(' or ')'.</li>
 *  <li>s is a valid parentheses string.</li>
 * </ul>
 */
public interface RemoveOutermostParentheses {

    String removeOuterParentheses(String s);

    class RemoveOutermostParenthesesRev1 implements RemoveOutermostParentheses {

        @Override
        public String removeOuterParentheses(String s) {
            final var n = s.length();

            final var sb = new StringBuilder();
            var depth = 0;
            for (var i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    if (depth > 0) {
                        sb.append('(');
                    }
                    depth++;
                } else {
                    depth--;
                    if (depth > 0) {
                        sb.append(')');
                    }
                }
            }
            return sb.toString();
        }
    }
}
