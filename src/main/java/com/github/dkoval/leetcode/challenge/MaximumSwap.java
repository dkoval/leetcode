package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-swap/">Maximum Swap</a>
 * <p>
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 * <p>
 * Return the maximum valued number you can get.
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 10^8
 */
public interface MaximumSwap {

    int maximumSwap(int num);

    class MaximumSwapRev1 implements MaximumSwap {

        @Override
        public int maximumSwap(int num) {
            // convert num to a list of digits
            List<Integer> digits = new ArrayList<>();
            int x = num;
            while (x > 0) {
                digits.add(x % 10);
                x /= 10;
            }

            int n = digits.size();
            Collections.reverse(digits);

            // brute force
            int best = num;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    // swap digits at indices i and j
                    swap(digits, i, j);
                    best = Math.max(best, asNumber(digits));
                    // undo swap before considering a new pair of indices
                    swap(digits, i, j);
                }
            }
            return best;
        }

        private void swap(List<Integer> digits, int i, int j) {
            int tmp = digits.get(i);
            digits.set(i, digits.get(j));
            digits.set(j, tmp);
        }

        private int asNumber(List<Integer> digits) {
            int x = 0;
            for (int d : digits) {
                x *= 10;
                x += d;
            }
            return x;
        }
    }
}
