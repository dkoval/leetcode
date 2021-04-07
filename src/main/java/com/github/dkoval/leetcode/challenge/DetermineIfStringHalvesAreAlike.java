package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3699/">Determine if String Halves Are Alike</a>
 * <p>
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 * <p>
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 * <p>
 * Return true if a and b are alike. Otherwise, return false.
 */
public class DetermineIfStringHalvesAreAlike {

    // O(N) time | O(1) space
    public boolean halvesAreAlike(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += inc(s, i);
        }
        return (count == 0);
    }

    private int inc(String s, int idx) {
        int inc = isVowel(s.charAt(idx)) ? 1 : 0;
        return (idx < s.length() / 2) ? inc : -inc;
    }

    private boolean isVowel(char c) {
        char lc = Character.toLowerCase(c);
        return (lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u');
    }
}
