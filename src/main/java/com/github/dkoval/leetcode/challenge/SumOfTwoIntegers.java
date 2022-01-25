package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sum-of-two-integers/">Sum of Two Integers</a>
 * <p>
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * <p>
 * Constraints:
 * <p>
 * -1000 <= a, b <= 1000
 */
public class SumOfTwoIntegers {

    // Nice explanation of used technique: https://www.youtube.com/watch?v=qq64FrA2UXQ&
    public int getSum(int a, int b) {
        // a ^ b        - bit by bit sum ignoring carries
        // (a & b) << 1 - carry bits; not that carry gets applied in the next position to the left, that is why we do << 1
        int sum = a;
        int carry = b;
        while (carry != 0) {
            int tmp = (sum & carry) << 1;
            sum = sum ^ carry;
            carry = tmp;
        }
        return sum;
    }
}
