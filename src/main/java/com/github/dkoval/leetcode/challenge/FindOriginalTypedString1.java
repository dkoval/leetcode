package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-original-typed-string-i/">Find the Original Typed String I</a>
 * <p>
 * Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long,
 * resulting in a character being typed multiple times.
 * <p>
 * Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
 * <p>
 * You are given a string word, which represents the final output displayed on Alice's screen.
 * <p>
 * Return the total number of possible original strings that Alice might have intended to type.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 100</li>
 *  <li>word consists only of lowercase English letters.</li>
 * </ul>
 */
public interface FindOriginalTypedString1 {

    int possibleStringCount(String word);

    class FindOriginalTypedString1Rev1 implements FindOriginalTypedString1 {

        @Override
        public int possibleStringCount(String word) {
            final var n = word.length();

            var curr = '#';
            var total = 1;
            for (var i = 0; i < n; i++) {
                final var c = word.charAt(i);
                if (c == curr) {
                    total++;
                } else {
                    curr = c;
                }
            }
            return total;
        }
    }
}
