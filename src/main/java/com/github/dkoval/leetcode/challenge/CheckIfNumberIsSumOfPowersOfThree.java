package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/">Check If Number Is a Sum of Powers of Three</a>
 * <p>
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
 * <p>
 * An integer y is a power of three if there exists an integer x such that y == 3^x.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^7
 */
public interface CheckIfNumberIsSumOfPowersOfThree {

    boolean checkPowersOfThree(int n);

    class CheckIfNumberIsSumOfPowersOfThreeRev1 implements CheckIfNumberIsSumOfPowersOfThree {

        @Override
        public boolean checkPowersOfThree(int n) {
            // idea: convert n to base 3 and check if it contains only 1s and 0s
            while (n > 0) {
                // to be able to represent n in base 3 system,
                // digits should be either 0 or 1
                if (n % 3 == 2) {
                    return false;
                }
                n /= 3;
            }
            return true;
        }
    }
}
