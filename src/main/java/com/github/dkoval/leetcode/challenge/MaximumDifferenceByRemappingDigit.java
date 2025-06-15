package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/">Maximum Difference by Remapping a Digit</a>
 * <p>
 * You are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.
 * <p>
 * Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
 * <p>
 * Notes:
 * <p>
 * When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
 * <p>
 * Bob can remap a digit to itself, in which case num does not change.
 * <p>
 * Bob can remap different digits for obtaining minimum and maximum values respectively.
 * <p>
 * The resulting number after remapping can contain leading zeroes.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 10^8
 */
public interface MaximumDifferenceByRemappingDigit {

    int minMaxDifference(int num);

    class MaximumDifferenceByRemappingDigitRev1 implements MaximumDifferenceByRemappingDigit {

        @Override
        public int minMaxDifference(int num) {
            final var digits = Integer.toString(num);
            final var max = remap(digits, '9');
            final var min = remap(digits, '0');
            return max - min;
        }

        private int remap(String digits, char x) {
            var ans = 0;
            var replace = '#';
            for (var i = 0; i < digits.length(); i++) {
                var c = digits.charAt(i);
                if (c != x) {
                    if (replace == '#') {
                        replace = c;
                    }

                    if (c == replace) {
                        c = x;
                    }
                }

                ans *= 10;
                ans += c - '0';
            }
            return ans;
        }
    }
}
