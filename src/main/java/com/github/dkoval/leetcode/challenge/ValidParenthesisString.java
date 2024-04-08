package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/valid-parenthesis-string/">Valid Parenthesis String</a>
 * <p>
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 * <p>
 * The following rules define a valid string:
 * <ul>
 *  <li>Any left parenthesis '(' must have a corresponding right parenthesis ')'.</li>
 *  <li>Any right parenthesis ')' must have a corresponding left parenthesis '('.</li>
 *  <li>Left parenthesis '(' must go before the corresponding right parenthesis ')'.</li>
 *  <li>'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s[i] is '(', ')' or '*'.</li>
 * </ul>
 */
public interface ValidParenthesisString {

    boolean checkValidString(String s);

    class ValidParenthesisStringRev1 implements ValidParenthesisString {

        @Override
        public boolean checkValidString(String s) {
            int n = s.length();

            // DP top-down
            Boolean[][] dp = new Boolean[n + 1][n + 1];
            return calc(s, 0, 0, dp);
        }

        private boolean calc(String s, int index, int depth, Boolean[][] dp) {
            if (index == s.length()) {
                return depth == 0;
            }

            // already solved?
            if (dp[index][depth] != null) {
                return dp[index][depth];
            }

            char c = s.charAt(index);
            boolean ans;
            if (c == '(') {
                ans = calc(s, index + 1, depth + 1, dp);
            } else if (c == ')') {
                ans = (depth - 1 >= 0) && calc(s, index + 1, depth - 1, dp);
            } else {
                // option #1: * -> (
                // option #2: * -> )
                // option #3: * -> ""
                ans = calc(s, index + 1, depth + 1, dp)
                        || (depth - 1 >= 0 && calc(s, index + 1, depth - 1, dp))
                        || calc(s, index + 1, depth, dp);
            }
            return dp[index][depth] = ans;
        }
    }
}
