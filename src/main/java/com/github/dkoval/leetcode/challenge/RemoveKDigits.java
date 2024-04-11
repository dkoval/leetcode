package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-k-digits/">Remove K Digits</a>
 * <p>
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= num.length <= 10^5</li>
 *  <li>num consists of only digits</li>
 *  <li>num does not have any leading zeros except for the zero itself</li>
 * </ul>
 */
public interface RemoveKDigits {

    String removeKdigits(String num, int k);

    class RemoveKDigitsRev2 implements RemoveKDigits {

        @Override
        public String removeKdigits(String num, int k) {
            int n = num.length();

            if (n == k) {
                return "0";
            }

            // digits at the front are worth more than those at the back
            Deque<Character> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char x = num.charAt(i);
                while (k > 0 && !q.isEmpty() && q.peekLast() > x) {
                    // make room for a smaller digit to be put at the front
                    q.pollLast();
                    k--;
                }
                q.offerLast(x);
            }

            // corner case: k > 0
            while (k > 0) {
                q.pollLast();
                k--;
            }

            // remove leading 0's
            while (!q.isEmpty() && q.peekFirst() == '0') {
                q.pollFirst();
            }

            if (q.isEmpty()) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {

                sb.append(q.pollFirst());
            }
            return sb.toString();
        }
    }
}
