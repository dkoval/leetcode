package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3554/">The kth Factor of n</a>
 * <p>
 * Given two positive integers n and k.
 * <p>
 * A factor of an integer n is defined as an integer i where n % i == 0.
 * <p>
 * Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
 */
public class KthFactorOfN {

    public int kthFactor(int n, int k) {
        int numFactors = 0, factor = -1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factor = i;
                if (++numFactors == k) break;
            }
        }
        return (numFactors == k) ? factor : -1;
    }
}
