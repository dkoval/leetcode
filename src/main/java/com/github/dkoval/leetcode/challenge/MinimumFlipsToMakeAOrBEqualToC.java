package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">Minimum Flips to Make a OR b Equal to c</a>
 * <p>
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make
 * (a OR b == c) (bitwise OR operation).
 * <p>
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 * <p>
 * Constraints:
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 * Accepted
 * 52.9K
 */
public interface MinimumFlipsToMakeAOrBEqualToC {

    int minFlips(int a, int b, int c);

    class MinimumFlipsToMakeAOrBEqualToCRev1 implements MinimumFlipsToMakeAOrBEqualToC {

        @Override
        public int minFlips(int a, int b, int c) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                int x1 = a & 1;
                int x2 = b & 1;
                int x3 = c & 1;
                if ((x1 | x2) != x3) {
                    // Case #1: x1 | x2 = 0, x3 = 1
                    // Possible scenarios:
                    // x1 = 0, x2 = 0 -> flip 1 bit
                    //
                    // Case #2: x1 | x2 = 1, x3 = 0
                    // Possible scenarios:
                    // x1 = 1, x2 = 0 -> flip 1 bit
                    // x1 = 0, x2 = 1 -> flip 1 bit
                    // x1 = 1, x2 = 1 -> flip 2 bits
                    count += (x3 == 1) || (x1 ^ x2) == 1 ? 1 : 2;
                }
                a >>= 1;
                b >>= 1;
                c >>= 1;
            }
            return count;
        }
    }
}
