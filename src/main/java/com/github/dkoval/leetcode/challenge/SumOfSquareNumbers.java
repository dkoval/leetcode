package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sum-of-square-numbers/">Sum of Square Numbers</a>
 * <p>
 * Given a non-negative integer c, decide whether there're two integers a and b such that a^2 + b^2 = c.
 * <p>
 * Constraints:
 * <p>
 * 0 <= c <= 2^31 - 1
 */
public interface SumOfSquareNumbers {

    boolean judgeSquareSum(int c);

    // O(sqrt(c)) time | O(1) space
    class SumOfSquareNumbersRev1 implements SumOfSquareNumbers {

        @Override
        public boolean judgeSquareSum(int c) {
            // binary search for a solution in [0 : sqrt(c)] range
            long a = 0;
            long b = (int) Math.sqrt(c);
            while (a <= b) {
                long sum = a * a + b * b;
                if (sum < c) {
                    a++;
                } else if (sum > c) {
                    b--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    class SumOfSquareNumbersRev2 implements SumOfSquareNumbers {

        @Override
        public boolean judgeSquareSum(int c) {
            // a^2 + b^2 = c
            // the largest a^2 (or b^2) can be is c:
            // a^2 + 0 = c <=> 0 + b^2 = c
            for (int a = 0; a <= Math.sqrt(c); a++) {
                int b = (int) Math.sqrt(c - a * a);
                if (a * a + b * b == c) {
                    return true;
                }
            }
            return false;
        }
    }
}
