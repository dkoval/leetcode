package com.github.dkoval.leetcode.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">Add to Array-Form of Integer</a>
 *
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
 *
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int k) {
        int i = A.length;
        int carry = 0;
        List<Integer> answer = new ArrayList<>();
        while (--i >= 0 || k > 0) {
            int digit = k % 10;
            int sum = digit + carry;
            if (i >= 0) {
                sum += A[i];
            }
            answer.add(sum % 10);
            carry = (sum >= 10) ? 1 : 0;
            k /= 10;
        }
        if (carry == 1) {
            answer.add(1);
        }
        Collections.reverse(answer);
        return answer;
    }
}
