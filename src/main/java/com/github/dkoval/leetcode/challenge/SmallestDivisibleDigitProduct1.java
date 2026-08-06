package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/smallest-divisible-digit-product-i/">Smallest Divisible Digit Product I</a>
 * <p>
 * You are given two integers n and t. Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= t <= 10</li>
 * </ul>
 */
public interface SmallestDivisibleDigitProduct1 {

    int smallestNumber(int n, int t);

    class SmallestDivisibleDigitProduct1Rev1 implements SmallestDivisibleDigitProduct1 {

        @Override
        public int smallestNumber(int n, int t) {
            // Within at most 10 attempts, we are guaranteed to encounter an integer whose last digit is 0.
            // Since the product of its digits is then 0, it is divisible by any positive integer t.
            for (var x = n; x < n + 10; x++) {
                if (productOfDigits(x) % t == 0) {
                    return x;
                }
            }
            throw new IllegalStateException("This shouldn't have happened");
        }

        private int productOfDigits(int x) {
            var product = 1;
            while (x > 0) {
                product *= x % 10;
                x /= 10;
            }
            return product;
        }
    }
}
