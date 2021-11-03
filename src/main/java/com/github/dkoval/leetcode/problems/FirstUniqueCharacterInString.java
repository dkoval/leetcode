package com.github.dkoval.leetcode.problems;

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
public class FirstUniqueCharacterInString {

    private static final int ALPHABET_SIZE = 26;

    // O(N) time | O(1) space
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] counts = new int[ALPHABET_SIZE];

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
