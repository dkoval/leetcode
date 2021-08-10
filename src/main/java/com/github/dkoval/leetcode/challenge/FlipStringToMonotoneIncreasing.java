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
public interface FlipStringToMonotoneIncreasing {

    int minFlipsMonoIncr(String s);

    // O(N) time | O(N) space
    class FlipStringToMonotoneIncreasingUsingPrefixSum implements FlipStringToMonotoneIncreasing {

        @Override
        public int minFlipsMonoIncr(String s) {
            int n = s.length();
            int[] prefixSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) - '0');
            }

            // Target string s' consists of two parts: left - X number of 0's and right - (N - X) number of 1's
            int result = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                // Number of 1's in the left half s[0 : i - 1] to flip 1 -> 0
                int numOnesLeft = prefixSum[i];
                // Interim - number of 1's in the right part s[i : n - 1]
                int numOnesRight = prefixSum[n] - prefixSum[i];
                // Number of 0's in the right half s[i : n - 1] to flip 0 -> 1
                int numZerosRight = n - i - numOnesRight;
                // Check if a better result was found
                result = Math.min(result, numOnesLeft + numZerosRight);
            }
            return result;
        }
    }

    // O(N) time | O(1) space
    class FlipStringToMonotoneIncreasingInConstantSpace implements FlipStringToMonotoneIncreasing {

        @Override
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

            // Target string s' consists of X number of 0's followed by (N - X) number of 1's
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
}
