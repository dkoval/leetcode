package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/smallest-number-with-all-set-bits/">Smallest Number With All Set Bits</a>
 * <p>
 * You are given a positive number n.
 * <p>
 * Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public interface SmallestNumberWithAllSetBits {

    int smallestNumber(int n);

    class SmallestNumberWithAllSetBitsRev1 implements SmallestNumberWithAllSetBits {

        @Override
        public int smallestNumber(int n) {
            var pow2 = 2;
            while (pow2 <= n) {
                pow2 *= 2;
            }
            return pow2 - 1;
        }
    }

    class SmallestNumberWithAllSetBitsRev2 implements SmallestNumberWithAllSetBits {

        @Override
        public int smallestNumber(int n) {
            final int numBits = (int) (Math.log(n) / Math.log(2)) + 1;
            return (1 << numBits) - 1;
        }
    }
}
