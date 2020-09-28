package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.problems.SubarrayProductLessThanK;
import org.jetbrains.annotations.NotNull;

public class SubarrayProductLessThanKUsingWindowJava implements SubarrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(@NotNull int[] nums, int k) {
        if (k <= 1) return 0;
        int l = 0, r = 0, count = 0, product = 1;
        while (r < nums.length) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
