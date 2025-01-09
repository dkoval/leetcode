package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/counting-words-with-a-given-prefix/">Counting Words With a Given Prefix</a>
 * <p>
 * You are given an array of strings words and a string pref.
 * <p>
 * Return the number of strings in words that contain pref as a prefix.
 * <p>
 * A prefix of a string s is any leading contiguous substring of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length, pref.length <= 100</li>
 *  <li>words[i] and pref consist of lowercase English letters.</li>
 * </ul>
 */
public interface CountingWordsWithGivenPrefix {

    int prefixCount(String[] words, String pref);

    // O(W * P) time | O(1) space
    class CountingWordsWithGivenPrefixRev1 implements CountingWordsWithGivenPrefix {

        @Override
        public int prefixCount(String[] words, String pref) {
            var count = 0;
            for (var word : words) {
                if (prefix(word, pref)) {
                    count++;
                }
            }
            return count;
        }

        private boolean prefix(String word, String pref) {
            if (word.length() < pref.length()) {
                return false;
            }

            for (var i = 0; i < pref.length(); i++) {
                if (word.charAt(i) != pref.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
