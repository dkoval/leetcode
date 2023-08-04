package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-break/">Word Break</a>
 * <p>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 300</li>
 *  <li>1 <= wordDict.length <= 1000</li>
 *  <li>1 <= wordDict[i].length <= 20</li>
 *  <li>s and wordDict[i] consist of only lowercase English letters.</li>
 *  <li>All the strings of wordDict are unique.</li>
 * </ul>
 */
public interface WordBreak {

    boolean wordBreak(String s, List<String> wordDict);

    // O(N^2) time, O(N) space
    class WordBreakDPTopDownRev1 implements WordBreak {

        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            return canBreak(s, dict, 0, new HashMap<>());
        }

        private boolean canBreak(String s, Set<String> dict, int start, Map<String, Boolean> cache) {
            int n = s.length();

            if (start >= n) {
                return true;
            }

            String suffix = s.substring(start, n);
            if (cache.containsKey(suffix)) {
                return cache.get(suffix);
            }

            boolean ans = false;
            for (int end = n - 1; end >= start; end--) {
                String word = s.substring(start, end + 1);
                if (dict.contains(word) && canBreak(s, dict, end + 1, cache)) {
                    ans = true;
                    break;
                }
            }

            cache.put(suffix, ans);
            return ans;
        }
    }

    class WordBreakDPTopDownRev2 implements WordBreak {

        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();

            Set<String> dict = new HashSet<>(wordDict);
            if (dict.contains(s)) {
                return true;
            }

            // memo[i] - whether suffix s[i:] can be broken down into words from `dict`
            Boolean[] memo = new Boolean[n];
            return canBreak(s, dict, 0, memo);
        }

        // whether suffix s[idx:] can be broken down into words from `wordDict`
        private boolean canBreak(String s, Set<String> wordDict, int idx, Boolean[] memo) {
            if (idx == s.length()) {
                return true;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            for (int i = idx; i < s.length(); i++) {
                String word = s.substring(idx, i + 1);
                if (wordDict.contains(word) && canBreak(s, wordDict, i + 1, memo)) {
                    return memo[idx] = true;
                }
            }
            return memo[idx] = false;
        }
    }
}
