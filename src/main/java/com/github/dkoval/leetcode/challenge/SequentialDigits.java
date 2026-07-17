package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sequential-digits/">Sequential Digits</a>
 * <p>
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * <p>
 * Constraints:
 * <p>
 * 10 <= low <= high <= 10^9
 */
public interface SequentialDigits {

    List<Integer> sequentialDigits(int low, int high);

    class SequentialDigitsRev4 implements SequentialDigits {

        public List<Integer> sequentialDigits(int low, int high) {
            var result = new ArrayList<Integer>();
            for (var x = 1; x <= 9; x++) {
                generate(x, low, high, result);
            }
            Collections.sort(result);
            return result;
        }

        private void generate(int curr, int low, int high, List<Integer> result) {
            if (curr > high) {
                return;
            }

            if (curr >= low) {
                result.add(curr);
            }

            var lastDigit = curr % 10;
            if (lastDigit < 9) {
                generate(curr * 10 + lastDigit + 1, low, high, result);
            }
        }
    }
}
