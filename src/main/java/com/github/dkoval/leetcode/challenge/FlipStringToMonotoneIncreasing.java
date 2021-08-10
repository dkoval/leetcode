package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/">Flip String to Monotone Increasing</a>
 * <p>
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none),
 * followed by some number of 1's (also possibly none).
 * <p>
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 * <p>
 * Return the minimum number of flips to make s monotone increasing.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 * <li>s[i] is either '0' or '1'</li>
 * </ul>
 */
public class FlipStringToMonotoneIncreasing {

    // O(N) time | O(1) space
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        // Number of 0 -> 1 flips
        int numZeroFlips = 0;
        // Number of 1 -> 0 flips, There can be up to s.count('1') number of such flips in string s.
        int numOneFlips = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                numOneFlips++;
            }
        }

        // Target string s' consists of N0 number of 0's followed by N1 number of 1's
        // s' = 00...011...1
        // To start with, turn all 1 -> 0 in s to achieve s' = 00...0, then see if we can improve the result.
        int result = numOneFlips;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                numZeroFlips++;
            } else {
                // flip 1 -> 0 is not required
                numOneFlips--;
            }
            result = Math.min(result, numZeroFlips + numOneFlips);
        }
        return result;
    }
}
