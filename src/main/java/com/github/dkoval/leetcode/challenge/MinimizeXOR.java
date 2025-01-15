package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimize-xor/">Minimize XOR</a>
 * <p>
 * Given two positive integers num1 and num2, find the positive integer x such that:
 * <ul>
 *  <li>x has the same number of set bits as num2, and</li>
 *  <li>The value x XOR num1 is minimal.</li>
 * </ul>
 * Note that XOR is the bitwise XOR operation.
 * <p>
 * Return the integer x. The test cases are generated such that x is uniquely determined.
 * <p>
 * The number of set bits of an integer is the number of 1's in its binary representation.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num1, num2 <= 10^9
 */
public interface MinimizeXOR {

    int minimizeXor(int num1, int num2);

    class MinimizeXORRev1 implements MinimizeXOR {

        @Override
        public int minimizeXor(int num1, int num2) {
            final var bits = new int[32];
            for (int i = 0; i < 32; i++) {
                bits[i] = (num1 >> i) & 1;
            }

            // Minimize XOR in 2 passes
            final var ans = new int[32];
            var count = Integer.bitCount(num2);

            // 1st pass: zero out the most significant bits:
            // 1 ^ 1 = 0
            for (var i = 31; i >= 0 && count > 0; i--) {
                if (bits[i] == 1) {
                    ans[i] = 1;
                    count--;
                }
            }

            // 2nd pass: keep on setting the least significant bits until count becomes 0:
            // 1 ^ 0 = 0 ^ 1 = 1
            for (var i = 0; i < 32 && count > 0; i++) {
                if (bits[i] == 0) {
                    ans[i] = 1;
                    count--;
                }
            }

            var x = 0;
            for (var i = 0; i < 32; i++) {
                x |= ans[i] << i;
            }
            return x;
        }
    }
}
