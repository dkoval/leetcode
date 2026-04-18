package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/mirror-distance-of-an-integer/">Mirror Distance of an Integer</a>
 * <p>
 * You are given an integer n.
 * <p>
 * Define its mirror distance as: abs(n - reverse(n)) where reverse(n) is the integer formed by reversing the digits of n.
 * <p>
 * Return an integer denoting the mirror distance of n.
 * <p>
 * abs(x) denotes the absolute value of x.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^9
 */
public interface MirrorDistanceOfInteger {

    int mirrorDistance(int n);

    class MirrorDistanceOfIntegerRev1 implements MirrorDistanceOfInteger {

        @Override
        public int mirrorDistance(int n) {
            return Math.abs(n - reverse(n));
        }

        private int reverse(int n) {
            var x = 0;
            while (n != 0) {
                x *= 10;
                x += n % 10;
                n /= 10;
            }
            return x;

        }
    }
}
