package com.github.dkoval.leetcode.challenge;

import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/">Prime Number of Set Bits in Binary Representation</a>
 * <p>
 * Given two integers left and right, return the count of numbers in the inclusive range [left, right]
 * having a prime number of set bits in their binary representation.
 * <p>
 * Recall that the number of set bits an integer has is the number of 1's present when written in binary.
 * <p>
 * For example, 21 written in binary is 10101, which has 3 set bits.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= left <= right <= 10^6</li>
 *  <li>0 <= right - left <= 10^4</li>
 * </ul>
 */
public interface PrimeNumberOfSetBitsInBinaryRepresentation {

    int countPrimeSetBits(int left, int right);

    class PrimeNumberOfSetBitsInBinaryRepresentationRev1 implements PrimeNumberOfSetBitsInBinaryRepresentation {

        // primary numbers in 1 .. 32 range
        private static final Set<Integer> PRIMES = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

        @Override
        public int countPrimeSetBits(int left, int right) {
            var count = 0;
            for (var x = left; x <= right; x++) {
                final var bits = countBits(x);
                if (PRIMES.contains(bits)) {
                    count++;
                }
            }
            return count;
        }

        private int countBits(int x) {
            var count = 0;
            while (x > 0) {
                count += x & 1;
                x >>= 1;
            }
            return count;
        }
    }
}
