package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3921/">Longest Uncommon Subsequence II</a>
 * <p>
 * Given an array of strings strs, return the length of the longest uncommon subsequence between them.
 * If the longest uncommon subsequence does not exist, return -1.
 * <p>
 * An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
 * <p>
 * A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
 * <p>
 * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc".
 * Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= strs.length <= 50</li>
 *  <li>1 <= strs[i].length <= 10</li>
 *  <li>strs[i] consists of lowercase English letters</li>
 * </ul>
 */
public class LongestUncommonSubsequence2 {

    // O(N^2 * L) time, where L is the average length of strs[i] | O(1) space
    public int findLUSlength(String[] strs) {
        int longest = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean ok = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                longest = Math.max(longest, strs[i].length());
            }
        }
        return longest;
    }

    // Is s1 a subsequence of s2?
    private boolean isSubsequence(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1 = "abcd" is a subsequence of s2 if s2 is of the following pattern:
        // s2 = "...a...b...c...d..."
        int ptr2 = 0;
        for (int ptr1 = 0; ptr1 < s1.length(); ptr1++) {
            while (ptr2 < s2.length() && s1.charAt(ptr1) != s2.charAt(ptr2)) {
                ptr2++;
            }

            if (ptr2 == s2.length()) {
                return false;
            }
            ptr2++;
        }
        return true;
    }
}
