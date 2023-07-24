package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/powx-n">Pow(x, n)</a>
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 * <p>
 * Constraints:
 * <ul>
 *  <li>-100.0 < x < 100.0</li>
 *  <li>-2^31 <= n <= 2^31-1</li>
 *  <li>n is an integer.</li>
 *  <li>Either x is not zero or n > 0.</li>
 *  <li>-10^4 <= x^n <= 10^4</li>
 * </ul>
 */
public interface Pow {

    double myPow(double x, int n);

    class PowRecursive implements Pow {

        @Override
        public double myPow(double x, int n) {
            return (n >= 0) ? pow(x, n) : 1 / pow(x, Math.abs(n));
        }

        private double pow(double x, int n) {
            if (n == 0) {
                return 1.0;
            }

            if (n == 1) {
                return x;
            }

            // x ^ n = x ^ (n / 2) * x ^ (n / 2), if n is even
            // x ^ n = x ^ (n / 2) * x ^ (n / 2) * x, if n is odd
            double res = pow(x,  n / 2);
            double ans = res * res;
            if (n % 2 != 0) {
                ans *= x;
            }
            return ans;
        }
    }
}
