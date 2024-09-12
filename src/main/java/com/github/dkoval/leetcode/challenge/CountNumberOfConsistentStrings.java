package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-consistent-strings/">Count the Number of Consistent Strings</a>
 * <p>
 * You are given a string allowed consisting of distinct characters and an array of strings words.
 * A string is consistent if all characters in the string appear in the string allowed.
 * <p>
 * Return the number of consistent strings in the array words.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 10^4</li>
 *  <li>1 <= allowed.length <= 26</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>The characters in allowed are distinct</li>
 *  <li>words[i] and allowed contain only lowercase English letters</li>
 * </ul>
 */
public interface CountNumberOfConsistentStrings {

    int countConsistentStrings(String allowed, String[] words);

    class CountNumberOfConsistentStringsRev1 implements CountNumberOfConsistentStrings {

        @Override
        public int countConsistentStrings(String allowed, String[] words) {
            Set<Character> good = new HashSet<>();
            for (int i = 0; i < allowed.length(); i++) {
                good.add(allowed.charAt(i));
            }

            int count = 0;
            for (String word : words) {
                if (consistent(word, good)) {
                    count++;
                }
            }
            return count;
        }

        private boolean consistent(String word, Set<Character> good) {
            for (int i = 0; i < word.length(); i++) {
                if (!good.contains(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
