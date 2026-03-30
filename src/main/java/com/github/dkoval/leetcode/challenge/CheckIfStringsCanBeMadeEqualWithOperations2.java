package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/">Check if Strings Can be Made Equal With Operations II</a>
 * <p>
 * You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.
 * <p>
 * You can apply the following operation on any of the two strings any number of times:
 * <p>
 * Choose any two indices i and j such that i < j and the difference j - i is even, then swap the two characters at those indices in the string.
 * <p>
 * Return true if you can make the strings s1 and s2 equal, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == s1.length == s2.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>s1 and s2 consist only of lowercase English letters.</li>
 * </ul>
 */
public interface CheckIfStringsCanBeMadeEqualWithOperations2 {

    boolean checkStrings(String s1, String s2);

    class CheckIfStringsCanBeMadeEqualWithOperations2Rev1 implements CheckIfStringsCanBeMadeEqualWithOperations2 {

        @Override
        public boolean checkStrings(String s1, String s2) {
            final var f1 = frequencies(s1);
            final var f2 = frequencies(s2);
            return f1.sameAs(f2);
        }

        private Frequencies frequencies(String s) {
            final var result = new Frequencies();
            for (var i = 0; i < s.length(); i++) {
                final var c = s.charAt(i);
                if (i % 2 == 0) {
                    result.evens[c - 'a']++;
                } else {
                    result.odds[c - 'a']++;
                }
            }
            return result;
        }

        private record Frequencies(
                int[] evens,
                int[] odds
        ) {

            Frequencies() {
                this(new int[26], new int[26]);
            }

            boolean sameAs(Frequencies that) {
                return Arrays.equals(evens, that.evens) && Arrays.equals(odds, that.odds);
            }
        }
    }
}
