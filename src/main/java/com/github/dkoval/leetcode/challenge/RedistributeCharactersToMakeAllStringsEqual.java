package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/">Redistribute Characters to Make All Strings Equal</a>
 * <p>
 * You are given an array of strings words (0-indexed).
 * <p>
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
 * <p>
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 100</li>
 *  <li>words[i] consists of lowercase English letters</li>
 * </ul>
 */
public interface RedistributeCharactersToMakeAllStringsEqual {

    boolean makeEqual(String[] words);

    class RedistributeCharactersToMakeAllStringsEqualRev1 implements RedistributeCharactersToMakeAllStringsEqual {

        @Override
        public boolean makeEqual(String[] words) {
            int n = words.length;
            if (n == 1) {
                return true;
            }

            int[] freq = new int[26];
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    freq[c - 'a']++;
                }
            }

            for (int x : freq) {
                if (x != 0 && x % n != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
