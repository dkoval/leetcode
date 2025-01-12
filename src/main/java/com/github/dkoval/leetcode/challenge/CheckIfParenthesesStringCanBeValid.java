package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/">Check if a Parentheses String Can Be Valid</a>
 * <p>
 * A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
 * <ul>
 *  <li>It is ().</li>
 *  <li>It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.</li>
 *  <li>It can be written as (A), where A is a valid parentheses string.</li>
 * </ul>
 * You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting
 * only of '0's and '1's. For each index i of locked,
 * <ul>
 *  <li>If locked[i] is '1', you cannot change s[i].</li>
 *  <li>But if locked[i] is '0', you can change s[i] to either '(' or ')'.</li>
 * </ul>
 * Return true if you can make s a valid parentheses string. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == s.length == locked.length</li>
 *  <li>1 <= n <= 105</li>
 *  <li>s[i] is either '(' or ')'.</li>
 *  <li>locked[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface CheckIfParenthesesStringCanBeValid {

    boolean canBeValid(String s, String locked);

    // O(N) time | O(N) space
    class CheckIfParenthesesStringCanBeValidRev1 implements CheckIfParenthesesStringCanBeValid {

        @Override
        public boolean canBeValid(String s, String locked) {
            final var n = s.length();

            // indices of '('
            final var opens = new ArrayDeque<Integer>();
            // indices of locked[0]
            final var anys = new ArrayDeque<Integer>();

            for (var i = 0; i < n; i++) {
                if (locked.charAt(i) == '0') {
                    anys.push(i);
                } else if (s.charAt(i) == '(') {
                    opens.push(i);
                } else {
                    // s[i] == ')'
                    // try to match ')' with '(' first; otherwise turn the last `any` to '(' if possible
                    if (!opens.isEmpty()) {
                        opens.pop();
                    } else {
                        if (anys.isEmpty()) {
                            return false;
                        }
                        anys.pop();
                    }
                }
            }

            // now, match remaining '(' with `any`s by turning the latter to ')'
            while (!opens.isEmpty() && !anys.isEmpty()) {
                // '(' has to come before ')'
                if (opens.pop() > anys.pop()) {
                    return false;
                }
            }

            // it's always possible to change an even number of remaining `any`s to
            // valid '()' pairs
            return opens.isEmpty() && (anys.size() % 2 == 0);
        }
    }
}
