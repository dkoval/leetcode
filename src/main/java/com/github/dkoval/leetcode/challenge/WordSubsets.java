package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-subsets/">Word Subsets</a>
 * <p>
 * You are given two string arrays words1 and words2.
 * <p>
 * A string b is a subset of string a if every letter in b occurs in a including multiplicity.
 * <p>
 * For example, "wrr" is a subset of "warrior" but is not a subset of "world".
 * A string a from words1 is universal if for every string b in words2, b is a subset of a.
 * <p>
 * Return an array of all the universal strings in words1. You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words1.length, words2.length <= 10^4</li>
 *  <li>1 <= words1[i].length, words2[i].length <= 10</li>
 *  <li>words1[i] and words2[i] consist only of lowercase English letters.</li>
 *  <li>All the strings of words1 are unique.</li>
 * </ul>
 */
public interface WordSubsets {

    List<String> wordSubsets(String[] A, String[] B);

    class WordSubsetsTLE implements WordSubsets {

        @Override
        public List<String> wordSubsets(String[] A, String[] B) {
            Map<String, int[]> wordStats = new HashMap<>();
            for (String a : A) {
                wordStats.put(a, charCounts(a));
            }

            int[] subsets = new int[A.length];
            for (String b : B) {
                int[] bCharCounts = charCounts(b);
                for (int i = 0; i < A.length; i++) {
                    int[] aCharCounts = wordStats.get(A[i]);
                    if (isSubset(aCharCounts, bCharCounts)) {
                        subsets[i]++;
                    }
                }
            }

            List<String> result = new ArrayList<>();
            for (int i = 0; i < subsets.length; i++) {
                if (subsets[i] == B.length) {
                    result.add(A[i]);
                }
            }
            return result;
        }

        private int[] charCounts(String s) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                counts[c - 'a']++;
            }
            return counts;
        }

        private boolean isSubset(int[] sourceCharCounts, int[] destCharCounts) {
            for (int i = 0; i < destCharCounts.length; i++) {
                if (destCharCounts[i] > sourceCharCounts[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    class WordSubsetsAccepted implements WordSubsets {

        @Override
        public List<String> wordSubsets(String[] words1, String[] words2) {
            // merged frequency table of individual words in words2[]
            // this information is then needed to check whether words1[i] is a universal string
            final var counts2 = new int[26];
            for (var word2 : words2) {
                // frequency table of word b
                final var counts = counts(word2);
                // merge frequencies, i.e. for each character in the alphabet, record the maximum frequency
                // across all words in words2[]
                for (var i = 0; i < 26; i++) {
                    counts2[i] = Math.max(counts2[i], counts[i]);
                }
            }

            final var ans = new ArrayList<String>();
            for (var word1 : words1) {
                // frequency table of word word1
                final var counts1 = counts(word1);
                if (isUniversal(counts1, counts2)) {
                    // there are enough characters in word `word1` to cover every word in words2[],
                    // therefore `word1` is word1 universal word
                    ans.add(word1);
                }
            }
            return ans;
        }

        private int[] counts(String s) {
            final var counts = new int[26];
            for (var i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }
            return counts;
        }

        private boolean isUniversal(int[] srcCounts, int[] dstCounts) {
            for (var i = 0; i < 26; i++) {
                if (dstCounts[i] > srcCounts[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
