package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/">Uncommon Words from Two Sentences</a>
 * <p>
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s1.length, s2.length <= 200</li>
 *  <li>s1 and s2 consist of lowercase English letters and spaces.</li>
 *  <li>s1 and s2 do not have leading or trailing spaces.</li>
 *  <li>All the words in s1 and s2 are separated by a single space.</li>
 * </ul>
 */
public interface UncommonWordsFromTwoSentences {

    String[] uncommonFromSentences(String s1, String s2);

    class UncommonWordsFromTwoSentencesRev1 implements UncommonWordsFromTwoSentences {

        @Override
        public String[] uncommonFromSentences(String s1, String s2) {
            List<String> ans = new ArrayList<>();
            Map<String, Integer> w1 = getWordCounts(s1);
            Map<String, Integer> w2 = getWordCounts(s2);
            uniqueWords(w1, w2, ans);
            uniqueWords(w2, w1, ans);
            return ans.toArray(String[]::new);
        }

        private Map<String, Integer> getWordCounts(String s) {
            String[] words = s.split(" ");
            Map<String, Integer> ans = new HashMap<>();
            for (String word : words) {
                ans.put(word, ans.getOrDefault(word, 0) + 1);
            }
            return ans;
        }

        private void uniqueWords(Map<String, Integer> w1, Map<String, Integer> w2, List<String> ans) {
            for (Map.Entry<String, Integer> entry : w1.entrySet()) {
                if (!w2.containsKey(entry.getKey()) && entry.getValue() == 1) {
                    ans.add(entry.getKey());
                }
            }
        }
    }
}
