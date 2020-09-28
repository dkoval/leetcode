package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.problems.SubarrayProductLessThanK;
import org.jetbrains.annotations.NotNull;

public class SubarrayProductLessThanKBruteForceJava implements SubarrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(@NotNull int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product < k) count++;
                else break;
            }
        }
        return count;
    }
}
