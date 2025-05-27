package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/">Divisible and Non-Divisible Sums Difference</a>
 * <p>
 * Define two integers as follows:
 * <p>
 * num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
 * <p>
 * num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
 * <p>
 * Return the integer num1 - num2.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n, m <= 1000
 */
public interface DivisibleAndNonDivisibleSumsDifference {

    int differenceOfSums(int n, int m);

    class DivisibleAndNonDivisibleSumsDifferenceRev1 implements DivisibleAndNonDivisibleSumsDifference {

        @Override
        public int differenceOfSums(int n, int m) {
            var diff = 0;
            for (var x = 1; x <= n; x++) {
                diff += (x % m != 0) ? x : -x;
            }
            return diff;
        }
    }
}
