package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/">Total Waviness of Numbers in Range I</a>
 * <p>
 * You are given two integers num1 and num2 representing an inclusive range [num1, num2].
 * <p>
 * The waviness of a number is defined as the total count of its peaks and valleys:
 * <p>
 * A digit is a peak if it is strictly greater than both of its immediate neighbors.
 * <p>
 * A digit is a valley if it is strictly less than both of its immediate neighbors.
 * <p>
 * The first and last digits of a number cannot be peaks or valleys.
 * <p>
 * Any number with fewer than 3 digits has a waviness of 0.
 * <p>
 * Return the total sum of waviness for all numbers in the range [num1, num2].
 * <p>
 * Constraints:
 * <p>
 * 1 <= num1 <= num2 <= 10^5
 */
public interface TotalWavinessOfNumbersInRange1 {

    int totalWaviness(int num1, int num2);

    class TotalWavinessOfNumbersInRange1Rev1 implements TotalWavinessOfNumbersInRange1 {

        @Override
        public int totalWaviness(int num1, int num2) {
            var total = 0;
            for (var x = num1; x <= num2; x++) {
                total += waviness(x);
            }
            return total;
        }

        private int waviness(int x) {
            var waviness = 0;
            var s = String.valueOf(x);
            for (var i = 1; i < s.length() - 1; i++) {
                final var prev = s.charAt(i - 1) - '0';
                final var curr = s.charAt(i) - '0';
                final var next = s.charAt(i + 1) - '0';
                if (isPeak(prev, curr, next) || isValley(prev, curr, next)) {
                    waviness++;
                }
            }
            return waviness;
        }

        private boolean isPeak(int prev, int curr, int next) {
            return (curr > prev) && (curr > next);
        }

        private boolean isValley(int prev, int curr, int next) {
            return (curr < prev) && (curr < next);
        }
    }
}
