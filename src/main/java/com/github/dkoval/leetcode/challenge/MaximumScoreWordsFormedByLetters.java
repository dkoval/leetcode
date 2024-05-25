package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-score-words-formed-by-letters/">Maximum Score Words Formed by Letters (Hard)</a>
 * <p>
 * Given a list of words, list of  single letters (might be repeating) and score of every character.
 * <p>
 * Return the maximum score of any valid set of words formed by using the given letters
 * (words[i] cannot be used two or more times).
 * <p>
 * It is not necessary to use all characters in letters and each letter can only be used once.
 * Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 14</li>
 *  <li>1 <= words[i].length <= 15</li>
 *  <li>1 <= letters.length <= 100</li>
 *  <li>letters[i].length == 1</li>
 *  <li>score.length == 26</li>
 *  <li>0 <= score[i] <= 10</li>
 *  <li>words[i], letters[i] contains only lower case English letters</li>
 * </ul>
 */
public interface MaximumScoreWordsFormedByLetters {

    int maxScoreWords(String[] words, char[] letters, int[] scores);

    class MaximumScoreWordsFormedByLettersRev1 implements MaximumScoreWordsFormedByLetters {

        @Override
        public int maxScoreWords(String[] words, char[] letters, int[] scores) {
            int n = words.length;

            int[] letterCounts = counts(letters);
            int[][] wordLetterCounts = new int[n][];
            for (int i = 0; i < n; i++) {
                wordLetterCounts[i] = counts(words[i].toCharArray());
            }

            // idea: backtracking
            return calc(wordLetterCounts, letterCounts, scores, 0, 0);
        }

        private int[] counts(char[] letters) {
            int[] counts = new int[26];
            for (char c : letters) {
                counts[c - 'a']++;
            }
            return counts;
        }

        private int calc(int[][] wordLetterCounts, int[] letterCounts, int[] scores, int index, int currScore) {
            if (index == wordLetterCounts.length) {
                return currScore;
            }

            int bestScore = -1;

            // option #1: skip words[i]
            bestScore = Math.max(bestScore, calc(wordLetterCounts, letterCounts, scores, index + 1, currScore));

            // option #2: take words[i], if there're enough letters in the bank
            if (canFormWord(wordLetterCounts, index, letterCounts)) {
                // form words[i] and increase the score
                int delta = formWord(wordLetterCounts, index, letterCounts, scores, false);
                bestScore = Math.max(bestScore, calc(wordLetterCounts, letterCounts, scores, index + 1, currScore + delta));
                // backtrack
                formWord(wordLetterCounts, index, letterCounts, scores, true);
            }
            return bestScore;
        }

        private boolean canFormWord(int[][] wordLetterCounts, int index, int[] letterCounts) {
            for (int i = 0; i < 26; i++) {
                if (wordLetterCounts[index][i] > letterCounts[i]) {
                    return false;
                }
            }
            return true;
        }

        private int formWord(int[][] wordLetterCounts, int index, int[] letterCounts, int[] scores, boolean undo) {
            int score = 0;
            int sign = undo ? -1 : 1;
            for (int i = 0; i < 26; i++) {
                letterCounts[i] -= wordLetterCounts[index][i] * sign;
                score += wordLetterCounts[index][i] * scores[i] * sign;
            }
            return score;
        }
    }
}
