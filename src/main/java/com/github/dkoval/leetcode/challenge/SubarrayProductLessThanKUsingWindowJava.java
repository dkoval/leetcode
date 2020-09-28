package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.problems.SubarrayProductLessThanK;
import org.jetbrains.annotations.NotNull;

public class SubarrayProductLessThanKUsingWindowJava implements SubarrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(@NotNull int[] nums, int k) {
        if (k <= 1) return 0;
        int l = 0, count = 0, product = 1;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l];
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }
}
