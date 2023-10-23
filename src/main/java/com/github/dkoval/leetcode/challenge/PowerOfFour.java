package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/power-of-four/d">Power of Four</a>
 * <p>
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * <p>
 * An integer n is a power of four, if there exists an integer x such that n == 4^x.
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= n <= 2^31 - 1
 */
public interface PowerOfFour {

    boolean isPowerOfFour(int n);

    class PowerOfFourRev1 implements PowerOfFour {

        @Override
        public boolean isPowerOfFour(int n) {
            while (n > 1 && n % 4 == 0) {
                n /= 4;
            }
            return n == 1;
        }
    }
}
