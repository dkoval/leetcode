package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3679/">Reordered Power of 2</a>
 * <p>
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such
 * that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 */
public class ReorderedPowerOf2 {
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

    public boolean reorderedPowerOf2(int N) {
        String x = normalize(N);
        return pow2.contains(x);
    }
}
