package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/reordered-power-of-2/">Reordered Power of 2</a>
 * <p>
 * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this so that the resulting number is a power of two.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^9
 */
public interface ReorderedPowerOf2 {

    boolean reorderedPowerOf2(int n);

    class ReorderedPowerOf2Rev1 implements ReorderedPowerOf2 {

        private final static Set<String> pow2 = new HashSet<>();

        static {
            for (int i = 0; i < 32; i++) {
                String x = normalize(1 << i); // x = 2^i
                pow2.add(x);
            }
        }

        private static String normalize(int x) {
            char[] chars = String.valueOf(x).toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }

        @Override
        public boolean reorderedPowerOf2(int n) {
            String x = normalize(n);
            return pow2.contains(x);
        }
    }
}
