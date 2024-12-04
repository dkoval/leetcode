package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/">Make String a Subsequence Using Cyclic Increments</a>
 * <p>
 * You are given two 0-indexed strings str1 and str2.
 * <p>
 * In an operation, you select a set of indices in str1, and for each index i in the set, increment str1[i] to the next
 * character cyclically. That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.
 * <p>
 * Return true if it is possible to make str2 a subsequence of str1 by performing the operation at most once, and false otherwise.
 * <p>
 * Note: A subsequence of a string is a new string that is formed from the original string by deleting some (possibly none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= str1.length <= 10^5</li>
 *  <li>1 <= str2.length <= 10^5</li>
 *  <li>str1 and str2 consist of only lowercase English letters.</li>
 * </ul>
 */
public interface MakeStringSubsequenceUsingCyclicIncrements {

    boolean canMakeSubsequence(String str1, String str2);

    class MakeStringSubsequenceUsingCyclicIncrementsRev1 implements MakeStringSubsequenceUsingCyclicIncrements {

        @Override
        public boolean canMakeSubsequence(String str1, String str2) {
            var n1 = str1.length();
            var n2 = str2.length();

            if (n1 < n2) {
                return false;
            }

            var i = 0;
            var j = 0;
            while (i < n1 && j < n2) {
                var c1 = str1.charAt(i);
                var c2 = str2.charAt(j);
                if (c1 == c2 || (char) ('a' + (c1 - 'a' + 1) % 26) == c2) {
                    j++;
                }
                i++;
            }
            return j == n2;
        }
    }
}
