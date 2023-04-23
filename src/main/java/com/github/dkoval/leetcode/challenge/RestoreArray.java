package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/restore-the-array/">Restore The Array</a>
 * <p>
 * A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed
 * as a string of digits s and all we know is that all integers in the array were in the range [1, k] and there are no leading zeros in the array.
 * <p>
 * Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of only digits and does not contain leading zeros.</li>
 *  <li>1 <= k <= 10^9
 * </ul>
 */
public interface RestoreArray {

    int MOD = 1_000_000_007;

    int numberOfArrays(String s, int k);

    // O(N * logK) time | O(N) space
    class RestoreArrayDPTopDown implements RestoreArray {

        @Override
        public int numberOfArrays(String s, int k) {
            int n = s.length();

            // DP: top-down
            // dp[i] - the number of the possible arrays that can be printed as s[i : ]
            Integer[] dp = new Integer[n];
            return count(s, k, 0, dp);
        }

        private int count(String s, int k, int start, Integer[] dp) {
            int n = s.length();

            if (start == n) {
                return 1;
            }

            // skip leading 0's
            if (s.charAt(start) == '0') {
                return 0;
            }

            // already solved?
            if (dp[start] != null) {
                return dp[start];
            }

            int count = 0;
            // number obtained from [start : i]
            long x = 0;
            for (int i = start; i < n; i++) {
                x *= 10;
                x += s.charAt(i) - '0';

                if (x > k) {
                    break;
                }

                // put a whitespace after s[i] digit
                count += count(s, k, i + 1, dp);
                count %= MOD;
            }

            // cache and return the answer
            return dp[start] = count;
        }
    }
}
