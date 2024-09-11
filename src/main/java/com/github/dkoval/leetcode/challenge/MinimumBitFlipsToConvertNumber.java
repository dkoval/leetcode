package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number/">Minimum Bit Flips to Convert Number</a>
 * <p>
 * A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.
 * <p>
 * For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown)
 * and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101,
 * flip the fifth bit from the right (a leading zero) to get 10111, etc.
 * <p>
 * Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
 * <p>
 * Constraints:
 * <p>
 * 0 <= start, goal <= 10^9
 */
public interface MinimumBitFlipsToConvertNumber {

    int minBitFlips(int start, int goal);

    class MinimumBitFlipsToConvertNumberRev1 implements MinimumBitFlipsToConvertNumber {

        @Override
        public int minBitFlips(int start, int goal) {
            // mask records bits that differ
            int mask = start ^ goal;
            // count 1's in the mask
            int count = 0;
            while (mask != 0) {
                count += mask & 1;
                mask >>= 1;
            }
            return count;
        }
    }
}
