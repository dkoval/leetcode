package com.github.dkoval.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">First Unique Character in a String</a>
 * <p>
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of only lowercase English letters</li>
 * </ul>
 */
public interface FirstUniqueCharacterInString {

    int firstUniqChar(String s);

    // O(N) time | O(1) space
    class FirstUniqueCharacterInStringRev1 implements FirstUniqueCharacterInString {

        public int firstUniqChar(String s) {
            int n = s.length();
            int[] counts = new int[26];

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                counts[c - 'a']++;
            }

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (counts[c - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    // O(N) time | O(1) space
    class FirstUniqueCharacterInStringRev2 implements FirstUniqueCharacterInString {

        @Override
        public int firstUniqChar(String s) {
            int n = s.length();

            Map<Character,  CharInfo> seen = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                final int index = i;
                seen.computeIfAbsent(c, __ -> new CharInfo(index, 0)).count++;
            }

            for (CharInfo info : seen.values()) {
                if (info.count == 1) {
                    return info.firstIndex;
                }
            }
            return -1;
        }

        private static class CharInfo {
            final int firstIndex;
            int count;

            CharInfo(int firstIndex, int count) {
                this.firstIndex = firstIndex;
                this.count = count;
            }
        }
    }
}
