package com.github.dkoval.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-removable-characters/">Maximum Number of Removable Characters</a>
 * <p>
 * You are given two strings s and p where p is a subsequence of s. You are also given a distinct 0-indexed integer array
 * removable containing a subset of indices of s (s is also 0-indexed).
 * <p>
 * You want to choose an integer k (0 <= k <= removable.length) such that, after removing k characters from s using the first
 * k indices in removable, p is still a subsequence of s. More formally, you will mark the character at s[removable[i]]
 * for each 0 <= i < k, then remove all marked characters and check if p is still a subsequence.
 * <p>
 * Return the maximum k you can choose such that p is still a subsequence of s after the removals.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= p.length <= s.length <= 10^5</li>
 *  <li>0 <= removable.length < s.length</li>
 *  <li>0 <= removable[i] < s.length</li>
 *  <li>p is a subsequence of s</li>
 *  <li>s and p both consist of lowercase English letters</li>
 *  <li>The elements in removable are distinct</li>
 * </ul>
 */
public interface MaximumNumberOfRemovableCharacters {

    int maximumRemovals(String s, String p, int[] removable);

    class MaximumNumberOfRemovableCharactersUsingBinarySearchRev1 implements MaximumNumberOfRemovableCharacters {

        @Override
        public int maximumRemovals(String s, String p, int[] removable) {
            // binary search k
            int left = 0;
            int right = removable.length;
            // isGood() condition:
            // TT...TFF...F
            //      ^ - answer
            // find the index of the last T (upper bound)
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (isGood(s, p, removable, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean isGood(String s, String p, int[] removable, int k) {
            Set<Integer> skip = new HashSet<>();
            for (int i = 0; i < k; i++) {
                skip.add(removable[i]);
            }

            // use sliding window to check if p is still a subsequence of s after removing characters from s
            int si = 0; // current index in s
            for (int pi = 0; pi < p.length(); pi++) {
                while (si < s.length() && (p.charAt(pi) != s.charAt(si) || skip.contains(si))) {
                    si++;
                }

                if (si == s.length()) {
                    return false;
                }
                si++;
            }
            return true;
        }
    }
}
