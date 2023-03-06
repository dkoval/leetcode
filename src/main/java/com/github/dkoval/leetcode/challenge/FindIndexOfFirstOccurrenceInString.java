package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">Find the Index of the First Occurrence in a String</a>
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= haystack.length, needle.length <= 10^4</li>
 *  <li>haystack and needle consist of only lowercase English characters.</li>
 * </ul>
 */
public interface FindIndexOfFirstOccurrenceInString {

    int strStr(String haystack, String needle);

    // O((N - M + 1) * M) time | O(1) space
    class FindIndexOfFirstOccurrenceInStringRev1 implements FindIndexOfFirstOccurrenceInString {

        @Override
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();

            // sliding window of length m
            for (int start = 0; start <= n - m; start++) {
                boolean matches = true;
                for (int i = 0; i < m; i++) {
                    if (haystack.charAt(start + i) != needle.charAt(i)) {
                        matches = false;
                        break;
                    }
                }

                if (matches) {
                    return start;
                }
            }
            return -1;
        }
    }
}
