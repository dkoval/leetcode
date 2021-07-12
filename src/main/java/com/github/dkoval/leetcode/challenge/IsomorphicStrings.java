package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3811/">Isomorphic Strings</a>
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {

    // O(N) time | O(N) space
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reverseMapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapping.containsKey(cs) && mapping.get(cs) != ct) {
                return false;
            }
            if (reverseMapping.containsKey(ct) && reverseMapping.get(ct) != cs) {
                return false;
            }
            mapping.put(cs, ct);
            reverseMapping.put(ct, cs);
        }
        return true;
    }
}
