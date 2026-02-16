package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/reverse-bits/">Reverse Bits</a>
 * <p>
 * Reverse bits of a given 32 bits signed integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= n <= 2^31 - 2</li>
 *  <li>n is even.</li>
 * </ul>
 */
public interface ReverseBits {

    int reverseBits(int n);

    class ReverseBitsRev1 implements ReverseBits {

        @Override
        public int reverseBits(int n) {
            var x = n;
            var res = 0;
            var i = 31;
            while (x > 0) {
                final var bit = x & 1;
                res |= bit << i;
                x >>= 1;
                i--;
            }
            return res;
        }
    }
}
