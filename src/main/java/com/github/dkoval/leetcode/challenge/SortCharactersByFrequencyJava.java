package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Sort Characters By Frequency</a>
 * <p>
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * <p>
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class SortCharactersByFrequencyJava {

    // O(N * logN) time | O(alpha) space, where
    // N - number of characters in input string s
    // alpha - size of the alphabet
    public static String frequencySort(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        // sort list of (char, frequency) pairs by their frequencies in decreasing order
        List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(frequencies.entrySet());
        sorted.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sorted) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            while (frequency-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
