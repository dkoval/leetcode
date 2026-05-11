package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/separate-the-digits-in-an-array/">Separate the Digits in an Array</a>
 * <p>
 * Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums
 * after separating them in the same order they appear in nums.
 * <p>
 * To separate the digits of an integer is to get all the digits it has in the same order.
 * <p>
 * For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface SeparateDigitsInArray {

    int[] separateDigits(int[] nums);

    class SeparateDigitsInArrayRev1 implements SeparateDigitsInArray {

        @Override
        public int[] separateDigits(int[] nums) {
            final var res = new ArrayList<Integer>();
            for (var x : nums) {
                res.addAll(digits(x));
            }
            return toArray(res);
        }

        private List<Integer> digits(int x) {
            final var digits = new ArrayList<Integer>();
            while (x > 0) {
                digits.add(x % 10);
                x /= 10;
            }

            Collections.reverse(digits);
            return digits;
        }

        private int[] toArray(List<Integer> nums) {
            final var res = new int[nums.size()];
            for (var i = 0; i < nums.size(); i++) {
                res[i] = nums.get(i);
            }
            return res;
        }
    }
}
