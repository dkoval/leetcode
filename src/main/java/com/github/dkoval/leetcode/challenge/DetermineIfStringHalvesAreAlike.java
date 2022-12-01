package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">Determine if String Halves Are Alike</a>
 * <p>
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 * <p>
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 * <p>
 * Return true if a and b are alike. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= s.length <= 1000</li>
 *  <li>s.length is even.</li>
 *  <li>s consists of uppercase and lowercase letters.</li>
 * </ul>
 */
public interface DetermineIfStringHalvesAreAlike {

    boolean halvesAreAlike(String s);

    // O(N) time | O(1) space
    class DetermineIfStringHalvesAreAlikeRev1 implements DetermineIfStringHalvesAreAlike {

        @Override
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

    class DetermineIfStringHalvesAreAlikeRev2 implements DetermineIfStringHalvesAreAlike {
        private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        @Override
        public boolean halvesAreAlike(String s) {
            int n = s.length();
            return countVowels(s, 0, n / 2 - 1) == countVowels(s, n / 2, n - 1);
        }

        private int countVowels(String s, int start, int end) {
            int count = 0;
            for (int i = start; i <= end; i++) {
                char c = Character.toLowerCase(s.charAt(i));
                if (VOWELS.contains(c)) {
                    count++;
                }
            }
            return count;
        }
    }
}
