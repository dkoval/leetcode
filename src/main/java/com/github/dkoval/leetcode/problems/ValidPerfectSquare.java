package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/valid-perfect-square/">Valid Perfect Square</a>
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Follow up: Do not use any built-in library function such as sqrt.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 2^31 - 1
 */
public interface ValidPerfectSquare {

    boolean isPerfectSquare(int num);

    // O(logN) time | O(1) space
    class ValidPerfectSquareBinarySearch implements ValidPerfectSquare {

        @Override
        public boolean isPerfectSquare(int num) {
            int left = 1;
            int right = num;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid < num / mid) {
                    left = mid + 1;
                } else {
                    if (mid * mid == num) {
                        return true;
                    }
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
