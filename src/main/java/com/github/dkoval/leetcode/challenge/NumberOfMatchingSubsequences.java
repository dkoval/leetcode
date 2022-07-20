package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-matching-subsequences/">Number of Matching Subsequences</a>
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
 *  <li>s and words[i] consist of only lowercase English letters</li>
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
            int si = -1; // current index in string s
            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                if (!indices.containsKey(w)) {
                    return false;
                }

                List<Integer> list = indices.get(w);
                int idx = indexOfFirstElementGreaterThan(list, si);
                if (idx == list.size()) {
                    return false;
                }

                si = list.get(idx);
            }
            return true;
        }

        private int indexOfFirstElementGreaterThan(List<Integer> nums, int target) {
            int left = 0;
            int right = nums.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums.get(mid) <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right + 1;
        }
    }
}
