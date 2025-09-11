package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">Sort Vowels in a String</a>
 * <p>
 * Given a 0-indexed string s, permute s to get a new string t such that:
 * <ul>
 *  <li>All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant,
 *  then t[i] = s[i].
 *  </li>
 *  <li>The vowels must be sorted in the nondecreasing order of their ASCII values.
 *  More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels,
 *  then t[i] must not have a higher ASCII value than t[j].
 *  </li>
 * </ul>
 * Return the resulting string.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists only of letters of the English alphabet in uppercase and lowercase.</li>
 * </ul>
 */
public interface SortVowelsInString {

    String sortVowels(String s);

    class SortVowelsInStringRev1 implements SortVowelsInString {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        @Override
        public String sortVowels(String s) {
            final var n = s.length();

            final var usedVowels = new ArrayList<Character>();
            for (int i = 0; i < n; i++) {
                final var c = s.charAt(i);
                if (VOWELS.contains(c)) {
                    usedVowels.add(c);
                }
            }

            usedVowels.sort(Character::compare);

            var index = 0;
            final var sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                final var c = s.charAt(i);
                sb.append(VOWELS.contains(c) ? usedVowels.get(index++) : c);
            }
            return sb.toString();
        }
    }
}
