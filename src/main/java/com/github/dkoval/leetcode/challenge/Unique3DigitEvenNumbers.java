package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/unique-3-digit-even-numbers/">Unique 3-Digit Even Numbers</a>
 * <p>
 * You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.
 * <p>
 * Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= digits.length <= 10</li>
 *  <li>0 <= digits[i] <= 9</li>
 * </ul>
 */
public interface Unique3DigitEvenNumbers {

    int totalNumbers(int[] digits);

    class Unique3DigitEvenNumbersRev1 implements Unique3DigitEvenNumbers {

        @Override
        public int totalNumbers(int[] digits) {
            final var n = digits.length;

            final var seen = new HashSet<Integer>();
            for (var i = 0; i < n; i++) {
                for (var j = 0; j < n; j++) {
                    for (var k = 0; k < n; k++) {
                        if (digits[i] != 0 && i != j && j != k && i != k) {
                            final var x = digits[i] * 100 + digits[j] * 10 + digits[k];
                            if (x % 2 == 0) {
                                seen.add(x);
                            }
                        }
                    }
                }
            }
            return seen.size();
        }
    }
}
