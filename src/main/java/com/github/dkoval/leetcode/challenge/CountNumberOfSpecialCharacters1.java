package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-special-characters-i/">Count the Number of Special Characters I</a>
 * <p>
 * You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
 * <p>
 * Return the number of special letters in word.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 50</li>
 *  <li>word consists of only lowercase and uppercase English letters.</li>
 * </ul>
 */
public interface CountNumberOfSpecialCharacters1 {

    int numberOfSpecialChars(String word);

    class CountNumberOfSpecialCharacters1Rev1 implements CountNumberOfSpecialCharacters1 {

        @Override
        public int numberOfSpecialChars(String word) {
            final var n = word.length();

            final var lower = new boolean[26];
            final var upper = new boolean[26];
            for (var i = 0; i < n; i++) {
                final var c = word.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    lower[c - 'a'] = true;
                    continue;
                }

                if (c >= 'A' && c <= 'Z') {
                    upper[c - 'A'] = true;
                }
            }

            var count = 0;
            for (var i = 0; i < 26; i++) {
                if (lower[i] && upper[i]) {
                    count++;
                }
            }
            return count;
        }
    }
}
