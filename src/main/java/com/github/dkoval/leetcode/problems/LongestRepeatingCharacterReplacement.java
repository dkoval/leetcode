package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Longest Repeating Character Replacement</a>
 * <p>
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of only uppercase English letters</li>
 *  <li>0 <= k <= s.length</li>
 * </ul>
 */
public class LongestRepeatingCharacterReplacement {

    // O(N) time | O(ALPHA) space, ALPHA = 26
    public int characterReplacement(String s, int k) {
        int n = s.length();

        // 26 uppercase English letters
        int[] counts = new int[26];
        int maxFreq = 0;

        int ans = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            maxFreq = Math.max(maxFreq, ++counts[s.charAt(end) - 'A']);

            // shrink the sliding window if no more characters can be replaced
            while (end - start + 1 - maxFreq > k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
