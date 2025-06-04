package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/">Find the Lexicographically Largest String From the Box I</a>
 * <p>
 * You are given a string word, and an integer numFriends.
 * <p>
 * Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
 * <ul>
 *  <li>word is split into numFriends non-empty strings, such that no previous round has had the exact same split.</li>
 *  <li>All the split words are put into a box.</li>
 * </ul>
 * Find the lexicographically largest string from the box after all the rounds are finished.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 5 * 10^3</li>
 *  <li>word consists only of lowercase English letters.</li>
 *  <li>1 <= numFriends <= word.length</li>
 * </ul>
 */
public interface FindLexicographicallyLargestStringFromBox1 {

    String answerString(String word, int numFriends);

    class FindLexicographicallyLargestStringFromBox1Rev1 implements FindLexicographicallyLargestStringFromBox1 {

        @Override
        public String answerString(String word, int numFriends) {
            if (numFriends == 1) {
                return word;
            }

            final var n = word.length();
            final var maxLength = n - numFriends + 1;

            var best = "";
            for (var left = 0; left < n; left++) {
                final var curr = word.substring(left, Math.min(left + maxLength, n));
                if (curr.compareTo(best) > 0) {
                    best = curr;
                }
            }
            return best;
        }
    }
}
