package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 * <p>
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has
 * (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given
 * as a signed integer type. It should not affect your implementation, as the integer's internal binary representation
 * is the same, whether it is signed or unsigned.
 * <p>
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        // In the binary representation, the least significant 1-bit in n always corresponds to a 0-bit in n - 1.
        // Therefore, n & (n - 1) always flips the least significant 1-bit in n to 0, and keeps all other bits the same.
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
