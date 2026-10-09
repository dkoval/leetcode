package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/">Minimum Insertions to Balance a Parentheses String</a>
 * <p>
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
 * <p>
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * <p>
 * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * <p>
 * In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
 * <p>
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * <p>
 * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 * <p>
 * Return the minimum number of insertions needed to make s balanced.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of '(' and ')' only.</li>
 * </ul>
 */
public interface MinimumInsertionsToBalanceParenthesesString {

    int minInsertions(String s);

    class MinimumInsertionsToBalanceParenthesesStringRev1 implements MinimumInsertionsToBalanceParenthesesString {

        @Override
        public int minInsertions(String s) {
            final var n = s.length();

            var unmatchedOpen = 0;
            var insertions = 0;
            var i = 0;
            while (i < n) {
                if (s.charAt(i) == '(') {
                    unmatchedOpen++;
                    i++;
                } else {
                    if (unmatchedOpen > 0) {
                        unmatchedOpen--;
                    } else {
                        // no opening parenthesis is available, so we must insert '(' before the current ')' to balance it
                        insertions++;
                    }

                    // for a consecutive pair of '))'
                    if (i + 1 < n && s.charAt(i + 1) == ')') {
                        i += 2;
                    } else {
                        // we must insert a ')' parenthesis immediately after the current position to complete the pair
                        insertions++;
                        i++;
                    }
                }
            }

            insertions += unmatchedOpen * 2;
            return insertions;
        }
    }

    class MinimumInsertionsToBalanceParenthesesStringRev2 implements MinimumInsertionsToBalanceParenthesesString {

        @Override
        public int minInsertions(String s) {
            final var n = s.length();

            var moves = 0;
            var depth = 0;
            for (var i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    depth += 2;
                    if (depth % 2 == 1) {
                        moves++;
                        depth--;
                    }
                } else {
                    depth--;
                    if (depth < 0) {
                        moves++;
                        depth = 1;
                    }
                }
            }
            return moves + depth;
        }
    }
}
