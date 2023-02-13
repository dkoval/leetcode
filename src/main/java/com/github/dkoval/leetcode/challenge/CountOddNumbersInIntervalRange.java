package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/">Count Odd Numbers in an Interval Range</a>
 * <p>
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 * Constraints:
 * <p>
 * 0 <= low <= high <= 10^9
 */
public interface CountOddNumbersInIntervalRange {

    int countOdds(int low, int high);

    // O(1) time | O(1) space
    class CountOddNumbersInIntervalRangeRev1 implements CountOddNumbersInIntervalRange {

        @Override
        public int countOdds(int low, int high) {
            // -----L-------R-----
            //      <------->
            // <------------>
            // <--->
            // count[low : high] = count[0 : high] - count[0 : low - 1]
            return count(high) - count(low - 1);
        }

        // the number of odd numbers in [0 : x] range
        private int count(int x) {
            return (x + 1) / 2;
        }
    }
}
