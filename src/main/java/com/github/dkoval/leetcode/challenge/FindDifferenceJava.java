package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class FindDifferenceJava implements FindDifference {

    @Override
    public char findTheDifference(@NotNull String s, @NotNull String t) {
        int addedCharAsciiValue = 0;
        for (int i = 0; i < s.length(); i++) {
            addedCharAsciiValue += t.charAt(i);
            addedCharAsciiValue -= s.charAt(i);
        }
        addedCharAsciiValue += t.charAt(t.length() - 1);
        return (char) addedCharAsciiValue;
    }
}
