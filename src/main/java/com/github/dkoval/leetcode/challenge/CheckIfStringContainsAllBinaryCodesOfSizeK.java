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
public abstract class CheckIfStringContainsAllBinaryCodesOfSizeK {

    public abstract boolean hasAllCodes(String s, int k);

    // Submission fails with Time Limit Exceeded error
    public static class CheckIfStringContainsAllBinaryCodesOfSizeKTLE extends CheckIfStringContainsAllBinaryCodesOfSizeK {

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

    // O(N) time | O(M) space, where N == s.length(), M == 2^k
    public static class CheckIfStringContainsAllBinaryCodesOfSizeKAccepted extends CheckIfStringContainsAllBinaryCodesOfSizeK {

        public boolean hasAllCodes(String s, int k) {
            // Sliding window: for each i in range [0, N), where N is the length of string s,
            // generate substrings of length k starting at index i
            Set<String> binCodes = new HashSet<>();
            for (int i = 0; i <= s.length() - k; i++) {
                String binCode = s.substring(i, i + k);
                binCodes.add(binCode);
            }
            // D oes the set contain all possible 2^k substring of length k?
            return binCodes.size() == (1 << k);
        }
    }
}
