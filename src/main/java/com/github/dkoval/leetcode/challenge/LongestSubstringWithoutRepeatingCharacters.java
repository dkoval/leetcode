package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/">Longest Substring Without Repeating Characters</a>
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (window.containsKey(c)) {
                // shrink the window
                int idx = window.get(c);
                for (int i = start; i <= idx; i++) {
                    window.remove(s.charAt(i));
                }
                start = idx + 1;
            }
            window.put(c, end);
            maxLength = Math.max(maxLength, window.size());
        }
        return maxLength;
    }
}
