package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/">Count Binary Substrings</a>
 * <p>
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * Note:
 * <ul>
 *  <li>s.length will be between 1 and 50,000.</li>
 *  <li>s will only consist of "0" or "1" characters.</li>
 * </ul>
 */
public class CountBinarySubstrings {

    // O(N) time | O(1) space
    public int countBinarySubstrings(String s) {
        // Let group be a contiguous sequence of 0's (00...0) or 1's (11...1).
        // Given two groups G1 = 000... and G2 = 11..., the number of substrings formed from concatenated G1 + G2 string
        // that have the same number of 0's and 1's is N = min(G1.length, G2.length).
        // Applying the above formula to all (G[i], G[i + 1]) pairs gives us the final count.
        int prevGroupLength = -1;
        int currGroupLength = 1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (prevGroupLength != -1) {
                    count += Math.min(prevGroupLength, currGroupLength);
                }
                prevGroupLength = currGroupLength;
                currGroupLength = 1;
            } else {
                currGroupLength++;
            }
        }
        count += (prevGroupLength > 0) ? Math.min(prevGroupLength, currGroupLength) : 0;
        return count;
    }
}
