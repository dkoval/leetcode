package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">Determine if Two Strings Are Close</a>
 * <p>
 * Two strings are considered close if you can attain one from the other using the following operations:
 * <ul>
 *  <li>
 *  Operation 1: Swap any two existing characters.
 *  <ul>
 *    <li>For example, abcde -> aecdb</li>
 *  </ul>
 *  </li>
 *  <li>
 *  Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 *  <ul>
 *    <li>For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)</li>
 *  </ul>
 *  </li>
 * </ul>
 * You can use the operations on either string as many times as necessary.
 * <p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word1.length, word2.length <= 10^5</li>
 *  <li>word1 and word2 contain only lowercase English letters.</li>
 * </ul>
 */
public interface DetermineIfTwoStringsAreClose {

    boolean closeStrings(String word1, String word2);

    class DetermineIfTwoStringsAreCloseRev1 implements DetermineIfTwoStringsAreClose {

        @Override
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }

            Map<Character, Integer> freq1 = frequencies(word1);
            Map<Character, Integer> freq2 = frequencies(word2);

            Set<Character> chars1 = freq1.keySet();
            Set<Character> chars2 = freq2.keySet();
            if (chars1.equals(chars2)) {
                // check if occurrences1 is a permutation of occurrences2
                List<Integer> occurrences1 = new ArrayList<>(freq1.values());
                Collections.sort(occurrences1);

                List<Integer> occurrences2 = new ArrayList<>(freq2.values());
                Collections.sort(occurrences2);
                return occurrences1.equals(occurrences2);
            }
            return false;
        }

        private Map<Character, Integer> frequencies(String word) {
            Map<Character, Integer> freq = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            return freq;
        }
    }

    class DetermineIfTwoStringsAreCloseRev2 implements DetermineIfTwoStringsAreClose {

        @Override
        public boolean closeStrings(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();

            if (n1 != n2) {
                return false;
            }

            Set<Character> seen1 = new HashSet<>();
            Set<Character> seen2 = new HashSet<>();
            int[][] counts = new int[2][26];
            for (int i = 0; i < n1; i++) {
                counts[0][word1.charAt(i) - 'a']++;
                seen1.add(word1.charAt(i));

                counts[1][word2.charAt(i) - 'a']++;
                seen2.add(word2.charAt(i));
            }

            // Operation 1 allows you to freely reorder the string.
            if (!seen1.equals(seen2)) {
                return false;
            }

            // Operation 2 allows you to freely reassign the letters' frequencies.
            Arrays.sort(counts[0]);
            Arrays.sort(counts[1]);

            for (int i = 0; i < 26; i++) {
                if (counts[0][i] != counts[1][i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
