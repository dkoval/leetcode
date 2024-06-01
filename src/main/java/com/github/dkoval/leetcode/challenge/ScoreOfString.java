package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/score-of-a-string/">Score of a String</a>
 * <p>
 * You are given a string s. The score of a string is defined as the sum of the absolute difference between
 * the ASCII values of adjacent characters.
 * <p>
 * Return the score of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= s.length <= 100</li>
 *  <li>s consists only of lowercase English letters</li>
 * </ul>
 */
public interface ScoreOfString {

    int scoreOfString(String s);

    class ScoreOfStringRev1 implements ScoreOfString {

        @Override
        public int scoreOfString(String s) {
            int score = 0;
            for (int i = 1; i < s.length(); i++) {
                score += Math.abs(((int) s.charAt(i)) - ((int) s.charAt(i - 1)));
            }
            return score;
        }
    }
}
