package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-substrings-with-only-1s/">Number of Substrings With Only 1s</a>
 * <p>
 * Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large,
 * return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface NumberOfSubstringsWithOnly1s {

    int MOD = 1_000_000_007;

    int numSub(String s);

    class NumberOfSubstringsWithOnly1sRev1 implements NumberOfSubstringsWithOnly1s {

        @Override
        public int numSub(String s) {
            final var n = s.length();

            var total = 0;
            var index = 0;
            while (index < n) {
                if (s.charAt(index) == '1') {
                    total++;
                    total %= MOD;
                    var count = 1;
                    while (index + 1 < n && s.charAt(index + 1) == '1') {
                        count++;
                        total += count;
                        total %= MOD;
                        index++;
                    }
                }
                index++;
            }
            return total;
        }
    }

    class NumberOfSubstringsWithOnly1sRev2 implements NumberOfSubstringsWithOnly1s {

        @Override
        public int numSub(String s) {
            final var n = s.length();

            var total = 0;
            var index = 0;
            while (index < n) {
                if (s.charAt(index) == '0') {
                    index++;
                    continue;
                }

                var count = 0;
                while (index < n && s.charAt(index) == '1') {
                    count++;
                    total += count;
                    total %= MOD;
                    index++;
                }
            }
            return total;
        }
    }
}
