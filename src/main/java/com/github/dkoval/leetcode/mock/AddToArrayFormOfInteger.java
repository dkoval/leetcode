package com.github.dkoval.leetcode.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">Add to Array-Form of Integer</a>
 * <p>
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * <p>
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= num.length <= 10^4</li>
 *  <li>0 <= num[i] <= 9</li>
 *  <li>num does not contain any leading zeros except for the zero itself.</li>
 *  <li>1 <= k <= 10^4</li>
 * </ul>
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length;
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        while (--i >= 0 || k > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
            }

            sum += k % 10;
            k /= 10;

            ans.add(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            ans.add(carry);
        }

        Collections.reverse(ans);
        return ans;
    }
}
