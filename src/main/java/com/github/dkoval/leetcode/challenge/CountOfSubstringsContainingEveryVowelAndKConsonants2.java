package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/">Count of Substrings Containing Every Vowel and K Consonants II</a>
 * <p>
 * You are given a string word and a non-negative integer k.
 * <p>
 * Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
 * <p>
 * Constraints:
 * <ul>
 *  <li>5 <= word.length <= 2 * 10^5</li>
 *  <li>word consists only of lowercase English letters</li>
 *  <li>0 <= k <= word.length - 5</li>
 * </ul>
 */
public interface CountOfSubstringsContainingEveryVowelAndKConsonants2 {

    long countOfSubstrings(String word, int k);

    // O(N) time | O(1) space
    // Resource: https://youtu.be/2wANakxRZNo?si=9nfoUXVhNilsggN8
    class CountOfSubstringsContainingEveryVowelAndKConsonants2Rev1 implements CountOfSubstringsContainingEveryVowelAndKConsonants2 {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

        @Override
        public long countOfSubstrings(String word, int k) {
            return atLeast(word, k) - atLeast(word, k + 1);
        }

        private long atLeast(String word, int k) {
            final var n = word.length();

            // sliding window
            var total = 0L;
            final var vowelCounts = new HashMap<Character, Integer>();
            var consonants = 0;
            var left = 0;
            for (var right = 0; right < n; right++) {
                final var rch = word.charAt(right);
                if (VOWELS.contains(rch)) {
                    vowelCounts.put(rch, vowelCounts.getOrDefault(rch, 0) + 1);
                } else {
                    consonants++;
                }

                // shrink the window as much as possible
                while (vowelCounts.size() == VOWELS.size() && consonants >= k) {
                    total += n - right;
                    final var lch = word.charAt(left);
                    if (vowelCounts.containsKey(lch)) {
                        final var count = vowelCounts.get(lch);
                        if (count > 1) {
                            vowelCounts.put(lch, count - 1);
                        } else {
                            vowelCounts.remove(lch);
                        }
                    } else {
                        consonants--;
                    }
                    left++;
                }
            }
            return total;
        }
    }
}
