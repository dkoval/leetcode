package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/">Check If a String Contains All Binary Codes of Size K</a>
 * <p>
 * Given a binary string s and an integer k.
 * <p>
 * Return True if every binary code of length k is a substring of s. Otherwise, return False.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 * 10^5</li>
 *  <li>s consists of 0's and 1's only.</li>
 *  <li>1 <= k <= 20</li>
 * </ul>
 */
public interface CheckIfStringContainsAllBinaryCodesOfSizeK {

    boolean hasAllCodes(String s, int k);

    // Submission fails with TLE error
    class CheckIfStringContainsAllBinaryCodesOfSizeKTLE implements CheckIfStringContainsAllBinaryCodesOfSizeK {

        @Override
        public boolean hasAllCodes(String s, int k) {
            int max = 1 << k; // 2^k
            for (int x = 0; x < max; x++) {
                String binCode = binCode(x, k);
                if (!s.contains(binCode)) {
                    return false;
                }
            }
            return true;
        }

        private String binCode(int x, int length) {
            StringBuilder sb = new StringBuilder();
            if (x == 0) {
                sb.append('0');
                length--;
            }
            while (x != 0) {
                sb.append(x & 1);
                x >>= 1;
                length--;
            }
            // add leading zeros, if needed
            while (length-- > 0) {
                sb.append('0');
            }
            return sb.reverse().toString();
        }
    }

    class CheckIfStringContainsAllBinaryCodesOfSizeKAccepted implements CheckIfStringContainsAllBinaryCodesOfSizeK {

        public boolean hasAllCodes(String s, int k) {
            // Sliding window: for each i in [0, N - k], where N is the length of string s,
            // generate substrings s[i : i + k - 1] of length k
            int n = s.length();
            int need = 1 << k; // 2^k
            Set<String> seen = new HashSet<>();
            for (int i = 0; i <= n - k; i++) {
                String subs = s.substring(i, i + k);
                seen.add(subs);

                // early termination
                if (seen.size() == need) {
                    return true;
                }
            }
            return seen.size() == need;
        }
    }

    class CheckIfStringContainsAllBinaryCodesOfSizeKRev2 implements CheckIfStringContainsAllBinaryCodesOfSizeK {

        @Override
        public boolean hasAllCodes(String s, int k) {
            final var n = s.length();

            // generate all possible substrings of length k
            final var substrs = new HashSet<>();
            for (var start = 0; start <= n - k; start++) {
                substrs.add(s.substring(start, start + k));
                // the total number of such substrings must be 2^k
                if (substrs.size() == (1 << k)) {
                    return true;
                }
            }
            return false;
        }
    }

    class CheckIfStringContainsAllBinaryCodesOptimized implements CheckIfStringContainsAllBinaryCodesOfSizeK {

        @Override
        public boolean hasAllCodes(String s, int k) {
            int n = s.length();
            int need = 1 << k; // 2^k
            boolean[] seen = new boolean[need];

            int x = 0; // current binary number of length k
            int mask = (1 << k) - 1; // k 1's
            for (int end = 0; end < n; end++) {
                // step #1: remove starting bit of the previous k-window
                // mask here makes sure x is always k bits long. For instance:
                // 11 << 1 = 110, but (11 << 1) & 11 = 10
                //            ^^
                x = (x << 1) & mask;
                // step #2: add ending bit of the current k-window
                int bit = s.charAt(end) - '0';
                x = x | bit;

                if (end >= k - 1 && !seen[x]) {
                    seen[x] = true;
                    need--;
                }
            }
            return need == 0;
        }
    }
}
