package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/valid-word/">Valid Word</a>
 * <p>
 * A word is considered valid if:
 * <ul>
 *  <li>It contains a minimum of 3 characters.</li>
 *  <li>It contains only digits (0-9), and English letters (uppercase and lowercase).</li>
 *  <li>It includes at least one vowel.</li>
 *  <li>It includes at least one consonant.</li>
 * </ul>
 * You are given a string word.
 * <p>
 * Return true if word is valid, otherwise, return false.
 * <p>
 * Notes:
 * <ul>
 *  <li>'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.</li>
 *  <li>A consonant is an English letter that is not a vowel.</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 20</li>
 *  <li>word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.</li>
 * </ul>
 */
public interface ValidWord {

    boolean isValid(String word);

    class ValidWordRev1 implements ValidWord {

        @Override
        public boolean isValid(String word) {
            final var n = word.length();
            if (n < 3) {
                return false;
            }

            var hasVowel = false;
            var hasConsonat = false;
            for (var i = 0; i < n; i++) {
                final var c = word.charAt(i);
                if (isDigit(c)) {
                    continue;
                }

                if (!isLetter(c)) {
                    return false;
                }

                if (isVowel(c)) {
                    hasVowel = true;
                } else {
                    hasConsonat = true;
                }
            }
            return hasVowel && hasConsonat;
        }

        private boolean isDigit(char c) {
            return (c >= '0' && c <= '9');
        }

        private boolean isLetter(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }

        private boolean isVowel(char c) {
            return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
        }
    }
}
