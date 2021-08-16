package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3891/">Minimum Window Substring (Hard)</a>
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
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // frequencies of characters in string t
        Map<Character, Integer> tCounts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCounts.put(t.charAt(i), tCounts.getOrDefault(t.charAt(i), 0) + 1);
        }

        // boundaries of the sliding window
        int left = 0; // inclusive
        int right = 0; // exclusive

        // frequencies of characters in the sliding window s[left:right)
        Map<Character, Integer> windowCounts = new HashMap<>();

        // answer is s[start:end) substring
        int start = -1; // inclusive
        int end = -1; // exclusive
        int minLength = Integer.MAX_VALUE;

        while (right <= s.length()) {
            // If the sliding window s[left:right) contains all characters of t,
            // shrink it by advancing the left pointer;
            // otherwise expand the window by advancing the right pointer.
            if (isValidWindow(windowCounts, tCounts)) {
                // check if we found a better solution
                if (right - left < minLength) {
                    start = left;
                    end = right;
                    minLength = right - left;
                }

                // remove character s[left] from the sliding window
                char c = s.charAt(left);
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) - 1);
                left++;
            } else {
                if (right == s.length()) {
                    break;
                }

                // add character s[right] to the sliding window
                char c = s.charAt(right);
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
                right++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(start, end);
    }

    /**
     * Checks if the sliding window s[left: right) contains all the characters of string t.
     *
     * @param windowCounts the frequencies of characters of the sliding window s[left:right).
     * @param tCounts      the frequencies of characters of string t.
     * @return true if the sliding window s[left:right) contains all the characters of string t.
     */
    private boolean isValidWindow(Map<Character, Integer> windowCounts, Map<Character, Integer> tCounts) {
        for (Map.Entry<Character, Integer> entry : tCounts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (!windowCounts.containsKey(c) || windowCounts.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}
