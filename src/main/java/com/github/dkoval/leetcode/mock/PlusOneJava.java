package com.github.dkoval.leetcode.mock;

import com.github.dkoval.leetcode.interview.array.PlusOne;
import org.jetbrains.annotations.NotNull;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 *
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array
 * contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class PlusOneJava implements PlusOne {

    @NotNull
    public int[] plusOne(@NotNull int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
