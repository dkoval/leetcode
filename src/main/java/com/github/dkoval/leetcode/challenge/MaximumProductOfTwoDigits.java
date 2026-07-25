package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/maximum-product-of-two-digits/">Maximum Product of Two Digits</a>
 * <p>
 * You are given a positive integer n.
 * <p>
 * Return the maximum product of any two digits in n.
 * <p>
 * Note: You may use the same digit twice if it appears more than once in n.
 * <p>
 * Constraints:
 * <p>
 * 10 <= n <= 10^9
 */
public interface MaximumProductOfTwoDigits {

    int maxProduct(int n);

    class MaximumProductOfTwoDigitsRev1 implements MaximumProductOfTwoDigits {

        @Override
        public int maxProduct(int n) {
            final var digits = new ArrayList<Integer>();
            while (n > 0) {
                digits.add(n % 10);
                n /= 10;
            }

            var best = 0;
            for (var i = 0; i < digits.size() - 1; i++) {
                for (var j = i + 1; j < digits.size(); j++) {
                    best = Math.max(best, digits.get(i) * digits.get(j));
                }
            }
            return best;
        }
    }

    class MaximumProductOfTwoDigitsRev2 implements MaximumProductOfTwoDigits {

        @Override
        public int maxProduct(int n) {
            var max1 = 0;
            var max2 = 0;
            while (n > 0) {
                var digit = n % 10;
                if (digit > max1) {
                    max2 = max1;
                    max1 = digit;
                } else if (digit > max2) {
                    max2 = digit;
                }
                n /= 10;
            }
            return max1 * max2;
        }
    }
}
