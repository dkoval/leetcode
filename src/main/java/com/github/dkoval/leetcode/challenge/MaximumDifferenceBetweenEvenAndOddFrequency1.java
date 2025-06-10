package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/">Maximum Difference Between Even and Odd Frequency I</a>
 * <p>
 * You are given a string s consisting of lowercase English letters.
 * <p>
 * Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:
 * <p>
 * a1 has an odd frequency in the string.
 * a2 has an even frequency in the string.
 * <p>
 * Return this maximum difference.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= s.length <= 100</li>
 *  <li>s consists only of lowercase English letters.</li>
 *  <li>s contains at least one character with an odd frequency and one with an even frequency.</li>
 * </ul>
 */
public interface MaximumDifferenceBetweenEvenAndOddFrequency1 {

    int maxDifference(String s);

    class MaximumDifferenceBetweenEvenAndOddFrequency1Rev1 implements MaximumDifferenceBetweenEvenAndOddFrequency1 {

        @Override
        public int maxDifference(String s) {
            final var n = s.length();

            final var freq = new int[26];
            for (var i = 0; i < n; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // constraint: s contains at least one character with an odd frequency and one with an even frequency
            var maxOddFreq = Integer.MIN_VALUE;
            var minEvenFreq = Integer.MAX_VALUE;
            for (var f : freq) {
                if (f % 2 == 1) {
                    maxOddFreq = Math.max(maxOddFreq, f);
                } else if (f > 0) {
                    minEvenFreq = Math.min(minEvenFreq, f);
                }
            }
            return maxOddFreq - minEvenFreq;
        }
    }
}
