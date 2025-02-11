package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring/">Remove All Occurrences of a Substring</a>
 * <p>
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 * <p>
 * Find the leftmost occurrence of the substring part and remove it from s.
 * <p>
 * Return s after removing all occurrences of part.
 * <p>
 * A substring is a contiguous sequence of characters in a string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>1 <= part.length <= 1000</li>
 *  <li>s and part consists of lowercase English letters.</li>
 * </ul>
 */
public interface RemoveAllOccurrencesOfSubstring {

    String removeOccurrences(String s, String part);

    class RemoveAllOccurrencesOfSubstringRev1 implements RemoveAllOccurrencesOfSubstring {

        @Override
        public String removeOccurrences(String s, String part) {
            final var n = s.length();
            final var p = part.length();

            final var q = new ArrayDeque<Character>();
            for (var i = 0; i < n; i++) {
                q.offerLast(s.charAt(i));
                if (q.size() < p || s.charAt(i) != part.charAt(p - 1)) {
                    continue;
                }

                final var tmp = new ArrayDeque<Character>();
                for (var j = p - 1; j >= 0; j--) {
                    if (q.peekLast() != part.charAt(j)) {
                        break;
                    }
                    tmp.push(q.pollLast());
                }

                if (tmp.size() == p) {
                    continue;
                }

                // return temporarily removed characters
                while (!tmp.isEmpty()) {
                    q.offerLast(tmp.pop());
                }
            }

            final var sb = new StringBuilder();
            while (!q.isEmpty()) {
                sb.append(q.pollFirst());
            }
            return sb.toString();
        }
    }

    class RemoveAllOccurrencesOfSubstringRev2 implements RemoveAllOccurrencesOfSubstring {

        @Override
        public String removeOccurrences(String s, String part) {
            final var p = part.length();

            while (s.contains(part)) {
                final var index = s.indexOf(part);
                s = s.substring(0, index) + s.substring(index + p);
            }
            return s;
        }
    }
}
