package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/">Number of Matching Subsequences</a>
 * <p>
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 * 10^4</li>
 *  <li>1 <= words.length <= 5000</li>
 *  <li>1 <= words[i].length <= 50</li>
 *  <li>s and words[i] consist of only lowercase English letters.</li>
 * </ul>
 */
public interface NumberOfMatchingSubsequences {

    int numMatchingSubseq(String s, String[] words);

    class NumberOfMatchingSubsequencesBruteForceTLE implements NumberOfMatchingSubsequences {

        @Override
        public int numMatchingSubseq(String s, String[] words) {
            int count = 0;
            for (String word : words) {
                if (word.length() > s.length()) {
                    continue;
                }

                if (isSubsequence(word, s)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isSubsequence(String word, String s) {
            int i = 0;
            for (int j = 0; j < word.length(); j++) {
                while (i < s.length() && s.charAt(i) != word.charAt(j)) {
                    i++;
                }
                if (i == s.length()) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }

    class NumberOfMatchingSubsequencesUsingMapWithBinarySearch implements NumberOfMatchingSubsequences {

        @Override
        public int numMatchingSubseq(String s, String[] words) {
            Map<Character, List<Integer>> indices = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                indices.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
            }

            int count = 0;
            for (String word : words) {
                if (word.length() > s.length()) {
                    continue;
                }

                if (isSubsequence(word, indices)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isSubsequence(String word, Map<Character, List<Integer>> indices) {
            int lastCharIdx = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!indices.containsKey(c)) {
                    return false;
                }
                List<Integer> list = indices.get(c);
                int idx = indexOfFirstElementGreaterThan(list, lastCharIdx);
                if (idx == list.size()) {
                    return false;
                }
                lastCharIdx = list.get(idx);
            }
            return true;
        }

        private int indexOfFirstElementGreaterThan(List<Integer> list, int x) {
            int l = 0, r = list.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid) <= x) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return r + 1;
        }
    }
}
