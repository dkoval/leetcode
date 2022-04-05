package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= s.length <= 5 * 10^4</li>
 *  <li>s consists of English letters, digits, symbols and spaces</li>
 * </ul>
 */
public interface LongestSubstringWithoutRepeatingCharacters {

    int lengthOfLongestSubstring(String s);

    class LongestSubstringWithoutRepeatingCharactersRev1 implements LongestSubstringWithoutRepeatingCharacters {

        // O(N) time | O(min(alphabet, N)) space
        @Override
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            Map<Character, Integer> window = new HashMap<>();
            int start = 0;
            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (window.containsKey(c)) {
                    int idx = window.get(c);
                    // shrink the window, i.e. remove characters before s[idx + 1]
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

    class LongestSubstringWithoutRepeatingCharactersRev2 implements LongestSubstringWithoutRepeatingCharacters {

        // O(N) time | O(min(alphabet, N)) space
        @Override
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            Map<Character, Integer> seen = new HashMap<>();
            int start = 0;
            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (seen.containsKey(c)) {
                    int idx = seen.get(c);
                    if (idx >= start) {
                        maxLength = Math.max(maxLength, end - start);
                        start = idx + 1;
                    }
                }
                seen.put(c, end);
            }

            if (start < s.length()) {
                maxLength = Math.max(maxLength, s.length() - start);
            }
            return maxLength;
        }
    }

    class LongestSubstringWithoutRepeatingCharactersRev3 implements LongestSubstringWithoutRepeatingCharacters {

        // O(N) time | O(min(alphabet, N)) space
        @Override
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            Map<Character, Integer> seen = new HashMap<>();
            int start = 0;
            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (seen.containsKey(c)) {
                    int idx = seen.get(c);
                    if (idx >= start) {
                        start = idx + 1;
                    }
                }
                seen.put(c, end);
                maxLength = Math.max(maxLength, end - start + 1);
            }
            return maxLength;
        }
    }
}
