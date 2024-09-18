package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 * <p>
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface LargestNumber {

    String largestNumber(int[] nums);

    class LargestNumberRev1 implements LargestNumber {

        @NotNull
        @Override
        public String largestNumber(int[] nums) {
            int n = nums.length;

            // idea: convert numbers to strings, then sort lexicographically
            String[] xs = new String[n];
            for (int i = 0; i < n; i++) {
                xs[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(xs, (x, y) -> {
                // x = "3", y = "30"
                // "330" > "303"
                String s1 = x + y;
                String s2 = y + x;
                return s2.compareTo(s1);
            });

            // corner case
            if (xs[0].equals("0")) {
                return "0";
            }

            return String.join("", xs);
        }
    }
}
