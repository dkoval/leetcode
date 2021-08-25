package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3918/">Sum of Square Numbers</a>
 * <p>
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Constraints:
 * <p>
 * 0 <= c <= 231 - 1
 */
public class SumOfSquareNumbers {

    // O(sqrt(c)) time | O(1) space
    public boolean judgeSquareSum(int c) {
        // binary search for a solution in [0 : sqrt(c)] range
        int l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum < c) {
                l++;
            } else if (sum > c) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}
