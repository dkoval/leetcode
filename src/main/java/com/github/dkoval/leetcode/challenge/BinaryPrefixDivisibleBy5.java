package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/">Binary Prefix Divisible By 5</a>
 * <p>
 * You are given a binary array nums (0-indexed).
 * <p>
 * We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
 * <p>
 * For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
 * <p>
 * Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
 * <p>
 * Constraints:
 * <ul>
 *  <ul>1 <= nums.length <= 10^5</ul>
 *  <ul>nums[i] is either 0 or 1.</ul>
 * </ul>
 */
public interface BinaryPrefixDivisibleBy5 {

    List<Boolean> prefixesDivBy5(int[] nums);

    class BinaryPrefixDivisibleBy5Rev1 implements BinaryPrefixDivisibleBy5 {

        @Override
        public List<Boolean> prefixesDivBy5(int[] nums) {
            final var ans = new ArrayList<Boolean>();
            var prefix = 0;
            for (var x : nums) {
                prefix *= 2;
                prefix += x;
                prefix %= 5;
                ans.add(prefix == 0);
            }
            return ans;
        }
    }
}
