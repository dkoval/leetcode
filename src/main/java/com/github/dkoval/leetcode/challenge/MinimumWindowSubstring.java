package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring (Hard)</a>
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
 * every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == s.length</li>
 *  <li>n == t.length</li>
 *  <li>1 <= m, n <= 10^5</li>
 *  <li>s and t consist of uppercase and lowercase English letters.</li>
 * </ul>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public interface MinimumWindowSubstring {

    String minWindow(String s, String t);

    // O(M + N) time | O(ALPHA) = O(1) space
    class MinimumWindowSubstringRev1 implements MinimumWindowSubstring {

        @Override
        public String minWindow(String s, String t) {
            if (t.length() > s.length()) {
                return "";
            }

            // frequencies of characters in string t
            Map<Character, Integer> tCounts = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                tCounts.put(c, tCounts.getOrDefault(c, 0) + 1);
            }

            // frequencies of characters in a sliding window s[left : right]
            Map<Character, Integer> windowCounts = new HashMap<>();

            int bestStart = -1;
            int bestLength = s.length() + 1;

            // boundaries of a sliding window (both inclusive)
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                char last = s.charAt(right);
                windowCounts.put(last, windowCounts.getOrDefault(last, 0) + 1);

                // try to shrink a valid sliding window from the left
                if (valid(windowCounts, tCounts)) {
                    while (left <= right) {
                        char first = s.charAt(left);
                        if (windowCounts.get(first) <= tCounts.getOrDefault(first, 0)) {
                            break;
                        }
                        windowCounts.put(first, windowCounts.get(first) - 1);
                        left++;
                    }

                    if (right - left + 1 < bestLength) {
                        bestStart = left;
                        bestLength = right - left + 1;
                    }
                }
            }
            return (bestStart == -1) ? "" : s.substring(bestStart, bestStart + bestLength);
        }

        private boolean valid(Map<Character, Integer> windowCounts, Map<Character, Integer> tCounts) {
            // valid IFF: for all c in tCounts, windowCounts[c] > tCounts
            for (char c : tCounts.keySet()) {
                if (windowCounts.getOrDefault(c, 0) < tCounts.get(c)) {
                    return false;
                }
            }
            return true;
        }
    }
}
