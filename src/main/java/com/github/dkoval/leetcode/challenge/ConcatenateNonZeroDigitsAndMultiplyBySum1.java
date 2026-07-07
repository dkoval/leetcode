package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/">Concatenate Non-Zero Digits and Multiply by Sum I</a>
 * <p>
 * You are given an integer n.
 * <p>
 * Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.
 * <p>
 * Let sum be the sum of digits in x.
 * <p>
 * Return an integer representing the value of x * sum.
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 10^9
 */
public interface ConcatenateNonZeroDigitsAndMultiplyBySum1 {

    long sumAndMultiply(int n);

    class ConcatenateNonZeroDigitsAndMultiplyBySum1Rev1 implements ConcatenateNonZeroDigitsAndMultiplyBySum1 {

        @Override
        public long sumAndMultiply(int n) {
            var stack = new ArrayDeque<Integer>();
            var sum = 0;
            while (n > 0) {
                var digit = n % 10;
                if (digit > 0) {
                    stack.push(digit);
                    sum += digit;
                }
                n /= 10;
            }

            var x = 0L;
            while (!stack.isEmpty()) {
                x *= 10;
                x += stack.pop();
            }

            return x * sum;
        }
    }

    class ConcatenateNonZeroDigitsAndMultiplyBySum1Rev2 implements ConcatenateNonZeroDigitsAndMultiplyBySum1 {

        @Override
        public long sumAndMultiply(int n) {
            var x = 0;
            var sum = 0;
            var pow10 = 1;
            while (n > 0) {
                var digit = n % 10;
                sum += digit;
                if (digit > 0) {
                    x += digit * pow10;
                    pow10 *= 10;
                }
                n /= 10;
            }
            return (long) x * sum;
        }
    }
}
