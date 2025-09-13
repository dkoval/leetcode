package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/">Find Most Frequent Vowel and Consonant</a>
 * <p>
 * You are given a string s consisting of lowercase English letters ('a' to 'z').
 * <p>
 * Your task is to:
 * <p>
 * Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
 * Find the consonant (all other letters excluding vowels) with the maximum frequency.
 * Return the sum of the two frequencies.
 * <p>
 * Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them.
 * If there are no vowels or no consonants in the string, consider their frequency as 0.
 * <p>
 * The frequency of a letter x is the number of times it occurs in the string.
 * <p>
 * Constraints:
 * <ul>
 *  <ul>1 <= s.length <= 100</ul>
 *  <ul>s consists of lowercase English letters only.</ul>
 * </ul>
 */
public interface FindMostFrequentVowelAndConsonant {

    int maxFreqSum(String s);

    class FindMostFrequentVowelAndConsonantRev1 implements FindMostFrequentVowelAndConsonant {

        @Override
        public int maxFreqSum(String s) {
            final var n = s.length();

            final var freqs = new int[26];
            for (var i = 0; i < n; i++) {
                freqs[s.charAt(i) - 'a']++;
            }

            var maxVowel = 0;
            var maxConsonant = 0;
            for (var i = 0; i < 26; i++) {
                final var c = (char) ('a' + i);
                if (isVowel(c)) {
                    maxVowel = Math.max(maxVowel, freqs[i]);
                } else {
                    maxConsonant = Math.max(maxConsonant, freqs[i]);
                }
            }
            return maxVowel + maxConsonant;
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
