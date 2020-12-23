package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/featured/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/">Next Greater Element III</a>
 * <p>
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
 * and is greater in value than n. If no such positive integer exists, return -1.
 * <p>
 * Note that the returned integer should fit in 32-bit integer,
 * if there is a valid answer but it does not fit in 32-bit integer,
 * return -1.
 */
public class NextGreaterElement3 {

    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();

        // moving from right to left, find the first digit that is smaller than the digit next to it
        int k = digits.length - 2;
        while (k >= 0 && digits[k] >= digits[k + 1]) {
            k--;
        }
        if (k < 0) {
            return -1;
        }

        // in digits[k + 1 : n - 1] subarray, find the smallest digit x that is greater then digits[k]
        int xIdx = k + 1;
        for (int i = k + 2; i < digits.length; i++) {
            if (digits[i] > digits[k] && digits[i] <= digits[xIdx]) {
                xIdx = i;
            }
        }

        // swap digits[k] with digit x
        char tmp = digits[k];
        digits[k] = digits[xIdx];
        digits[xIdx] = tmp;

        // sort digits after k in ascending order
        Arrays.sort(digits, k + 1, digits.length);

        long x = Long.parseLong(String.valueOf(digits));
        return x <= Integer.MAX_VALUE ? (int) x : -1;
    }
}
