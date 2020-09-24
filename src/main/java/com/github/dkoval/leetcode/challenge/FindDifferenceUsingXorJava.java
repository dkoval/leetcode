package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

// Time complexity: O(N), space complexity: O(1)
public class FindDifferenceUsingXorJava implements FindDifference {

    // Resource: https://www.youtube.com/watch?v=sRwElQ_TOr8&t=266s
    @Override
    public char findTheDifference(@NotNull String s, @NotNull String t) {
        char addedChar = 0;
        for (int i = 0; i < s.length(); i++) addedChar ^= s.charAt(i);
        for (int i = 0; i < t.length(); i++) addedChar ^= t.charAt(i);
        return addedChar;
    }
}
