package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/">Minimum Number of Steps to Make Two Strings Anagram</a>
 * <p>
 * You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 * <p>
 * Return the minimum number of steps to make t an anagram of s.
 * <p>
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 * 10^4</li>
 *  <li>s.length == t.length</li>
 *  <li>s and t consist of lowercase English letters only</li>
 * </ul>
 */
public interface MinimumNumberOfStepsToMakeTwoStringsAnagram {

    int minSteps(String s, String t);

    // O(N) time | O(ALPHA) = O(1) space
    class MinimumNumberOfStepsToMakeTwoStringsAnagramRev1 implements MinimumNumberOfStepsToMakeTwoStringsAnagram {

        @Override
        public int minSteps(String s, String t) {
            int n = s.length();

            int[][] counts = new int[2][26];
            for (int i = 0; i < n; i++) {
                counts[0][s.charAt(i) - 'a']++;
                counts[1][t.charAt(i) - 'a']++;
            }

            int steps = 0;
            for (int i = 0; i < 26; i++) {
                if (counts[1][i] < counts[0][i]) {
                    steps += counts[0][i] - counts[1][i];
                }
            }
            return steps;
        }
    }
}
