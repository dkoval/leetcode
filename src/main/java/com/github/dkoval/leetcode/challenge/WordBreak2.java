package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break-ii/">Word Break II (Hard)</a>
 * <p>
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word
 * is a valid dictionary word. Return all such possible sentences in any order.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 20</li>
 *  <li>1 <= wordDict.length <= 1000</li>
 *  <li>1 <= wordDict[i].length <= 10</li>
 *  <li>s and wordDict[i] consist of only lowercase English letters</li>
 *  <li>All the strings of wordDict are unique</li>
 *  <li>Input is generated in a way that the length of the answer doesn't exceed 10^5</li>
 * </ul>
 */
public interface WordBreak2 {

    List<String> wordBreak(String s, List<String> wordDict);

    class WordBreak2Rev2 implements WordBreak2 {

        @Override
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> ans = new ArrayList<>();
            calc(s, new HashSet<>(wordDict), 0, new ArrayList<>(), ans);
            return ans;
        }

        private void calc(String s, Set<String> dict, int start, List<String> words, List<String> ans) {
            if (start == s.length()) {
                if (!words.isEmpty()) {
                    String sentence = String.join(" ", words);
                    ans.add(sentence);
                }
                return;
            }

            for (int end = start; end < s.length(); end++) {
                String word = s.substring(start, end + 1);
                if (dict.contains(word)) {
                    // add word to the sentence
                    words.add(word);
                    calc(s, dict, end + 1, words, ans);
                    // backtrack
                    words.removeLast();
                }
            }
        }
    }
}
