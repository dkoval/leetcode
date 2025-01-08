package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i">Count Prefix and Suffix Pairs I</a>
 * <p>
 * You are given a 0-indexed string array words.
 * <p>
 * Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
 * <p>
 * isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.
 * <p>
 * For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.
 * <p>
 * Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.
 * <p>
 * Constraints:
 * <ul>
 *  <li>>1 <= words.length <= 50</li>
 *  <li>>1 <= words[i].length <= 10</li>
 *  <li>>words[i] consists only of lowercase English letters.</li>
 * </ul>
 */
public interface CountPrefixAndSuffixPairs1 {

    int countPrefixSuffixPairs(String[] words);

    class CountPrefixAndSuffixPairs1Rev1 implements CountPrefixAndSuffixPairs1 {

        @Override
        public int countPrefixSuffixPairs(String[] words) {
            final var n = words.length;

            var count = 0;
            for (var i = 0; i < n - 1; i++) {
                for (var j = i + 1; j < n; j++) {
                    if (isPrefixAndSuffix(words[i], words[j])) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isPrefixAndSuffix(String s1, String s2) {
            final var w1 = s1.length();
            final var w2 = s2.length();

            if (w1 > w2) {
                return false;
            }

            for (var left = 0; left < w1; left++) {
                if (s1.charAt(left) != s2.charAt(left)) {
                    return false;
                }

                if (s1.charAt(w1 - left - 1) != s2.charAt(w2 - left - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
