package com.github.dkoval.leetcode.challenge;

/**
 * <a>https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3597/</a>
 * <p>
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * <p>
 * A string is represented by an array if the array elements concatenated in order forms the string.
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = read(word1), sb2 = read(word2);
        return equals(sb1, sb2);
    }

    private StringBuilder read(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String chars : word) {
            sb.append(chars);
        }
        return sb;
    }

    private boolean equals(StringBuilder sb1, StringBuilder sb2) {
        if (sb1 == sb2) {
            return true;
        }
        if (sb1 == null || sb2 == null) {
            return false;
        }
        if (sb1.length() != sb2.length()) {
            return false;
        }
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
