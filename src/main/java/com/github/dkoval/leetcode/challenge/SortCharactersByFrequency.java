package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Sort Characters By Frequency</a>
 * <p>
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * <p>
 * Return the sorted string. If there are multiple answers, return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 * 10^5</li>
 *  <li></li>s consists of uppercase and lowercase English letters and digits</li>
 * </ul>
 */
public interface SortCharactersByFrequency {

    String frequencySort(String s);

    // O(N * logN) time | O(alpha) space, where
    // N - number of characters in input string s
    // alpha - size of the alphabet
    class SortCharactersByFrequencyRev1 implements SortCharactersByFrequency {

        @Override
        public String frequencySort(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            // sort list of (char, frequency) pairs by their frequencies in decreasing order
            List<Map.Entry<Character, Integer>> pairs = new ArrayList<>(counts.entrySet());
            pairs.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> pair : pairs) {
                char c = pair.getKey();
                int count = pair.getValue();
                while (count-- > 0) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
