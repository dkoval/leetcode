package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3584/">Longest Substring with At Most K Distinct Characters</a>
 * <p>
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] charFreq = new int[256];
        int l = 0, r = 0; // sliding window boundaries
        int numDistinctChars = 0;
        int maxLength = 0;
        while (r < s.length()) {
            char rc = s.charAt(r);
            if (charFreq[rc] == 0) {
                numDistinctChars++;
            }
            charFreq[rc]++;
            while (numDistinctChars > k) {
                char lc = s.charAt(l);
                charFreq[lc]--;
                if (charFreq[lc] == 0) {
                    numDistinctChars--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
