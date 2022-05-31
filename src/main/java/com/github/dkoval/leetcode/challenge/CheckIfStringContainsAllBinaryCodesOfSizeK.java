package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3669/">Check If a String Contains All Binary Codes of Size K</a>
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
}
