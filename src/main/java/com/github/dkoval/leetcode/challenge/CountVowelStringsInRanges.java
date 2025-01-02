package com.github.dkoval.leetcode.challenge;

import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/count-vowel-strings-in-ranges/">Count Vowel Strings in Ranges</a>
 * <p>
 * You are given a 0-indexed array of strings words and a 2D array of integers queries.
 * <p>
 * Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive)
 * of words that start and end with a vowel.
 * <p>
 * Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
 * <p>
 * Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 10^5</li>
 *  <li>1 <= words[i].length <= 4^0</li>
 *  <li>words[i] consists only of lowercase English letters.</li>
 *  <li>sum(words[i].length) <= 3 * 10^5</li>
 *  <li>1 <= queries.length <= 10^5</li>
 *  <li>0 <= li <= ri < words.length</li>
 * </ul>
 */
public interface CountVowelStringsInRanges {

    int[] vowelStrings(String[] words, int[][] queries);

    class CountVowelStringsInRangesRev1 implements CountVowelStringsInRanges {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

        @Override
        public int[] vowelStrings(String[] words, int[][] queries) {
            final var n = words.length;
            final var q = queries.length;

            // prefix[i] - the number of "good" strings that end at index i
            final var prefix = new int[n];
            for (var i = 0; i < n; i++) {
                if (i > 0) {
                    prefix[i] = prefix[i - 1];
                }
                if (good(words[i])) {
                    prefix[i]++;
                }
            }

            final var ans = new int[q];
            for (var i = 0; i < q; i++) {
                final var l = queries[i][0];
                final var r = queries[i][1];
                ans[i] = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
            }
            return ans;
        }

        private boolean good(String word) {
            final var w = word.length();
            return VOWELS.contains(word.charAt(0)) && VOWELS.contains(word.charAt(w - 1));
        }
    }
}
