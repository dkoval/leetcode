package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/reverse-prefix-of-word/">Reverse Prefix of Word</a>
 * <p>
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends
 * at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
 * <p>
 * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
 * The resulting string will be "dcbaefd".
 * <p>
 * Return the resulting string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 250</li>
 *  <li>word consists of lowercase English letters.</li>
 *  <li>ch is a lowercase English letter.</li>
 * </ul>
 */
public interface ReversePrefixOfWord {

    String reversePrefix(String word, char ch);

    class ReversePrefixOfWordRev1 implements ReversePrefixOfWord {

        @Override
        public String reversePrefix(String word, char ch) {
            int n = word.length();

            int end = 0;
            while (end < n && word.charAt(end) != ch) {
                end++;
            }

            if (end == n) {
                return word;
            }

            StringBuilder prefix = new StringBuilder();
            for (int i = end; i >= 0; i--) {
                prefix.append(word.charAt(i));
            }

            return prefix.append(word.substring(end + 1)).toString();
        }
    }
}
