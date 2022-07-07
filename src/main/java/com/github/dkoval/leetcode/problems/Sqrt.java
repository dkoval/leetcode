package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 * <p>
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * <p>
 * Constraints:
 * <p>
 * 0 <= x <= 2^31 - 1
 */
public interface Sqrt {

    int mySqrt(int x);

    class SqrtUsingBinarySearchRev1 implements Sqrt {

        @Override
        public int mySqrt(int x) {
            if (x <= 1) {
                return x;
            }

            // find the largest y such that y^2 <= x
            int left = 1;
            int right = x;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid < x / mid) {
                    ans = mid;
                    left = mid + 1;
                } else if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return ans;
        }
    }

    class SqrtUsingBinarySearchRev2 implements Sqrt {

        @Override
        public int mySqrt(int x) {
            if (x <= 1) {
                return x;
            }

            // find the smallest y such that y^2 > x,
            // then the answer = y - 1 (round down)
            int left = 1;
            int right = x;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mid < x / mid) {
                    // mid can't be a solution
                    left = mid + 1;
                } else if (mid > x / mid) {
                    // mid is a possible solution;
                    // check if there is a better one to the left of mid
                    right = mid;
                } else {
                    return mid;
                }
            }
            return left - 1;
        }
    }
}
