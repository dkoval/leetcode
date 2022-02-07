package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class FindDifferenceUsingCountsJava implements FindDifference {

    // O(N) time | O(alpha) space, where alpha = 26 is the size of the alphabet
    @Override
    public char findTheDifference(@NotNull String s, @NotNull String t) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--counts[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return '#';
    }
}
