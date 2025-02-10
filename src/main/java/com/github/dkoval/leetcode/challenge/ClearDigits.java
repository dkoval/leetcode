package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/clear-digits/">Clear Digits</a>
 * <p>
 * You are given a string s.
 * <p>
 * Your task is to remove all digits by doing this operation repeatedly:
 * <p>
 * Delete the first digit and the closest non-digit character to its left.
 * <p>
 * Return the resulting string after removing all digits.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s consists only of lowercase English letters and digits.</li>
 *  <li>The input is generated such that it is possible to delete all digits.</li>
 * </ul>
 */
public interface ClearDigits {

    String clearDigits(String s);

    // O(N) time | O(N) space
    class ClearDigitsRev1 implements ClearDigits {

        @Override
        public String clearDigits(String s) {
            final var n = s.length();

            final var q = new ArrayDeque<Character>();
            for (var i = 0; i < n; i++) {
                final var c = s.charAt(i);
                if (Character.isDigit(c)) {
                    if (!q.isEmpty()) {
                        q.pollLast();
                    }
                } else {
                    q.offerLast(c);
                }
            }

            final var sb = new StringBuilder();
            while (!q.isEmpty()) {
                sb.append(q.pollFirst());
            }

            return sb.toString();
        }
    }
}
