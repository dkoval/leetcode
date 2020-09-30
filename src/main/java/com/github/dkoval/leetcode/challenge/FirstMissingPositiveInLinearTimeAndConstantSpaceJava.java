package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class FirstMissingPositiveInLinearTimeAndConstantSpaceJava implements FirstMissingPositive {

    @Override
    public int firstMissingPositive(@NotNull int[] nums) {
        boolean foundOne = false;
        for (int num : nums) {
            if (num == 1) {
                foundOne = true;
                break;
            }
        }

        if (!foundOne) return 1;
        if (nums.length == 1) return 2;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}
