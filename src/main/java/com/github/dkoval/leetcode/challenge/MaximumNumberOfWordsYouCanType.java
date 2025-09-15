package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-words-you-can-type/">Maximum Number of Words You Can Type</a>
 * <p>
 * There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
 * <p>
 * Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of
 * all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= text.length <= 10^4</li>
 *  <li>0 <= brokenLetters.length <= 26</li>
 *  <li>text consists of words separated by a single space without any leading or trailing spaces.</li>
 *  <li>Each word only consists of lowercase English letters.</li>
 *  <li>brokenLetters consists of distinct lowercase English letters.</li>
 * </ul>
 */
public interface MaximumNumberOfWordsYouCanType {

    int canBeTypedWords(String text, String brokenLetters);

    class MaximumNumberOfWordsYouCanTypeRev1 implements MaximumNumberOfWordsYouCanType {

        private static boolean canBeTyped(String word, String brokenLetters) {
            for (var i = 0; i < word.length(); i++) {
                if (brokenLetters.indexOf(word.charAt(i)) != -1) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int canBeTypedWords(String text, String brokenLetters) {
            final var words = text.split(" ");
            var count = 0;
            for (var word : words) {
                count += canBeTyped(word, brokenLetters) ? 1 : 0;
            }
            return count;
        }
    }
}
