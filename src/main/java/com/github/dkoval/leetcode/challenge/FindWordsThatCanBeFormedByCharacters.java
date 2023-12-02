package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">Find Words That Can Be Formed by Characters</a>
 * <p>
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 1000</li>
 *  <li>1 <= words[i].length, chars.length <= 100</li>
 *  <li>words[i] and chars consist of lowercase English letters</li>
 * </ul>
 */
public interface FindWordsThatCanBeFormedByCharacters {

    int countCharacters(String[] words, String chars);

    class FindWordsThatCanBeFormedByCharactersRev1 implements FindWordsThatCanBeFormedByCharacters {

        @Override
        public int countCharacters(String[] words, String chars) {
            int ans = 0;
            int[] given = frequencies(chars);
            for (String word : words) {
                if (isGood(word, given)) {
                    ans += word.length();
                }
            }
            return ans;
        }

        private int[] frequencies(String s) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                freq[index]++;
            }
            return freq;
        }

        private boolean isGood(String s, int[] given) {
            int[] freq = frequencies(s);
            for (int i = 0; i < 26; i++) {
                if (freq[i] > given[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
