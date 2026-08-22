package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/">Check Divisibility by Digit Sum and Product</a>
 * <p>
 * You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
 * <p>
 * The digit sum of n (the sum of its digits).
 * <p>
 * The digit product of n (the product of its digits).
 * <p>
 * Return true if n is divisible by this sum; otherwise, return false.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^6
 */
public interface CheckDivisibilityByDigitSumAndProduct {

    boolean checkDivisibility(int n);

    class CheckDivisibilityByDigitSumAndProductRev1 implements CheckDivisibilityByDigitSumAndProduct {

        @Override
        public boolean checkDivisibility(int n) {
            var x = n;
            var digitSum = 0;
            var digitProd = 1;
            while (x > 0) {
                var digit = x % 10;
                digitSum += digit;
                digitProd *= digit;
                x /= 10;
            }
            return isDivisible(n, digitSum + digitProd);
        }

        private boolean isDivisible(int a, int b) {
            return (a % b == 0);
        }
    }
}
