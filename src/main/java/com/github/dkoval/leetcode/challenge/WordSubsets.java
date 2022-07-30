package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-subsets/">Word Subsets</a>
 * <p>
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * <p>
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 * <p>
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * <p>
 * Return a list of all universal words in A.  You can return the words in any order.
 * <p>
 * Note:
 * <ul>
 *     <li>1 <= A.length, B.length <= 10000</li>
 *     <li>1 <= A[i].length, B[i].length <= 10</li>
 *     <li>A[i] and B[i] consist only of lowercase letters</li>
 *     <li>All words in A[i] are unique: there isn't i != j with A[i] == A[j]</li>
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
        public List<String> wordSubsets(String[] A, String[] B) {
            // merged frequency table of individual words in B[]
            // this information is then needed to check whether A[i] is a universal string
            int[] bCounts = new int[26];
            for (String b : B) {
                // frequency table of word b
                int[] counts = counts(b);
                // merge frequencies, i.e. for each character in the alphabet, record the maximum frequency
                // across all words in B[]
                for (int i = 0; i < 26; i++) {
                    bCounts[i] = Math.max(bCounts[i], counts[i]);
                }
            }

            List<String> ans = new ArrayList<>();
            for (String a : A) {
                // frequency table of word a
                int[] aCounts = counts(a);
                if (isSubset(aCounts, bCounts)) {
                    // there are enough characters in word `a` to cover every word in B[],
                    // therefore `a` is a universal word
                    ans.add(a);
                }
            }
            return ans;
        }

        private int[] counts(String s) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }
            return counts;
        }

        private boolean isSubset(int[] srcCounts, int[] dstCounts) {
            for (int i = 0; i < 26; i++) {
                if (dstCounts[i] > srcCounts[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
