package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/">Isomorphic Strings</a>
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 * 10^4</li>
 *  <li>t.length == s.length</li>
 *  <li>s and t consist of any valid ascii character</li>
 * </ul>
 */
public interface IsomorphicStrings {

    boolean isIsomorphic(String s, String t);

    // O(N) time | O(N) space
    class IsomorphicStringsRev1 implements IsomorphicStrings {

        @Override
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

    // O(N) time | O(N) space
    class IsomorphicStringsRev2 implements IsomorphicStrings {

        @Override
        public boolean isIsomorphic(String s, String t) {
            // t.length == s.length
            int n = s.length();

            // s' char -> t's char
            Map<Character, Character> mapping = new HashMap<>();
            // t's char -> s' char
            Map<Character, Character> reverseMapping = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                if (!mapping.containsKey(c1)) {
                    mapping.put(c1, c2);
                }

                if (!reverseMapping.containsKey(c2)) {
                    reverseMapping.put(c2, c1);
                }

                if (mapping.get(c1) != c2 || reverseMapping.get(c2) != c1) {
                    return false;
                }
            }
            return true;
        }
    }

    // O(N) time | O(N) space
    class IsomorphicStringsMessy implements IsomorphicStrings {

        @Override
        public boolean isIsomorphic(String s, String t) {
            // t.length == s.length
            int n = t.length();

            Map<Character, Integer> counts1 = new HashMap<>();
            Map<Character, Integer> counts2 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                counts1.put(c1, counts1.getOrDefault(c1, 0) + 1);
                counts2.put(c2, counts2.getOrDefault(c2, 0) + 1);
            }

            if (counts1.size() != counts2.size()) {
                return false;
            }

            // controls that no two characters may map to the same character
            Map<Character, Character> lookup = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                if (!lookup.containsKey(c1)) {
                    lookup.put(c1, c2);
                    continue;
                }

                if (lookup.get(c1) != c2) {
                    return false;
                }
            }
            return true;
        }
    }
}
