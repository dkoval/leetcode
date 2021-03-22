package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3654/">Divide Two Integers</a>
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Note:
 * <p>
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        // corner cases
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend >= 0) == (divisor >= 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;

        // idea: subtract and double divisor at each step
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            result += 1 << count;
            dividend -= divisor << count;
        }
        return sign ? result : -result;
    }
}
