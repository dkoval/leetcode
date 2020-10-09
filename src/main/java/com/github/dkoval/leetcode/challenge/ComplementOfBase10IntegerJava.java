package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3484/">Complement of Base 10 Integer</a>
 *
 * Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary,
 * 11 as "1011" in binary, and so on. Note that except for N = 0, there are no leading zeroes in any binary representation.
 *
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.
 * For example, the complement of "101" in binary is "010" in binary.
 *
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 */
public abstract class ComplementOfBase10IntegerJava {

    public abstract int bitwiseComplement(int N);

    public static class ComplementOfBase10IntegerFlipBitByBitJava extends ComplementOfBase10IntegerJava {

        @Override
        public int bitwiseComplement(int N) {
            if (N == 0) return 1;
            int result = 0;
            int i = 0;
            while (N != 0) {
                int bit = (N & 1) ^ 1; // take N's LSB and flip it
                result |= bit << i++; // move bit to i-th position
                N >>= 1; // divide N by 2
            }
            return result;
        }
    }

    public static class ComplementOfBase10IntegerHighestOneBitJava extends ComplementOfBase10IntegerJava {

        // This implementation is taken from "Hacker's Delight" book.
        // The idea is to create 1-bits bitmask by propagating the highest 1-bit into the lower ones.
        @Override
        public int bitwiseComplement(int N) {
            if (N == 0) return 1;
            // bitmask has the same length as N and contains only ones 1...1
            int bitmask = N;
            bitmask |= (bitmask >> 1);
            bitmask |= (bitmask >> 2);
            bitmask |= (bitmask >> 4);
            bitmask |= (bitmask >> 8);
            bitmask |= (bitmask >> 16);
            // flip all bits
            return bitmask ^ N;
        }
    }
}
