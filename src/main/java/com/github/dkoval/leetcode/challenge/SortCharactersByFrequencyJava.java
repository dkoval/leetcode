package com.github.dkoval.leetcode.challenge;

import java.util.*;

public class SortCharactersByFrequencyJava {

    public static String frequencySort(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedByFrequency = new ArrayList<>(frequencies.entrySet());
        sortedByFrequency.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> charAndFrequency : sortedByFrequency) {
            for (int i = 0; i < charAndFrequency.getValue(); i++) {
                result.append(charAndFrequency.getKey());
            }
        }
        return result.toString();
    }
}
