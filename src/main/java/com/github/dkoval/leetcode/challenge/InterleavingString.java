package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3765/">Interleaving String</a>
 * <p>
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * <pre>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * </pre>
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * Note: a + b is the concatenation of strings a and b.
 */
public interface InterleavingString {

    boolean isInterleave(String s1, String s2, String s3);

    // O(N1 * N2) time | O(N1 * N2), where N2 and N2 are lengths of s1 and s2 respectively
    class InterleavingStringTopDown implements InterleavingString {

        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            // DP: top-down with memoization
            return checkIfInterleave(s1, 0, s2, 0, s3, new HashMap<>());
        }

        private boolean checkIfInterleave(String s1, int idx1, String s2, int idx2, String s3, Map<String, Boolean> memo) {
            String key = key(idx1, idx2);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int idx3 = idx1 + idx2;
            if (idx3 == s3.length()) {
                return cacheAndReturn(memo, key, true);
            }

            if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3) && checkIfInterleave(s1, idx1 + 1, s2, idx2, s3, memo)) {
                return cacheAndReturn(memo, key, true);
            }

            if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3) && checkIfInterleave(s1, idx1, s2, idx2 + 1, s3, memo)) {
                return cacheAndReturn(memo, key, true);
            }

            return cacheAndReturn(memo, key, false);
        }

        private String key(int idx1, int idx2) {
            return idx1 + "|" + idx2;
        }

        private boolean cacheAndReturn(Map<String, Boolean> memo, String key, boolean value) {
            memo.put(key, value);
            return value;
        }
    }
}
